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
import com.saberpro.dataaccess.dao.IModuloDAO;
import com.saberpro.dataaccess.dao.IProgramaDAO;
import com.saberpro.dataaccess.dao.IProgramaModuloDAO;
import com.saberpro.modelo.ProgramaModulo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestProgramaModuloDao {

	private final static Logger log = LoggerFactory.getLogger(TestProgramaModuloDao.class);
	private static long proModId = 5L;

	@Autowired
	IProgramaModuloDAO programaModuloDao;
	
	@Autowired
	IProgramaDAO programaDao;
	
	@Autowired
	IModuloDAO moduloDao;	

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {

		assertNotNull("El programaModuloDao es null",programaModuloDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		

		ProgramaModulo programaModulo = programaModuloDao.findById(proModId);

		assertNull("programaUsuario ya existe",programaModulo);
		
		programaModulo = new ProgramaModulo();
		programaModulo.setActivo("S");
		programaModulo.setFechaCreacion(new Date());
		programaModulo.setModulo(moduloDao.findById(1L));
		programaModulo.setPrograma(programaDao.findById(2L));
		programaModulo.setUsuCreador(0L);
		
		programaModuloDao.save(programaModulo);
		proModId = programaModulo.getIdProgramaModulo();

		log.info("Se creo la programaModulo " + programaModulo.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {

		assertNotNull("El programaModuloDao es null",programaModuloDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		

		ProgramaModulo programaModulo = programaModuloDao.findById(proModId);

		assertNotNull("programaModulo no ya existe",programaModulo);

		programaModulo.setModulo(moduloDao.findById(5L));
		programaModulo.setPrograma(programaDao.findById(5L));;

		programaModuloDao.update(programaModulo);

		log.info("Se actualizo la programaModulo " + programaModulo.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El programaModuloDao es null",programaModuloDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		

		ProgramaModulo programaModulo = programaModuloDao.findById(proModId);

		assertNotNull("programaModulo no ya existe",programaModulo);

		programaModuloDao.deleteById(proModId);
		

		log.info("Se borro la programaModulo " + programaModulo.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El programaModuloDao es null",programaModuloDao);
		assertNotNull("El programaDao es null",programaDao);
		assertNotNull("El moduloDao es null",moduloDao);

		List<ProgramaModulo> list = programaModuloDao.findAll();

		for (ProgramaModulo programaModulo : list) {
			log.info(programaModulo.toString());
		}

	}


}
