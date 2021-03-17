package co.edu.usbcali.arquitectura.modelo.control;

import co.edu.usbcali.arquitectura.dataaccess.dao.*;
import co.edu.usbcali.arquitectura.dto.mapper.ISaludoMapper;
import co.edu.usbcali.arquitectura.exceptions.*;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoDTO;
import co.edu.usbcali.arquitectura.modelo.dto.SaludoNombreDTO;
import co.edu.usbcali.arquitectura.utilities.Utilities;

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
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("SaludoLogic")
public class SaludoLogic implements ISaludoLogic {
    private static final Logger log = LoggerFactory.getLogger(SaludoLogic.class);

    /**
     * DAO injected by Spring that manages Saludo entities
     *
     */
    @Autowired
    private ISaludoDAO saludoDAO;
    @Autowired
    private INombreLogic NombreLogic;

    @Autowired
    private ISaludoMapper saludoMapper;
    @Autowired
    private Validator validator;

    /**
    * Logic injected by Spring that manages Idioma entities
    *
    */
    @Autowired
    IIdiomaLogic logicIdioma1;

    public void validateSaludo(Saludo saludo) throws Exception {
        try {
            Set<ConstraintViolation<Saludo>> constraintViolations = validator.validate(saludo);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Saludo> constraintViolation : constraintViolations) {
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
    public List<Saludo> getSaludo() throws Exception {
        log.debug("finding all Saludo instances");

        List<Saludo> list = new ArrayList<Saludo>();

        try {
            list = saludoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Saludo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Saludo");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveSaludo(Saludo entity) throws Exception {
        log.debug("saving Saludo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Saludo");
            }

            validateSaludo(entity);

            if (getSaludo(entity.getIdSaludo()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            saludoDAO.save(entity);
            log.debug("save Saludo successful");
        } catch (Exception e) {
            log.error("save Saludo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteSaludo(Saludo entity) throws Exception {
        log.debug("deleting Saludo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Saludo");
        }

        if (entity.getIdSaludo() == null) {
            throw new ZMessManager().new EmptyFieldException("idSaludo");
        }

        try {
            saludoDAO.deleteById(entity.getIdSaludo());
            log.debug("delete Saludo successful");
        } catch (Exception e) {
            log.error("delete Saludo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateSaludo(Saludo entity) throws Exception {
        log.debug("updating Saludo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Saludo");
            }

            validateSaludo(entity);

            saludoDAO.update(entity);

            log.debug("update Saludo successful");
        } catch (Exception e) {
            log.error("update Saludo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<SaludoDTO> getDataSaludo() throws Exception {
        try {
            List<Saludo> saludo = saludoDAO.findAll();

            List<SaludoDTO> saludoDTO = new ArrayList<SaludoDTO>();

            for (Saludo saludoTmp : saludo) {
                SaludoDTO saludoDTO2 = saludoMapper.saludoToSaludoDTO(saludoTmp);
                saludoDTO.add(saludoDTO2);
            }

            return saludoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Saludo getSaludo(Integer idSaludo) throws Exception {
        log.debug("getting Saludo instance");

        Saludo entity = null;

        try {
            entity = saludoDAO.findById(idSaludo);
        } catch (Exception e) {
            log.error("get Saludo failed", e);
            throw new ZMessManager().new FindingException("Saludo");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Saludo> findPageSaludo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Saludo> entity = null;

        try {
            entity = saludoDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Saludo Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberSaludo() throws Exception {
        Long entity = null;

        try {
            entity = saludoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Saludo Count");
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
    public List<Saludo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Saludo> list = new ArrayList<Saludo>();
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
            list = saludoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

	@SuppressWarnings("unused")
	@Override
	public SaludoNombreDTO SaludoNombre(String nombre) throws Exception {
		if (nombre.trim().equals("")) {
			throw new Exception("el nombre no puede estar vacio");
		}
		if (nombre == null) {
			throw new Exception("el nombre no puede ser nulo");
		}
		 
		SaludoNombreDTO saludo = saludoDAO.SaludoNombre(nombre);
		
		if (saludo == null) {
			throw new Exception("Registro no encontrado en base de datos");
		}
		
		return saludo;
	}


}
