package com.saberpro.modelo.control;

import com.saberpro.dataaccess.dao.*;

import com.saberpro.dto.mapper.IProgramaMapper;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.ProgramaDTO;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.FacesUtils;
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
@Service("ProgramaLogic")
public class ProgramaLogic implements IProgramaLogic {
    private static final Logger log = LoggerFactory.getLogger(ProgramaLogic.class);

    /**
     * DAO injected by Spring that manages Programa entities
     *
     */
    @Autowired
    private IUsuarioDAO usuarioDAO;
    @Autowired
    private IProgramaDAO programaDAO;
    @Autowired
    private IProgramaMapper programaMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages ProgramaModulo entities
    *
    */
    @Autowired
    private IProgramaModuloDAO programaModuloDAO;

    /**
    * DAO injected by Spring that manages ProgramaUsuario entities
    *
    */
    @Autowired
    private IProgramaUsuarioDAO programaUsuarioDAO;

    /**
    * Logic injected by Spring that manages Facultad entities
    *
    */
    @Autowired
    IFacultadLogic logicFacultad1;

    public void validatePrograma(Programa programa) throws Exception {
        try {
            Set<ConstraintViolation<Programa>> constraintViolations = validator.validate(programa);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Programa> constraintViolation : constraintViolations) {
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
    public List<Programa> getPrograma() throws Exception {
        log.debug("finding all Programa instances");

        List<Programa> list = new ArrayList<Programa>();

        try {
            list = programaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Programa failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Programa");
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<Programa> getPrograma(String tipo) throws Exception {
        log.debug("finding all Programa instances");

        List<Programa> list = new ArrayList<Programa>();

        try {
            list = programaDAO.findAll(tipo);
        } catch (Exception e) {
            log.error("finding all Programa failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Programa");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePrograma(Programa entity) throws Exception {
        log.debug("saving Programa instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Programa");
            }

            validatePrograma(entity);           

            programaDAO.save(entity);
            
            Facultad facultad = entity.getFacultad();
            Usuario usuario = usuarioDAO.findById(entity.getUsuCreador());
			Object[] variable = {"facultad.idFacultad",true,facultad.getIdFacultad(),"="};
			Programa programa = findByCriteria(variable,null,null).get(0);
			List<Usuario> decanoList = usuarioDAO.findByTipoUsuarioPrograma(programa.getIdPrograma(),Constantes.USER_TYPE_DECANO);
			
			if(decanoList.size()!=0) {
				Usuario decano = decanoList.get(0);
				
				if(decano!=null) {
					ProgramaUsuario programaUsuario = new ProgramaUsuario();
					programaUsuario.setActivo(Constantes.ESTADO_ASIGNADO);
					programaUsuario.setFechaCreacion(new Date());
					programaUsuario.setPrograma(entity);
					programaUsuario.setUsuario(decano);
					programaUsuario.setUsuCreador(usuario.getIdUsuario());
					
					programaUsuarioDAO.save(programaUsuario);
				}
			}
            
            
            log.debug("save Programa successful");
        } catch (Exception e) {
            log.error("save Programa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePrograma(Programa entity) throws Exception {
        log.debug("deleting Programa instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Programa");
        }

        if (entity.getIdPrograma() == null) {
            throw new ZMessManager().new EmptyFieldException("idPrograma");
        }

        List<ProgramaModulo> programaModulos = null;
        List<ProgramaUsuario> programaUsuarios = null;

        try {
            programaModulos = programaModuloDAO.findByProperty("programa.idPrograma",
                    entity.getIdPrograma());

            if (Utilities.validationsList(programaModulos) == true) {
                throw new ZMessManager().new DeletingException(
                    "programaModulos");
            }

            programaUsuarios = programaUsuarioDAO.findByProperty("programa.idPrograma",
                    entity.getIdPrograma());

            if (Utilities.validationsList(programaUsuarios) == true) {
                throw new ZMessManager().new DeletingException(
                    "programaUsuarios");
            }

            programaDAO.deleteById(entity.getIdPrograma());
            log.debug("delete Programa successful");
        } catch (Exception e) {
            log.error("delete Programa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePrograma(Programa entity) throws Exception {
        log.debug("updating Programa instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Programa");
            }

            validatePrograma(entity);

            programaDAO.update(entity);

            log.debug("update Programa successful");
        } catch (Exception e) {
            log.error("update Programa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ProgramaDTO> getDataPrograma() throws Exception {
        try {
            List<Programa> programa = programaDAO.findAll();

            List<ProgramaDTO> programaDTO = new ArrayList<ProgramaDTO>();

            for (Programa programaTmp : programa) {
                ProgramaDTO programaDTO2 = programaMapper.programaToProgramaDTO(programaTmp);
                programaDTO.add(programaDTO2);
            }

            return programaDTO;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional(readOnly = true)
    public List<ProgramaDTO> getDataPrograma(String tipo) throws Exception {
        try {
            List<Programa> programa = programaDAO.findAll(tipo);

            List<ProgramaDTO> programaDTO = new ArrayList<ProgramaDTO>();

            for (Programa programaTmp : programa) {
                ProgramaDTO programaDTO2 = programaMapper.programaToProgramaDTO(programaTmp);
                programaDTO.add(programaDTO2);
            }

            return programaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Programa getPrograma(Long idPrograma) throws Exception {
        log.debug("getting Programa instance");

        Programa entity = null;

        try {
            entity = programaDAO.findById(idPrograma);
        } catch (Exception e) {
            log.error("get Programa failed", e);
            throw new ZMessManager().new FindingException("Programa");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Programa> findPagePrograma(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Programa> entity = null;

        try {
            entity = programaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Programa Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPrograma() throws Exception {
        Long entity = null;

        try {
            entity = programaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Programa Count");
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
    public List<Programa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Programa> list = new ArrayList<Programa>();
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
            list = programaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }

	@Override
	@Transactional(readOnly = true)
	public Programa findByNombre(String nombre) throws Exception {
		log.debug("getting Programa instance");

        Programa entity = null;

        try {
            entity = programaDAO.findByNombre(nombre);
        } catch (Exception e) {
            log.error("get Programa failed", e);
            throw new ZMessManager().new FindingException("Programa");
        } finally {
        }

        return entity;
	}

	@Override
	@Transactional(readOnly = true)
	public ProgramaDTO findDataByNombre(String nombre) throws Exception {
		log.debug("getting Programa instance");

        Programa entity = null;
        ProgramaDTO entityDTO = null;
        try {
            entity = programaDAO.findByNombre(nombre);
            entityDTO = programaMapper.programaToProgramaDTO(entity);
        } catch (Exception e) {
            log.error("get Programa failed", e);
            throw new ZMessManager().new FindingException("Programa");
        } finally {
        }

        return entityDTO;
	}
}
