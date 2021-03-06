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
import com.saberpro.dataaccess.dao.ITipoModuloDAO;
import com.saberpro.modelo.Modulo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestModuloDao {

	private final static Logger log = LoggerFactory.getLogger(TestModuloDao.class);
	private static long moduId = 9L;
	
	@Autowired
	ITipoModuloDAO tipoModuloDao;
	
	@Autowired
	IModuloDAO moduloDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		assertNotNull("El ModuloDao es null",moduloDao);
		
		Modulo modulo = moduloDao.findById(moduId);
		
		
		
		assertNull("modulo ya existe",modulo);
		
		modulo = new Modulo();
		modulo.setActivo("S");
		modulo.setCantidadPreguntas(25L);
		modulo.setFechaCreacion(new Date());
		modulo.setNombre("Competencia logica".toUpperCase());
		modulo.setPrioridad(1L);
		modulo.setTipoModulo(tipoModuloDao.findById(1L));
		modulo.setUsuCreador(0L);		
		
		moduloDao.save(modulo);
		moduId = modulo.getIdModulo();
		
		log.info("Se creo la modulo "+modulo.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		assertNotNull("El ModuloDao es null",moduloDao);
		
		Modulo modulo = moduloDao.findById(moduId);
		
		assertNotNull(" modulo no ya existe",modulo);	
			
		modulo.setNombre("Competencia Opcional".toUpperCase());		
				
		moduloDao.update(modulo);		
		
		log.info("Se actualizo la  modulo "+modulo.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		assertNotNull("El ModuloDao es null",moduloDao);
		
		Modulo modulo = moduloDao.findById(moduId);
		
		assertNotNull(" modulo no ya existe",modulo);				
			
				
		moduloDao.deleteById(moduId);
		//moduloDao.delete(modulo);
		
		log.info("Se borro la Modulo "+modulo.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		assertNotNull("El ModuloDao es null",moduloDao);
		
		
		List<Modulo> list = moduloDao.findByPrograma(5L);
		log.info("Tamaño es de "+list.size());
		for (Modulo modulo : list) {
			log.info(modulo.toString());
		}
		

	}
}
