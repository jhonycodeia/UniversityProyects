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
import com.saberpro.dataaccess.dao.IOpcionDAO;
import com.saberpro.modelo.Opcion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestOpcionDao {

	private final static Logger log = LoggerFactory.getLogger(TestOpcionDao.class);
	private static long opcId = 1L;
	
	@Autowired
	IOpcionDAO opcionDao;
	
	@Autowired
	IGrupoOpcionDAO grupoOpcionDao;
	
		
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);	
		assertNotNull("El opcionDao es null",opcionDao);	
		
		Opcion opcion = opcionDao.findById(opcId);
		
		assertNull("opcion ya existe",opcion);		
		
		opcion = new Opcion();
		opcion.setActivo("S");
		opcion.setDescripcion("gestiona preguntas");
		opcion.setFechaCreacion(new Date());
		opcion.setGrupoOpcion(grupoOpcionDao.findById(1L));
		opcion.setNombre("gestionDao");
		opcion.setRuta("gestionusuario.xhtml");
		opcion.setUsuCreador(0L);
		
		opcionDao.save(opcion);
		opcId = opcion.getIdOpcion();
		
		log.info("Se creo la opcion "+opcion.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);	
		assertNotNull("El opcionDao es null",opcionDao);	
		
		Opcion opcion = opcionDao.findById(opcId);
		
		assertNotNull("opcion no ya existe",opcion);	
			
		opcion.setActivo("N");	
				
		opcionDao.update(opcion);		
		
		log.info("Se creo la opcion "+opcion.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);	
		assertNotNull("El opcionDao es null",opcionDao);	
		
		Opcion opcion = opcionDao.findById(opcId);
		
		assertNotNull("opcion no ya existe",opcion);					
			
				
		opcionDao.deleteById(opcId);
		
		
		log.info("Se creo la opcion "+opcion.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);	
		assertNotNull("El opcionDao es null",opcionDao);
		
		List<Opcion> list;
		try {
			list = opcionDao.findByGrupo(3L,"S");
			for (Opcion opcion : list) {
				log.info(opcion.toString());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
