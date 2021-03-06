package co.edu.usbcali.banco.modelo;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoDocumento;

public class ClienteTest {

	private final static Logger log=LoggerFactory.getLogger(ClienteTest.class);
	private final static String persistenceUnit="banco-persistencia";
	private final static BigDecimal clieId=new BigDecimal("1200");
	
	@Test
	//Crear
	public void atest() {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager=entityManagerFactory.createEntityManager();		
		
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		
		assertNull("El cliente ya existe",cliente);
		
		cliente = new Cliente();
		cliente.setActivo('S');
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida Siempre Viva 123");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero J Simpson");
		cliente.setTelefono("457 45 6908");
		
		TipoDocumento tipoDocumento=entityManager.find(TipoDocumento.class,3L);
		
		assertNotNull("El tipo de documento no existe", tipoDocumento);
		
		cliente.setTipoDocumento(tipoDocumento);
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	@Test
	//Consultar
	public void btest() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente=entityManager.find(Cliente.class, clieId);
		
		assertNotNull("El cliente no existe",cliente);
		
		log.info(cliente.toString());
		log.info(cliente.getTipoDocumento().toString());
	
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	@Test
	//Modificar
	public void ctest() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente=entityManager.find(Cliente.class, clieId);
		
		assertNotNull("El cliente no existe",cliente);
		
		cliente.setTelefono("+57 316 489 651");
		
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}
	
	@Test
	//Borrar
	public void dtest() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory(persistenceUnit);
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente=entityManager.find(Cliente.class, clieId);
		
		assertNotNull("El cliente no existe",cliente);
		
		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
	}


}
