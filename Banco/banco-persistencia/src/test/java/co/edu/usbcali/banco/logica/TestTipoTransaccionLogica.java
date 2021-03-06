package co.edu.usbcali.banco.logica;

import static org.junit.Assert.*;

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

import co.edu.usbcali.banco.dao.ITipoTransaccionDAO;
import co.edu.usbcali.banco.modelo.TipoTransaccion;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTipoTransaccionLogica {

	private final static Logger log=LoggerFactory.getLogger(TestTipoTransaccionLogica.class);
	private static long tipoId= 4L;	
	
	@Autowired
	private ITipoTransaccionLogica tipoTransaccionLogica;
	


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {		
		
		assertNotNull("El tipoTransaccionLogica es nulo",tipoTransaccionLogica);
		
		
		TipoTransaccion tipoTransaccion = tipoTransaccionLogica.find(tipoId);
		
		assertNull("El tipoTransaccion ya existe",tipoTransaccion);
		
		tipoTransaccion=new TipoTransaccion();		
		tipoTransaccion.setActivo('S');
		tipoTransaccion.setNombre("dolares");
			
		
		tipoTransaccionLogica.create(tipoTransaccion);
		tipoId = tipoTransaccion.getTitrId();
		
		
		
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		
		assertNotNull("El tipoTransaccionLogica es nulo",tipoTransaccionLogica);

		TipoTransaccion tipoTransaccion = tipoTransaccionLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoTransaccion);
		
		log.info(tipoTransaccion.toString());
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		
		assertNotNull("El tipoTransaccionLogica es nulo",tipoTransaccionLogica);

		TipoTransaccion tipoTransaccion = tipoTransaccionLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoTransaccion);
		
		tipoTransaccion.setNombre("Euros");
		
		tipoTransaccionLogica.update(tipoTransaccion);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest()throws Exception {
		
		assertNotNull("El tipoTransaccionLogica es nulo",tipoTransaccionLogica);

		TipoTransaccion tipoTransaccion = tipoTransaccionLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoTransaccion);
		
		tipoTransaccion.setNombre("Targeta de identidad");
		
		tipoTransaccionLogica.delete(tipoTransaccion);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void etest()throws Exception {
		
		
		assertNotNull("El tipoTransaccionLogica es nulo",tipoTransaccionLogica);
		
		List<TipoTransaccion> losTransacciones = tipoTransaccionLogica.findAll();
		for (TipoTransaccion tipoTransaccion : losTransacciones) {
			log.info(tipoTransaccion.toString());
			
		}
	}

}
