package co.edu.usbcali.banco.dao;

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

import co.edu.usbcali.banco.dao.ITipoUsuarioDAO;
import co.edu.usbcali.banco.dao.IUsuarioDAO;
import co.edu.usbcali.banco.modelo.TipoUsuario;
import co.edu.usbcali.banco.modelo.Usuario;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestUsuarioDAO {

	private final static Logger log = LoggerFactory.getLogger(TestUsuarioDAO.class);
	private final static String usuaId = "jhonycode";
	
	
	@Autowired
	IUsuarioDAO usuarioDao;
	@Autowired
	ITipoUsuarioDAO tipoUsuarioDao;
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void atest() {
		
		assertNotNull("El IUsuarioDAO es nulo",usuarioDao);
		assertNotNull("El ITipoUsuarioDAO es nulo",tipoUsuarioDao);
		

		Usuario usuario = usuarioDao.find(usuaId);
		assertNull("El cliente ya existe", usuario);
		
		usuario = new Usuario();
		usuario.setUsuUsuario(usuaId);
		usuario.setActivo('S');
		usuario.setClave("jsdas156225");
		usuario.setIdentificacion(new BigDecimal(145635556));
		usuario.setNombre("Jhony Sarria");
		
		TipoUsuario tipoUsuario = tipoUsuarioDao.find(3L);
		
		usuario.setTipoUsuario(tipoUsuario);
		
		usuarioDao.create(usuario);
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void btest() {

		assertNotNull("El IUsuarioDAO es nulo",usuarioDao);
		assertNotNull("El ITipoUsuarioDAO es nulo",tipoUsuarioDao);

		Usuario usuario = usuarioDao.find(usuaId);

		assertNotNull("El cliente no existe", usuario);

		log.info(usuario.toString());
		

	}
	
	@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void ctest() {

		assertNotNull("El IUsuarioDAO es nulo",usuarioDao);
		assertNotNull("El ITipoUsuarioDAO es nulo",tipoUsuarioDao);
		
		Usuario usuario = usuarioDao.find(usuaId);

		assertNotNull("El cliente no existe", usuario);

		usuario.setNombre("Carlos Santiago");

		usuarioDao.update(usuario);

	}
	
	@Test	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void dtest() {

		assertNotNull("El IUsuarioDAO es nulo",usuarioDao);
		assertNotNull("El ITipoUsuarioDAO es nulo",tipoUsuarioDao);

		Usuario usuario = usuarioDao.find(usuaId);

		assertNotNull("El cliente no existe", usuario);

		usuarioDao.delete(usuario);

	}

	@Test	
	@Transactional(readOnly = true)
	public void etest() {

		assertNotNull("El IUsuarioDAO es nulo",usuarioDao);
		assertNotNull("El ITipoUsuarioDAO es nulo",tipoUsuarioDao);

		List<Usuario> listUsuario = usuarioDao.findAll();

		assertNotNull("no hay usuarios", listUsuario);

		for (Usuario usuario : listUsuario) {
			//log.info(usuario.toString());
			//log.info(usuario.getTipoUsuario().getNombre());
		}
		

	}

}
