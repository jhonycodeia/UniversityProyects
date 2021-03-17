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
import com.saberpro.dataaccess.dao.IProgramaDAO;
import com.saberpro.dataaccess.dao.IProgramaUsuarioDAO;
import com.saberpro.dataaccess.dao.IUsuarioDAO;
import com.saberpro.modelo.ProgramaUsuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestProgramaUsuarioDao {

	private final static Logger log = LoggerFactory.getLogger(TestProgramaUsuarioDao.class);
	private static long proUsuId = 10L;

	@Autowired
	IProgramaUsuarioDAO programaUsuarioDao;
	
	@Autowired
	IProgramaDAO programaDao;
	
	@Autowired
	IUsuarioDAO usuarioDao;	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {

		assertNotNull("El programaUsuarioDao; es null",programaUsuarioDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		

		ProgramaUsuario programaUsuario = programaUsuarioDao.findById(proUsuId);

		assertNull("programaUsuario ya existe",programaUsuario);
		
		programaUsuario = new ProgramaUsuario();
		programaUsuario.setActivo("S");
		programaUsuario.setFechaCreacion(new Date());
		programaUsuario.setPrograma(programaDao.findById(2L));
		programaUsuario.setUsuario(usuarioDao.findById(1L));
		programaUsuario.setUsuCreador(0L);			
			
		programaUsuarioDao.save(programaUsuario);
		proUsuId = programaUsuario.getIdProgramaUsuario();

		log.info("Se creo la programaUsuario " + programaUsuario.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {

		assertNotNull("El programaUsuarioDao; es null",programaUsuarioDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		

		ProgramaUsuario programaUsuario = programaUsuarioDao.findById(proUsuId);

		assertNotNull("programaUsuario no ya existe",programaUsuario);

		programaUsuario.setPrograma(programaDao.findById(3L));

		programaUsuarioDao.update(programaUsuario);

		log.info("Se actualizo la programaUsuario " + programaUsuario.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El programaUsuarioDao; es null",programaUsuarioDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El usuarioDao es null",usuarioDao);
		

		ProgramaUsuario programaUsuario = programaUsuarioDao.findById(proUsuId);

		assertNotNull("programaUsuario no ya existe",programaUsuario);

		programaUsuarioDao.deleteById(proUsuId);
		// programaUsuarioDao.delete(programaUsuario);

		log.info("Se borro la programaUsuario " + programaUsuario.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El programaUsuarioDao; es null",programaUsuarioDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El usuarioDao es null",usuarioDao);

		List<ProgramaUsuario> list = programaUsuarioDao.findAll();

		for (ProgramaUsuario programaUsuario : list) {
			log.info(programaUsuario.toString());
		}

	}

}
