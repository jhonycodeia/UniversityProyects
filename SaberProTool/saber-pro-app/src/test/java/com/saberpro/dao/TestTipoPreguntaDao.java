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
import com.saberpro.dataaccess.dao.ITipoPreguntaDAO;
import com.saberpro.modelo.TipoPregunta;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestTipoPreguntaDao {

	private final static Logger log = LoggerFactory.getLogger(TestTipoPreguntaDao.class);
	private static long tipoPreId = 3L;
	
	@Autowired
	ITipoPreguntaDAO tipoPreguntaDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El tipopreguntDao es null",tipoPreguntaDao);
		
		
		
		TipoPregunta tipoPregunta = tipoPreguntaDao.findById(tipoPreId);
		
		assertNull("tipoPregunta ya existe",tipoPregunta);
		
		tipoPregunta = new TipoPregunta();
		tipoPregunta.setActivo("S");
		tipoPregunta.setFechaCreacion(new Date());
		tipoPregunta.setNombre("Checkbox".toUpperCase());
		tipoPregunta.setUsuCreador(0L);		
		
		tipoPreguntaDao.save(tipoPregunta);
		tipoPreId = tipoPregunta.getIdTipoPregunta();
		
		log.info("Se creo la tipoPregunta "+tipoPregunta.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El tipopreguntDao es null",tipoPreguntaDao);	
		
		
		TipoPregunta tipoPregunta = tipoPreguntaDao.findById(tipoPreId);
		
		assertNotNull("tipoPregunta no ya existe",tipoPregunta);	
			
		tipoPregunta.setNombre("Falso Verdad".toUpperCase());		
				
		tipoPreguntaDao.update(tipoPregunta);		
		
		log.info("Se actualizo la  tipoPregunta "+tipoPregunta.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El tipopreguntDao es null",tipoPreguntaDao);			
		
		TipoPregunta tipoPregunta = tipoPreguntaDao.findById(tipoPreId);
		
		assertNotNull("tipoPregunta no ya existe",tipoPregunta);				
			
				
		tipoPreguntaDao.deleteById(tipoPreId);
		//tipoPreguntaDao.delete(tipoPregunta);
		
		log.info("Se borro la tipoPregunta "+tipoPregunta.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El tipopreguntDao es null",tipoPreguntaDao);
		
		List<TipoPregunta> list = tipoPreguntaDao.findAll();
		
		for (TipoPregunta tipoPregunta : list) {
			log.info(tipoPregunta.toString());
		}
		

	}

}
