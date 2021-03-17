package com.saberpro.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.dataaccess.dao.IPruebaProgramaUsuarioPreguntaDAO;
import com.saberpro.dataaccess.dao.IRespuestaDAO;
import com.saberpro.dataaccess.dao.IRespuestaPruebaProgramaUsuarioPreguntaDAO;
import com.saberpro.modelo.RespuestaPruebaProgramaUsuarioPregunta;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestRespuestaPruebaProgramaUsuarioPreguntaDao {

	private final static Logger log = LoggerFactory.getLogger(TestResultadoRealDao.class);
	private static long respPrueId = 5L;
	
	@Autowired
	IPruebaProgramaUsuarioPreguntaDAO pruebaProgramaUsuarioPreguntaDao;
	
	@Autowired
	IRespuestaDAO respuestaDao;
	
	@Autowired
	IRespuestaPruebaProgramaUsuarioPreguntaDAO respuestaPruebaProgramaUsuarioPreguntaDao;
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);	
		assertNotNull("El respuestaDao es null",respuestaDao);
		assertNotNull("El respuestaPruebaProgramaUsuarioPreguntaDao es null",respuestaPruebaProgramaUsuarioPreguntaDao);
		
		
		RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta = respuestaPruebaProgramaUsuarioPreguntaDao.findById(respPrueId);
		
		assertNull("respuestaPruebaProgramaUsuarioPregunta ya existe",respuestaPruebaProgramaUsuarioPregunta);
		
		respuestaPruebaProgramaUsuarioPregunta = new RespuestaPruebaProgramaUsuarioPregunta();
		respuestaPruebaProgramaUsuarioPregunta.setActivo("S");
		respuestaPruebaProgramaUsuarioPregunta.setFechaCreacion(new Date());
		respuestaPruebaProgramaUsuarioPregunta.setPruebaProgramaUsuarioPregunta(pruebaProgramaUsuarioPreguntaDao.findById(1L));
		respuestaPruebaProgramaUsuarioPregunta.setPorcentajeAsignado(0L);
		respuestaPruebaProgramaUsuarioPregunta.setRespuesta(respuestaDao.findById(1L));
		respuestaPruebaProgramaUsuarioPregunta.setUsuCreador(0L);
		
		
		respuestaPruebaProgramaUsuarioPreguntaDao.save(respuestaPruebaProgramaUsuarioPregunta);
		respPrueId = respuestaPruebaProgramaUsuarioPregunta.getIdRespuestaPruebaProgramaUsuarioPregunta();
		
		log.info("Se creo la respuestaPruebaProgramaUsuarioPregunta "+respuestaPruebaProgramaUsuarioPregunta.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);	
		assertNotNull("El respuestaDao es null",respuestaDao);
		assertNotNull("El respuestaPruebaProgramaUsuarioPreguntaDao es null",respuestaPruebaProgramaUsuarioPreguntaDao);
		
		
		RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta = respuestaPruebaProgramaUsuarioPreguntaDao.findById(respPrueId);
				
		assertNotNull("respuestaPruebaProgramaUsuarioPregunta no ya existe",respuestaPruebaProgramaUsuarioPregunta);	
			
		respuestaPruebaProgramaUsuarioPregunta.setPorcentajeAsignado(50L);	
				
		respuestaPruebaProgramaUsuarioPreguntaDao.update(respuestaPruebaProgramaUsuarioPregunta);		
		
		log.info("Se actualizo la  respuestaPruebaProgramaUsuarioPregunta "+respuestaPruebaProgramaUsuarioPregunta.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);	
		assertNotNull("El respuestaDao es null",respuestaDao);
		assertNotNull("El respuestaPruebaProgramaUsuarioPreguntaDao es null",respuestaPruebaProgramaUsuarioPreguntaDao);
		
		
		RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta = respuestaPruebaProgramaUsuarioPreguntaDao.findById(respPrueId);
				
		assertNotNull("respuestaPruebaProgramaUsuarioPregunta no ya existe",respuestaPruebaProgramaUsuarioPregunta);				
			
				
		respuestaPruebaProgramaUsuarioPreguntaDao.deleteById(respPrueId);
		//respuestaPruebaProgramaUsuarioPreguntaDao.delete(respuestaPruebaProgramaUsuarioPregunta);
		
		log.info("Se borro la respuestaPruebaProgramaUsuarioPregunta "+respuestaPruebaProgramaUsuarioPregunta.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);	
		assertNotNull("El respuestaDao es null",respuestaDao);
		assertNotNull("El respuestaPruebaProgramaUsuarioPreguntaDao es null",respuestaPruebaProgramaUsuarioPreguntaDao);		
		
		List<RespuestaPruebaProgramaUsuarioPregunta> list = respuestaPruebaProgramaUsuarioPreguntaDao.findRespuestasPruebaProgramaUsuarioPreguntaByPruebaProgramaUsuario(4L);
		log.info("El tamaño es de "+list.size());
		for (RespuestaPruebaProgramaUsuarioPregunta respuestaPruebaProgramaUsuarioPregunta : list) {
			log.info(respuestaPruebaProgramaUsuarioPregunta.toString());
		}
		

	}

}
