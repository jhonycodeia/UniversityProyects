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
import com.saberpro.dataaccess.dao.IGrupoOpcionDAO;
import com.saberpro.modelo.GrupoOpcion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestGrupoOpcionDao {

	private final static Logger log = LoggerFactory.getLogger(TestOpcionDao.class);
	private static long opcId = 3L;
	
		
	@Autowired
	IGrupoOpcionDAO grupoOpcionDao;
	
		
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);				
		
		GrupoOpcion grupoOpcion = grupoOpcionDao.findById(opcId);
		
		assertNull("grupoOpcion ya existe",grupoOpcion);		
		
		grupoOpcion = new GrupoOpcion();
		grupoOpcion.setActivo("S");
		grupoOpcion.setDescripcion("meno preguntas");
		grupoOpcion.setFechaCreacion(new Date());
		grupoOpcion.setNombre("respuestas");
		grupoOpcion.setUsuCreador(0L);
						
		grupoOpcionDao.save(grupoOpcion);
		opcId = grupoOpcion.getIdGrupoOpcion();
		
		log.info("Se creo la grupoOpcion "+grupoOpcion.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);				
		
		GrupoOpcion grupoOpcion = grupoOpcionDao.findById(opcId);
		
		assertNotNull("grupoOpcion no ya existe",grupoOpcion);	
			
		grupoOpcion.setActivo("N");	
				
		grupoOpcionDao.update(grupoOpcion);		
		
		log.info("Se creo la grupoOpcion "+grupoOpcion.toString());	
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);				
		
		GrupoOpcion grupoOpcion = grupoOpcionDao.findById(opcId);
		
		assertNotNull("grupoOpcion no ya existe",grupoOpcion);						
			
				
		grupoOpcionDao.deleteById(opcId);
		
		
		log.info("Se creo la grupoOpcion "+grupoOpcion.toString());			
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);	
		
		
		List<GrupoOpcion> list = grupoOpcionDao.findAll();
		
		for (GrupoOpcion grupoOpcion : list) {
			log.info(grupoOpcion.toString());
		}
		

	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testEConsultaTipoUsuario() throws DaoException {

		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);	
		
		
		List<GrupoOpcion> list = grupoOpcionDao.findByTipoUsuario(5L,"S");
		
		log.info("tamaño "+list.size());
		for (GrupoOpcion grupoOpcion : list) {
			log.info(grupoOpcion.toString());
		}
		

	}

}
