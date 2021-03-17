package com.saberpro.modelo.control;

import com.saberpro.dataaccess.dao.*;

import com.saberpro.dto.mapper.IRespuestaPruebaProgramaUsuarioPreguntaMapper;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.RespuestaPruebaProgramaUsuarioPreguntaDTO;

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
import java.util.Date;
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
@Service("RespuestaPruebaProgramaUsuarioPreguntaLogic")
public class RespuestaPruebaProgramaUsuarioPreguntaLogic
    implements IRespuestaPruebaProgramaUsuarioPreguntaLogic {
    private static final Logger log = LoggerFactory.getLogger(RespuestaPruebaProgramaUsuarioPreguntaLogic.class);

    /**
     * DAO injected by Spring that manages RespuestaPruebaProgramaUsuarioPregunta entities
     *
     */
    @Autowired
    private IRespuestaPruebaProgramaUsuarioPreguntaDAO respuestaPruebaProgramaUsuarioPreguntaDAO;
    @Autowired
    private IRespuestaPruebaProgramaUsuarioPreguntaMapper respuestaPruebaProgramaUsuarioPreguntaMapper;
    @Autowired
    private Validator validator;

    /**
    * Logic injected by Spring that manages PruebaProgramaUsuarioPregunta entities
    *
    */
    @Autowired
    IPruebaProgramaUsuarioPreguntaLogic logicPruebaProgramaUsuarioPregunta1;

    /**
    * Logic injected by Spring that manages Respuesta entities
    *
    */
    @Autowired
    IRespuestaLogic logicRespuesta2;
    
    @Autowired
    private IRespuestaLogic respuestaLogic;

    public void validateRespuestaPruebaProgramaUsuarioPregunta(
        RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta)
        throws Exception {
        try {
            Set<ConstraintViolation<RespuestaPruebaProgramaUsuarioPregunta>> constraintViolations =
                validator.validate(respuestaPruebaProgramaUsuarioPregunta);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<RespuestaPruebaProgramaUsuarioPregunta> constraintViolation : constraintViolations) {
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
    public List<RespuestaPruebaProgramaUsuarioPregunta> getRespuestaPruebaProgramaUsuarioPregunta()
        throws Exception {
        log.debug(
            "finding all RespuestaPruebaProgramaUsuarioPregunta instances");

        List<RespuestaPruebaProgramaUsuarioPregunta> list = new ArrayList<RespuestaPruebaProgramaUsuarioPregunta>();

        try {
            list = respuestaPruebaProgramaUsuarioPreguntaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all RespuestaPruebaProgramaUsuarioPregunta failed",
                e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "RespuestaPruebaProgramaUsuarioPregunta");
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<RespuestaPruebaProgramaUsuarioPregunta> getRespuestaPruebaProgramaUsuarioPregunta(String tipo)
        throws Exception {
        log.debug(
            "finding all RespuestaPruebaProgramaUsuarioPregunta instances");

        List<RespuestaPruebaProgramaUsuarioPregunta> list = new ArrayList<RespuestaPruebaProgramaUsuarioPregunta>();

        try {
            list = respuestaPruebaProgramaUsuarioPreguntaDAO.findAll(tipo);
        } catch (Exception e) {
            log.error("finding all RespuestaPruebaProgramaUsuarioPregunta failed",
                e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "RespuestaPruebaProgramaUsuarioPregunta");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveRespuestaPruebaProgramaUsuarioPregunta(
        RespuestaPruebaProgramaUsuarioPregunta entity)
        throws Exception {
        log.debug("saving RespuestaPruebaProgramaUsuarioPregunta instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "RespuestaPruebaProgramaUsuarioPregunta");
            }

            validateRespuestaPruebaProgramaUsuarioPregunta(entity);            

            respuestaPruebaProgramaUsuarioPreguntaDAO.save(entity);
            log.debug("save RespuestaPruebaProgramaUsuarioPregunta successful");
        } catch (Exception e) {
            log.error("save RespuestaPruebaProgramaUsuarioPregunta failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteRespuestaPruebaProgramaUsuarioPregunta(
        RespuestaPruebaProgramaUsuarioPregunta entity)
        throws Exception {
        log.debug("deleting RespuestaPruebaProgramaUsuarioPregunta instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "RespuestaPruebaProgramaUsuarioPregunta");
        }

        if (entity.getIdRespuestaPruebaProgramaUsuarioPregunta() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "idRespuestaPruebaProgramaUsuarioPregunta");
        }

        try {
            respuestaPruebaProgramaUsuarioPreguntaDAO.deleteById(entity.getIdRespuestaPruebaProgramaUsuarioPregunta());
            log.debug(
                "delete RespuestaPruebaProgramaUsuarioPregunta successful");
        } catch (Exception e) {
            log.error("delete RespuestaPruebaProgramaUsuarioPregunta failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateRespuestaPruebaProgramaUsuarioPregunta(
        RespuestaPruebaProgramaUsuarioPregunta entity)
        throws Exception {
        log.debug("updating RespuestaPruebaProgramaUsuarioPregunta instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "RespuestaPruebaProgramaUsuarioPregunta");
            }

            validateRespuestaPruebaProgramaUsuarioPregunta(entity);

            respuestaPruebaProgramaUsuarioPreguntaDAO.update(entity);

            log.debug(
                "update RespuestaPruebaProgramaUsuarioPregunta successful");
        } catch (Exception e) {
            log.error("update RespuestaPruebaProgramaUsuarioPregunta failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<RespuestaPruebaProgramaUsuarioPreguntaDTO> getDataRespuestaPruebaProgramaUsuarioPregunta()
        throws Exception {
        try {
            List<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPregunta =
                respuestaPruebaProgramaUsuarioPreguntaDAO.findAll();

            List<RespuestaPruebaProgramaUsuarioPreguntaDTO> respuestaPruebaProgramaUsuarioPreguntaDTO =
                new ArrayList<RespuestaPruebaProgramaUsuarioPreguntaDTO>();

            for (RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPreguntaTmp : respuestaPruebaProgramaUsuarioPregunta) {
                RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaDTO2 =
                    respuestaPruebaProgramaUsuarioPreguntaMapper.respuestaPruebaProgramaUsuarioPreguntaToRespuestaPruebaProgramaUsuarioPreguntaDTO(respuestaPruebaProgramaUsuarioPreguntaTmp);
                respuestaPruebaProgramaUsuarioPreguntaDTO.add(respuestaPruebaProgramaUsuarioPreguntaDTO2);
            }

            return respuestaPruebaProgramaUsuarioPreguntaDTO;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional(readOnly = true)
    public List<RespuestaPruebaProgramaUsuarioPreguntaDTO> getDataRespuestaPruebaProgramaUsuarioPregunta(String tipo)
        throws Exception {
        try {
            List<RespuestaPruebaProgramaUsuarioPregunta> respuestaPruebaProgramaUsuarioPregunta =
                respuestaPruebaProgramaUsuarioPreguntaDAO.findAll(tipo);

            List<RespuestaPruebaProgramaUsuarioPreguntaDTO> respuestaPruebaProgramaUsuarioPreguntaDTO =
                new ArrayList<RespuestaPruebaProgramaUsuarioPreguntaDTO>();

            for (RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPreguntaTmp : respuestaPruebaProgramaUsuarioPregunta) {
                RespuestaPruebaProgramaUsuarioPreguntaDTO respuestaPruebaProgramaUsuarioPreguntaDTO2 =
                    respuestaPruebaProgramaUsuarioPreguntaMapper.respuestaPruebaProgramaUsuarioPreguntaToRespuestaPruebaProgramaUsuarioPreguntaDTO(respuestaPruebaProgramaUsuarioPreguntaTmp);
                respuestaPruebaProgramaUsuarioPreguntaDTO.add(respuestaPruebaProgramaUsuarioPreguntaDTO2);
            }

            return respuestaPruebaProgramaUsuarioPreguntaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RespuestaPruebaProgramaUsuarioPregunta getRespuestaPruebaProgramaUsuarioPregunta(
        Long idRespuestaPruebaProgramaUsuarioPregunta)
        throws Exception {
        log.debug("getting RespuestaPruebaProgramaUsuarioPregunta instance");

        RespuestaPruebaProgramaUsuarioPregunta entity = null;

        try {
            entity = respuestaPruebaProgramaUsuarioPreguntaDAO.findById(idRespuestaPruebaProgramaUsuarioPregunta);
        } catch (Exception e) {
            log.error("get RespuestaPruebaProgramaUsuarioPregunta failed", e);
            throw new ZMessManager().new FindingException(
                "RespuestaPruebaProgramaUsuarioPregunta");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<RespuestaPruebaProgramaUsuarioPregunta> findPageRespuestaPruebaProgramaUsuarioPregunta(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<RespuestaPruebaProgramaUsuarioPregunta> entity = null;

        try {
            entity = respuestaPruebaProgramaUsuarioPreguntaDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "RespuestaPruebaProgramaUsuarioPregunta Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberRespuestaPruebaProgramaUsuarioPregunta()
        throws Exception {
        Long entity = null;

        try {
            entity = respuestaPruebaProgramaUsuarioPreguntaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "RespuestaPruebaProgramaUsuarioPregunta Count");
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
    public List<RespuestaPruebaProgramaUsuarioPregunta> findByCriteria(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        List<RespuestaPruebaProgramaUsuarioPregunta> list = new ArrayList<RespuestaPruebaProgramaUsuarioPregunta>();
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
            list = respuestaPruebaProgramaUsuarioPreguntaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

	@Override
	 @Transactional(readOnly = true)
	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuario(
			long idPruebaProgramaUsuario) throws Exception {
		 log.debug(
		            "finding all RespuestaPruebaProgramaUsuarioPregunta instances");

		        List<RespuestaPruebaProgramaUsuarioPregunta> list = new ArrayList<RespuestaPruebaProgramaUsuarioPregunta>();

		        try {
		            list = respuestaPruebaProgramaUsuarioPreguntaDAO.findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuario(idPruebaProgramaUsuario);
		        } catch (Exception e) {
		            log.error("finding all RespuestaPruebaProgramaUsuarioPregunta failed",
		                e);
		            throw new ZMessManager().new GettingException(ZMessManager.ALL +
		                "RespuestaPruebaProgramaUsuarioPregunta");
		        } finally {
		        }

		        return list;
	}
	
	@Override
	 @Transactional(readOnly = true)
	public List<RespuestaPruebaProgramaUsuarioPregunta> findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuarioPregunta(
			long idPruebaProgramaUsuarioPregunta) throws Exception {
		 log.debug(
		            "finding all findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuarioPregunta instances");

		        List<RespuestaPruebaProgramaUsuarioPregunta> list = new ArrayList<RespuestaPruebaProgramaUsuarioPregunta>();

		        try {
		            list = respuestaPruebaProgramaUsuarioPreguntaDAO.findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuarioPregunta(idPruebaProgramaUsuarioPregunta);
		        } catch (Exception e) {
		            log.error("finding all findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuarioPregunta failed",
		                e);
		            throw new ZMessManager().new GettingException(ZMessManager.ALL +
		                "RespuestaPruebaProgramaUsuarioPregunta");
		        } finally {
		        }

		        return list;
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void guardarRespuestaAPregunta(Long idPruebaProgramaUsuarioPregunta, Long idRespuesta) throws Exception {
		try {
			
			//Se consulta la prueba programa usuario
			PruebaProgramaUsuarioPregunta programaUsuarioPregunta = 
					logicPruebaProgramaUsuarioPregunta1.getPruebaProgramaUsuarioPregunta(idPruebaProgramaUsuarioPregunta);
			if (programaUsuarioPregunta == null || !programaUsuarioPregunta.getActivo().equals("S")) {
				throw new Exception("No existe programaUsuarioPregunta " + idPruebaProgramaUsuarioPregunta);
			}
			
			//Se consulta la respuesta
			Respuesta respuesta = respuestaLogic.getRespuesta(idRespuesta);
			if (respuesta==null || !respuesta.getActivo().equals("S")) {
				throw new Exception("No existe la respuesta " + idRespuesta);
			}
			
			Set<RespuestaPruebaProgramaUsuarioPregunta> respuestasDePregunta = 
					programaUsuarioPregunta.getRespuestaPruebaProgramaUsuarioPreguntas();
			
			for (RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta : respuestasDePregunta) {
				//se actualiza la respuesta y el % de acierto
				respuestaPruebaProgramaUsuarioPregunta.setRespuesta(respuesta);
				respuestaPruebaProgramaUsuarioPregunta.setPorcentajeAsignado(new Long(respuesta.getPorcentajeAcierto()));
				
				updateRespuestaPruebaProgramaUsuarioPregunta(respuestaPruebaProgramaUsuarioPregunta);
			}
			
			
		} catch (Exception e) {
			log.error("Ocurrió un error guardando la respuesta a la pregunta", e);
			throw e;
		}
	}
}
