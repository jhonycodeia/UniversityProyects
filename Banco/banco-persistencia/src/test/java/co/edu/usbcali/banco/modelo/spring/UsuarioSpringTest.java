package co.edu.usbcali.banco.modelo.spring;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;
import co.edu.usbcali.banco.modelo.UsuarioTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class UsuarioSpringTest {

	@PersistenceContext
	EntityManager entityManager;
	
	private final static Logger log=LoggerFactory.getLogger(UsuarioTest.class);	
	private final static String  userId=new String("jhonycode");

	//insert
	@Test	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest() {
				
		assertNotNull("EntityManager null", entityManager);		
		Usuario usuario = entityManager.find(Usuario.class, userId);
		assertNull("usuario ya existe",usuario);
		usuario = new Usuario();
		usuario.setActivo('S');
		usuario.setIdentificacion(new BigDecimal("1200"));		
		usuario.setNombre("Jhony Sarria");
		usuario.setClave("Jfjeo23123");
		usuario.setUsuUsuario(userId);
		
		
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, new Long(1));
		assertNotNull("El tipo de usuario no existe", tipoUsuario);
		usuario.setTipoUsuario(tipoUsuario);
		entityManager.persist(usuario);
	}
	
	//Select
	@Test	
	@Transactional(readOnly=true)
	public void btest() {		
		assertNotNull("EntityManager null", entityManager);
		
		Usuario usuario = entityManager.find(Usuario.class, userId);
		assertNotNull("El usuario no existe",usuario);
		
		log.info(usuario.toString());
					
		
	}
	
	//update
	@Test	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest() {		
		
		assertNotNull("EntityManager null", entityManager);
		
		Usuario usuario = entityManager.find(Usuario.class, userId);
		
		assertNotNull("El usuario no existe",usuario);
		
		usuario.setNombre("Camilo Sandoval");
				
		entityManager.merge(usuario);		
	}
	
	//delete
	@Test	
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest() {
		
		assertNotNull("EntityManager  null", entityManager);
		
		Usuario usuario = entityManager.find(Usuario.class, userId);
		
		assertNotNull("El usuario no existe",usuario);
				
		entityManager.remove(usuario);
				
	}

}
