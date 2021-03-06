package com.saberpro.dao;

import static org.junit.Assert.*;

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

import com.saberpro.dataaccess.api.DaoException;
import com.saberpro.dataaccess.dao.IPreguntaDAO;
import com.saberpro.dataaccess.dao.IPruebaProgramaUsuarioDAO;
import com.saberpro.dataaccess.dao.IPruebaProgramaUsuarioPreguntaDAO;
import com.saberpro.dataaccess.dao.IPruebaRealDAO;
import com.saberpro.modelo.PruebaProgramaUsuarioPregunta;
import com.saberpro.modelo.PruebaReal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestPruebaProgramaUsuarioPreguntaDao {

	private final static Logger log = LoggerFactory.getLogger(TestPruebaProgramaUsuarioPreguntaDao.class);
	private static long pruProUsuId = 5L;

	@Autowired
	IPreguntaDAO preguntaDao;
	
	@Autowired
	IPruebaProgramaUsuarioDAO pruebaProgramaUsuarioDao;
	
	@Autowired
	IPruebaProgramaUsuarioPreguntaDAO pruebaProgramaUsuarioPreguntaDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {

		assertNotNull("El preguntaDao es null",preguntaDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);

		PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta = pruebaProgramaUsuarioPreguntaDao.findById(pruProUsuId);

		assertNull("pruebaProgramaUsuarioPregunta ya existe", pruebaProgramaUsuarioPregunta);

		pruebaProgramaUsuarioPregunta = new PruebaProgramaUsuarioPregunta();
		pruebaProgramaUsuarioPregunta.setActivo("S");
		pruebaProgramaUsuarioPregunta.setFechaCreacion(new Date());
		pruebaProgramaUsuarioPregunta.setPregunta(preguntaDao.findById(1L));
		pruebaProgramaUsuarioPregunta.setPruebaProgramaUsuario(pruebaProgramaUsuarioDao.findById(2L));
		pruebaProgramaUsuarioPregunta.setUsuCreador(0L);		

		pruebaProgramaUsuarioPreguntaDao.save(pruebaProgramaUsuarioPregunta);
		pruProUsuId = pruebaProgramaUsuarioPregunta.getIdPruebaProgramaUsuarioPregunta();

		log.info("Se creo la pruebaProgramaUsuarioPregunta " + pruebaProgramaUsuarioPregunta.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {

		assertNotNull("El preguntaDao es null",preguntaDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);

		PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta = pruebaProgramaUsuarioPreguntaDao.findById(pruProUsuId);

		assertNotNull("pruebaProgramaUsuarioPregunta no ya existe",pruebaProgramaUsuarioPregunta);

		pruebaProgramaUsuarioPregunta.setPregunta(preguntaDao.findById(2L));

		pruebaProgramaUsuarioPreguntaDao.update(pruebaProgramaUsuarioPregunta);

		log.info("Se actualizo la pruebaProgramaUsuarioPregunta " + pruebaProgramaUsuarioPregunta.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El preguntaDao es null",preguntaDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);

		PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta = pruebaProgramaUsuarioPreguntaDao.findById(pruProUsuId);

		assertNotNull("pruebaProgramaUsuarioPregunta no ya existe",pruebaProgramaUsuarioPregunta);

		pruebaProgramaUsuarioPreguntaDao.deleteById(pruProUsuId);
		// pruebaProgramaUsuarioPreguntaDao.delete(pruebaProgramaUsuarioPregunta);

		log.info("Se borro la pruebaProgramaUsuarioPregunta " + pruebaProgramaUsuarioPregunta.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El preguntaDao es null",preguntaDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioPreguntaDao es null",pruebaProgramaUsuarioPreguntaDao);

		List<PruebaProgramaUsuarioPregunta> list = pruebaProgramaUsuarioPreguntaDao.findAll();

		for (PruebaProgramaUsuarioPregunta pruebaProgramaUsuarioPregunta : list) {
			log.info(pruebaProgramaUsuarioPregunta.toString());
		}

	}

}
