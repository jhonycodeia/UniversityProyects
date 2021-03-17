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
import com.saberpro.dataaccess.dao.IPermisoDAO;
import com.saberpro.dataaccess.dao.ITipoUsuarioDAO;
import com.saberpro.modelo.Permiso;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestPermisoDao {

	private final static Logger log = LoggerFactory.getLogger(TestPermisoDao.class);
	private static long perId = 1L;
	
	@Autowired
	IGrupoOpcionDAO grupoOpcionDao;
	
	@Autowired
	ITipoUsuarioDAO tipoUsuarioDao;
	
	@Autowired
	IPermisoDAO permisoDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);
		assertNotNull("El tipoUsuarioDao es null",tipoUsuarioDao);
		assertNotNull("El permisoDao es null",permisoDao);
		
		
		
		Permiso permiso = permisoDao.findById(perId);
		
		assertNull("permiso ya existe",permiso);
		
		permiso = new Permiso();
		permiso.setActivo("S");
		permiso.setFechaCreacion(new Date());
		permiso.setGrupoOpcion(grupoOpcionDao.findById(2L));
		permiso.setTipoUsuario(tipoUsuarioDao.findById(5L));
		permiso.setUsuCreador(0L);
		
		permisoDao.save(permiso);
		perId = permiso.getIdPermiso();
		
		log.info("Se creo la permiso "+permiso.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);
		assertNotNull("El tipoUsuarioDao es null",tipoUsuarioDao);
		assertNotNull("El permisoDao es null",permisoDao);
		
		
		
		Permiso permiso = permisoDao.findById(perId);
		
		assertNotNull("permiso no ya existe",permiso);	
			
		permiso.setActivo("N");	
				
		permisoDao.update(permiso);		
		
		log.info("Se creo la permiso "+permiso.toString());	
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);
		assertNotNull("El tipoUsuarioDao es null",tipoUsuarioDao);
		assertNotNull("El permisoDao es null",permisoDao);
		
		
		
		Permiso permiso = permisoDao.findById(perId);
		
		assertNotNull("permiso no ya existe",permiso);				
			
				
		permisoDao.deleteById(perId);
		
		
		log.info("Se creo la permiso "+permiso.toString());			
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El grupoOpcionDao es null",grupoOpcionDao);
		assertNotNull("El tipoUsuarioDao es null",tipoUsuarioDao);
		assertNotNull("El permisoDao es null",permisoDao);		
		
		List<Permiso> list = permisoDao.findAll();
		
		for (Permiso permiso : list) {
			log.info(permiso.toString());
		}
		

	}

}
