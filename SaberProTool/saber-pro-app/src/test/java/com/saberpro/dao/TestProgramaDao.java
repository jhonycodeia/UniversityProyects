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
import com.saberpro.dataaccess.dao.IFacultadDAO;
import com.saberpro.dataaccess.dao.IProgramaDAO;
import com.saberpro.modelo.Programa;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestProgramaDao {

	private final static Logger log = LoggerFactory.getLogger(TestProgramaDao.class);
	private static long progId = 16L;
	
	@Autowired
	IFacultadDAO facultadDao;
	@Autowired
	IProgramaDAO programaDao;
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		assertNotNull("El facultadDao es null",facultadDao);
		assertNotNull("El programaDao es null",facultadDao);
		
		Programa programa = programaDao.findById(progId);
		
		
		
		assertNull("programa ya existe",programa);
		
		programa = new Programa();	
		programa.setActivo("S");
		programa.setFechaCreacion(new Date());
		programa.setNombre("Biologia".toUpperCase());
		programa.setUsuCreador(0L);
		programa.setFacultad(facultadDao.findById(1L));
		
		
		programaDao.save(programa);
		progId = programa.getIdPrograma();
		
		log.info("Se creo la programa "+programa.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		assertNotNull("El facultadDao es null",facultadDao);
		assertNotNull("El programaDao es null",facultadDao);
		
		Programa programa = programaDao.findById(progId);		
		
		
		assertNotNull("programa no  existe",programa);	
			
		programa.setNombre("Biologia y Buceo".toUpperCase());		
				
		programaDao.update(programa);		
		
		log.info("Se actualizo la programa "+programa.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		assertNotNull("El facultadDao es null",facultadDao);
		
		assertNotNull("El facultadDao es null",facultadDao);
		assertNotNull("El programaDao es null",facultadDao);
		
		Programa programa = programaDao.findById(progId);		
		
		
		assertNotNull("programa no  existe",programa);			
			
				
		programaDao.deleteById(progId);
		//programaDao.delete(programa);
		
		log.info("Se borro la programa "+programa.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El facultadDao es null",facultadDao);
		assertNotNull("El programaDao es null",facultadDao);
		
		List<Programa> list = programaDao.findAll();
		
		for (Programa programa : list) {
			log.info(programa.toString());
		}
		

	}
}
