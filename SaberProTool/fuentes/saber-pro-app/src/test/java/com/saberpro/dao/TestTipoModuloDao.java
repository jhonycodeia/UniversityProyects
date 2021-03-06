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
import com.saberpro.dataaccess.dao.ITipoModuloDAO;
import com.saberpro.modelo.Facultad;
import com.saberpro.modelo.TipoModulo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestTipoModuloDao {

	private final static Logger log = LoggerFactory.getLogger(TestTipoModuloDao.class);
	private static long tipoModuId = 3L;
	
	@Autowired
	ITipoModuloDAO tipoModuloDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		
		TipoModulo tipoModulo = tipoModuloDao.findById(tipoModuId);
		
		
		
		assertNull("tipo modulo ya existe",tipoModulo);
		
		tipoModulo = new TipoModulo();
		tipoModulo.setActivo("S");
		tipoModulo.setFechaCreacion(new Date());
		tipoModulo.setNombre("Competencia de pruebas".toUpperCase());
		tipoModulo.setUsuCreador(0L);
		
		tipoModuloDao.save(tipoModulo);
		tipoModuId = tipoModulo.getIdTipoModulo();
		
		log.info("Se creo la tipo modulo "+tipoModulo.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		
		TipoModulo tipoModulo = tipoModuloDao.findById(tipoModuId);
		
		assertNotNull("tipo modulo no ya existe",tipoModulo);	
			
		tipoModulo.setNombre("Competencia Opcional".toUpperCase());		
				
		tipoModuloDao.update(tipoModulo);		
		
		log.info("Se actualizo la tipo modulo "+tipoModulo.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		
		TipoModulo tipoModulo = tipoModuloDao.findById(tipoModuId);
		
		assertNotNull("tipo modulo no ya existe",tipoModulo);			
			
				
		tipoModuloDao.deleteById(tipoModuId);
		//tipoModuloDao.delete(tipoModulo);
		
		log.info("Se borro la tipoModulo "+tipoModulo.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El tipoModuloDao es null",tipoModuloDao);
		
		List<TipoModulo> list = tipoModuloDao.findAll();
		
		for (TipoModulo tipoModulo : list) {
			log.info(tipoModulo.toString());
		}
		

	}

}
