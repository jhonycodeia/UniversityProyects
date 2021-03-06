package com.saberpro.modelo.control;

import com.saberpro.dataaccess.dao.*;

import com.saberpro.dto.mapper.IProgramaUsuarioMapper;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ProgramaUsuarioDTO;

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
@Service("ProgramaUsuarioLogic")
public class ProgramaUsuarioLogic implements IProgramaUsuarioLogic {
    private static final Logger log = LoggerFactory.getLogger(ProgramaUsuarioLogic.class);

    /**
     * DAO injected by Spring that manages ProgramaUsuario entities
     *
     */
    @Autowired
    private IProgramaUsuarioDAO programaUsuarioDAO;
    @Autowired
    private IProgramaUsuarioMapper programaUsuarioMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages PruebaProgramaUsuario entities
    *
    */
    @Autowired
    private IPruebaProgramaUsuarioDAO pruebaProgramaUsuarioDAO;

    /**
    * Logic injected by Spring that manages Programa entities
    *
    */
    @Autowired
    IProgramaLogic logicPrograma1;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario2;

    public void validateProgramaUsuario(ProgramaUsuario programaUsuario)
        throws Exception {
        try {
            Set<ConstraintViolation<ProgramaUsuario>> constraintViolations = validator.validate(programaUsuario);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<ProgramaUsuario> constraintViolation : constraintViolations) {
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
    public List<ProgramaUsuario> getProgramaUsuario() throws Exception {
        log.debug("finding all ProgramaUsuario instances");

        List<ProgramaUsuario> list = new ArrayList<ProgramaUsuario>();

        try {
            list = programaUsuarioDAO.findAll();
        } catch (Exception e) {
            log.error("finding all ProgramaUsuario failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "ProgramaUsuario");
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<ProgramaUsuario> getProgramaUsuario(String tipo) throws Exception {
        log.debug("finding all ProgramaUsuario instances");

        List<ProgramaUsuario> list = new ArrayList<ProgramaUsuario>();

        try {
            list = programaUsuarioDAO.findAll(tipo);
        } catch (Exception e) {
            log.error("finding all ProgramaUsuario failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "ProgramaUsuario");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveProgramaUsuario(ProgramaUsuario entity)
        throws Exception {
        log.debug("saving ProgramaUsuario instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "ProgramaUsuario");
            }

            validateProgramaUsuario(entity);

            programaUsuarioDAO.save(entity);
            log.debug("save ProgramaUsuario successful");
        } catch (Exception e) {
            log.error("save ProgramaUsuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteProgramaUsuario(ProgramaUsuario entity)
        throws Exception {
        log.debug("deleting ProgramaUsuario instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("ProgramaUsuario");
        }

        if (entity.getIdProgramaUsuario() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "idProgramaUsuario");
        }

        List<PruebaProgramaUsuario> pruebaProgramaUsuarios = null;

        try {
            pruebaProgramaUsuarios = pruebaProgramaUsuarioDAO.findByProperty("programaUsuario.idProgramaUsuario",
                    entity.getIdProgramaUsuario());

            if (Utilities.validationsList(pruebaProgramaUsuarios) == true) {
                throw new ZMessManager().new DeletingException(
                    "pruebaProgramaUsuarios");
            }

            programaUsuarioDAO.deleteById(entity.getIdProgramaUsuario());
            log.debug("delete ProgramaUsuario successful");
        } catch (Exception e) {
            log.error("delete ProgramaUsuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateProgramaUsuario(ProgramaUsuario entity)
        throws Exception {
        log.debug("updating ProgramaUsuario instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "ProgramaUsuario");
            }

            validateProgramaUsuario(entity);

            programaUsuarioDAO.update(entity);

            log.debug("update ProgramaUsuario successful");
        } catch (Exception e) {
            log.error("update ProgramaUsuario failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaUsuarioDTO> getDataProgramaUsuario()
        throws Exception {
        try {
            List<ProgramaUsuario> programaUsuario = programaUsuarioDAO.findAll();

            List<ProgramaUsuarioDTO> programaUsuarioDTO = new ArrayList<ProgramaUsuarioDTO>();

            for (ProgramaUsuario programaUsuarioTmp : programaUsuario) {
                ProgramaUsuarioDTO programaUsuarioDTO2 = programaUsuarioMapper.programaUsuarioToProgramaUsuarioDTO(programaUsuarioTmp);
                programaUsuarioDTO.add(programaUsuarioDTO2);
            }

            return programaUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional(readOnly = true)
    public List<ProgramaUsuarioDTO> getDataProgramaUsuario(String tipo)
        throws Exception {
        try {
            List<ProgramaUsuario> programaUsuario = programaUsuarioDAO.findAll(tipo);

            List<ProgramaUsuarioDTO> programaUsuarioDTO = new ArrayList<ProgramaUsuarioDTO>();

            for (ProgramaUsuario programaUsuarioTmp : programaUsuario) {
                ProgramaUsuarioDTO programaUsuarioDTO2 = programaUsuarioMapper.programaUsuarioToProgramaUsuarioDTO(programaUsuarioTmp);
                programaUsuarioDTO.add(programaUsuarioDTO2);
            }

            return programaUsuarioDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ProgramaUsuario getProgramaUsuario(Long idProgramaUsuario)
        throws Exception {
        log.debug("getting ProgramaUsuario instance");

        ProgramaUsuario entity = null;

        try {
            entity = programaUsuarioDAO.findById(idProgramaUsuario);
        } catch (Exception e) {
            log.error("get ProgramaUsuario failed", e);
            throw new ZMessManager().new FindingException("ProgramaUsuario");
        } finally {
        }

        return entity;
    }
    
    @Transactional(readOnly = true)
    public ProgramaUsuarioDTO getDataProgramaUsuario(Long idProgramaUsuario)
        throws Exception {
        log.debug("getting ProgramaUsuario instance");

        ProgramaUsuario entity = null;

        try {
            entity = programaUsuarioDAO.findById(idProgramaUsuario);
        } catch (Exception e) {
            log.error("get ProgramaUsuario failed", e);
            throw new ZMessManager().new FindingException("ProgramaUsuario");
        } finally {
        }

        return programaUsuarioMapper.programaUsuarioToProgramaUsuarioDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ProgramaUsuario> findPageProgramaUsuario(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<ProgramaUsuario> entity = null;

        try {
            entity = programaUsuarioDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "ProgramaUsuario Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberProgramaUsuario() throws Exception {
        Long entity = null;

        try {
            entity = programaUsuarioDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "ProgramaUsuario Count");
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
    public List<ProgramaUsuario> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<ProgramaUsuario> list = new ArrayList<ProgramaUsuario>();
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
            list = programaUsuarioDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
