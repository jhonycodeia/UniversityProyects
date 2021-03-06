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
import com.saberpro.dataaccess.dao.ITipoPruebaDAO;
import com.saberpro.modelo.TipoPrueba;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestTipoPrueba {

	private final static Logger log = LoggerFactory.getLogger(TestTipoPrueba.class);
	private static long tipoPruId = 3L;
	
	@Autowired
	ITipoPruebaDAO tipoPruebaDao;	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);	
		
		
		TipoPrueba tipoPrueba = tipoPruebaDao.findById(tipoPruId);
		
		assertNull("tipoPrueba ya existe",tipoPrueba);
		
		tipoPrueba = new TipoPrueba();
		tipoPrueba.setActivo("S");
		tipoPrueba.setDescripcion("prueba");
		tipoPrueba.setFechaCreacion(new Date());
		tipoPrueba.setNombre("Real");
		tipoPrueba.setUsuCreador(0L);		
		
		tipoPruebaDao.save(tipoPrueba);
		tipoPruId = tipoPrueba.getIdTipoPrueba();
		
		log.info("Se creo la tipoPrueba "+tipoPrueba.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);			
		
		TipoPrueba tipoPrueba = tipoPruebaDao.findById(tipoPruId);
		
		assertNotNull("tipoPrueba no ya existe",tipoPrueba);	
			
		tipoPrueba.setNombre("mario");;		
				
		tipoPruebaDao.update(tipoPrueba);		
		
		log.info("Se actualizo la  tipoPrueba "+tipoPrueba.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);			
		
		TipoPrueba tipoPrueba = tipoPruebaDao.findById(tipoPruId);
		
		assertNotNull("tipoPrueba no ya existe",tipoPrueba);			
			
				
		tipoPruebaDao.deleteById(tipoPruId);
		//tipoPruebaDao.delete(tipoPrueba);
		
		log.info("Se borro la tipoPrueba "+tipoPrueba.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El tipoPruebaDao es null",tipoPruebaDao);		
		
		List<TipoPrueba> list = tipoPruebaDao.findAll();
		
		for (TipoPrueba tipoPrueba : list) {
			log.info(tipoPrueba.toString());
		}
		

	}

}
