package com.green.service;

import com.green.dto.ComentarioDTO;

import com.green.exception.*;

import com.green.mapper.ComentarioMapper;

import com.green.modelo.*;

import com.green.repository.*;
import com.green.utility.Constantes;
import com.green.utility.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 * @author Zathura Code Generator http://zathuracode.org/ www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class ComentarioServiceImpl implements ComentarioService {
	private static final Logger log = LoggerFactory.getLogger(ComentarioServiceImpl.class);

	/**
	 * Repository injected by Spring that manages Comentario entities
	 *
	 */
	@Autowired
	private TipoNotificacionRepository tipoNotificacionRepository;
	@Autowired
	private NotificacionRepository notificacionRepository;
	@Autowired
	private CapsulaRepository capsulaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private UsuarioTrofeoRepository usuarioTrofeoRepository;
	@Autowired
	private TrofeoRepository trofeoRepository;
	@Autowired
	private TipoPuntosRepository tipoPuntosRepository;
	@Autowired
	private PuntosRepository puntosRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private ComentarioMapper comentarioMapper;
	@Autowired
	private Validator validator;

	/**
	 * Service injected by Spring that manages Capsula entities
	 *
	 */
	@Autowired
	CapsulaService serviceCapsula1;

	/**
	 * Service injected by Spring that manages Usuario entities
	 *
	 */
	@Autowired
	UsuarioService serviceUsuario2;

	public void validateComentario(Comentario comentario) throws Exception {
		try {
			Set<ConstraintViolation<Comentario>> constraintViolations = validator.validate(comentario);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<Comentario> constraintViolation : constraintViolations) {
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
	public List<Comentario> getComentario() throws Exception {
		log.debug("finding all Comentario instances");

		List<Comentario> list = new ArrayList<Comentario>();

		try {
			list = comentarioRepository.findAll();
		} catch (Exception e) {
			log.error("finding all Comentario failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Comentario");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveComentario(Comentario entity) throws Exception {
		log.debug("saving Comentario instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Comentario");
			}

			validateComentario(entity);

//            if (getComentario(entity.getIdComentario()) != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }

			comentarioRepository.save(entity);

			// puntos
			log.debug("update puntos instance");
			
			Capsula capsula = capsulaRepository.getOne(entity.getCapsula().getIdCapsula());
			Usuario usuario = usuarioRepository.getOne(capsula.getUsuario().getIdUsuario());

			if (entity.getUsuario().getIdUsuario() != usuario.getIdUsuario()) {
				List<Puntos> listPuntos = puntosRepository
						.findByCriteria("model.usuario.idUsuario=" + usuario.getIdUsuario());

				for (Puntos puntos : listPuntos) {
					if (puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TOTAL
							|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_GANADO
							|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_COMENTAR) {

						puntos.setPuntos((puntos.getPuntos() + 5L));
						puntos.setFechaModificacion(new Date());
						puntos.setUsuModificador(entity.getUsuario().getIdUsuario());

						puntosRepository.update(puntos);
					}
				}

				usuario.setPuntos((usuario.getPuntos() + 5L));
				usuario.setFechaModificacion(new Date());
				usuario.setUsuModificador(entity.getUsuario().getIdUsuario());

				usuarioRepository.update(usuario);

				log.debug("saving trofeos instance");
				// Trofeos
				UsuarioTrofeo usuarioTrofeo = null;

				List<Trofeo> listTrofeos = trofeoRepository.findAll();

				for (Trofeo trofeo : listTrofeos) {
					List<UsuarioTrofeo> trofeoGanados = usuarioTrofeoRepository
							.findByCriteria("model.usuario.idUsuario=" + usuario.getIdUsuario()
									+ " and model.trofeo.idTrofeo=" + trofeo.getIdTrofeo());
					if (trofeoGanados.size() == 0) {
						if (usuario.getPuntos() >= trofeo.getRequisito()) {
							usuarioTrofeo = new UsuarioTrofeo();
							usuarioTrofeo.setFechaCreacion(new Date());
							usuarioTrofeo.setUsuCreador(entity.getUsuario().getIdUsuario());
							usuarioTrofeo.setUsuario(usuario);
							usuarioTrofeo.setTrofeo(trofeo);
							usuarioTrofeo.setActivo(Constantes.ESTADO_ACTIVO);

							usuarioTrofeoRepository.save(usuarioTrofeo);
						}
					}
				}
				
				//notificacion comentario
				Notificacion notificacion = new Notificacion();
				
				notificacion.setNombre("Se a comentado tu capsula:"+capsula.getTitulo());
				notificacion.setUsuario(usuario);
				notificacion.setTipoNotificacion(tipoNotificacionRepository.getOne(Constantes.NOTIFICACION_TYPE_PERSONAL));
				notificacion.setCapsula(capsula);
				notificacion.setActivo(Constantes.ESTADO_PENDIENTE);
				notificacion.setFechaCreacion(new Date());
				notificacion.setUsuCreador(entity.getUsuario().getIdUsuario());
				notificacion.setValor("/XHTML/capsula/capsulaDetalle.xhtml?id="+capsula.getIdCapsula());
				
				notificacionRepository.save(notificacion);
			}

			log.debug("save Comentario successful");
		} catch (Exception e) {
			log.error("save Comentario failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteComentario(Comentario entity) throws Exception {
		log.debug("deleting Comentario instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Comentario");
		}

		if (entity.getIdComentario() == null) {
			throw new ZMessManager().new EmptyFieldException("idComentario");
		}

		try {
			comentarioRepository.deleteById(entity.getIdComentario());
			log.debug("delete Comentario successful");
		} catch (Exception e) {
			log.error("delete Comentario failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateComentario(Comentario entity) throws Exception {
		log.debug("updating Comentario instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Comentario");
			}

			validateComentario(entity);

			comentarioRepository.update(entity);

			log.debug("update Comentario successful");
		} catch (Exception e) {
			log.error("update Comentario failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ComentarioDTO> getDataComentario() throws Exception {
		try {
			List<Comentario> comentario = comentarioRepository.findAll();

			List<ComentarioDTO> comentarioDTO = new ArrayList<ComentarioDTO>();

			for (Comentario comentarioTmp : comentario) {
				ComentarioDTO comentarioDTO2 = comentarioMapper.comentarioToComentarioDTO(comentarioTmp);
				comentarioDTO.add(comentarioDTO2);
			}

			return comentarioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Comentario getComentario(Long idComentario) throws Exception {
		log.debug("getting Comentario instance");

		Comentario entity = null;

		try {
			if (comentarioRepository.findById(idComentario).isPresent()) {
				entity = comentarioRepository.findById(idComentario).get();
			}
		} catch (Exception e) {
			log.error("get Comentario failed", e);
			throw new ZMessManager().new FindingException("Comentario");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Comentario> findPageComentario(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<Comentario> entity = null;

		try {
			entity = comentarioRepository.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Comentario Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberComentario() throws Exception {
		Long entity = null;

		try {
			entity = comentarioRepository.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Comentario Count");
		} finally {
		}

		return entity;
	}

	/**
	 *
	 * @param varibles         este arreglo debera tener:
	 *
	 *                         [0] = String variable = (String) varibles[i];
	 *                         representa como se llama la variable en el pojo
	 *
	 *                         [1] = Boolean booVariable = (Boolean) varibles[i +
	 *                         1]; representa si el valor necesita o no ''(comillas
	 *                         simples)usado para campos de tipo string
	 *
	 *                         [2] = Object value = varibles[i + 2]; representa el
	 *                         valor que se va a buscar en la BD
	 *
	 *                         [3] = String comparator = (String) varibles[i + 3];
	 *                         representa que tipo de busqueda voy a hacer..,
	 *                         ejemplo: where nombre=william o where
	 *                         nombre<>william, en este campo iria el tipo de
	 *                         comparador que quiero si es = o <>
	 *
	 *                         Se itera de 4 en 4..., entonces 4 registros del
	 *                         arreglo representan 1 busqueda en un campo, si se
	 *                         ponen mas pues el continuara buscando en lo que se le
	 *                         ingresen en los otros 4
	 *
	 *
	 * @param variablesBetween
	 *
	 *                         la diferencia son estas dos posiciones
	 *
	 *                         [0] = String variable = (String) varibles[j]; la
	 *                         variable ne la BD que va a ser buscada en un rango
	 *
	 *                         [1] = Object value = varibles[j + 1]; valor 1 para
	 *                         buscar en un rango
	 *
	 *                         [2] = Object value2 = varibles[j + 2]; valor 2 para
	 *                         buscar en un rango ejempolo: a > 1 and a < 5 --> 1
	 *                         seria value y 5 seria value2
	 *
	 *                         [3] = String comparator1 = (String) varibles[j + 3];
	 *                         comparador 1 ejemplo: a comparator1 1 and a < 5
	 *
	 *                         [4] = String comparator2 = (String) varibles[j + 4];
	 *                         comparador 2 ejemplo: a comparador1>1 and a
	 *                         comparador2<5 (el original: a > 1 and a < 5) *
	 * @param                  variablesBetweenDates(en este caso solo para mysql)
	 *                         [0] = String variable = (String) varibles[k]; el
	 *                         nombre de la variable que hace referencia a una fecha
	 *
	 *                         [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *                         comparar(deben ser dates)
	 *
	 *                         [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *                         comparar(deben ser dates)
	 *
	 *                         esto hace un between entre las dos fechas.
	 *
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<Comentario> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		List<Comentario> list = new ArrayList<Comentario>();
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
			list = comentarioRepository.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
