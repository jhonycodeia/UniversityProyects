package co.edu.usbcali.banco.logica;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;
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
import co.edu.usbcali.banco.modelo.TipoDocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestCuentaRegistradaLogica {


	private final static Logger log=LoggerFactory.getLogger(TestCuentaRegistradaLogica.class);
	private final static BigDecimal clieId= new BigDecimal(500);
	private final static String cuenId= "0045-0476-8403-9704";
	private static long cureId = 100L;	
	
	
	@Autowired
	private ICuentaRegistradaLogica cuentaRegistradaLogica;
	
	@Autowired
	private IClienteLogica clienteLogica ;
	
	@Autowired
	private ICuentaLogica cuentaLogica;


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {		
		
		assertNotNull("El cuentaRegistradaLogica es nulo",cuentaRegistradaLogica);
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		
		
		CuentaRegistrada cuentaRegistrada =cuentaRegistradaLogica.find(cureId);		
		assertNull("El cuentaRegistrada ya existe",cuentaRegistrada);
		
		Cliente cliente = clienteLogica.find(clieId);
		assertNotNull("El cliente no existe",cliente);
		
		Cuenta cuenta = cuentaLogica.find(cuenId);
		assertNotNull("El cuenta no existe",cuenta);
		
		cuentaRegistrada =new CuentaRegistrada();	
		cuentaRegistrada.setCuenta(cuenta);
		cuentaRegistrada.setCliente(cliente);

		cuentaRegistradaLogica.create(cuentaRegistrada);
		cureId = cuentaRegistrada.getCureId();
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		
		assertNotNull("El cuentaRegistradaLogica es nulo",cuentaRegistradaLogica);
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		

		CuentaRegistrada cuentaRegistrada =cuentaRegistradaLogica.find(cureId);
		assertNotNull("El cuentaRegistrada no existe",cuentaRegistrada);
		
		log.info(cuentaRegistrada.toString());
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		
		assertNotNull("El cuentaRegistradaLogica es nulo",cuentaRegistradaLogica);
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		

		CuentaRegistrada cuentaRegistrada =cuentaRegistradaLogica.find(cureId);
		assertNotNull("El cuentaRegistrada no existe",cuentaRegistrada);
		
		cuentaRegistrada.setCliente(clienteLogica.find(new BigDecimal(15)));
		
		cuentaRegistradaLogica.update(cuentaRegistrada);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest()throws Exception {
		
		assertNotNull("El cuentaRegistradaLogica es nulo",cuentaRegistradaLogica);
		assertNotNull("El clienteLogica es nulo",clienteLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		

		CuentaRegistrada cuentaRegistrada =cuentaRegistradaLogica.find(cureId);
		assertNotNull("El cuentaRegistrada no existe",cuentaRegistrada);
		
		
		
		cuentaRegistradaLogica.delete(cuentaRegistrada);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=true)
	public void etest()throws Exception {
		
		
		
		
		List<CuentaRegistrada> aux = cuentaRegistradaLogica.findCliente(new BigDecimal(1145248));
		for (CuentaRegistrada cuentaRegistrada : aux) {
			log.info(cuentaRegistrada.getCuenta().toString());
		};
	}

}
