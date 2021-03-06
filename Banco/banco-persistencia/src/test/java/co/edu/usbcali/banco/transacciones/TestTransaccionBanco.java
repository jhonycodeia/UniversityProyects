package co.edu.usbcali.banco.transacciones;

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

import co.edu.usbcali.banco.logica.ITransaccionBanco;
import co.edu.usbcali.banco.modelo.Cuenta;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTransaccionBanco {

	private final static Logger log = LoggerFactory.getLogger(TestTransaccionBanco.class);
	private final static String usuaId = "aadamoco";
	private final static BigDecimal clieId = new BigDecimal(860);
	private final static BigDecimal clieIdFin = new BigDecimal(346);
	private final static BigDecimal saldo = new BigDecimal(50000);
	private final static String cuenId = "4640-0341-9387-5781";
	private final static String cuenIdFin = "1630-2511-2937-7299";

	@Autowired
	private ITransaccionBanco transaccionBanco;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void retirotest() {

		try {
			Cuenta cuenta = transaccionBanco.retirar(usuaId, cuenId, clieId, saldo);
			log.info(cuenta.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void consignacionotest() {

		try {
			Cuenta cuenta = transaccionBanco.consignar(usuaId, cuenId, clieId, saldo);
			log.info(cuenta.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void trasferenciatest() {

		try {
			Cuenta cuenta = transaccionBanco.transferencia(usuaId,cuenId,cuenIdFin,clieId,clieIdFin,saldo);
			log.info(cuenta.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
