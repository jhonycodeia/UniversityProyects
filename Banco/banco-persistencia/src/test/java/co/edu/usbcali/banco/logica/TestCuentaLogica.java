package co.edu.usbcali.banco.logica;

import static org.junit.Assert.*;

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

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.CuentaRegistrada;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestCuentaLogica {

	private final static Logger log=LoggerFactory.getLogger(TestCuentaLogica.class);
	private final static BigDecimal clieId= new BigDecimal(500);
	private final static String cuenId= "0045-0476-8403-0004";
	
	
	@Autowired
	private IClienteLogica clienteLogica ;
	
	@Autowired
	private ICuentaLogica cuentaLogica;


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {		
		
		
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		
		
		Cuenta cuenta =cuentaLogica.find(cuenId);		
		assertNull("El cuentaRegistrada ya existe",cuenta);
		
		Cliente cliente = clienteLogica.find(clieId);
		assertNotNull("El cliente no existe",cliente);		
		
		cuenta =new Cuenta();
		cuenta.setCuenId(cuenId);
		cuenta.setActiva('S');
		cuenta.setClave("sdaad56");
		cuenta.setCliente(cliente);
		cuenta.setSaldo(new BigDecimal(500000));

		cuentaLogica.create(cuenta);
		
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		
		
		Cuenta cuenta =cuentaLogica.find(cuenId);	
		assertNotNull("El cuentaRegistrada no existe",cuenta);
		
		log.info(cuenta.toString());
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		
		
		Cuenta cuenta =cuentaLogica.find(cuenId);	
		assertNotNull("El cuentaRegistrada no existe",cuenta);
		
		cuenta.setClave("jdao587425");
		
		cuentaLogica.update(cuenta);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest()throws Exception {
		
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		
		
		Cuenta cuenta =cuentaLogica.find(cuenId);	
		assertNotNull("El cuentaRegistrada no existe",cuenta);
		
		
		
		cuentaLogica.delete(cuenta);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void etest()throws Exception {
		
		
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		
				
		List<Cuenta> losCuentas = cuentaLogica.findAll();
		for (Cuenta cuenta : losCuentas) {
			log.info(cuenta.toString());
			
		}
	}
	
	@Test
	@Transactional(readOnly=true)
	public void ftest() {		
		List<Cuenta> losCuentas = cuentaLogica.findAllCliente(new BigDecimal(860));
		for (Cuenta cuenta : losCuentas) {
			log.info(cuenta.toString());
			
		}
	}

}
