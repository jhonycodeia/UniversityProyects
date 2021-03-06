package co.edu.usbcali.banco.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import java.math.BigDecimal;
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

import co.edu.usbcali.banco.dao.IClienteDAO;
import co.edu.usbcali.banco.dao.ICuentaDAO;
import co.edu.usbcali.banco.dao.ICuentaRegistradaDAO;
import co.edu.usbcali.banco.dao.IUsuarioDAO;
import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoTransaccion;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestCuentaDAO {

	private final static Logger log = LoggerFactory.getLogger(TestCuentaDAO.class);
	private final static String cuenId = "7992-5996-351-9087";
	private final static long cureId = 100L;
	private final static String usuaId = "aadamoco";
	private final static BigDecimal clieId = new BigDecimal("500");

	@Autowired
	ICuentaDAO cuentaDao;
	@Autowired
	IUsuarioDAO usuarioDao;
	@Autowired
	IClienteDAO clienteDao;
	@Autowired
	ICuentaRegistradaDAO cuentaRegistradaDao;
	@Autowired
	ITipoDocumentoDAO tipoDocumentoDAO;
	@Autowired
	ITipoTransaccionDAO tipoTransaccionDAO;
	@Autowired
	ITipoUsuarioDAO tipoUsuarioDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void atestCuenta() {
		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);
		assertNotNull("El IClienteDao es nulo", clienteDao);

		Cuenta cuenta = cuentaDao.find(cuenId);
		assertNull("El cuenta ya existe", cuenta);

		Cliente cliente = clienteDao.find(clieId);
		assertNotNull("El cliente es null", cliente);

		cuenta = new Cuenta();
		cuenta.setCuenId(cuenId);
		cuenta.setActiva('S');
		cuenta.setClave("12354");
		cuenta.setCliente(cliente);
		cuenta.setCuenId(cuenId);
		cuenta.setSaldo(new BigDecimal(2500000));

		cuentaDao.create(cuenta);
	}

	

	@Test
	@Transactional(readOnly = true)
	public void btestCuenta() {

		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);

		Cuenta cuenta = cuentaDao.find(cuenId);

		assertNotNull("El cuenta no existe", cuenta);

		log.info(cuenta.toString());

	}

	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void ctestCuenta() {

		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);

		Cuenta cuenta = cuentaDao.find(cuenId);

		assertNotNull("El cuenta no existe", cuenta);

		cuenta.setClave("258934");

		cuentaDao.update(cuenta);

	}

	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void dtestCuenta() {

		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);

		Cuenta cuenta = cuentaDao.find(cuenId);

		assertNotNull("El cuenta no existe", cuenta);
		
		log.info(cuenta.toString());

		cuentaDao.delete(cuenta);

	}
	
	@Test	
	@Transactional(readOnly = true)
	public void etestCuenta() {

		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);

		List<Cuenta> listCuenta = cuentaDao.findAll();

		assertNotNull("no hay usuarios",listCuenta);

		for (Cuenta cuenta : listCuenta) {
			log.info(cuenta.toString());
		}
		

	}
	@Test	
	@Transactional(readOnly = true)
	public void ftestCuenta() {

		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);

		List<Cuenta> listCuenta = cuentaDao.findAllCliente(new BigDecimal(1));

		assertNotNull("no hay usuarios",listCuenta);

		for (Cuenta cuenta : listCuenta) {
			log.info(cuenta.toString());
		}
		

	}
	
	@Test	
	@Transactional(readOnly = true)
	public void gtestCuenta() {

		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);

		TipoDocumento tipoDocumento = tipoDocumentoDAO.findName("CEDULA");
		TipoUsuario tipoUsuario = tipoUsuarioDAO.findName("CAJERO");
		TipoTransaccion tipoTransaccion = tipoTransaccionDAO.findName("RETIRO");
		log.info(tipoTransaccion.getNombre());
		log.info(tipoTransaccion.getTitrId()+"");
		

	}

}
