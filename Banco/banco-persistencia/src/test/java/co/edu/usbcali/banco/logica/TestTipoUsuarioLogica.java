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

import co.edu.usbcali.banco.modelo.TipoUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTipoUsuarioLogica {

	private final static Logger log=LoggerFactory.getLogger(TestTipoUsuarioLogica.class);
	private  static long tipoId= 5L;	
	
	@Autowired
	private ITipoUsuarioLogica tipoUsuarioLogica;


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {		
		
		assertNotNull("El tipoUsuarioLogica es nulo",tipoUsuarioLogica);
		
		
		TipoUsuario tipoUsuario = tipoUsuarioLogica.find(tipoId);
		
		assertNull("El tipoUsuario ya existe",tipoUsuario);
		
		tipoUsuario=new TipoUsuario();		
		tipoUsuario.setActivo('S');
		tipoUsuario.setNombre("Banquero");			

		tipoUsuarioLogica.create(tipoUsuario);
		tipoId = tipoUsuario.getTiusId();
		
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		
		assertNotNull("El tipoUsuarioLogica es nulo", tipoUsuarioLogica);

		TipoUsuario tipoUsuario = tipoUsuarioLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoUsuario);
		
		log.info(tipoUsuario.toString());
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		
		assertNotNull("El tipoUsuarioLogica es nulo", tipoUsuarioLogica);

		TipoUsuario tipoUsuario = tipoUsuarioLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoUsuario);
		
		tipoUsuario.setNombre("Aseador");
		
		tipoUsuarioLogica.update(tipoUsuario);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest()throws Exception {
		
		assertNotNull("El tipoUsuarioLogica es nulo", tipoUsuarioLogica);

		TipoUsuario tipoUsuario = tipoUsuarioLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoUsuario);
		
		tipoUsuario.setNombre("Targeta de identidad");
		
		tipoUsuarioLogica.delete(tipoUsuario);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void etest()throws Exception {
		
		
		assertNotNull("El tipoUsuarioLogica es nulo", tipoUsuarioLogica);
		
		List<TipoUsuario> losUsuarios = tipoUsuarioLogica.findAll();
		for (TipoUsuario tipoUsuario : losUsuarios) {
			log.info(tipoUsuario.toString());
			
		}
	}

}
