package co.edu.usbcali.banco.logica;

import static org.junit.Assert.*;

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

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.TipoTransaccion;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTransaccionLogica {

	private final static Logger log=LoggerFactory.getLogger(TestTransaccionLogica.class);	
	private final static long tipoId= 1L;
	private final static String cuenId= "0045-0476-8403-9704";
	private final static String usuaId= "aadamoco";
	private static long tranId= 5000L;
	
	
	
	@Autowired
	private ITransaccionLogica transaccionLogica;
	
	@Autowired
	private ICuentaLogica cuentaLogica;
	
	@Autowired
	private ITipoTransaccionLogica tipoTransaccionLogica;
	
	@Autowired
	private IUsuarioLogica usuarioLogica;
	
	


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {		
		
		
		assertNotNull("El clienteLogica es nulo",usuarioLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		assertNotNull("El cuentaLogica es nulo",tipoTransaccionLogica);
		assertNotNull("El cuentaLogica es nulo",transaccionLogica);
		
		
		Transaccion transaccion = transaccionLogica.find(5000L);		
		assertNull("El cuentaRegistrada ya existe",transaccion);
		
		Usuario usuario = usuarioLogica.find(usuaId);
		assertNotNull("El cliente no existe",usuario);	
		
		Cuenta cuenta = cuentaLogica.find(cuenId);
		assertNotNull("El cliente no existe",cuenta);	
		
		TipoTransaccion tipoTransaccion = tipoTransaccionLogica.find(1L);
		assertNotNull("El cliente no existe",tipoTransaccion);
		
		transaccion =new Transaccion();		
		transaccion.setCuenta(cuenta);
		transaccion.setFecha(new Date());
		transaccion.setTipoTransaccion(tipoTransaccion);
		transaccion.setUsuario(usuario);
		transaccion.setValor(new BigDecimal(500000));

		transaccionLogica.create(transaccion);
		tranId = transaccion.getTranId();
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		
		assertNotNull("El clienteLogica es nulo",usuarioLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		assertNotNull("El cuentaLogica es nulo",tipoTransaccionLogica);
		assertNotNull("El cuentaLogica es nulo",transaccionLogica);
		
		
		Transaccion transaccion = transaccionLogica.find(tranId);
		assertNotNull("El cuentaRegistrada no existe",transaccion);		
		
		
		log.info(transaccion.toString());
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		
		assertNotNull("El clienteLogica es nulo",usuarioLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		assertNotNull("El cuentaLogica es nulo",tipoTransaccionLogica);
		assertNotNull("El cuentaLogica es nulo",transaccionLogica);
		
		
		Transaccion transaccion = transaccionLogica.find(tranId);
		assertNotNull("El cuentaRegistrada no existe",transaccion);
		
		transaccion.setValor(new BigDecimal(100000));
		
		transaccionLogica.update(transaccion);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest()throws Exception {
		
		assertNotNull("El clienteLogica es nulo",usuarioLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		assertNotNull("El cuentaLogica es nulo",tipoTransaccionLogica);
		assertNotNull("El cuentaLogica es nulo",transaccionLogica);
		
		
		Transaccion transaccion = transaccionLogica.find(tranId);	
		assertNotNull("El cuentaRegistrada no existe",transaccion);
			
		transaccionLogica.delete(transaccion);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void etest()throws Exception {
		
		
		assertNotNull("El clienteLogica es nulo",usuarioLogica);
		assertNotNull("El cuentaLogica es nulo",cuentaLogica);
		assertNotNull("El cuentaLogica es nulo",tipoTransaccionLogica);
		assertNotNull("El cuentaLogica es nulo",transaccionLogica);		
				
		List<Transaccion> losTransacciones = transaccionLogica.findAllCuenta("0098-5195-2877-0140");
		for (Transaccion transaccion : losTransacciones) {
			log.info(transaccion.toString());
			
		}
	}

}
