package com.green.service;

import com.green.dto.UsuarioDTO;

import com.green.exception.*;
import com.green.mapper.AreaMapper;
import com.green.mapper.PuntosMapper;
import com.green.mapper.TipoPuntosMapper;
import com.green.mapper.TipoUsuarioMapper;
import com.green.mapper.UsuarioMapper;

import com.green.modelo.*;

import com.green.repository.*;

import com.green.utility.Utilities;
import com.green.utility.Constantes;
import com.green.utility.Email;
import com.green.utility.PasswordGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    /**
     * Repository injected by Spring that manages Usuario entities
     *
     */
    //Mapper       
    @Autowired
    private UsuarioMapper usuarioMapper;   
    //Dao      
    @Autowired
    private TrofeoRepository trofeoRepository; 
    @Autowired
    private TipoPuntosRepository tipoPuntosRepository;
    @Autowired
    private AreaRepository areaRepository;  
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    //Utility
    @Autowired
    private Validator validator;
    @Autowired
	private PasswordGenerator passwordGenerator;
	@Autowired
	private Email emailCorreo;
	@Autowired
	private PasswordEncoder passwordEncoder;

    /**
    * Repository injected by Spring that manages Calificacion entities
    *
    */
    @Autowired
    private CalificacionRepository calificacionRepository;

    /**
    * Repository injected by Spring that manages Capsula entities
    *
    */
    @Autowired
    private CapsulaRepository capsulaRepository;

    /**
    * Repository injected by Spring that manages Comentario entities
    *
    */
    @Autowired
    private ComentarioRepository comentarioRepository;

    /**
    * Repository injected by Spring that manages Notificacion entities
    *
    */
    @Autowired
    private NotificacionRepository notificacionRepository;

    /**
    * Repository injected by Spring that manages Puntos entities
    *
    */
    @Autowired
    private PuntosRepository puntosRepository;

    /**
    * Repository injected by Spring that manages RecompensaUsuario entities
    *
    */
    @Autowired
    private RecompensaUsuarioRepository recompensaUsuarioRepository;

    /**
    * Repository injected by Spring that manages UsuarioTrofeo entities
    *
    */
    @Autowired
    private UsuarioTrofeoRepository usuarioTrofeoRepository;

    /**
    * Service injected by Spring that manages Area entities
    *
    */
    @Autowired
    AreaService serviceArea1;

    /**
    * Service injected by Spring that manages TipoUsuario entities
    *
    */
    @Autowired
    TipoUsuarioService serviceTipoUsuario2;

    public void validateUsuario(Usuario usuario) throws Exception {
        try {
            Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Usuario> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
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
            list = usuarioRepository.findAll();
        } catch (Exception e) {
            log.error("finding all Usuario failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Usuario");
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
            
            Object[] correo = { "correo", true, entity.getCorreo(), "=" };	

			if (findByCriteria(correo, null, null).size() != 0) {
				throw new Exception("La dirección de correo ya se encuentra registrado");
			}
            
            String password = passwordGenerator.password(8);
            
            entity.setPuntos(5L);
            entity.setUsuCreador(0L);
			entity.setClave(passwordEncoder.encode(password));	
			entity.setFechaCreacion(new Date());
			entity.setTipoUsuario(tipoUsuarioRepository.getOne(Constantes.USER_TYPE_JUGADOR));
			entity.setArea(areaRepository.getOne(Constantes.AREA_FUNCIONAL));			
			entity.setActivo(Constantes.ESTADO_PENDIENTE);

			validateUsuario(entity);
			
//            if (getUsuario(entity.getIdUsuario()) != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }

            usuarioRepository.save(entity);
            log.debug("save Usuario successful");
            
            List<TipoPuntos> listTipoPuntos = tipoPuntosRepository.findAll();
            
            for (TipoPuntos tipoPuntos : listTipoPuntos) {
				Puntos puntos = new Puntos();
				
				if(tipoPuntos.getIdTipoPuntos()==Constantes.PUNTOS_TYPE_GANADO || tipoPuntos.getIdTipoPuntos()==Constantes.PUNTOS_TYPE_TOTAL) {
					puntos.setPuntos(5L);
				}else {
					puntos.setPuntos(0L);
				}				
				puntos.setUsuCreador(entity.getUsuCreador());
				puntos.setFechaCreacion(new Date());			
				puntos.setActivo(Constantes.ESTADO_ACTIVO);
				puntos.setUsuario(entity);
				puntos.setTipoPuntos(tipoPuntos);
				
				puntosRepository.save(puntos);
				
			}
            
            Trofeo trofeo = trofeoRepository.getOne(Constantes.LLAVE_BRONCE);
            
            UsuarioTrofeo usuarioTrofeo = new UsuarioTrofeo();
            usuarioTrofeo.setFechaCreacion(new Date());
            usuarioTrofeo.setUsuCreador(0L);
            usuarioTrofeo.setActivo(Constantes.ESTADO_ACTIVO);
            usuarioTrofeo.setUsuario(entity);
            usuarioTrofeo.setTrofeo(trofeo);
            
            usuarioTrofeoRepository.save(usuarioTrofeo);
            

			String message = "Se creó la cuenta correctamente\n\nSu correo de acceso es: " + entity.getCorreo()
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

        List<Calificacion> calificacions = null;
        List<Capsula> capsulas = null;
        List<Comentario> comentarios = null;
        List<Notificacion> notificacions = null;
        List<Puntos> puntoses = null;
        List<RecompensaUsuario> recompensaUsuarios = null;
        List<UsuarioTrofeo> usuarioTrofeos = null;

        try {
            calificacions = calificacionRepository.findByProperty("usuario.idUsuario",
                    entity.getIdUsuario());

            if (Utilities.validationsList(calificacions) == true) {
                throw new ZMessManager().new DeletingException("calificacions");
            }

            capsulas = capsulaRepository.findByProperty("usuario.idUsuario",
                    entity.getIdUsuario());

            if (Utilities.validationsList(capsulas) == true) {
                throw new ZMessManager().new DeletingException("capsulas");
            }

            comentarios = comentarioRepository.findByProperty("usuario.idUsuario",
                    entity.getIdUsuario());

            if (Utilities.validationsList(comentarios) == true) {
                throw new ZMessManager().new DeletingException("comentarios");
            }

            notificacions = notificacionRepository.findByProperty("usuario.idUsuario",
                    entity.getIdUsuario());

            if (Utilities.validationsList(notificacions) == true) {
                throw new ZMessManager().new DeletingException("notificacions");
            }

            puntoses = puntosRepository.findByProperty("usuario.idUsuario",
                    entity.getIdUsuario());

            if (Utilities.validationsList(puntoses) == true) {
                throw new ZMessManager().new DeletingException("puntoses");
            }

            recompensaUsuarios = recompensaUsuarioRepository.findByProperty("usuario.idUsuario",
                    entity.getIdUsuario());

            if (Utilities.validationsList(recompensaUsuarios) == true) {
                throw new ZMessManager().new DeletingException(
                    "recompensaUsuarios");
            }

            usuarioTrofeos = usuarioTrofeoRepository.findByProperty("usuario.idUsuario",
                    entity.getIdUsuario());

            if (Utilities.validationsList(usuarioTrofeos) == true) {
                throw new ZMessManager().new DeletingException("usuarioTrofeos");
            }

            usuarioRepository.deleteById(entity.getIdUsuario());
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
                throw new ZMessManager().new NullEntityExcepcion("Usuario");
            }
            
            if(entity.getActivo().equals(Constantes.ESTADO_PENDIENTE)) {
            	entity.setActivo(Constantes.ESTADO_ACTIVO);
            	entity.setClave(passwordEncoder.encode(entity.getClave()));
            }
            validateUsuario(entity);

            usuarioRepository.update(entity);

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
            List<Usuario> usuario = usuarioRepository.findAll();

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
            if (usuarioRepository.findById(idUsuario).isPresent()) {
                entity = usuarioRepository.findById(idUsuario).get();
            }
        } catch (Exception e) {
            log.error("get Usuario failed", e);
            throw new ZMessManager().new FindingException("Usuario");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Usuario> entity = null;

        try {
            entity = usuarioRepository.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
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
            entity = usuarioRepository.count();
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
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Usuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Usuario> list = new ArrayList<Usuario>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
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
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
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
            list = usuarioRepository.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
