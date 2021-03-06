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
import com.saberpro.dataaccess.dao.IEstadoPruebaDAO;
import com.saberpro.modelo.EstadoPrueba;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestEstadoPruebaDao {

	private final static Logger log = LoggerFactory.getLogger(TestEstadoPruebaDao.class);
	private static long estPruId = 6L;

	@Autowired
	IEstadoPruebaDAO estadoPruebaDao;
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {

		assertNotNull("El programaModuloDao es null",estadoPruebaDao);		

		EstadoPrueba estadoPrueba = estadoPruebaDao.findById(estPruId);

		assertNull("estadoPrueba ya existe",estadoPrueba);
		
		estadoPrueba = new EstadoPrueba();
		estadoPrueba.setActivo("S");
		estadoPrueba.setFechaCreacion(new Date());
		estadoPrueba.setNombre("Prueba");
		estadoPrueba.setUsuCreador(0L);
		
		estadoPruebaDao.save(estadoPrueba);
		estPruId = estadoPrueba.getIdEstadoPrueba();

		log.info("Se creo la estadoPrueba " + estadoPrueba.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {

		assertNotNull("El programaModuloDao es null",estadoPruebaDao);		

		EstadoPrueba estadoPrueba = estadoPruebaDao.findById(estPruId);

		assertNotNull("estadoPrueba no ya existe",estadoPrueba);

		estadoPrueba.setNombre("dog");

		estadoPruebaDao.update(estadoPrueba);

		log.info("Se creo la estadoPrueba " + estadoPrueba.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El programaModuloDao es null",estadoPruebaDao);		

		EstadoPrueba estadoPrueba = estadoPruebaDao.findById(estPruId);

		assertNotNull("estadoPrueba no ya existe",estadoPrueba);		

		estadoPruebaDao.deleteById(estPruId);
		

		log.info("Se creo la estadoPrueba " + estadoPrueba.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El programaModuloDao es null",estadoPruebaDao);		

		List<EstadoPrueba> list = estadoPruebaDao.findAll();

		for (EstadoPrueba estadoPrueba : list) {
			log.info(estadoPrueba.toString());
		}

	}

}
