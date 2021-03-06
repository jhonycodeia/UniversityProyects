package co.edu.usbcali.banco.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;

public class UsuarioTest {

	private final static Logger log = LoggerFactory.getLogger(UsuarioTest.class);
	private final static String persistenceUnit = "banco-persistencia";
	private final static String usuid = "jhonycode";

	
	@Test // insert into usuario
	public void atest() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		assertNotNull("El EntityManager es nulo", entityManager);

		Usuario usuario = entityManager.find(Usuario.class, usuid);

		assertNull("el usuario ya exite", usuario);

		log.info("el usuario no existe");

		usuario = new Usuario();
		usuario.setUsuUsuario(usuid);
		usuario.setClave("khr123JU");
		usuario.setIdentificacion(new BigDecimal(11248458));
		usuario.setNombre("Jhony Sarria");
		usuario.setActivo('S');
		
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, 3L);

		assertNotNull("El tipo de usuario no existe", tipoUsuario);

		
		
		log.info(usuario.toString());
		log.info(tipoUsuario.toString());

		usuario.setTipoUsuario(tipoUsuario);

		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}
	
	@Test // select * from usuario
	public void btest() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		assertNotNull("El EntityManager es nulo", entityManager);

		Usuario usuario = entityManager.find(Usuario.class, usuid);

		assertNotNull("el usuario no existe", usuario);	
		
		log.info(usuario.toString());
		log.info(usuario.getTipoUsuario().toString());

		entityManager.close();
		entityManagerFactory.close();

	}
	
	@Test // update usuario
	public void ctest() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		assertNotNull("El EntityManager es nulo", entityManager);

		Usuario usuario = entityManager.find(Usuario.class, usuid);

		assertNotNull("el usuario no existe", usuario);	
		
		log.info(usuario.toString());
		log.info(usuario.getTipoUsuario().toString());
		
		usuario.setClave("kh84pojT");
		usuario.setIdentificacion(new BigDecimal(11984357));
		
		TipoUsuario tipoUsuario = entityManager.find(TipoUsuario.class, 1L);

		assertNotNull("El tipo de usuario no existe", tipoUsuario);
		
		usuario.setTipoUsuario(tipoUsuario);
		
		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}
	
	@Test // delete from usuario
	public void dtest() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		assertNotNull("El EntityManager es nulo", entityManager);

		Usuario usuario = entityManager.find(Usuario.class, usuid);

		assertNotNull("el usuario no existe", usuario);	
		
		log.info(usuario.toString());
		log.info(usuario.getTipoUsuario().toString());	
		
		entityManager.getTransaction().begin();
		entityManager.remove(usuario);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}
