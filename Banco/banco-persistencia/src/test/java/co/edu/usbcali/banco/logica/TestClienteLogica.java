package co.edu.usbcali.banco.logica;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
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

import co.edu.usbcali.banco.dao.ITipoDocumentoDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoDocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestClienteLogica {

	private final static Logger log=LoggerFactory.getLogger(TestClienteLogica.class);
	private final static BigDecimal clieId=new BigDecimal("101234");
	
	@Autowired
	private IClienteLogica clienteLogica;
	
	@Autowired
	private ITipoDocumentoLogica tipoDocumentoLogica;


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {
		
		assertNotNull("El clienteLogica es nulo", clienteLogica);
		assertNotNull("El tipoDocumentoDAO es nulo",tipoDocumentoLogica);
		
		
		Cliente cliente=clienteLogica.find(clieId);
		
		assertNull("El cliente ya existe",cliente);
		
		cliente=new Cliente();
		cliente.setActivo('S');
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida Siempre Viva 123");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero J Simpson");
		cliente.setTelefono("457 45 6908");
		
		TipoDocumento tipoDocumento=tipoDocumentoLogica.find(1L);
		assertNotNull("El tipo de documento no existe", tipoDocumento);
		cliente.setTipoDocumento(tipoDocumento);

		clienteLogica.create(cliente);
		
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		assertNotNull("El clienteDAO es nulo", clienteLogica);
		assertNotNull("El tipoDocumentoDAO es nulo", tipoDocumentoLogica);

		Cliente cliente=clienteLogica.find(clieId);
		assertNotNull("El cliente no existe",cliente);
		
		log.info("ID:"+cliente.getClieId());
		log.info("NOMBRE:"+cliente.getNombre());
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		assertNotNull("El clienteDAO es nulo", clienteLogica);
		assertNotNull("El tipoDocumentoDAO es nulo",tipoDocumentoLogica);
		
		Cliente cliente=clienteLogica.find(clieId);
		assertNotNull("El cliente no existe",cliente);
		cliente.setTelefono("+57 316 489 651");
		
		clienteLogica.update(cliente);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest()throws Exception {
		assertNotNull("El clienteDAO es nulo", clienteLogica);
		assertNotNull("El tipoDocumentoDAO es nulo",tipoDocumentoLogica);
		
		Cliente cliente=clienteLogica.find(clieId);
		assertNotNull("El cliente no existe",cliente);
		clienteLogica.delete(cliente);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void etest()throws Exception {
		assertNotNull("El clienteDAO es nulo", clienteLogica);
		assertNotNull("El tipoDocumentoDAO es nulo", tipoDocumentoLogica);
		
		List<Cliente> losClientes=clienteLogica.findAll();
		for (Cliente cliente : losClientes) {
			log.info("ID:"+cliente.getClieId());
			log.info("NOMBRE:"+cliente.getNombre());
		}
	}
	
	
}
