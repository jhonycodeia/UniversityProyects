package co.edu.usbcali.banco.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;

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

import co.edu.usbcali.banco.dao.IClienteDAO;
import co.edu.usbcali.banco.dao.ITipoDocumentoDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoDocumento;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestClienteDAO {

	
	private final static Logger log = LoggerFactory.getLogger(TestClienteDAO.class);
	private final static BigDecimal clieId = new BigDecimal("101234");

	@Autowired
	IClienteDAO clienteDao;
	@Autowired
	ITipoDocumentoDAO tipoDocumentoDao;

	@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void atest() {

		assertNotNull("El IClienteDAO es nulo",clienteDao);
		assertNotNull("El ITipoDocumentoDAOr es nulo",tipoDocumentoDao);
		

		Cliente cliente = clienteDao.find(clieId);
		assertNull("El cliente ya existe", cliente);

		cliente = new Cliente();
		cliente.setActivo('S');
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida Siempre Viva 123");
		cliente.setEmail("hjsimpson@gmail.com");
		cliente.setNombre("Homero J Simpson");
		cliente.setTelefono("457 45 6908");

		TipoDocumento tipoDocumento = tipoDocumentoDao.find(new Long(1));

		assertNotNull("El tipo de documento no existe", tipoDocumento);

		cliente.setTipoDocumento(tipoDocumento);

		clienteDao.create(cliente);

	}

	@Test	
	@Transactional(readOnly = true)
	public void btest() {

		assertNotNull("El IClienteDAO es nulo",clienteDao);
		assertNotNull("El ITipoDocumentoDAOr es nulo",tipoDocumentoDao);

		Cliente cliente = clienteDao.find(clieId);

		assertNotNull("El cliente no existe", cliente);

		log.info("ID:" + cliente.getClieId());
		log.info("NOMBRE:" + cliente.getNombre());

	}

	@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void ctest() {

		assertNotNull("El IClienteDAO es nulo",clienteDao);
		assertNotNull("El ITipoDocumentoDAOr es nulo",tipoDocumentoDao);

		Cliente cliente = clienteDao.find(clieId);

		assertNotNull("El cliente no existe", cliente);

		cliente.setTelefono("+57 316 489 651");

		clienteDao.update(cliente);

	}

	@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void dtest() {

		assertNotNull("El IClienteDAO es nulo",clienteDao);
		assertNotNull("El ITipoDocumentoDAOr es nulo",tipoDocumentoDao);

		Cliente cliente = clienteDao.find(clieId);

		assertNotNull("El cliente no existe", cliente);

		clienteDao.delete(cliente);

	}
}
