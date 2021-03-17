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
import com.saberpro.modelo.Facultad;





@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestFacultadDao {
	
	private final static Logger log = LoggerFactory.getLogger(TestFacultadDao.class);
	private static long facuId = 7L;
	
	@Autowired
	IFacultadDAO facultadDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		assertNotNull("El facultadDao es null",facultadDao);
		
		Facultad facultad = facultadDao.findById(facuId);
		
		
		
		assertNull("facultad ya existe",facultad);
		
		facultad = new Facultad();		
		facultad.setNombre("Politica");
		facultad.setFechaCreacion(new Date());
		facultad.setActivo("S");
		facultad.setUsuCreador(0L);
		
		
		facultadDao.save(facultad);
		facuId = facultad.getIdFacultad();
		
		log.info("Se creo la facultad "+facultad.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		assertNotNull("El facultadDao es null",facultadDao);
		
		Facultad facultad = facultadDao.findById(facuId);		
		
		
		assertNotNull("facultad no ya existe",facultad);	
			
		facultad.setNombre("Politica,Recreacion y Artes".toUpperCase());		
				
		facultadDao.update(facultad);		
		
		log.info("Se actualizo la facultad "+facultad.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		assertNotNull("El facultadDao es null",facultadDao);
		
		Facultad facultad = facultadDao.findById(facuId);		
		
		
		assertNotNull("facultad no ya existe",facultad);			
			
				
		facultadDao.deleteById(facuId);
		//facultadDao.delete(facultad);
		
		log.info("Se borro la facultad "+facultad.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El facultadDao es null",facultadDao);
		
		List<Facultad> list = facultadDao.findAll();
		
		for (Facultad facultad : list) {
			log.info(facultad.toString());
		}
		

	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testeConsulta() {

		assertNotNull("El facultadDao es null",facultadDao);
		
		Facultad facultad = facultadDao.findByNombre("ECONOMICAS");
		
		
		log.info(facultad.toString());
		
		

	}

}
