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

import co.edu.usbcali.banco.dao.ICuentaDAO;
import co.edu.usbcali.banco.dao.ITipoTransaccionDAO;
import co.edu.usbcali.banco.dao.ITransaccionDAO;
import co.edu.usbcali.banco.dao.IUsuarioDAO;
import co.edu.usbcali.banco.modelo.Cuenta;
import co.edu.usbcali.banco.modelo.TipoTransaccion;
import co.edu.usbcali.banco.modelo.Transaccion;
import co.edu.usbcali.banco.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestTransaccionDAO {

	private final static Logger log = LoggerFactory.getLogger(TestTransaccionDAO.class);
	private final static long tranId = 3005L;
	private final static String cuenId = "7572-5956-2301-9837";
	private final static String usuaId = "aadamoco";
	
	@Autowired
	ITransaccionDAO transaccionDao;
	@Autowired
	ITipoTransaccionDAO tipoTransaccionDao;
	@Autowired
	ICuentaDAO cuentaDao;
	@Autowired
	IUsuarioDAO usuarioDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void atest() {
		
		assertNotNull("El ITransaccionDao es nulo",transaccionDao);
		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);
		assertNotNull("El ICuentaDAO  es nulo",cuentaDao);
		assertNotNull("El IUsuarioDAO es nulo",usuarioDao);
		

		Transaccion transaccion = transaccionDao.find(tranId);
		assertNull("El transaccion ya existe",transaccion);
		
		Usuario usuario = usuarioDao.find(usuaId);
		assertNotNull("El usuario es null",usuario);
		
		Cuenta cuenta = cuentaDao.find(cuenId);
		assertNotNull("El cuenta es null",cuenta);
		
		TipoTransaccion tipoTransaccion = tipoTransaccionDao.find(1L);
		assertNotNull("El tipotrasaccion es null",tipoTransaccion);
		
		transaccion = new Transaccion();		
		transaccion.setCuenta(cuenta);
		transaccion.setFecha(new Date());
		transaccion.setTipoTransaccion(tipoTransaccion);
		transaccion.setUsuario(usuario);
		transaccion.setValor(new BigDecimal(1500000));
		
		transaccionDao.create(transaccion);
		
	}
	
	/*@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void atestTipo() {
		
		assertNotNull("El ITransaccionDao es nulo",transaccionDao);
		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);
		assertNotNull("El ICuentaDAO  es nulo",cuentaDao);
		assertNotNull("El IUsuarioDAO es nulo",usuarioDao);
		

		TipoTransaccion tipoTransaccion  = tipoTransaccionDao.find(4L);
		assertNull("El transaccion ya existe",tipoTransaccion);
		
		
		
		tipoTransaccion = new TipoTransaccion();		
		tipoTransaccion.setActivo('S');
		tipoTransaccion.setNombre("Dolares");
		
		tipoTransaccionDao.create(tipoTransaccion);
		
	}
	*/
	@Test	
	@Transactional(readOnly = true)
	public void btest() {

		assertNotNull("El ITransaccionDao es nulo",transaccionDao);

		Transaccion transaccion = transaccionDao.find(tranId);

		assertNotNull("El trasaccion no existe", transaccion);

		log.info(transaccion.toString());
		

	}
	
	/*@Test	
	@Transactional(readOnly = true)
	public void btestTipo() {

		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);

		TipoTransaccion tipoTransaccion  = tipoTransaccionDao.find(4L);	
		

		assertNotNull("El trasaccion no existe", tipoTransaccion);

		log.info(tipoTransaccion.toString());
		

	}*/
	
	@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void ctest() {

		assertNotNull("El ITransaccionDao es nulo",transaccionDao);
		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);
		
		Transaccion transaccion = transaccionDao.find(tranId);

		assertNotNull("El trasaccion no existe", transaccion);

		transaccion.setTipoTransaccion(tipoTransaccionDao.find(3L));

		transaccionDao.update(transaccion);

	}
	
	/*@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void ctestTipo() {

		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);

		TipoTransaccion tipoTransaccion  = tipoTransaccionDao.find(4L);	
		

		assertNotNull("El tipo transacion no existe", tipoTransaccion);

		log.info(tipoTransaccion.toString());

		tipoTransaccion.setNombre("Euros");;

		tipoTransaccionDao.update(tipoTransaccion);

	}*/
	
	@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void dtest() {

		assertNotNull("El ITransaccionDao es nulo",transaccionDao);
		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);
		
		Transaccion transaccion = transaccionDao.find(tranId);

		assertNotNull("El trasaccion no existe", transaccion);

		transaccionDao.delete(transaccion);

	}
	
	/*@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void dtestTipo() {

		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);

		TipoTransaccion tipoTransaccion  = tipoTransaccionDao.find(4L);	
		

		assertNotNull("El trasaccion no existe", tipoTransaccion);
		

		tipoTransaccionDao.delete(tipoTransaccion);

	}
	*/
	@Test	
	@Transactional(readOnly = true)
	public void etest() {

		assertNotNull("El ITransaccionDao es nulo",transaccionDao);
		assertNotNull("El ITipoTransaccionDao es nulo",tipoTransaccionDao);

		List<Transaccion> listTrasacciones = transaccionDao.findAllCuenta("6339-3469-8951-3600");

		assertNotNull("no hay usuarios",listTrasacciones);

		for (Transaccion transaccion : listTrasacciones) {
			log.info(transaccion.toString());
		}
		

	}

}
