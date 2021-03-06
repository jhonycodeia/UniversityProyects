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
import co.edu.usbcali.banco.modelo.TipoDocumento;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestUsuarioLogica {

	private final static Logger log=LoggerFactory.getLogger(TestUsuarioLogica.class);
	private final static String usuaId = "jhonycode";
	
	@Autowired
	private IUsuarioLogica usuarioLogica;
	
	@Autowired
	private ITipoUsuarioLogica tipoUsuarioLogica;


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {
		
		assertNotNull("El usuarioLogica es nulo", usuarioLogica);
		assertNotNull("El tipoUsuarioLogica es nulo",tipoUsuarioLogica);
		
		
		Usuario usuario = usuarioLogica.find(usuaId);
		
		assertNull("El usuario ya existe",usuario);
		
		usuario = new Usuario();
		usuario.setActivo('S');
		usuario.setUsuUsuario(usuaId);
		usuario.setClave("12345");
		usuario.setIdentificacion(new BigDecimal(1145248));
		usuario.setNombre("Jhony Sarria");
		
		TipoUsuario tipoUsuario=tipoUsuarioLogica.find(1L);
		assertNotNull("El tipoUsuario no existe", tipoUsuario);
		usuario.setTipoUsuario(tipoUsuario);

		usuarioLogica.create(usuario);
		
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		assertNotNull("El usuarioLogica es nulo", usuarioLogica);
		assertNotNull("El tipoUsuarioLogica es nulo",tipoUsuarioLogica);

		Usuario usuario = usuarioLogica.find(usuaId);
		assertNotNull("El cliente no existe",usuario);
		
		log.info(usuario.toString());
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		assertNotNull("El usuarioLogica es nulo", usuarioLogica);
		assertNotNull("El tipoUsuarioLogica es nulo",tipoUsuarioLogica);
		
		Usuario usuario = usuarioLogica.find(usuaId);
		assertNotNull("El cliente no existe",usuario);
		
		usuario.setClave("gjose153584");
		
		usuarioLogica.update(usuario);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=true)
	public void dtest()throws Exception {
		assertNotNull("El usuarioLogica es nulo", usuarioLogica);
		assertNotNull("El tipoUsuarioLogica es nulo",tipoUsuarioLogica);
		
		Usuario usuario = usuarioLogica.find(usuaId);
		assertNotNull("El cliente no existe",usuario);
		
		usuarioLogica.delete(usuario);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=true)
	public void etest()throws Exception {
		assertNotNull("El usuarioLogica es nulo", usuarioLogica);
		assertNotNull("El tipoUsuarioLogica es nulo",tipoUsuarioLogica);
		
		List<Usuario> losUsuarios = usuarioLogica.findAll();
		for (Usuario usuario : losUsuarios) {
			log.info(usuario.toString());
			
		}
	}
	
	@Test
	@Transactional(readOnly=true)
	public void ftest()throws Exception {
		assertNotNull("El usuarioLogica es nulo", usuarioLogica);
		assertNotNull("El tipoUsuarioLogica es nulo",tipoUsuarioLogica);
		
		String id = "kdaubney1";
		String pass = "ux9zOncZQWN";
		
		Usuario usuario = usuarioLogica.login(id, pass);
		
	    if(usuario!=null) {
	    	log.info("inicio session");
	    }
	    else {
	    	log.info("error");
	    }
		
		
		
	}
}
