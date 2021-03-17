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
import com.saberpro.dataaccess.dao.IParametroDAO;
import com.saberpro.modelo.Parametro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestParametroDao {

	private final static Logger log = LoggerFactory.getLogger(TestParametroDao.class);
	private static long parId = 1L;
	
	@Autowired
	IParametroDAO parametroDao;
	
		
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El parametroDao es null",parametroDao);		
		
		Parametro parametro = parametroDao.findById(parId);
		
		assertNull("parametro ya existe",parametro);		
		
		parametro = new Parametro();
		parametro.setActivo("S");
		parametro.setDescripcion("ruta rest full");
		parametro.setFechaCreacion(new Date());
		parametro.setNombre("Api restFull");
		parametro.setUsuCreador(0L);
		parametro.setValor("Saberpro/rest");
		
		parametroDao.save(parametro);
		parId = parametro.getIdParametro();
		
		log.info("Se creo la parametro "+parametro.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El parametroDao es null",parametroDao);		
		
		Parametro parametro = parametroDao.findById(parId);
		
		assertNotNull("parametro no ya existe",parametro);	
			
		parametro.setActivo("N");	
				
		parametroDao.update(parametro);		
		
		log.info("Se creo la parametro "+parametro.toString());	
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El parametroDao es null",parametroDao);		
		
		Parametro parametro = parametroDao.findById(parId);
		
		assertNotNull("parametro no ya existe",parametro);					
			
				
		parametroDao.deleteById(parId);
		
		
		log.info("Se creo la parametro "+parametro.toString());			
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El parametroDao es null",parametroDao);	
		
		List<Parametro> list = parametroDao.findAll();
		
		for (Parametro parametro : list) {
			log.info(parametro.toString());
		}
		

	}
}
