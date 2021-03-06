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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoDocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class ClienteSpringTest {
	
	private final static Logger log=LoggerFactory.getLogger(ClienteSpringTest.class);	
	private final static BigDecimal clieId=new BigDecimal("101234");

	@PersistenceContext
	EntityManager entityManager;
	@Test
	//Crear
	//@Transactional de spring       propagation es para las transacciones   
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest() {	
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente=entityManager.find(Cliente.class, clieId);//busco el cliente con el id=101234
		
		assertNull("El cliente ya existe",cliente);// si es nulo, siga, de lo contrario pare, cliente ya existe 
		
		cliente=new Cliente();//crea el objeto y lo declara
		cliente.setActivo('S');
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida Siempre Viva 123");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero J Simpson");
		cliente.setTelefono("457 45 6908");
		
		TipoDocumento tipoDocumento=entityManager.find(TipoDocumento.class, new Long(1));//traigo el objeto tipodocumento
		
		assertNotNull("El tipo de documento no existe", tipoDocumento);//si  no es nulo, siga, sino imprima mensaje 
		
		cliente.setTipoDocumento(tipoDocumento);//agrego el tipodedoc
				

		entityManager.persist(cliente);//grabo o guardo
		
		
		
	}

	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente=entityManager.find(Cliente.class, clieId);//find solo consulta por id
		
		assertNotNull("El cliente no existe",cliente);
		
		log.info("ID:"+cliente.getClieId());
		log.info("NOMBRE:"+cliente.getNombre());
					
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest() {
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente=entityManager.find(Cliente.class, clieId);
		
		assertNotNull("El cliente no existe",cliente);
		
		cliente.setTelefono("+57 316 489 651");
		
		entityManager.merge(cliente);
		
	}
	
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest() {
		
		assertNotNull("El EntityManager es nulo", entityManager);
		
		Cliente cliente=entityManager.find(Cliente.class, clieId);
		
		assertNotNull("El cliente no existe",cliente);
			
		entityManager.remove(cliente);	
		
	}


}
