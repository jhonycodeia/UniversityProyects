package com.saberpro.modelo.control;

import com.saberpro.dataaccess.dao.*;

import com.saberpro.dto.mapper.IUsuarioMapper;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.UsuarioDTO;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.Email;
import com.saberpro.utilities.FacesUtils;
import com.saberpro.utilities.PasswordGenerator;
import com.saberpro.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@Scope("singleton")
@Service("UsuarioLogic")
public class UsuarioLogic implements IUsuarioLogic {
	private static final Logger log = LoggerFactory.getLogger(UsuarioLogic.class);

	/**
	 * DAO injected by Spring that manages Usuario entities
	 *
	 */
	@Autowired
	private IProgramaUsuarioLogic programaUsuarioLogic;
	@Autowired
	private IProgramaLogic programaLogic;
	@Autowired
	private ITipoUsuarioLogic tipoUsuarioLogic;
	@Autowired
	private IUsuarioDAO usuarioDAO;
	@Autowired
	private IUsuarioMapper usuarioMapper;
	@Autowired
	private IGrupoOpcionDAO grupoOpcionDao;
	@Autowired
	private Validator validator;
	@Autowired
	private PasswordGenerator passwordGenerator;
	@Autowired
	private Email emailCorreo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * DAO injected by Spring that manages Matricula entities
	 *
	 */
	@Autowired
	private IMatriculaDAO matriculaDAO;

	/**
	 * DAO injected by Spring that manages ProgramaUsuario entities
	 *
	 */
	@Autowired
	private IProgramaUsuarioDAO programaUsuarioDAO;

	/**
	 * Logic injected by Spring that manages TipoUsuario entities
	 *
	 */
	@Autowired
	ITipoUsuarioLogic logicTipoUsuario1;

