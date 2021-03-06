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
import com.saberpro.dataaccess.dao.IPruebaDAO;
import com.saberpro.dataaccess.dao.IPruebaModuloDAO;
import com.saberpro.modelo.PruebaModulo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestPruebaModuloDao {

	private final static Logger log = LoggerFactory.getLogger(TestPruebaModuloDao.class);
	private static long pruModId = 2L;

	@Autowired
	IPruebaDAO pruebaDao;
	
	@Autowired
	IModuloDAO moduloDao;
	
	@Autowired
	IPruebaModuloDAO pruebaModuloDao;	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		assertNotNull("El pruebaModuloDao es null",pruebaModuloDao);
		

		PruebaModulo pruebaModulo = pruebaModuloDao.findById(pruModId);

		assertNull("pruebaModulo ya existe",pruebaModulo);
		
		pruebaModulo = new PruebaModulo();
		pruebaModulo.setActivo("S");
		pruebaModulo.setFechaCreacion(new Date());
		pruebaModulo.setModulo(moduloDao.findById(2L));
		pruebaModulo.setNumeroPreguntas(25L);
		pruebaModulo.setPrueba(pruebaDao.findById(1L));
		pruebaModulo.setUsuCreador(0L);		
			
		pruebaModuloDao.save(pruebaModulo);
		pruModId = pruebaModulo.getIdPruebaModulo();

		log.info("Se creo la pruebaModulo " + pruebaModulo.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		assertNotNull("El pruebaModuloDao es null",pruebaModuloDao);
		

		PruebaModulo pruebaModulo = pruebaModuloDao.findById(pruModId);

		assertNotNull("pruebaModulo no ya existe",pruebaModulo);

		pruebaModulo.setNumeroPreguntas(4L);

		pruebaModuloDao.update(pruebaModulo);

		log.info("Se actualizo la pruebaModulo " + pruebaModulo.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		assertNotNull("El pruebaModuloDao es null",pruebaModuloDao);
		

		PruebaModulo pruebaModulo = pruebaModuloDao.findById(pruModId);

		assertNotNull("pruebaModulo no ya existe",pruebaModulo);

		pruebaModuloDao.deleteById(pruModId);
		// pruebaModuloDao.delete(pruebaModulo;

		log.info("Se borro la pruebaModulo " + pruebaModulo.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		assertNotNull("El pruebaModuloDao es null",pruebaModuloDao);

		List<PruebaModulo> list = pruebaModuloDao.findAll();

		for (PruebaModulo pruebaModulo : list) {
			log.info(pruebaModulo.toString());
		}

	}

}
