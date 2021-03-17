package com.saberpro.modelo.control;

import com.saberpro.dataaccess.dao.*;

import com.saberpro.dto.mapper.IPruebaProgramaUsuarioMapper;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ModeloPruebaDTO;
import com.saberpro.modelo.dto.ModuloPreguntaDTO;
import com.saberpro.modelo.dto.PreguntaDTO;
import com.saberpro.modelo.dto.PruebaProgramaUsuarioDTO;
import com.saberpro.modelo.dto.RespuestaDTO;
import com.saberpro.modelo.dto.ResultadosModuloDTO;
import com.saberpro.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("PruebaProgramaUsuarioLogic")
public class PruebaProgramaUsuarioLogic implements IPruebaProgramaUsuarioLogic {
    private static final Logger log = LoggerFactory.getLogger(PruebaProgramaUsuarioLogic.class);

    /**
     * DAO injected by Spring that manages PruebaProgramaUsuario entities
     *
     */
    @Autowired
    private IPruebaProgramaUsuarioDAO pruebaProgramaUsuarioDAO;
    @Autowired
    private IPruebaProgramaUsuarioMapper pruebaProgramaUsuarioMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages PruebaProgramaUsuarioPregunta entities
    *
    */
    @Autowired
    private IPruebaProgramaUsuarioPreguntaDAO pruebaProgramaUsuarioPreguntaDAO;

    /**
    * Logic injected by Spring that manages EstadoPrueba entities
    *
    */
    @Autowired
    IEstadoPruebaLogic logicEstadoPrueba1;

    /**
    * Logic injected by Spring that manages ProgramaUsuario entities
    *
    */
    @Autowired
    IProgramaUsuarioLogic logicProgramaUsuario2;

    /**
    * Logic injected by Spring that manages Prueba entities
    *
    */
    @Autowired
    IPruebaLogic logicPrueba3;
    
    @Autowired
    private IRespuestaPruebaProgramaUsuarioPreguntaLogic respuestaPruebaProgramaUsuarioPreguntaLogic;

