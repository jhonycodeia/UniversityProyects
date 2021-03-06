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
import com.saberpro.dataaccess.dao.IPruebaDAO;
import com.saberpro.dataaccess.dao.ITipoPruebaDAO;
import com.saberpro.modelo.Prueba;
import com.saberpro.modelo.TipoPrueba;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestPruebaDao {

	private final static Logger log = LoggerFactory.getLogger(TestPruebaDao.class);
	private static long pruId = 2L;
	
	@Autowired
	ITipoPruebaDAO tipoPruebaDao;	
	
	@Autowired
	IPruebaDAO pruebaDao;	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);	
		assertNotNull("El pruebaDao es null",pruebaDao);
		
		
		Prueba prueba = pruebaDao.findById(pruId);
		
		assertNull("prueba ya existe",prueba);
		
		prueba = new Prueba();
		prueba.setActivo("S");
		prueba.setFechaCreacion(new Date());
		prueba.setTipoPrueba(tipoPruebaDao.findById(1L));
		prueba.setUsuCreador(0L);				
		
		pruebaDao.save(prueba);
		pruId = prueba.getIdPrueba();
		
		log.info("Se creo la prueba "+prueba.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);	
		assertNotNull("El pruebaDao es null",pruebaDao);
		
		
		Prueba prueba = pruebaDao.findById(pruId);
		
		assertNotNull("prueba no ya existe",prueba);	
			
		prueba.setTipoPrueba(tipoPruebaDao.findById(2L));		
				
		pruebaDao.update(prueba);		
		
		log.info("Se actualizo la  prueba "+prueba.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);	
		assertNotNull("El pruebaDao es null",pruebaDao);		
		
		Prueba prueba = pruebaDao.findById(pruId);
		
		assertNotNull("prueba no ya existe",prueba);			
			
				
		pruebaDao.deleteById(pruId);
		//pruebaDao.delete(prueba);
		
		log.info("Se borro la prueba "+prueba.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);	
		assertNotNull("El pruebaDao es null",pruebaDao);		
		
		List<Prueba> list = pruebaDao.findAll();
		
		for (Prueba prueba : list) {
			log.info(prueba.toString());
		}
		

	}

}
