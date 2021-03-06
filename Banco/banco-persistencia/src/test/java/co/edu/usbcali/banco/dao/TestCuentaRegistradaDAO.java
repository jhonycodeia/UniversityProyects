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
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestCuentaRegistradaDAO {

	private final static Logger log = LoggerFactory.getLogger(TestCuentaRegistradaDAO.class);
	private final static String cuenId = "7992-5996-351-987";
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

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void atestCuentaRegistrada() {
		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);
		assertNotNull("El IClienteDao es nulo", clienteDao);
		assertNotNull("El ICuentaRegistradaDAO es nulo", cuentaRegistradaDao);

		CuentaRegistrada cuentaRegistrada = cuentaRegistradaDao.find(cureId);
		assertNull("El cuenta ya existe", cuentaRegistrada);

		Cliente cliente = clienteDao.find(clieId);
		assertNotNull("El cliente es null", cliente);

		Cuenta cuenta = cuentaDao.find(cuenId);
		assertNotNull("El cuenta es null", cuenta);

		cuentaRegistrada = new CuentaRegistrada();
		cuentaRegistrada.setCliente(cliente);
		cuentaRegistrada.setCuenta(cuenta);
		cuentaRegistrada.setCureId(cureId);

		cuentaRegistradaDao.create(cuentaRegistrada);
	}

	@Test
	@Transactional(readOnly = true)
	public void btestCuentaRegistrada() {

		assertNotNull("El ICuentaRegistradaDAO es nulo", cuentaRegistradaDao);

		CuentaRegistrada cuentaRegistrada = cuentaRegistradaDao.find(cureId);

		assertNotNull("El cuenta registrada no existe", cuentaRegistrada);

		log.info(cuentaRegistrada.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void ctestCuentaRegistrada() {

		assertNotNull("El ICuentaRegistradaDAO es nulo", cuentaRegistradaDao);

		CuentaRegistrada cuentaRegistrada = cuentaRegistradaDao.find(cureId);

		assertNotNull("El cuenta registrada no existe", cuentaRegistrada);

		cuentaRegistrada.setCliente(clienteDao.find(new BigDecimal(15)));

		cuentaRegistradaDao.update(cuentaRegistrada);

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void dtestCuentaRegistrada() {

		assertNotNull("El ICuentaRegistradaDAO es nulo", cuentaRegistradaDao);

		CuentaRegistrada cuentaRegistrada = cuentaRegistradaDao.find(cureId);

		assertNotNull("El cuenta registrada no existe", cuentaRegistrada);

		cuentaRegistradaDao.delete(cuentaRegistrada);

	}

	@Test
	@Transactional(readOnly = true)
	public void etestCuenta() {

		assertNotNull("El ICuentaDAO  es nulo", cuentaDao);

		List<Cuenta> listCuenta = cuentaDao.findAll();

		assertNotNull("no hay usuarios", listCuenta);

		for (Cuenta cuenta : listCuenta) {
			log.info(cuenta.toString());
		}

	}

	@Test
	@Transactional(readOnly = true)
	public void etestCuentaRegistrada() {

		assertNotNull("El ICuentaRegistradaDAO es nulo", cuentaRegistradaDao);

		List<CuentaRegistrada> listCuentaRegistrada = cuentaRegistradaDao.findAll();

		assertNotNull("no hay usuarios", listCuentaRegistrada);

		for (CuentaRegistrada cuentaRegistrada : listCuentaRegistrada) {
			log.info(cuentaRegistrada.toString());
		}

	}

	@Test
	@Transactional(readOnly = true)
	public void ftestCuentaRegistrada() {

		//CuentaRegistrada aux = cuentaRegistradaDao.findClienteCuenta("4640-0341-9387-5781",new BigDecimal(1145248));
		List<CuentaRegistrada> listCuentaRegistrada = cuentaRegistradaDao.findClienteOnly(new BigDecimal(1145248));

		assertNotNull("no hay usuarios", listCuentaRegistrada);

		for (CuentaRegistrada cuentaRegistrada : listCuentaRegistrada) {
			log.info(cuentaRegistrada.toString());
		}


	}

}
