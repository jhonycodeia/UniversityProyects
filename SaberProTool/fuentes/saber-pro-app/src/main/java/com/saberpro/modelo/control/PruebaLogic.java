package com.saberpro.modelo.control;

import com.saberpro.dataaccess.dao.*;

import com.saberpro.dto.mapper.IPruebaMapper;

import com.saberpro.exceptions.*;

import com.saberpro.modelo.*;
import com.saberpro.modelo.dto.PruebaDTO;
import com.saberpro.utilities.Constantes;
import com.saberpro.utilities.Utilities;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("PruebaLogic")
public class PruebaLogic implements IPruebaLogic {
    private static final Logger log = LoggerFactory.getLogger(PruebaLogic.class);

    /**
     * DAO injected by Spring that manages Prueba entities
     *
     */
    @Autowired
    private IPruebaDAO pruebaDAO;
    @Autowired
    private IPruebaMapper pruebaMapper;
    @Autowired
    private Validator validator;
    @Autowired
    private IParametroLogic parametroLogic; 
    
    @Autowired
    private DataSource dataSource;

    /**
    * DAO injected by Spring that manages PruebaModulo entities
    *
    */
    @Autowired
    private IPruebaModuloDAO pruebaModuloDAO;

    /**
    * DAO injected by Spring that manages PruebaProgramaUsuario entities
    *
    */
    @Autowired
    private IPruebaProgramaUsuarioDAO pruebaProgramaUsuarioDAO;

    /**
    * Logic injected by Spring that manages TipoPrueba entities
    *
    */
    @Autowired
    ITipoPruebaLogic logicTipoPrueba1;