	public void validateUsuario(Usuario usuario) throws Exception {
		try {
			Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}

				throw new Exception(strMessage.toString());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<Usuario> getUsuario() throws Exception {
		log.debug("finding all Usuario instances");

		List<Usuario> list = new ArrayList<Usuario>();

		try {
			list = usuarioDAO.findAll();
		} catch (Exception e) {
			log.error("finding all Usuario failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Usuario");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = true)
	public List<Usuario> getUsuario(String tipo) throws Exception {
		log.debug("finding all Usuario instances");

		List<Usuario> list = new ArrayList<Usuario>();

		try {
			list = usuarioDAO.findAll(tipo);
		} catch (Exception e) {
			log.error("finding all Usuario failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Usuario");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveUsuario(Usuario entity) throws Exception {
		log.debug("saving Usuario instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Usuario");
			}

			String password = passwordGenerator.password(8);

			entity.setPassword(passwordEncoder.encode(password));
			entity.setActivo(Constantes.ESTADO_PENDIENTE);

			validateUsuario(entity);
			Object[] identificacion = { "identificacion", true, entity.getIdentificacion(), "=" };
			Object[] correo = { "correo", true, entity.getCorreo(), "=" };
			Object[] celular = { "celular", true, entity.getCelular(), "=" };

			if (findByCriteria(identificacion, null, null).size() != 0) {
				throw new Exception("El número de identificación ya se encuentra registrado");
			}
			if (findByCriteria(correo, null, null).size() != 0) {
				throw new Exception("La dirección de correo ya se encuentra registrado");
			}
			if (findByCriteria(celular, null, null).size() != 0) {
				throw new Exception("El número de celular ya se encuentra registrado");
			}

			usuarioDAO.save(entity);
			log.debug("save Usuario successful");

			String message = "Se creó la cuenta correctamente\n\nSu código de acceso es: " + entity.getCodigo()
					+ "\nSu contraseña es: " + password + "\n\nGracias por ingresar a nuestra plataforma";
			emailCorreo.sendSimpleMessage(entity.getCorreo(), "SaberProTool: Creación de cuenta", message);
		} catch (Exception e) {
			log.error("save Usuario failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteUsuario(Usuario entity) throws Exception {
		log.debug("deleting Usuario instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Usuario");
		}

		if (entity.getIdUsuario() == null) {
			throw new ZMessManager().new EmptyFieldException("idUsuario");
		}

		List<Matricula> matriculas = null;
		List<ProgramaUsuario> programaUsuarios = null;

		try {
			matriculas = matriculaDAO.findByProperty("usuario.idUsuario", entity.getIdUsuario());

			if (Utilities.validationsList(matriculas) == true) {
				throw new ZMessManager().new DeletingException("matriculas");
			}

			programaUsuarios = programaUsuarioDAO.findByProperty("usuario.idUsuario", entity.getIdUsuario());

			if (Utilities.validationsList(programaUsuarios) == true) {
				throw new ZMessManager().new DeletingException("programaUsuarios");
			}

			usuarioDAO.deleteById(entity.getIdUsuario());
			log.debug("delete Usuario successful");
		} catch (Exception e) {
			log.error("delete Usuario failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateUsuario(Usuario entity) throws Exception {
		log.debug("updating Usuario instance");

		try {
			if (entity == null) {
				throw new Exception("El usuario no puede ser nulo");
			}

			validateUsuario(entity);

			Object[] identificacion = { "identificacion", true, entity.getIdentificacion(), "=", "codigo", true,
					entity.getCodigo(), "<>" };
			Object[] correo = { "correo", true, entity.getCorreo(), "=", "codigo", true, entity.getCodigo(), "<>" };
			Object[] celular = { "celular", true, entity.getCelular(), "=", "codigo", true, entity.getCodigo(), "<>" };

			if (findByCriteria(identificacion, null, null).size() != 0) {
				throw new Exception("El número de identificación ya se encuentra registrado");
			}
			if (findByCriteria(correo, null, null).size() != 0) {
				throw new Exception("La dirección de correo ya se encuentra registrado");
			}
			if (findByCriteria(celular, null, null).size() != 0) {
				throw new Exception("El número de celular ya se encuentra registrado");
			}

			usuarioDAO.update(entity);

			log.debug("update Usuario successful");
		} catch (Exception e) {
			log.error("update Usuario failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<UsuarioDTO> getDataUsuario() throws Exception {
		try {
			List<Usuario> usuario = usuarioDAO.findAll();

			List<UsuarioDTO> usuarioDTO = new ArrayList<UsuarioDTO>();

			for (Usuario usuarioTmp : usuario) {
				UsuarioDTO usuarioDTO2 = usuarioMapper.usuarioToUsuarioDTO(usuarioTmp);
				usuarioDTO.add(usuarioDTO2);
			}

			return usuarioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public List<UsuarioDTO> getDataUsuario(String tipo) throws Exception {
		try {
			List<Usuario> usuario = usuarioDAO.findAll(tipo);

			List<UsuarioDTO> usuarioDTO = new ArrayList<UsuarioDTO>();

			for (Usuario usuarioTmp : usuario) {
				UsuarioDTO usuarioDTO2 = usuarioMapper.usuarioToUsuarioDTO(usuarioTmp);
				usuarioDTO.add(usuarioDTO2);
			}

			return usuarioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Usuario getUsuario(Long idUsuario) throws Exception {
		log.debug("getting Usuario instance");

		Usuario entity = null;

		try {
			entity = usuarioDAO.findById(idUsuario);
		} catch (Exception e) {
			log.error("get Usuario failed", e);
			throw new ZMessManager().new FindingException("Usuario");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Usuario> findPageUsuario(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Usuario> entity = null;

		try {
			entity = usuarioDAO.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuario Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberUsuario() throws Exception {
		Long entity = null;

		try {
			entity = usuarioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuario Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles
	 *            este arreglo debera tener:
	 *
	 *            [0] = String variable = (String) varibles[i]; representa como se
	 *            llama la variable en el pojo
	 *
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa
	 *            si el valor necesita o no ''(comillas simples)usado para campos de
	 *            tipo string
	 *
	 *            [2] = Object value = varibles[i + 2]; representa el valor que se
	 *            va a buscar en la BD
	 *
	 *            [3] = String comparator = (String) varibles[i + 3]; representa que
	 *            tipo de busqueda voy a hacer.., ejemplo: where nombre=william o
	 *            where nombre<>william, en este campo iria el tipo de comparador
	 *            que quiero si es = o <>
	 *
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *            la diferencia son estas dos posiciones
	 *
	 *            [0] = String variable = (String) varibles[j]; la variable ne la BD
	 *            que va a ser buscada en un rango
	 *
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en un
	 *            rango
	 *
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un
	 *            rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
	 *
	 *            [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
	 *            ejemplo: a comparator1 1 and a < 5
	 *
	 *            [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
	 *            ejemplo: a comparador1>1 and a comparador2<5 (el original: a > 1
	 *            and a < 5) *
	 * @param variablesBetweenDates(en
	 *            este caso solo para mysql) [0] = String variable = (String)
	 *            varibles[k]; el nombre de la variable que hace referencia a una
	 *            fecha
	 *
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben
	 *            ser dates)
	 *
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben
	 *            ser dates)
	 *
	 *            esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<Usuario> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Usuario> list = new ArrayList<Usuario>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between " + value + " and " + value2 + ")")
							: (tempWhere + " AND (model." + variable + " between " + value + " and " + value2 + ")");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = usuarioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByCodigo(long codigo) throws Exception {
		log.debug("getting Usuario instance");

		Usuario entity = null;

		try {
			entity = usuarioDAO.findByCodigo(codigo);
		} catch (Exception e) {
			log.error("get Usuario failed", e);
			throw new ZMessManager().new FindingException("Usuario");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioDTO findDataByCodigo(long codigo) throws Exception {
		log.debug("getting Usuario instance");

		Usuario entity = null;
		UsuarioDTO entityDTO = null;
		try {
			entity = usuarioDAO.findByCodigo(codigo);
			entityDTO = usuarioMapper.usuarioToUsuarioDTO(entity);
		} catch (Exception e) {
			log.error("get Usuario failed", e);
			throw new ZMessManager().new FindingException("Usuario");
		} finally {
		}

		return entityDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByEmail(String email) throws Exception {
		log.debug("getting Usuario instance");

		Usuario entity = null;

		try {
			entity = usuarioDAO.findByEmail(email);
		} catch (Exception e) {
			log.error("get Usuario failed", e);
			throw new ZMessManager().new FindingException("Usuario");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public User loadByCodigo(long codigo) throws Exception {

		Usuario usuario = usuarioDAO.findByCodigo(codigo);

		if (usuario != null) {
			List<GrupoOpcion> grupos = grupoOpcionDao.findByTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario());
			List<GrantedAuthority> permisos = new ArrayList<>();
			TipoUsuario tipoUsuario = tipoUsuarioLogic.getTipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario());

			
			permisos.add(new SimpleGrantedAuthority("ROLE_"+ tipoUsuario.getNombre()));
			
			log.info("Tipo de usuario: " + tipoUsuario.getNombre());
			
			User user = new User(Long.toString(usuario.getCodigo()), usuario.getPassword(), permisos);

			return user;
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void resetByEmail(String email) throws Exception {
		log.debug("updating Usuario instance");

		try {
			Usuario usuario = usuarioDAO.findByEmail(email);
			if (usuario == null) {
				throw new ZMessManager().new NullEntityExcepcion("Usuario");
			}

			String password = passwordGenerator.password(8);

			usuario.setPassword(passwordEncoder.encode(password));
			usuario.setActivo(Constantes.ESTADO_PENDIENTE);

			validateUsuario(usuario);

			usuarioDAO.update(usuario);

			String message = FacesUtils.plantillaCorreo(Long.toString(usuario.getCodigo()), password);
			emailCorreo.sendSimpleHtml(usuario.getCorreo(), "SaberProTool: Reestablecer contraseña de la cuenta",
					message);

			log.debug("update Usuario successful");
		} catch (Exception e) {
			log.error("update Usuario failed", e);
			throw e;
		} finally {
		}
	}

	@Override
	public String encodePassword(String code) throws Exception {
		return passwordEncoder.encode(code);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByTipoUsuarioPrograma(long idPrograma, long idTipoUsuario) throws Exception {
		List<Usuario> entity = null;

		try {
			entity = usuarioDAO.findByTipoUsuarioPrograma(idPrograma, idTipoUsuario);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuario Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByTipoUsuarioFacultad(long idFacultad, long idTipoUsuario) throws Exception {
		List<Usuario> entity = null;

		try {
			entity = usuarioDAO.findByTipoUsuarioFacultad(idFacultad, idTipoUsuario);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuario Count");
		} finally {
		}

		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void asignarDecano(Usuario decano,Usuario despedido,long user,long idFacultad) throws Exception {

		try {
			if(decano!=null) {
				if(despedido!=null) {
					
					Object[] variable2 = {"usuario.idUsuario",true,despedido.getIdUsuario(),"="};
					List<ProgramaUsuario> listProgramaUsuari = programaUsuarioLogic.findByCriteria(variable2,null,null);
					for (ProgramaUsuario programaUsuario : listProgramaUsuari) {
						if(programaUsuario.getActivo().equals(Constantes.ESTADO_ASIGNADO)) {
							programaUsuarioLogic.deleteProgramaUsuario(programaUsuario);
						}
					}
					despedido.setTipoUsuario(tipoUsuarioLogic.getTipoUsuario(Constantes.USER_TYPE_DOCENTE));
					despedido.setFechaModificacion(new Date());
					despedido.setUsuModificador(user);					
					usuarioDAO.update(despedido);
				}
				
				decano.setTipoUsuario(tipoUsuarioLogic.getTipoUsuario(Constantes.USER_TYPE_DECANO));
				decano.setFechaModificacion(new Date());
				decano.setUsuModificador(user);
				
				usuarioDAO.update(decano);
				
				Object[] variable5 = {"usuario.idUsuario",true,decano.getIdUsuario(),"=","activo",true,Constantes.ESTADO_ACTIVO,"="};
				ProgramaUsuario entityPrograma = programaUsuarioLogic.findByCriteria(variable5,null,null).get(0);
				
				Object[] variable3 = {"facultad.idFacultad",true,idFacultad,"="};					
				List<Programa> listPrograma = programaLogic.findByCriteria(variable3,null,null);
				for (Programa programa : listPrograma) {
					ProgramaUsuario programaUsuario = new ProgramaUsuario();
					programaUsuario.setActivo(Constantes.ESTADO_ASIGNADO);
					programaUsuario.setFechaCreacion(new Date());
					programaUsuario.setPrograma(programa);
					programaUsuario.setUsuario(decano);
					programaUsuario.setUsuCreador(user);
					
					if(entityPrograma.getPrograma().getIdPrograma()!=programa.getIdPrograma())
						programaUsuarioLogic.saveProgramaUsuario(programaUsuario);
				}
			}

		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuario Count");
		} finally {
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByUsuarioInPrueba(long idPrueba) throws Exception {
		List<Usuario> entity = null;

		try {
			entity = usuarioDAO.findByUsuarioInPrueba(idPrueba);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuario Count");
		} finally {
		}

		return entity;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findByUsuarioInPruebaActivo(long idPrueba) throws Exception {
		List<Usuario> entity = null;

		try {
			entity = usuarioDAO.findByUsuarioInPruebaActivo(idPrueba);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Usuario Count");
		} finally {
		}

		return entity;
	}

}
