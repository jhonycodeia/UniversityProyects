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
import com.saberpro.dataaccess.dao.IEstadoPruebaDAO;
import com.saberpro.dataaccess.dao.IProgramaUsuarioDAO;
import com.saberpro.dataaccess.dao.IPruebaDAO;
import com.saberpro.dataaccess.dao.IPruebaProgramaUsuarioDAO;
import com.saberpro.modelo.PruebaProgramaUsuario;
import com.saberpro.modelo.dto.ResultadosModuloDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestPruebaProgramaUsuarioDao {

	private final static Logger log = LoggerFactory.getLogger(TestPruebaProgramaUsuarioDao.class);
	private static long pruProUsuId = 3L;

	@Autowired
	IPruebaDAO pruebaDao;
	
	@Autowired
	IEstadoPruebaDAO estadoPruebaDao;
	
	@Autowired
	IProgramaUsuarioDAO programaUsuarioDao;
	
	@Autowired
	IPruebaProgramaUsuarioDAO pruebaProgramaUsuarioDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El estadoPruebaDao; es null",estadoPruebaDao);
		assertNotNull("El programaUsuarioDao es null",programaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);

		PruebaProgramaUsuario pruebaProgramaUsuario = pruebaProgramaUsuarioDao.findById(pruProUsuId);

		assertNull("pruebaProgramaUsuario ya existe",pruebaProgramaUsuario);
		
		pruebaProgramaUsuario = new PruebaProgramaUsuario();
		pruebaProgramaUsuario.setActivo("S");
		pruebaProgramaUsuario.setEstadoPrueba(estadoPruebaDao.findById(1L));
		pruebaProgramaUsuario.setFechaCreacion(new Date());
		pruebaProgramaUsuario.setProgramaUsuario(programaUsuarioDao.findById(2L));
		pruebaProgramaUsuario.setPrueba(pruebaDao.findById(1L));
		pruebaProgramaUsuario.setUsuCreador(0L);
			
		pruebaProgramaUsuarioDao.save(pruebaProgramaUsuario);
		pruProUsuId = pruebaProgramaUsuario.getIdPruebaProgramaUsuario();

		log.info("Se creo la pruebaProgramaUsuario " + pruebaProgramaUsuario.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El estadoPruebaDao; es null",estadoPruebaDao);
		assertNotNull("El programaUsuarioDao es null",programaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);

		PruebaProgramaUsuario pruebaProgramaUsuario = pruebaProgramaUsuarioDao.findById(pruProUsuId);

		assertNotNull("pruebaProgramaUsuario no ya existe",pruebaProgramaUsuario);

		pruebaProgramaUsuario.setProgramaUsuario(programaUsuarioDao.findById(3L));

		pruebaProgramaUsuarioDao.update(pruebaProgramaUsuario);

		log.info("Se actualizo la pruebaProgramaUsuario " + pruebaProgramaUsuario.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El estadoPruebaDao; es null",estadoPruebaDao);
		assertNotNull("El programaUsuarioDao es null",programaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);

		PruebaProgramaUsuario pruebaProgramaUsuario = pruebaProgramaUsuarioDao.findById(pruProUsuId);

		assertNotNull("pruebaProgramaUsuario no ya existe",pruebaProgramaUsuario);

		pruebaProgramaUsuarioDao.deleteById(pruProUsuId);
		// pruebaProgramaUsuarioDao.delete(pruebaProgramaUsuario);

		log.info("Se borro la pruebaProgramaUsuario " + pruebaProgramaUsuario.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El pruebaDao es null",pruebaDao);
		assertNotNull("El estadoPruebaDao; es null",estadoPruebaDao);
		assertNotNull("El programaUsuarioDao es null",programaUsuarioDao);
		assertNotNull("El pruebaProgramaUsuarioDao es null",pruebaProgramaUsuarioDao);

		List<ResultadosModuloDTO> list = pruebaProgramaUsuarioDao.findResultado(5L,5L);

		for (ResultadosModuloDTO pruebaProgramaUsuario : list) {
			log.info(pruebaProgramaUsuario.toString());
		}

	}

}
