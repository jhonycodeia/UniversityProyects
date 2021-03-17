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
import com.saberpro.dataaccess.dao.IMatriculaDAO;
import com.saberpro.dataaccess.dao.IPruebaRealDAO;
import com.saberpro.dataaccess.dao.IUsuarioDAO;
import com.saberpro.modelo.Matricula;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestMatriculaDao {

	private final static Logger log = LoggerFactory.getLogger(TestMatriculaDao.class);
	private static long matId = 3L;

	@Autowired
	IPruebaRealDAO pruebaRealDao;
	
	@Autowired
	IUsuarioDAO usuarioDao;
	
	@Autowired
	IMatriculaDAO matriculaDao;
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {

		assertNotNull("El pruebaRealDao es null",pruebaRealDao);	
		assertNotNull("El usuarioDao es null",usuarioDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);	

		Matricula matricula = matriculaDao.findById(matId);

		assertNull("matricula ya existe",matricula);
		
		matricula = new Matricula();
		matricula.setActivo("S");
		matricula.setFechaCreacion(new Date());
		matricula.setPruebaReal(pruebaRealDao.findById(1L));
		matricula.setUsuario(usuarioDao.findById(1L));
		matricula.setUsuCreador(0L);
		
		matriculaDao.save(matricula);
		matId = matricula.getIdMatricula();

		log.info("Se creo la matricula " + matricula.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {

		assertNotNull("El pruebaRealDao es null",pruebaRealDao);	
		assertNotNull("El usuarioDao es null",usuarioDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);	

		Matricula matricula = matriculaDao.findById(matId);

		assertNotNull("matricula no ya existe",matricula);

		matricula.setActivo("N");

		matriculaDao.update(matricula);

		log.info("Se creo la matricula " + matricula.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El pruebaRealDao es null",pruebaRealDao);	
		assertNotNull("El usuarioDao es null",usuarioDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);	

		Matricula matricula = matriculaDao.findById(matId);

		assertNotNull("matricula no ya existe",matricula);		

		matriculaDao.deleteById(matId);
		

		log.info("Se creo la matricula " + matricula.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El pruebaRealDao es null",pruebaRealDao);	
		assertNotNull("El usuarioDao es null",usuarioDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);	

		List<Matricula> list = matriculaDao.findAll();

		for (Matricula matricula : list) {
			log.info(matricula.toString());
		}

	}

}