    public void validatePruebaProgramaUsuario(
        PruebaProgramaUsuario pruebaProgramaUsuario) throws Exception {
        try {
            Set<ConstraintViolation<PruebaProgramaUsuario>> constraintViolations =
                validator.validate(pruebaProgramaUsuario);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<PruebaProgramaUsuario> constraintViolation : constraintViolations) {
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
    public List<PruebaProgramaUsuario> getPruebaProgramaUsuario()
        throws Exception {
        log.debug("finding all PruebaProgramaUsuario instances");

        List<PruebaProgramaUsuario> list = new ArrayList<PruebaProgramaUsuario>();

        try {
            list = pruebaProgramaUsuarioDAO.findAll();
        } catch (Exception e) {
            log.error("finding all PruebaProgramaUsuario failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "PruebaProgramaUsuario");
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuario> getPruebaProgramaUsuario(String tipo)
        throws Exception {
        log.debug("finding all PruebaProgramaUsuario instances");

        List<PruebaProgramaUsuario> list = new ArrayList<PruebaProgramaUsuario>();

        try {
            list = pruebaProgramaUsuarioDAO.findAll(tipo);
        } catch (Exception e) {
            log.error("finding all PruebaProgramaUsuario failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "PruebaProgramaUsuario");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePruebaProgramaUsuario(PruebaProgramaUsuario entity)
        throws Exception {
        log.debug("saving PruebaProgramaUsuario instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "PruebaProgramaUsuario");
            }

            validatePruebaProgramaUsuario(entity);            

            pruebaProgramaUsuarioDAO.save(entity);
            log.debug("save PruebaProgramaUsuario successful");
        } catch (Exception e) {
            log.error("save PruebaProgramaUsuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePruebaProgramaUsuario(PruebaProgramaUsuario entity)
        throws Exception {
        log.debug("deleting PruebaProgramaUsuario instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "PruebaProgramaUsuario");
        }

        if (entity.getIdPruebaProgramaUsuario() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "idPruebaProgramaUsuario");
        }

        List<PruebaProgramaUsuarioPregunta> pruebaProgramaUsuarioPreguntas = null;

        try {
            pruebaProgramaUsuarioPreguntas = pruebaProgramaUsuarioPreguntaDAO.findByProperty("pruebaProgramaUsuario.idPruebaProgramaUsuario",
                    entity.getIdPruebaProgramaUsuario());

            if (Utilities.validationsList(pruebaProgramaUsuarioPreguntas) == true) {
                throw new ZMessManager().new DeletingException(
                    "pruebaProgramaUsuarioPreguntas");
            }

            pruebaProgramaUsuarioDAO.deleteById(entity.getIdPruebaProgramaUsuario());
            log.debug("delete PruebaProgramaUsuario successful");
        } catch (Exception e) {
            log.error("delete PruebaProgramaUsuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePruebaProgramaUsuario(PruebaProgramaUsuario entity)
        throws Exception {
        log.debug("updating PruebaProgramaUsuario instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "PruebaProgramaUsuario");
            }

            validatePruebaProgramaUsuario(entity);

            pruebaProgramaUsuarioDAO.update(entity);

            log.debug("update PruebaProgramaUsuario successful");
        } catch (Exception e) {
            log.error("update PruebaProgramaUsuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuarioDTO> getDataPruebaProgramaUsuario()
        throws Exception {
        try {
            List<PruebaProgramaUsuario> pruebaProgramaUsuario = pruebaProgramaUsuarioDAO.findAll();

            List<PruebaProgramaUsuarioDTO> pruebaProgramaUsuarioDTO = new ArrayList<PruebaProgramaUsuarioDTO>();

            for (PruebaProgramaUsuario pruebaProgramaUsuarioTmp : pruebaProgramaUsuario) {
                PruebaProgramaUsuarioDTO pruebaProgramaUsuarioDTO2 = pruebaProgramaUsuarioMapper.pruebaProgramaUsuarioToPruebaProgramaUsuarioDTO(pruebaProgramaUsuarioTmp);
                pruebaProgramaUsuarioDTO.add(pruebaProgramaUsuarioDTO2);
            }

            return pruebaProgramaUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuarioDTO> getDataPruebaProgramaUsuario(String tipo)
        throws Exception {
        try {
            List<PruebaProgramaUsuario> pruebaProgramaUsuario = pruebaProgramaUsuarioDAO.findAll(tipo);

            List<PruebaProgramaUsuarioDTO> pruebaProgramaUsuarioDTO = new ArrayList<PruebaProgramaUsuarioDTO>();

            for (PruebaProgramaUsuario pruebaProgramaUsuarioTmp : pruebaProgramaUsuario) {
                PruebaProgramaUsuarioDTO pruebaProgramaUsuarioDTO2 = pruebaProgramaUsuarioMapper.pruebaProgramaUsuarioToPruebaProgramaUsuarioDTO(pruebaProgramaUsuarioTmp);
                pruebaProgramaUsuarioDTO.add(pruebaProgramaUsuarioDTO2);
            }

            return pruebaProgramaUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PruebaProgramaUsuario getPruebaProgramaUsuario(
        Long idPruebaProgramaUsuario) throws Exception {
        log.debug("getting PruebaProgramaUsuario instance");

        PruebaProgramaUsuario entity = null;

        try {
            entity = pruebaProgramaUsuarioDAO.findById(idPruebaProgramaUsuario);
        } catch (Exception e) {
            log.error("get PruebaProgramaUsuario failed", e);
            throw new ZMessManager().new FindingException(
                "PruebaProgramaUsuario");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<PruebaProgramaUsuario> findPagePruebaProgramaUsuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<PruebaProgramaUsuario> entity = null;

        try {
            entity = pruebaProgramaUsuarioDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PruebaProgramaUsuario Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPruebaProgramaUsuario()
        throws Exception {
        Long entity = null;

        try {
            entity = pruebaProgramaUsuarioDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PruebaProgramaUsuario Count");
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
    public List<PruebaProgramaUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<PruebaProgramaUsuario> list = new ArrayList<PruebaProgramaUsuario>();
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
            list = pruebaProgramaUsuarioDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
	@Override
	@Transactional(readOnly = true)
	public List<ResultadosModuloDTO> findResultado(long idProgramaUsuario, long idPruebaProgramaUsuario) {
		List<ResultadosModuloDTO> entity = null;

        try {
            entity = pruebaProgramaUsuarioDAO.findResultado(idProgramaUsuario, idPruebaProgramaUsuario);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PruebaProgramaUsuario Count");
        } finally {
        }

        return entity;
	}
	
	@Override
	@Transactional(readOnly = true)
	public ModeloPruebaDTO consultarPruebaProgramaUsuario(Long idPruebaProgramaUsuario) throws Exception {
		try {
			ModeloPruebaDTO modelo = new ModeloPruebaDTO();
			
			//Se consulta la prueba programa usuario
			PruebaProgramaUsuario pruebaProgramaUsuario = getPruebaProgramaUsuario(idPruebaProgramaUsuario);
			if (pruebaProgramaUsuario == null) {
				throw new Exception("No existe la prueba programa usuario " + idPruebaProgramaUsuario);
			}
			
			Prueba prueba = pruebaProgramaUsuario.getPrueba();
			if (prueba==null || !prueba.getActivo().equals("S")) {
				throw new Exception("La prueba no existe");
			}
			
			modelo.setFechaFinal(prueba.getFechaFinal());
			modelo.setFechaInicial(prueba.getFechaInicial());
			modelo.setIdPrueba(prueba.getIdPrueba());
			
			//Se consultan las preguntas de la prueba
			Set<PruebaProgramaUsuarioPregunta> preguntas = pruebaProgramaUsuario.getPruebaProgramaUsuarioPreguntas();
			List<PruebaProgramaUsuarioPregunta> preguntasSorted = new LinkedList<>();
			
			for (PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta : preguntas) {
				preguntasSorted.add(pruebaProgramaUsuarioPregunta);
			}
			Collections.sort(preguntasSorted, new Comparator<PruebaProgramaUsuarioPregunta>() {

				@Override
				public int compare(PruebaProgramaUsuarioPregunta o1, PruebaProgramaUsuarioPregunta o2) {
					return o1.getIdPruebaProgramaUsuarioPregunta().compareTo(o2.getIdPruebaProgramaUsuarioPregunta());
				}
			});
			
			if (preguntasSorted == null || preguntasSorted.size()==0) {
				throw new Exception("La prueba no tiene preguntas calculadas. Id prueba: " + prueba.getIdPrueba());
			}
			
			List<ModuloPreguntaDTO> modulosPreguntas = new ArrayList<>();
			
			int contadorPreguntasTotales = 0;
			int contadorPreguntasContestadas = 0;
			
			for (PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta : preguntasSorted) {
			
				contadorPreguntasTotales++;
				
				ModuloPreguntaDTO moduloPreguntaDTO = new ModuloPreguntaDTO();
				
				moduloPreguntaDTO.setIdModulo(pruebaProgramaUsuarioPregunta.getPregunta().getModulo().getIdModulo());
				moduloPreguntaDTO.setNombreModulo(pruebaProgramaUsuarioPregunta.getPregunta().getModulo().getNombre());
				moduloPreguntaDTO.setPrioridadModulo(pruebaProgramaUsuarioPregunta.getPregunta().getModulo().getPrioridad());
				
				Pregunta pregunta = pruebaProgramaUsuarioPregunta.getPregunta();
				PreguntaDTO preguntaDTO = new PreguntaDTO();
				
				preguntaDTO.setActivo(pregunta.getActivo());
				preguntaDTO.setDescripcionPregunta(pregunta.getDescripcionPregunta());
				preguntaDTO.setFechaCreacion(pregunta.getFechaCreacion());
				preguntaDTO.setFechaModificacion(pregunta.getFechaModificacion());
				preguntaDTO.setIdModulo_Modulo(pregunta.getModulo().getIdModulo());
				preguntaDTO.setIdPregunta(pregunta.getIdPregunta());
				preguntaDTO.setIdTipoPregunta_TipoPregunta(pregunta.getTipoPregunta().getIdTipoPregunta());
				preguntaDTO.setRetroalimentacion(pregunta.getRetroalimentacion());
				preguntaDTO.setUsuCreador(pregunta.getUsuCreador());
				preguntaDTO.setUsuModificador(pregunta.getUsuModificador());
				
				moduloPreguntaDTO.setPreguntaDTO(preguntaDTO);
				
				Set<Respuesta> respuestas = pregunta.getRespuestas();
				List<RespuestaDTO> respuestasDTO =  new LinkedList<>();
				for (Respuesta respuesta : respuestas) {
					
					RespuestaDTO respuestaDTO = new RespuestaDTO();
					respuestaDTO.setActivo(respuesta.getActivo());
					respuestaDTO.setDescripcionRespuesta(respuesta.getDescripcionRespuesta());
					respuestaDTO.setFechaCreacion(respuesta.getFechaCreacion());
					respuestaDTO.setFechaModificacion(respuesta.getFechaModificacion());
					respuestaDTO.setIdPregunta_Pregunta(pregunta.getIdPregunta());
					respuestaDTO.setIdRespuesta(respuesta.getIdRespuesta());
					respuestaDTO.setPorcentajeAcierto(respuesta.getPorcentajeAcierto());
					respuestaDTO.setRutaImagen(respuesta.getRutaImagen());
					respuestaDTO.setUsuCreador(respuesta.getUsuCreador());
					respuestaDTO.setUsuModificador(respuesta.getUsuModificador());
					
					respuestasDTO.add(respuestaDTO);
				}
				
				moduloPreguntaDTO.setRespuestasDTO(respuestasDTO);		
				
				//Para esa prueba programa usuario pregunta, se consulta la respuesta seleccionada (Si la hay)
				Set<RespuestaPruebaProgramaUsuarioPregunta> respuestasSeleccionadas = pruebaProgramaUsuarioPregunta.getRespuestaPruebaProgramaUsuarioPreguntas();
				if (respuestasSeleccionadas!=null && respuestasSeleccionadas.size()>0) {
					Respuesta respuestaSeleccionada = respuestasSeleccionadas.iterator().next().getRespuesta();
					
					if (respuestaSeleccionada!=null) {
						
						contadorPreguntasContestadas++;
						
						RespuestaDTO respuestaSeleccionadaDTO = new RespuestaDTO();
						respuestaSeleccionadaDTO.setActivo(respuestaSeleccionada.getActivo());
						respuestaSeleccionadaDTO.setDescripcionRespuesta(respuestaSeleccionada.getDescripcionRespuesta());
						respuestaSeleccionadaDTO.setFechaCreacion(respuestaSeleccionada.getFechaCreacion());
						respuestaSeleccionadaDTO.setFechaModificacion(respuestaSeleccionada.getFechaModificacion());
						respuestaSeleccionadaDTO.setIdPregunta_Pregunta(pregunta.getIdPregunta());
						respuestaSeleccionadaDTO.setIdRespuesta(respuestaSeleccionada.getIdRespuesta());
						respuestaSeleccionadaDTO.setPorcentajeAcierto(respuestaSeleccionada.getPorcentajeAcierto());
						respuestaSeleccionadaDTO.setRutaImagen(respuestaSeleccionada.getRutaImagen());
						respuestaSeleccionadaDTO.setUsuCreador(respuestaSeleccionada.getUsuCreador());
						respuestaSeleccionadaDTO.setUsuModificador(respuestaSeleccionada.getUsuModificador());
						
						moduloPreguntaDTO.setRespuestaSeleccionada(respuestaSeleccionadaDTO);
					}
					
				}
				
				modulosPreguntas.add(moduloPreguntaDTO);
				
			}
			
			//Se ordena por módulo
			Collections.sort(modulosPreguntas, new Comparator<ModuloPreguntaDTO>() {

				@Override
				public int compare(ModuloPreguntaDTO o1, ModuloPreguntaDTO o2) {
					return o1.getIdModulo().compareTo(o1.getIdModulo());
				}

			});
			
			modelo.setModuloPreguntasDTO(modulosPreguntas);
			modelo.setNombrePrograma(pruebaProgramaUsuario.getProgramaUsuario().getPrograma().getNombre());
			modelo.setNombreTipoPrueba(prueba.getTipoPrueba().getNombre());
			modelo.setTiempo(prueba.getTiempo());
			
			modelo.setCantidadTotalDePreguntas(contadorPreguntasTotales);
			modelo.setCantidadTotalDePreguntasContestadas(contadorPreguntasContestadas);
			
			if (contadorPreguntasTotales!=0) {
				modelo.setPorcentajeAvance((int)( (contadorPreguntasContestadas*1.0D)/(contadorPreguntasTotales*1.0D)*100D) );
			}
			
			return modelo;
		} catch (Exception e) {
			log.error("Error consultando la prueba programa usuario: " + idPruebaProgramaUsuario, e);
			throw e;
		}
	}
}
