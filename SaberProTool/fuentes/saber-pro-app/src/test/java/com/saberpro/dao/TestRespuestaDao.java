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
import com.saberpro.dataaccess.dao.IModuloDAO;
import com.saberpro.dataaccess.dao.IPreguntaDAO;
import com.saberpro.dataaccess.dao.IRespuestaDAO;
import com.saberpro.dataaccess.dao.ITipoPreguntaDAO;
import com.saberpro.modelo.Pregunta;
import com.saberpro.modelo.Respuesta;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestRespuestaDao {
	private final static Logger log = LoggerFactory.getLogger(TestRespuestaDao.class);
	private static long resId = 17L;
	
	@Autowired
	IRespuestaDAO respuestaDao;
	
	@Autowired
	IPreguntaDAO preguntaDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El preguntDao es null",preguntaDao);
		assertNotNull("El respuestaDao es null",respuestaDao);		
		
		
		Respuesta respuesta = respuestaDao.findById(resId);
		
		assertNull("respuesta ya existe",respuesta);
		
		respuesta = new Respuesta();
		respuesta.setActivo("S");
		respuesta.setDescripcionRespuesta("prueba");
		respuesta.setFechaCreacion(new Date());
		respuesta.setPorcentajeAcierto(100);
		respuesta.setPregunta(preguntaDao.findById(1L));
		respuesta.setUsuCreador(0L);
		
		respuestaDao.save(respuesta);
		resId = respuesta.getIdRespuesta();
		
		log.info("Se creo la respuesta "+respuesta.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El preguntDao es null",preguntaDao);
		assertNotNull("El respuestaDao es null",respuestaDao);		
		
		
		Respuesta respuesta = respuestaDao.findById(resId);
		
		assertNotNull("respuesta no ya existe",respuesta);	
			
		respuesta.setDescripcionRespuesta("mario");;		
				
		respuestaDao.update(respuesta);		
		
		log.info("Se actualizo la  respuesta "+respuesta.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El preguntDao es null",preguntaDao);
		assertNotNull("El respuestaDao es null",respuestaDao);		
		
		
		Respuesta respuesta = respuestaDao.findById(resId);
		
		assertNotNull("respuesta no ya existe",respuesta);				
			
				
		respuestaDao.deleteById(resId);
		//respuestaDao.delete(respuesta);
		
		log.info("Se borro la respuesta "+respuesta.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El preguntDao es null",preguntaDao);
		assertNotNull("El respuestaDao es null",respuestaDao);			
		
		List<Respuesta> list = respuestaDao.findAll();
		
		for (Respuesta respuesta : list) {
			log.info(respuesta.toString());
		}
		

	}

}
