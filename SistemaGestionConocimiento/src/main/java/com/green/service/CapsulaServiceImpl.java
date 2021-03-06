package com.green.service;

import com.green.dto.CapsulaDTO;
import com.green.dto.RankDTO;
import com.green.exception.*;

import com.green.mapper.CapsulaMapper;

import com.green.modelo.*;

import com.green.repository.*;
import com.green.utility.Constantes;
import com.green.utility.FilesDocumento;
import com.green.utility.Utilities;
import com.vortexbird.aws.s3.IS3Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
public class CapsulaServiceImpl implements CapsulaService {
	private static final Logger log = LoggerFactory.getLogger(CapsulaServiceImpl.class);

	/**
	 * Repository injected by Spring that manages Capsula entities
	 *
	 */
	@Autowired
	private TipoNotificacionRepository tipoNotificacionRepository;
	@Autowired
	private TipoCapsulaRepository tipoCapsulaRepository;
	@Autowired
	private PuntosRepository puntosRepository;
	@Autowired
	private UsuarioTrofeoRepository usuarioTrofeoRepository;
	@Autowired
	private TrofeoRepository trofeoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private IS3Services s3Services;
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	@Autowired
	private PalabrasClaveRepository palabrasClaveRepository;
	@Autowired
	private CapsulaRepository capsulaRepository;
	@Autowired
	private CapsulaMapper capsulaMapper;
	@Autowired
	private Validator validator;

	/**
	 * Repository injected by Spring that manages Calificacion entities
	 *
	 */
	@Autowired
	private CalificacionRepository calificacionRepository;

	/**
	 * Repository injected by Spring that manages CapsulaPalabrasClave entities
	 *
	 */
	@Autowired
	private CapsulaPalabrasClaveRepository capsulaPalabrasClaveRepository;

	/**
	 * Repository injected by Spring that manages Comentario entities
	 *
	 */
	@Autowired
	private ComentarioRepository comentarioRepository;

	/**
	 * Repository injected by Spring that manages Documento entities
	 *
	 */
	@Autowired
	private DocumentoRepository documentoRepository;

	/**
	 * Repository injected by Spring that manages Notificacion entities
	 *
	 */
	@Autowired
	private NotificacionRepository notificacionRepository;

	/**
	 * Service injected by Spring that manages Categoria entities
	 *
	 */
	@Autowired
	CategoriaService serviceCategoria1;

	/**
	 * Service injected by Spring that manages Proceso entities
	 *
	 */
	@Autowired
	ProcesoService serviceProceso2;

	/**
	 * Service injected by Spring that manages Subproceso entities
	 *
	 */
	@Autowired
	SubprocesoService serviceSubproceso3;

	/**
	 * Service injected by Spring that manages TipoCapsula entities
	 *
	 */
	@Autowired
	TipoCapsulaService serviceTipoCapsula4;

	/**
	 * Service injected by Spring that manages Usuario entities
	 *
	 */
	@Autowired
	UsuarioService serviceUsuario5;

