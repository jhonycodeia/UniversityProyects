package com.co.indra.service;

import com.co.indra.dto.CalculoDTO;
import com.co.indra.dto.RegistroCalculoDTO;
import com.co.indra.exception.*;
import com.co.indra.mapper.RegistroCalculoMapper;
import com.co.indra.model.*;
import com.co.indra.repository.*;
import com.co.indra.utility.CalculoMath;
import com.co.indra.utility.Constantes;
import com.co.indra.utility.Utilities;

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
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class RegistroCalculoServiceImpl implements RegistroCalculoService {
    private static final Logger log = LoggerFactory.getLogger(RegistroCalculoServiceImpl.class);

    /**
     * Repository injected by Spring that manages RegistroCalculo entities
     *
     */
    @Autowired
    private RegistroCalculoRepository registroCalculoRepository;
    @Autowired
    private UsuariosRepository usuariosRepository ;
    @Autowired
    private RegistroCalculoMapper registroCalculoMapper;
    @Autowired
	private CalculoMath calculo;
    @Autowired
    private Validator validator;

    /**
    * Service injected by Spring that manages Usuarios entities
    *
    */
    @Autowired
    UsuariosService serviceUsuarios1;

    public void validateRegistroCalculo(RegistroCalculo registroCalculo)
        throws Exception {
        try {
            Set<ConstraintViolation<RegistroCalculo>> constraintViolations = validator.validate(registroCalculo);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<RegistroCalculo> constraintViolation : constraintViolations) {
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
    public List<RegistroCalculo> getRegistroCalculo() throws Exception {
        log.debug("finding all RegistroCalculo instances");

        List<RegistroCalculo> list = new ArrayList<RegistroCalculo>();

        try {
            list = registroCalculoRepository.findAll();
        } catch (Exception e) {
            log.error("finding all RegistroCalculo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "RegistroCalculo");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveRegistroCalculo(RegistroCalculo entity)
        throws Exception {
        log.debug("saving RegistroCalculo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "RegistroCalculo");
            }

            validateRegistroCalculo(entity);

            if (getRegistroCalculo(entity.getIdResultado()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            registroCalculoRepository.save(entity);
            log.debug("save RegistroCalculo successful");
        } catch (Exception e) {
            log.error("save RegistroCalculo failed", e);
            throw e;
        } finally {
        }
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public RegistroCalculo saveRegistroCalculo(CalculoDTO entity)
        throws Exception {
        log.debug("saving RegistroCalculo instance");
        RegistroCalculo registraCalculo;
        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "CalculoDTO");
            }
            if(entity.getLimite()<Constantes.MINIMO || entity.getLimite()>Constantes.MAXIMO) {
            	throw new ZMessManager("EL Numero esta fuera del rango valido");
            }
            if(entity.getUsuario()==null || entity.getUsuario().trim().isEmpty()) {
            	throw new ZMessManager("Debe escribir un nombre de usuario");
            }
            
            List<Usuarios> usuario = usuariosRepository.findByProperty("name", entity.getUsuario());
            
            if(usuario.isEmpty()) {
            	throw new ZMessManager("El Usuario "+entity.getUsuario()+" no es valido");
            }
            
            registraCalculo = new RegistroCalculo();
            
            registraCalculo.setFechaEjecucion(new Date());
            registraCalculo.setUsuarios(usuario.get(0));
            registraCalculo.setResultado(calculo.valor(2, entity.getLimite()));
            
            registroCalculoRepository.save(registraCalculo);
           
            log.debug("save RegistroCalculo successful");
        } catch (Exception e) {
            log.error("save RegistroCalculo failed", e);
            throw e;
        } 
        return registraCalculo;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteRegistroCalculo(RegistroCalculo entity)
        throws Exception {
        log.debug("deleting RegistroCalculo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("RegistroCalculo");
        }

        if (entity.getIdResultado() == null) {
            throw new ZMessManager().new EmptyFieldException("idResultado");
        }

        try {
            registroCalculoRepository.deleteById(entity.getIdResultado());
            log.debug("delete RegistroCalculo successful");
        } catch (Exception e) {
            log.error("delete RegistroCalculo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateRegistroCalculo(RegistroCalculo entity)
        throws Exception {
        log.debug("updating RegistroCalculo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "RegistroCalculo");
            }

            validateRegistroCalculo(entity);

            registroCalculoRepository.update(entity);

            log.debug("update RegistroCalculo successful");
        } catch (Exception e) {
            log.error("update RegistroCalculo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<RegistroCalculoDTO> getDataRegistroCalculo()
        throws Exception {
        try {
            List<RegistroCalculo> registroCalculo = registroCalculoRepository.findAll();

            List<RegistroCalculoDTO> registroCalculoDTO = new ArrayList<RegistroCalculoDTO>();

            for (RegistroCalculo registroCalculoTmp : registroCalculo) {
                RegistroCalculoDTO registroCalculoDTO2 = registroCalculoMapper.registroCalculoToRegistroCalculoDTO(registroCalculoTmp);
                registroCalculoDTO.add(registroCalculoDTO2);
            }

            return registroCalculoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public RegistroCalculo getRegistroCalculo(Integer idResultado)
        throws Exception {
        log.debug("getting RegistroCalculo instance");

        RegistroCalculo entity = null;

        try {
            if (registroCalculoRepository.findById(idResultado).isPresent()) {
                entity = registroCalculoRepository.findById(idResultado).get();
            }
        } catch (Exception e) {
            log.error("get RegistroCalculo failed", e);
            throw new ZMessManager().new FindingException("RegistroCalculo");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<RegistroCalculo> findPageRegistroCalculo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<RegistroCalculo> entity = null;

        try {
            entity = registroCalculoRepository.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "RegistroCalculo Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberRegistroCalculo() throws Exception {
        Long entity = null;

        try {
            entity = registroCalculoRepository.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "RegistroCalculo Count");
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
    public List<RegistroCalculo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<RegistroCalculo> list = new ArrayList<RegistroCalculo>();
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
            list = registroCalculoRepository.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
