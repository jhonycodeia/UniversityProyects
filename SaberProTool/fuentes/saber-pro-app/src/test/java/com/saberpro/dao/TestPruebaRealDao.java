package com.saberpro.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
import com.saberpro.dataaccess.dao.IPruebaRealDAO;
import com.saberpro.modelo.PruebaReal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestPruebaRealDao {

	private final static Logger log = LoggerFactory.getLogger(TestPruebaRealDao.class);
	private static long prueRealId = 2L;

	@Autowired
	IPruebaRealDAO pruebaRealDao;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException, ParseException {

		assertNotNull("El pruebaRealDao es null", pruebaRealDao);

		PruebaReal pruebaReal = pruebaRealDao.findById(prueRealId);

		assertNull("pruebaReal ya existe", pruebaReal);

		DateFormat iso8601 = new SimpleDateFormat("yyyy-MM-dd");

		iso8601.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = iso8601.parse("2018-10-15");

		pruebaReal = new PruebaReal();
		pruebaReal.setActivo("S");
		pruebaReal.setFecha(date);
		pruebaReal.setFechaCreacion(new Date());
		pruebaReal.setUsuCreador(0L);

		pruebaRealDao.save(pruebaReal);
		prueRealId = pruebaReal.getIdPruebaReal();

		log.info("Se creo la pruebaReal " + pruebaReal.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException, ParseException {

		assertNotNull("El pruebaRealDao es null", pruebaRealDao);

		PruebaReal pruebaReal = pruebaRealDao.findById(prueRealId);

		assertNotNull("pruebaReal no ya existe", pruebaReal);

		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("2018-7-28");
		
		pruebaReal.setFecha(date);

		pruebaRealDao.update(pruebaReal);

		log.info("Se actualizo la  pruebaReal " + pruebaReal.toString());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {

		assertNotNull("El pruebaRealDao es null", pruebaRealDao);

		PruebaReal pruebaReal = pruebaRealDao.findById(prueRealId);

		assertNotNull("pruebaReal no ya existe", pruebaReal);

		pruebaRealDao.deleteById(prueRealId);
		// pruebaRealRealDao.delete(pruebaReal);

		log.info("Se borro la pruebaReal " + pruebaReal.toString());

	}

	@Test
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El pruebaRealDao es null", pruebaRealDao);

		List<PruebaReal> list = pruebaRealDao.findAll();

		for (PruebaReal pruebaReal : list) {
			log.info(pruebaReal.toString());
		}

	}

}