    public void validatePrueba(Prueba prueba) throws Exception {
        try {
            Set<ConstraintViolation<Prueba>> constraintViolations = validator.validate(prueba);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Prueba> constraintViolation : constraintViolations) {
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
    public List<Prueba> getPrueba() throws Exception {
        log.debug("finding all Prueba instances");

        List<Prueba> list = new ArrayList<Prueba>();

        try {
            list = pruebaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Prueba failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Prueba");
        } finally {
        }

        return list;
    }
    
    @Transactional(readOnly = true)
    public List<Prueba> getPrueba(String tipo) throws Exception {
        log.debug("finding all Prueba instances");

        List<Prueba> list = new ArrayList<Prueba>();

        try {
            list = pruebaDAO.findAll(tipo);
        } catch (Exception e) {
            log.error("finding all Prueba failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Prueba");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePrueba(Prueba entity) throws Exception {
        log.debug("saving Prueba instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Prueba");
            }

            validatePrueba(entity);            

            pruebaDAO.save(entity);
            log.debug("save Prueba successful");
        } catch (Exception e) {
            log.error("save Prueba failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePrueba(Prueba entity) throws Exception {
        log.debug("deleting Prueba instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Prueba");
        }

        if (entity.getIdPrueba() == null) {
            throw new ZMessManager().new EmptyFieldException("idPrueba");
        }

        List<PruebaModulo> pruebaModulos = null;
        List<PruebaProgramaUsuario> pruebaProgramaUsuarios = null;

        try {
            pruebaModulos = pruebaModuloDAO.findByProperty("prueba.idPrueba",
                    entity.getIdPrueba());

            if (Utilities.validationsList(pruebaModulos) == true) {
                throw new ZMessManager().new DeletingException("pruebaModulos");
            }

            pruebaProgramaUsuarios = pruebaProgramaUsuarioDAO.findByProperty("prueba.idPrueba",
                    entity.getIdPrueba());

            if (Utilities.validationsList(pruebaProgramaUsuarios) == true) {
                throw new ZMessManager().new DeletingException(
                    "pruebaProgramaUsuarios");
            }

            pruebaDAO.deleteById(entity.getIdPrueba());
            log.debug("delete Prueba successful");
        } catch (Exception e) {
            log.error("delete Prueba failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePrueba(Prueba entity) throws Exception {
        log.debug("updating Prueba instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Prueba");
            }

            validatePrueba(entity);

            pruebaDAO.update(entity);

            log.debug("update Prueba successful");
        } catch (Exception e) {
            log.error("update Prueba failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<PruebaDTO> getDataPrueba() throws Exception {
        try {
            List<Prueba> prueba = pruebaDAO.findAll();

            List<PruebaDTO> pruebaDTO = new ArrayList<PruebaDTO>();

            for (Prueba pruebaTmp : prueba) {
                PruebaDTO pruebaDTO2 = pruebaMapper.pruebaToPruebaDTO(pruebaTmp);
                pruebaDTO.add(pruebaDTO2);
            }

            return pruebaDTO;
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Transactional(readOnly = true)
    public List<PruebaDTO> getDataPrueba(String tipo) throws Exception {
        try {
            List<Prueba> prueba = pruebaDAO.findAll(tipo);

            List<PruebaDTO> pruebaDTO = new ArrayList<PruebaDTO>();

            for (Prueba pruebaTmp : prueba) {
                PruebaDTO pruebaDTO2 = pruebaMapper.pruebaToPruebaDTO(pruebaTmp);
                pruebaDTO.add(pruebaDTO2);
            }

            return pruebaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Prueba getPrueba(Long idPrueba) throws Exception {
        log.debug("getting Prueba instance");

        Prueba entity = null;

        try {
            entity = pruebaDAO.findById(idPrueba);
        } catch (Exception e) {
            log.error("get Prueba failed", e);
            throw new ZMessManager().new FindingException("Prueba");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Prueba> findPagePrueba(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Prueba> entity = null;

        try {
            entity = pruebaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Prueba Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPrueba() throws Exception {
        Long entity = null;

        try {
            entity = pruebaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Prueba Count");
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
    public List<Prueba> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Prueba> list = new ArrayList<Prueba>();
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
            list = pruebaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    public ByteArrayInputStream generarInformeIndividual(Long idPrueba) throws Exception{
    	
    	Connection conn = null;
    	
    	try {
			
    		//1. Se consulta la prueba.
    		/*Prueba prueba = getPrueba(idPrueba);
    		if (prueba==null || !prueba.getActivo().equals("S")) {
    			throw new Exception("No existe la prueba con ID " + idPrueba );
    		}*/
    		
    		//2. Se consulta el parametro de la ruta de los reportes
    		String rutaReportes = "";
    		
    		Parametro parametroRutaReportes = parametroLogic.getParametro(Constantes.PARAMETRO_REPORTES);
    		if (parametroRutaReportes == null || !parametroRutaReportes.getActivo().equals("S")) {
    			throw new Exception("No existe el parámetro  'RUTA REPORTES'");
    		}
    		
    		File fRutaReportes = new File(parametroRutaReportes.getValor());
    		if (!fRutaReportes.exists() || !fRutaReportes.canRead()) {
    			throw new Exception("No existe la ruta base de reportes o no se tienen permisos de lectura a la carpeta");
    		}
    		
    		//3. Se manda a generar el reporte
    		ByteArrayOutputStream bos = new ByteArrayOutputStream();
    		
    		//Se abre el reporte
    		File fReporte = new File(fRutaReportes, "resultadosPorEstudiante.jasper");
    		InputStream inputStream = new FileInputStream(fReporte);
    		
    		//Se obtiene la conexion a la BD
    		conn = dataSource.getConnection();
    		
    		//Se llena el reporte
    		Map<String, Object> params = new HashMap<>();
    		params.put("P_ID_PRUEBA_PROGRAMA_USUARIO", idPrueba);
    		params.put("P_RUTA_RECURSOS", parametroRutaReportes.getValor());
    		
    		JasperPrint print = JasperFillManager.fillReport(inputStream, params, conn);
    		
    		//4. Es exporta el reporte en PDF
    		
    		JRPdfExporter jrPdfExporter = new JRPdfExporter();
			
			jrPdfExporter.setExporterInput(new SimpleExporterInput(print));
			jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(bos));
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			jrPdfExporter.setConfiguration(configuration);
			
			jrPdfExporter.exportReport();
			
			//5. Retornar los bytes del PDF
			ByteArrayInputStream is = new ByteArrayInputStream(bos.toByteArray());
    		
			return is;
    		
		} catch (Exception e) {
			log.error("Error generando el informe individual de pruebas. IdPrueba = " + idPrueba, e);
			throw e;
		}finally {
			if (conn!=null && !conn.isClosed()) {
				conn.close();
			}
		}
    }

	@Override
	@Transactional(readOnly = true)
	public ByteArrayInputStream generarInformeGrupo(Long idTipoPrueba, Long idPrograma, Long idModulo, String periodo,
			List<String> correos) throws Exception {
Connection conn = null;
    	
    	try {
			
    		//1. Se consulta la prueba.
    		/*Prueba prueba = getPrueba(idPrueba);
    		if (prueba==null || !prueba.getActivo().equals("S")) {
    			throw new Exception("No existe la prueba con ID " + idPrueba );
    		}*/
    		
    		//2. Se consulta el parametro de la ruta de los reportes
    		String rutaReportes = "";
    		
    		Parametro parametroRutaReportes = parametroLogic.getParametro(Constantes.PARAMETRO_REPORTES);
    		if (parametroRutaReportes == null || !parametroRutaReportes.getActivo().equals("S")) {
    			throw new Exception("No existe el parámetro  'RUTA REPORTES'");
    		}
    		
    		File fRutaReportes = new File(parametroRutaReportes.getValor());
    		if (!fRutaReportes.exists() || !fRutaReportes.canRead()) {
    			throw new Exception("No existe la ruta base de reportes o no se tienen permisos de lectura a la carpeta");
    		}
    		
    		//3. Se manda a generar el reporte
    		ByteArrayOutputStream bos = new ByteArrayOutputStream();
    		
    		//Se abre el reporte
    		File fReporte = new File(fRutaReportes, "resultadosPorTodosEstudiantePrograma.jasper");
    		InputStream inputStream = new FileInputStream(fReporte);
    		
    		//Se obtiene la conexion a la BD
    		conn = dataSource.getConnection();
    		
    		//Se llena el reporte
    		Map<String, Object> params = new HashMap<>();
    		params.put("P_ID_TIPO_PRUEBA", idTipoPrueba);
    		params.put("P_ID_PROGRAMA", idPrograma);
    		params.put("P_ID_MODULO", idModulo);
    		params.put("P_PERIODO", periodo);
    		params.put("P_ID_USUARIO", correos);
    		params.put("P_RUTA_RECURSOS", parametroRutaReportes.getValor());
    		
    		JasperPrint print = JasperFillManager.fillReport(inputStream, params, conn);
    		
    		//4. Es exporta el reporte en PDF
    		
    		JRPdfExporter jrPdfExporter = new JRPdfExporter();
			
			jrPdfExporter.setExporterInput(new SimpleExporterInput(print));
			jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(bos));
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
			jrPdfExporter.setConfiguration(configuration);
			
			jrPdfExporter.exportReport();
			
			//5. Retornar los bytes del PDF
			ByteArrayInputStream is = new ByteArrayInputStream(bos.toByteArray());
    		
			return is;
    		
		} catch (Exception e) {
			log.error("Error generando el informe grupal ", e);
			throw e;
		}finally {
			if (conn!=null && !conn.isClosed()) {
				conn.close();
			}
		}
	}
    
}
