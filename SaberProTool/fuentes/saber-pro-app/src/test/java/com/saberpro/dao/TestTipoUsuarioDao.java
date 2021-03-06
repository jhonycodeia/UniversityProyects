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
import com.saberpro.dataaccess.dao.ITipoUsuarioDAO;
import com.saberpro.modelo.TipoUsuario;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestTipoUsuarioDao {

	private final static Logger log = LoggerFactory.getLogger(TestTipoUsuarioDao.class);
	private static long tipoUsuId = 5L;
	
	@Autowired
	ITipoUsuarioDAO tipoUsuarioDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		
		
		TipoUsuario tipoUsuario = tipoUsuarioDao.findById(tipoUsuId);
		
		
		
		assertNull("tipoUsuario ya existe",tipoUsuario);
		
		tipoUsuario = new TipoUsuario();	
		tipoUsuario.setActivo("S");
		tipoUsuario.setFechaCreacion(new Date());
		tipoUsuario.setNombre("Tester".toUpperCase());
		tipoUsuario.setUsuCreador(0L);		
		
		tipoUsuarioDao.save(tipoUsuario);
		tipoUsuId = tipoUsuario.getIdTipoUsuario();
		
		log.info("Se creo la tipoUsuario "+tipoUsuario.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		
		
		TipoUsuario tipoUsuario = tipoUsuarioDao.findById(tipoUsuId);
		
		assertNotNull(" tipo usuario no ya existe",tipoUsuario);	
			
		tipoUsuario.setNombre("Competencia".toUpperCase());		
				
		tipoUsuarioDao.update(tipoUsuario);		
		
		log.info("Se actualizo la  modulo "+tipoUsuario.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		
		
		TipoUsuario tipoUsuario = tipoUsuarioDao.findById(tipoUsuId);
		
		assertNotNull(" tipo usuario no ya existe",tipoUsuario);			
			
				
		tipoUsuarioDao.deleteById(tipoUsuId);
		//tipoUsuarioDao.delete(tipoUsuario);
		
		log.info("Se borro la Modulo "+tipoUsuario.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		
		List<TipoUsuario> list = tipoUsuarioDao.findAll();
		
		for (TipoUsuario tipoUsuario : list) {
			log.info(tipoUsuario.toString());
		}
		

	}

}