	public void validateCapsula(Capsula capsula) throws Exception {
		try {
			Set<ConstraintViolation<Capsula>> constraintViolations = validator.validate(capsula);

			if (constraintViolations.size() > 0) {
				StringBuilder strMessage = new StringBuilder();

				for (ConstraintViolation<Capsula> constraintViolation : constraintViolations) {
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
	public List<Capsula> getCapsula() throws Exception {
		log.debug("finding all Capsula instances");

		List<Capsula> list = new ArrayList<Capsula>();

		try {
			list = capsulaRepository.findAll();
		} catch (Exception e) {
			log.error("finding all Capsula failed", e);
			throw new ZMessManager().new GettingException(ZMessManager.ALL + "Capsula");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCapsula(Capsula entity) throws Exception {
		log.debug("obsoleto");
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCapsula(Capsula entity, List<FilesDocumento> documentos, List<String> palabras) throws Exception {
		log.debug("saving Capsula instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Capsula");
			}

			validateCapsula(entity);

			List<Capsula> listCapsula = capsulaRepository
					.findByCriteria("model.titulo =\'" + entity.getTitulo() + "\'");

			if (listCapsula.size() > 0) {
				throw new Exception("Ese titulo ya existe");
			}

			capsulaRepository.save(entity);

			// Guardar palabras claves
			if (palabras.size() > 0) {
				log.debug("guardando las palabras claves");
				for (String string : palabras) {
					PalabrasClave palabrasClave = null;
					List<PalabrasClave> listPalabras = palabrasClaveRepository
							.findByCriteria("model.nombre=\'" + string + "\'");
					if (listPalabras.size() > 0) {
						palabrasClave = listPalabras.get(0);
					} else {
						palabrasClave = new PalabrasClave();

						palabrasClave.setNombre(string);
						palabrasClave.setFechaCreacion(new Date());
						palabrasClave.setUsuCreador(entity.getUsuCreador());
						palabrasClave.setActivo(Constantes.ESTADO_ACTIVO);

						palabrasClaveRepository.save(palabrasClave);
					}
					CapsulaPalabrasClave capsulaPalabrasClave = new CapsulaPalabrasClave();

					capsulaPalabrasClave.setNombre(string);
					capsulaPalabrasClave.setFechaCreacion(new Date());
					capsulaPalabrasClave.setUsuCreador(entity.getUsuCreador());
					capsulaPalabrasClave.setActivo(Constantes.ESTADO_ACTIVO);
					capsulaPalabrasClave.setCapsula(entity);
					capsulaPalabrasClave.setPalabrasClave(palabrasClave);

					capsulaPalabrasClaveRepository.save(capsulaPalabrasClave);

				}
			}
			// guardar documentos
			if (documentos.size() > 0) {
				log.debug("guardando las archivos");
				for (FilesDocumento filesDocumentos : documentos) {

					InputStream initialStream = filesDocumentos.getInputStream();
					byte[] buffer = new byte[initialStream.available()];
					initialStream.read(buffer);

					File targetFile = new File(filesDocumentos.getName());
					OutputStream outStream = new FileOutputStream(targetFile);
					outStream.write(buffer);

					Documento documento = new Documento();

					documento.setNombre(filesDocumentos.getName());
					documento.setRuta("capsula/" + entity.getIdCapsula() + "/" + filesDocumentos.getName());
					documento.setUsuCreador(entity.getUsuCreador());
					documento.setDescripcion(filesDocumentos.getContentType());
					documento.setFechaCreacion(new Date());
					documento.setActivo(Constantes.ESTADO_ACTIVO);
					documento.setTipoDocumento(tipoDocumentoRepository.getOne(Constantes.DOCUMENTO_TYPE_FILES));
					documento.setCapsula(entity);

					s3Services.uploadPrivate(Constantes.BUCKET_NAME, documento.getRuta(), targetFile);

					outStream.close();
					initialStream.close();

					documentoRepository.save(documento);

				}
			}

			Usuario usuario = usuarioRepository.getOne(entity.getUsuario().getIdUsuario());
			Capsula capsulaPadre = entity.getParent() != 0 ? capsulaRepository.getOne(entity.getParent()) : null;
			Usuario usuarioTool = capsulaPadre != null
					? usuarioRepository.getOne(capsulaPadre.getUsuario().getIdUsuario())
					: null;

			long puntosusuario = 0L;
			long puntosPadre = 0L;
			boolean ganaPadre = false;

			if (entity.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_ESTANDAR
					|| entity.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_TOOL) {
				puntosusuario = 2L;
			} else if (entity.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_GUIA) {
				puntosusuario = 5L;
				puntosPadre = 5L;
				ganaPadre = true;
			}

			// adicionando puntos a usuario
			List<Puntos> listPuntos = puntosRepository
					.findByCriteria("model.usuario.idUsuario=" + usuario.getIdUsuario());

			for (Puntos puntos : listPuntos) {
				if (puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TOTAL
						|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_GANADO
						|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_PUBLICAR) {

					puntos.setPuntos((puntos.getPuntos() + puntosusuario));
					puntos.setFechaModificacion(new Date());
					puntos.setUsuModificador(entity.getUsuario().getIdUsuario());

					puntosRepository.update(puntos);
				}
			}

			usuario.setPuntos((usuario.getPuntos() + puntosusuario));
			usuario.setFechaModificacion(new Date());
			usuario.setUsuModificador(entity.getUsuario().getIdUsuario());

			usuarioRepository.update(usuario);

			log.debug("saving trofeos instance");
			// Trofeos
			UsuarioTrofeo usuarioTrofeo = null;

			List<Trofeo> listTrofeos = trofeoRepository.findAll();

			for (Trofeo trofeo : listTrofeos) {
				List<UsuarioTrofeo> trofeoGanados = usuarioTrofeoRepository.findByCriteria("model.usuario.idUsuario="
						+ usuario.getIdUsuario() + " and model.trofeo.idTrofeo=" + trofeo.getIdTrofeo());
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
			// asignando puntos a usuarioPadre
			if (ganaPadre) {
				listPuntos = puntosRepository.findByCriteria("model.usuario.idUsuario=" + usuarioTool.getIdUsuario());

				for (Puntos puntos : listPuntos) {
					if (puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TOTAL
							|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_GANADO
							|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TRASFERIR) {

						puntos.setPuntos((puntos.getPuntos() + puntosPadre));
						puntos.setFechaModificacion(new Date());
						puntos.setUsuModificador(entity.getUsuario().getIdUsuario());

						puntosRepository.update(puntos);
					}
				}

				usuarioTool.setPuntos((usuarioTool.getPuntos() + puntosPadre));
				usuarioTool.setFechaModificacion(new Date());
				usuarioTool.setUsuModificador(entity.getUsuario().getIdUsuario());

				usuarioRepository.update(usuarioTool);

				log.debug("saving trofeos instance");
				// Trofeos
				usuarioTrofeo = null;

				for (Trofeo trofeo : listTrofeos) {
					List<UsuarioTrofeo> trofeoGanados = usuarioTrofeoRepository
							.findByCriteria("model.usuario.idUsuario=" + usuarioTool.getIdUsuario()
									+ " and model.trofeo.idTrofeo=" + trofeo.getIdTrofeo());
					if (trofeoGanados.size() == 0) {
						if (usuarioTool.getPuntos() >= trofeo.getRequisito()) {
							usuarioTrofeo = new UsuarioTrofeo();
							usuarioTrofeo.setFechaCreacion(new Date());
							usuarioTrofeo.setUsuCreador(entity.getUsuario().getIdUsuario());
							usuarioTrofeo.setUsuario(usuarioTool);
							usuarioTrofeo.setTrofeo(trofeo);
							usuarioTrofeo.setActivo(Constantes.ESTADO_ACTIVO);

							usuarioTrofeoRepository.save(usuarioTrofeo);
						}
					}
				}

			}

//            if (getCapsula(entity.getIdCapsula()) != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }

			log.debug("save Capsula successful");
		} catch (Exception e) {
			log.error("save Capsula failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void validarCapsula(Capsula entity, Usuario usuario, boolean pasa) throws Exception {
		if (!pasa) {
			entity.setActivo(Constantes.ESTADO_INACTIVO);
			entity.setUsuModificador(usuario.getIdUsuario());
			entity.setFechaModificacion(new Date());

			capsulaRepository.update(entity);
			Notificacion notificacion = new Notificacion();

			notificacion.setUsuario(entity.getUsuario());
			notificacion.setTipoNotificacion(tipoNotificacionRepository.getOne(Constantes.NOTIFICACION_TYPE_PERSONAL));
			notificacion.setNombre("Fue rechazada tu capsula" + entity.getTitulo());
			notificacion.setCapsula(entity);
			notificacion.setActivo(Constantes.ESTADO_PENDIENTE);
			notificacion.setFechaCreacion(new Date());
			notificacion.setUsuCreador(usuario.getIdUsuario());
			notificacion.setValor("/XHTML/capsula/capsulaDetalle.xhtml?id=" + entity.getIdCapsula());

			notificacionRepository.save(notificacion);
		} else {
			entity.setActivo(Constantes.ESTADO_ACTIVO);
			entity.setUsuModificador(usuario.getIdUsuario());
			entity.setFechaModificacion(new Date());

			capsulaRepository.update(entity);

			// Puntos
			Usuario usuarioCapsula = usuarioRepository.getOne(entity.getUsuario().getIdUsuario());
			Capsula capsulaPadre = entity.getParent() != 0 ? capsulaRepository.getOne(entity.getParent()) : null;
			Usuario usuarioTool = capsulaPadre != null
					? usuarioRepository.getOne(capsulaPadre.getUsuario().getIdUsuario())
					: null;

			long puntosusuario = 0L;
			long puntosPadre = 0L;
			long puntosDivulgacion = 0L;
			boolean ganaPadre = false;

			if (entity.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_ESTANDAR) {
				puntosusuario = 5L;
			} else if (entity.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_TOOL) {
				puntosusuario = 10L;
			} else if (entity.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_GUIA) {
				puntosusuario = 3L;
				puntosPadre = 15L;
				puntosDivulgacion = 20L;
				ganaPadre = true;
			}

			// adicionando puntos a usuario
			List<Puntos> listPuntos = puntosRepository
					.findByCriteria("model.usuario.idUsuario=" + usuarioCapsula.getIdUsuario());

			for (Puntos puntos : listPuntos) {
				if (puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TOTAL
						|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_GANADO
						|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_PUBLICAR) {

					puntos.setPuntos((puntos.getPuntos() + puntosusuario));
					puntos.setFechaModificacion(new Date());
					puntos.setUsuModificador(usuario.getIdUsuario());

					puntosRepository.update(puntos);
				}
			}

			usuarioCapsula.setPuntos((usuarioCapsula.getPuntos() + puntosusuario));
			usuarioCapsula.setFechaModificacion(new Date());
			usuarioCapsula.setUsuModificador(usuario.getIdUsuario());

			usuarioRepository.update(usuarioCapsula);

			log.debug("saving trofeos instance");
			// Trofeos
			UsuarioTrofeo usuarioTrofeo = null;

			List<Trofeo> listTrofeos = trofeoRepository.findAll();

			for (Trofeo trofeo : listTrofeos) {
				List<UsuarioTrofeo> trofeoGanados = usuarioTrofeoRepository.findByCriteria("model.usuario.idUsuario="
						+ usuarioCapsula.getIdUsuario() + " and model.trofeo.idTrofeo=" + trofeo.getIdTrofeo());
				if (trofeoGanados.size() == 0) {
					if (usuarioCapsula.getPuntos() >= trofeo.getRequisito()) {
						usuarioTrofeo = new UsuarioTrofeo();
						usuarioTrofeo.setFechaCreacion(new Date());
						usuarioTrofeo.setUsuCreador(usuario.getIdUsuario());
						usuarioTrofeo.setUsuario(usuarioCapsula);
						usuarioTrofeo.setTrofeo(trofeo);
						usuarioTrofeo.setActivo(Constantes.ESTADO_ACTIVO);

						usuarioTrofeoRepository.save(usuarioTrofeo);
					}
				}
			}
			// asignando puntos a usuarioPadre
			if (ganaPadre) {
				listPuntos = puntosRepository.findByCriteria("model.usuario.idUsuario=" + usuarioTool.getIdUsuario());

				for (Puntos puntos : listPuntos) {
					if (puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TOTAL
							|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_GANADO
							|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TRASFERIR) {

						puntos.setPuntos((puntos.getPuntos() + puntosPadre));
						puntos.setFechaModificacion(new Date());
						puntos.setUsuModificador(usuario.getIdUsuario());

						puntosRepository.update(puntos);
					}
				}

				usuarioTool.setPuntos((usuarioTool.getPuntos() + puntosPadre));
				usuarioTool.setFechaModificacion(new Date());
				usuarioTool.setUsuModificador(entity.getUsuario().getIdUsuario());

				usuarioRepository.update(usuarioTool);

				// capsula divulgacion
				if (capsulaPadre.getTipoCapsula().getIdTipoCapsula() == Constantes.CAPSULA_TYPE_TOOL) {

					capsulaPadre.setTipoCapsula(tipoCapsulaRepository.getOne(Constantes.CAPSULA_TYPE_DIVULGACION));
					capsulaPadre.setUsuModificador(usuario.getIdUsuario());
					capsulaPadre.setFechaModificacion(new Date());

					capsulaRepository.update(capsulaPadre);

					listPuntos = puntosRepository
							.findByCriteria("model.usuario.idUsuario=" + usuarioTool.getIdUsuario());

					for (Puntos puntos : listPuntos) {
						if (puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TOTAL
								|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_GANADO
								|| puntos.getTipoPuntos().getIdTipoPuntos() == Constantes.PUNTOS_TYPE_TRASFERIR) {

							puntos.setPuntos((puntos.getPuntos() + puntosDivulgacion));
							puntos.setFechaModificacion(new Date());
							puntos.setUsuModificador(usuario.getIdUsuario());

							puntosRepository.update(puntos);
						}
					}

					usuarioTool.setPuntos((usuarioTool.getPuntos() + puntosDivulgacion));
					usuarioTool.setFechaModificacion(new Date());
					usuarioTool.setUsuModificador(entity.getUsuario().getIdUsuario());

					usuarioRepository.update(usuarioTool);
				}

				log.debug("saving trofeos instance");
				// Trofeos
				usuarioTrofeo = null;

				for (Trofeo trofeo : listTrofeos) {
					List<UsuarioTrofeo> trofeoGanados = usuarioTrofeoRepository
							.findByCriteria("model.usuario.idUsuario=" + usuarioTool.getIdUsuario()
									+ " and model.trofeo.idTrofeo=" + trofeo.getIdTrofeo());
					if (trofeoGanados.size() == 0) {
						if (usuarioTool.getPuntos() >= trofeo.getRequisito()) {
							usuarioTrofeo = new UsuarioTrofeo();
							usuarioTrofeo.setFechaCreacion(new Date());
							usuarioTrofeo.setUsuCreador(entity.getUsuario().getIdUsuario());
							usuarioTrofeo.setUsuario(usuarioTool);
							usuarioTrofeo.setTrofeo(trofeo);
							usuarioTrofeo.setActivo(Constantes.ESTADO_ACTIVO);

							usuarioTrofeoRepository.save(usuarioTrofeo);
						}
					}
				}

			}

			// Notificaciones

			List<Usuario> listUsuario = usuarioRepository.findAll();

			// Notificaciones social
			for (Usuario usuarioNotificacion : listUsuario) {

				if (usuarioNotificacion.getIdUsuario() != entity.getUsuario().getIdUsuario()) {
					Notificacion notificacion = new Notificacion();

					notificacion.setNombre("El usuario " + usuarioCapsula.getNombre() + " "
							+ usuarioCapsula.getApellido() + " creo una capsula");
					notificacion.setUsuario(usuarioNotificacion);
					notificacion.setTipoNotificacion(
							tipoNotificacionRepository.getOne(Constantes.NOTIFICACION_TYPE_SOCIAL));
					notificacion.setCapsula(entity);
					notificacion.setActivo(Constantes.ESTADO_PENDIENTE);
					notificacion.setFechaCreacion(new Date());
					notificacion.setUsuCreador(usuario.getIdUsuario());
					notificacion.setValor("/XHTML/capsula/capsulaDetalle.xhtml?id=" + entity.getIdCapsula());

					notificacionRepository.save(notificacion);
				}

			}

			// Notificacion Personal

			Notificacion notificacion = new Notificacion();

			notificacion.setUsuario(usuarioCapsula);
			notificacion.setNombre("Fue aprobada tu capsula:" + entity.getTitulo());
			notificacion.setTipoNotificacion(tipoNotificacionRepository.getOne(Constantes.NOTIFICACION_TYPE_PERSONAL));
			notificacion.setCapsula(entity);
			notificacion.setActivo(Constantes.ESTADO_PENDIENTE);
			notificacion.setFechaCreacion(new Date());
			notificacion.setUsuCreador(usuario.getIdUsuario());
			notificacion.setValor("/XHTML/capsula/capsulaDetalle.xhtml?id=" + entity.getIdCapsula());

			notificacionRepository.save(notificacion);

		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCapsula(Capsula entity) throws Exception {
		log.debug("deleting Capsula instance");

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Capsula");
		}

		if (entity.getIdCapsula() == null) {
			throw new ZMessManager().new EmptyFieldException("idCapsula");
		}

		List<Calificacion> calificacions = null;
		List<CapsulaPalabrasClave> capsulaPalabrasClaves = null;
		List<Comentario> comentarios = null;
		List<Documento> documentos = null;
		List<Notificacion> notificacions = null;

		try {
			calificacions = calificacionRepository.findByProperty("capsula.idCapsula", entity.getIdCapsula());

			if (Utilities.validationsList(calificacions) == true) {
				throw new ZMessManager().new DeletingException("calificacions");
			}

			capsulaPalabrasClaves = capsulaPalabrasClaveRepository.findByProperty("capsula.idCapsula",
					entity.getIdCapsula());

			if (Utilities.validationsList(capsulaPalabrasClaves) == true) {
				throw new ZMessManager().new DeletingException("capsulaPalabrasClaves");
			}

			comentarios = comentarioRepository.findByProperty("capsula.idCapsula", entity.getIdCapsula());

			if (Utilities.validationsList(comentarios) == true) {
				throw new ZMessManager().new DeletingException("comentarios");
			}

			documentos = documentoRepository.findByProperty("capsula.idCapsula", entity.getIdCapsula());

			if (Utilities.validationsList(documentos) == true) {
				throw new ZMessManager().new DeletingException("documentos");
			}

			notificacions = notificacionRepository.findByProperty("capsula.idCapsula", entity.getIdCapsula());

			if (Utilities.validationsList(notificacions) == true) {
				throw new ZMessManager().new DeletingException("notificacions");
			}

			capsulaRepository.deleteById(entity.getIdCapsula());
			log.debug("delete Capsula successful");
		} catch (Exception e) {
			log.error("delete Capsula failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCapsula(Capsula entity) throws Exception {
		log.debug("updating Capsula instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Capsula");
			}

			validateCapsula(entity);

			capsulaRepository.update(entity);

			log.debug("update Capsula successful");
		} catch (Exception e) {
			log.error("update Capsula failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCapsula(Capsula entity, List<FilesDocumento> documentos, List<String> palabras) throws Exception {
		log.debug("updating Capsula instance");

		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Capsula");
			}
			validateCapsula(entity);

			List<Capsula> listCapsula = capsulaRepository
					.findByCriteria("model.titulo =\'" + entity.getTitulo() + "\'");

			if (listCapsula.size() > 0 && listCapsula.get(0).getIdCapsula() == entity.getIdCapsula()) {
				throw new Exception("Ese titulo ya existe");
			}

			capsulaRepository.update(entity);

			List<CapsulaPalabrasClave> listCapsulaPalabras = capsulaPalabrasClaveRepository
					.findByCriteria("model.capsula.idCapsula=" + entity.getIdCapsula());

			log.debug("borrando palabras claves");
			for (CapsulaPalabrasClave capsulaPalabrasClave : listCapsulaPalabras) {
				capsulaPalabrasClaveRepository.delete(capsulaPalabrasClave);
			}

			if (palabras.size() > 0) {
				log.debug("guardando las palabras claves");
				for (String string : palabras) {
					PalabrasClave palabrasClave = null;
					List<PalabrasClave> listPalabras = palabrasClaveRepository
							.findByCriteria("model.nombre=\'" + string + "\'");
					if (listPalabras.size() > 0) {
						palabrasClave = listPalabras.get(0);
					} else {
						palabrasClave = new PalabrasClave();

						palabrasClave.setNombre(string);
						palabrasClave.setFechaCreacion(new Date());
						palabrasClave.setUsuCreador(entity.getUsuCreador());
						palabrasClave.setActivo(Constantes.ESTADO_ACTIVO);

						palabrasClaveRepository.save(palabrasClave);
					}

					CapsulaPalabrasClave capsulaPalabrasClave = new CapsulaPalabrasClave();

					capsulaPalabrasClave.setNombre(string);
					capsulaPalabrasClave.setFechaCreacion(new Date());
					capsulaPalabrasClave.setUsuCreador(entity.getUsuCreador());
					capsulaPalabrasClave.setActivo(Constantes.ESTADO_ACTIVO);
					capsulaPalabrasClave.setCapsula(entity);
					capsulaPalabrasClave.setPalabrasClave(palabrasClave);

					capsulaPalabrasClaveRepository.save(capsulaPalabrasClave);

				}
			}

			if (documentos.size() > 0) {
				log.debug("guardando las archivos nuevos");
				for (FilesDocumento filesDocumentos : documentos) {

					if (filesDocumentos.getInputStream() != null) {
						InputStream initialStream = filesDocumentos.getInputStream();
						byte[] buffer = new byte[initialStream.available()];
						initialStream.read(buffer);

						File targetFile = new File(filesDocumentos.getName());
						OutputStream outStream = new FileOutputStream(targetFile);
						outStream.write(buffer);

						Documento documento = new Documento();

						documento.setNombre(filesDocumentos.getName());
						documento.setRuta("capsula/" + entity.getIdCapsula() + "/" + filesDocumentos.getName());
						documento.setUsuCreador(entity.getUsuCreador());
						documento.setDescripcion(filesDocumentos.getContentType());
						documento.setFechaCreacion(new Date());
						documento.setActivo(Constantes.ESTADO_ACTIVO);
						documento.setTipoDocumento(tipoDocumentoRepository.getOne(Constantes.DOCUMENTO_TYPE_FILES));
						documento.setCapsula(entity);

						s3Services.uploadPrivate(Constantes.BUCKET_NAME, documento.getRuta(), targetFile);

						outStream.close();
						initialStream.close();

						documentoRepository.save(documento);
					}

				}
			}

			log.debug("update Capsula successful");
		} catch (Exception e) {
			log.error("update Capsula failed", e);
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<CapsulaDTO> getDataCapsula() throws Exception {
		try {
			List<Capsula> capsula = capsulaRepository.findAll();

			List<CapsulaDTO> capsulaDTO = new ArrayList<CapsulaDTO>();

			for (Capsula capsulaTmp : capsula) {
				CapsulaDTO capsulaDTO2 = capsulaMapper.capsulaToCapsulaDTO(capsulaTmp);
				capsulaDTO.add(capsulaDTO2);
			}

			return capsulaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Capsula getCapsula(Long idCapsula) throws Exception {
		log.debug("getting Capsula instance");

		Capsula entity = null;

		try {
			if (capsulaRepository.findById(idCapsula).isPresent()) {
				entity = capsulaRepository.findById(idCapsula).get();
			}
		} catch (Exception e) {
			log.error("get Capsula failed", e);
			throw new ZMessManager().new FindingException("Capsula");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Capsula> findPageCapsula(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Capsula> entity = null;

		try {
			entity = capsulaRepository.findPage(sortColumnName, sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Capsula Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberCapsula() throws Exception {
		Long entity = null;

		try {
			entity = capsulaRepository.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Capsula Count");
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
	public List<Capsula> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Capsula> list = new ArrayList<Capsula>();
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
			list = capsulaRepository.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RankDTO> rankPuntos(long idTipoPuntos) throws Exception {
		log.debug("getting Capsula instance");

		List<RankDTO> listRank = null;
		String sql = "Select new com.green.dto.RankDTO(usu.correo,pun.puntos) "
				+ "from Usuario usu,Puntos pun where usu.idUsuario=pun.usuario.idUsuario "
				+ "and pun.tipoPuntos.idTipoPuntos=:idTipoPuntos order by pun.puntos desc";

		try {
			listRank = capsulaRepository.createQuery(sql).setParameter("idTipoPuntos",idTipoPuntos).getResultList();
		} catch (Exception e) {
			log.error("get Capsula failed", e);
			return null;
		} finally {
		}

		return listRank;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RankDTO> rankCapsulas() throws Exception {
		log.debug("getting Capsula instance");

		List<RankDTO> listRank = null;
		String sql = "Select new com.green.dto.RankDTO(0,usu.correo,usu.capsulas.size) from Usuario usu order by (usu.capsulas.size) desc";

		try {
			listRank = capsulaRepository.createQuery(sql).getResultList();
		} catch (Exception e) {
			log.error("get Capsula failed", e);
			return null;
		} finally {
		}

		return listRank;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RankDTO> rankComentarios() throws Exception {
		log.debug("getting Capsula instance");

		List<RankDTO> listRank = null;
		String sql = "Select new com.green.dto.RankDTO(0,usu.correo,usu.comentarios.size) from Usuario usu order by (usu.comentarios.size) desc";

		try {
			listRank = capsulaRepository.createQuery(sql).getResultList();
		} catch (Exception e) {
			log.error("get Capsula failed", e);
			return null;
		} finally {
		}

		return listRank;
	}
}
