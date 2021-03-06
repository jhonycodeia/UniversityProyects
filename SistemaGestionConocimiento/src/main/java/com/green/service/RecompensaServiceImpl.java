package com.green.service;

import com.green.dto.RecompensaDTO;

import com.green.exception.*;

import com.green.mapper.RecompensaMapper;

import com.green.modelo.*;

import com.green.repository.*;
import com.green.utility.Constantes;
import com.green.utility.Utilities;
import com.vortexbird.aws.s3.IS3Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
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
public class RecompensaServiceImpl implements RecompensaService {
    private static final Logger log = LoggerFactory.getLogger(RecompensaServiceImpl.class);

    /**
     * Repository injected by Spring that manages Recompensa entities
     *
     */
    @Autowired
	private IS3Services s3Services;
    @Autowired
    private TipoPuntosRepository tipoPuntosRepository;
    @Autowired
    private PuntosRepository puntosRepository;
    @Autowired
    private RecompensaRepository recompensaRepository;
    @Autowired
    private RecompensaMapper recompensaMapper;
    @Autowired
    private Validator validator;

    /**
    * Repository injected by Spring that manages RecompensaUsuario entities
    *
    */
    @Autowired
    private RecompensaUsuarioRepository recompensaUsuarioRepository;

    public void validateRecompensa(Recompensa recompensa)
        throws Exception {
        try {
            Set<ConstraintViolation<Recompensa>> constraintViolations = validator.validate(recompensa);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Recompensa> constraintViolation : constraintViolations) {
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
    public List<Recompensa> getRecompensa() throws Exception {
        log.debug("finding all Recompensa instances");

        List<Recompensa> list = new ArrayList<Recompensa>();

        try {
            list = recompensaRepository.findAll();
        } catch (Exception e) {
            log.error("finding all Recompensa failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Recompensa");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveRecompensa(Recompensa entity) throws Exception {
        log.debug("saving Recompensa instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Recompensa");
            }

            validateRecompensa(entity);

//            if (getRecompensa(entity.getIdRecompensa()) != null) {
//                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
//            }

            recompensaRepository.save(entity);
            log.debug("save Recompensa successful");
        } catch (Exception e) {
            log.error("save Recompensa failed", e);
            throw e;
        } finally {
        }
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void reclamarRecompensa(Recompensa entity,Usuario usuario)throws Exception{
    	try {    		
    		Puntos puntosGanados = puntosRepository.findByCriteria("model.usuario.idUsuario="+usuario.getIdUsuario()+" and model.tipoPuntos.idTipoPuntos="+Constantes.PUNTOS_TYPE_GANADO).get(0);
    		Puntos puntosCanjeados = puntosRepository.findByCriteria("model.usuario.idUsuario="+usuario.getIdUsuario()+" and model.tipoPuntos.idTipoPuntos="+Constantes.PUNTOS_TYPE_CANJEADOS).get(0);
			
    		RecompensaUsuario recompensaUsuario = new RecompensaUsuario();
    		
    		recompensaUsuario.setFechaCreacion(new Date());
    		recompensaUsuario.setUsuCreador(usuario.getIdUsuario());
    		recompensaUsuario.setActivo(Constantes.ESTADO_ACTIVO);
    		recompensaUsuario.setUsuario(usuario);
    		recompensaUsuario.setRecompensa(entity);
    		
    		recompensaUsuarioRepository.save(recompensaUsuario);
    		
    		puntosGanados.setFechaModificacion(new Date());
    		puntosGanados.setUsuModificador(usuario.getIdUsuario());
    		puntosGanados.setPuntos((puntosGanados.getPuntos()-entity.getRequisito()));
    		
    		puntosRepository.update(puntosGanados);
    		
    		puntosCanjeados.setFechaModificacion(new Date());
    		puntosCanjeados.setUsuModificador(usuario.getIdUsuario());
    		puntosCanjeados.setPuntos((puntosCanjeados.getPuntos()+entity.getRequisito()));
    		
    		puntosRepository.update(puntosCanjeados);
    		
		} catch (Exception e) {
			throw e;
		}
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteRecompensa(Recompensa entity) throws Exception {
        log.debug("deleting Recompensa instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Recompensa");
        }

        if (entity.getIdRecompensa() == null) {
            throw new ZMessManager().new EmptyFieldException("idRecompensa");
        }

        List<RecompensaUsuario> recompensaUsuarios = null;

        try {
            recompensaUsuarios = recompensaUsuarioRepository.findByProperty("recompensa.idRecompensa",
                    entity.getIdRecompensa());

            if (Utilities.validationsList(recompensaUsuarios) == true) {
                throw new ZMessManager().new DeletingException(
                    "recompensaUsuarios");
            }

            recompensaRepository.deleteById(entity.getIdRecompensa());
            log.debug("delete Recompensa successful");
        } catch (Exception e) {
            log.error("delete Recompensa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateRecompensa(Recompensa entity) throws Exception {
        log.debug("updating Recompensa instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Recompensa");
            }

            validateRecompensa(entity);

            recompensaRepository.update(entity);

            log.debug("update Recompensa successful");
        } catch (Exception e) {
            log.error("update Recompensa failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<RecompensaDTO> getDataRecompensa() throws Exception {
        try {
            List<Recompensa> recompensa = recompensaRepository.findAll();

            List<RecompensaDTO> recompensaDTO = new ArrayList<RecompensaDTO>();

            for (Recompensa recompensaTmp : recompensa) {
                RecompensaDTO recompensaDTO2 = recompensaMapper.recompensaToRecompensaDTO(recompensaTmp);
                recompensaDTO.add(recompensaDTO2);
            }

            return recompensaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Recompensa getRecompensa(Long idRecompensa)
        throws Exception {
        log.debug("getting Recompensa instance");

        Recompensa entity = null;

        try {
            if (recompensaRepository.findById(idRecompensa).isPresent()) {
                entity = recompensaRepository.findById(idRecompensa).get();
            }
        } catch (Exception e) {
            log.error("get Recompensa failed", e);
            throw new ZMessManager().new FindingException("Recompensa");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Recompensa> findPageRecompensa(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Recompensa> entity = null;

        try {
            entity = recompensaRepository.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Recompensa Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberRecompensa() throws Exception {
        Long entity = null;

        try {
            entity = recompensaRepository.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Recompensa Count");
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
    public List<Recompensa> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Recompensa> list = new ArrayList<Recompensa>();
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
            list = recompensaRepository.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    @Override
	@Transactional(readOnly = true)
    public InputStream generarRecompensa(Long idRecompensa) throws Exception{
		try {
			Recompensa recompensa = recompensaRepository.getOne(idRecompensa);

			if (recompensa == null) {
				throw new Exception("La recompensa no se logro encontrar");
			}

			return s3Services.download(Constantes.BUCKET_NAME, recompensa.getValor());

		} catch (Exception e) {
			throw e;
		} finally {

		}
	}
}
