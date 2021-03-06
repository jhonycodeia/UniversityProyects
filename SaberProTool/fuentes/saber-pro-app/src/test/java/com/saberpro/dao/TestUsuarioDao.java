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
import com.saberpro.dataaccess.dao.IUsuarioDAO;
import com.saberpro.modelo.Usuario;
import com.saberpro.utilities.Constantes;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestUsuarioDao {

	private final static Logger log = LoggerFactory.getLogger(TestUsuarioDao.class);
	private static long usuId = 6L;
	
	@Autowired
	ITipoUsuarioDAO tipoUsuarioDao;
	
	@Autowired
	IUsuarioDAO usuarioDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		
		
		Usuario usuario = usuarioDao.findById(usuId);
		
		assertNull("tipoUsuario ya existe",usuario);
		
		usuario = new Usuario();
		usuario.setActivo("S");
		usuario.setApellido("Sarria Paloma");
		usuario.setCelular(3108971385L);
		usuario.setCodigo(1145879L);
		usuario.setCorreo("jhonypalacio@gmail.com");
		usuario.setFechaCreacion(new Date());
		usuario.setGenero("M");		
		usuario.setNombre("Jhony");
		usuario.setUsuCreador(0L);
		usuario.setTipoUsuario(tipoUsuarioDao.findById(1L));
		usuario.setPassword("12345");
		usuario.setIdentificacion(16597187L);
		
		usuarioDao.save(usuario);
		usuId = usuario.getIdUsuario();
		
		log.info("Se creo la tipoUsuario "+usuario.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		
		
		Usuario usuario = usuarioDao.findById(usuId);
		
		assertNotNull(" usuario no ya existe",usuario);	
			
		usuario.setNombre("Andres".toUpperCase());		
				
		usuarioDao.update(usuario);		
		
		log.info("Se actualizo la  usuario "+usuario.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		
		
		Usuario usuario = usuarioDao.findById(usuId);
		
		assertNotNull(" usuario no ya existe",usuario);				
			
				
		usuarioDao.deleteById(usuId);
		//usuarioDao.delete(usuario);
		
		log.info("Se borro la Modulo "+usuario.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		
		List<Usuario> list = usuarioDao.findByTipoUsuarioPrograma(5L,2L);
		
		log.info("tamaño "+list.size());
		for (Usuario usuario : list) {
			log.info(usuario.toString());
		}
		

	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testeConsultaCodigo() {

		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		
		Usuario usuario = usuarioDao.findByCodigo(9999999L);
		
		log.info(usuario.toString());
		
		

	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testfConsultaEmail() {

		assertNotNull("El tipousuarioDao es null",tipoUsuarioDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		
		List<Usuario> usuarioList = usuarioDao.findByUsuarioInPrueba(9L);
		
		log.info("Tamaño es de "+usuarioList.size());
		for (Usuario usuario2 : usuarioList) {
			log.info(usuario2.toString());
		}
		
		
		

	}

}
