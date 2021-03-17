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
import com.saberpro.dataaccess.dao.IModuloDAO;
import com.saberpro.dataaccess.dao.IResultadoRealDAO;
import com.saberpro.modelo.ResultadoReal;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestResultadoRealDao {

	private final static Logger log = LoggerFactory.getLogger(TestResultadoRealDao.class);
	private static long resuRealId = 2L;
	
	@Autowired
	IResultadoRealDAO resultadoRealDao;
	
	@Autowired
	IMatriculaDAO matriculaDao;
	
	@Autowired
	IModuloDAO moduloDao;
	
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El resultadoRealDao es null",resultadoRealDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		
		
		ResultadoReal resultadoReal = resultadoRealDao.findById(resuRealId);
		
		assertNull("resultadoReal ya existe",resultadoReal);
		
		resultadoReal = new ResultadoReal();
		resultadoReal.setActivo("S");
		resultadoReal.setFechaCreacion(new Date());
		resultadoReal.setMatricula(matriculaDao.findById(2L));
		resultadoReal.setModulo(moduloDao.findById(2L));
		resultadoReal.setPercentilGrupo(80L);
		resultadoReal.setPercentilNacional(65L);
		resultadoReal.setUsuCreador(0L);
		
		resultadoRealDao.save(resultadoReal);
		resuRealId = resultadoReal.getIdResultadoReal();
		
		log.info("Se creo la resultadoReal "+resultadoReal.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El resultadoRealDao es null",resultadoRealDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		
		
		ResultadoReal resultadoReal = resultadoRealDao.findById(resuRealId);
		
		assertNotNull("resultadoReal no ya existe",resultadoReal);	
			
		resultadoReal.setPercentilNacional(78L);		
				
		resultadoRealDao.update(resultadoReal);		
		
		log.info("Se actualizo la  resultadoReal "+resultadoReal.toString());
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El resultadoRealDao es null",resultadoRealDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);
		assertNotNull("El moduloDao es null",moduloDao);
		
		
		ResultadoReal resultadoReal = resultadoRealDao.findById(resuRealId);
		
		assertNotNull("resultadoReal no ya existe",resultadoReal);				
			
				
		resultadoRealDao.deleteById(resuRealId);
		//resultadoRealDao.delete(resultadoReal);
		
		log.info("Se borro la resultadoReal "+resultadoReal.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El resultadoRealDao es null",resultadoRealDao);	
		assertNotNull("El matriculaDao es null",matriculaDao);
		assertNotNull("El moduloDao es null",moduloDao);		
		
		List<ResultadoReal> list = resultadoRealDao.findAll();
		
		for (ResultadoReal resultadoReal : list) {
			log.info(resultadoReal.toString());
		}
		

	}

}
