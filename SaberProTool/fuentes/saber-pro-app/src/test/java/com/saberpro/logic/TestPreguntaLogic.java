package com.saberpro.logic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saberpro.dao.TestEstadoPruebaDao;
import com.saberpro.modelo.control.IPreguntaLogic;
import com.saberpro.utilities.Archivo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestPreguntaLogic {

	private final static Logger log = LoggerFactory.getLogger(TestPreguntaLogic.class);
	
	@Autowired
	IPreguntaLogic preguntaLogic;
	
	@Autowired
	Archivo archivo;
	
	@Test
	public void test() {
		try {
			//preguntaLogic.importXLSXFile(archivo.leer("/home/jhony/Descargas/Prueba exportar.xlsx"),0L);
		} catch (Exception e) {
			log.info("error de "+e.getMessage());
		}
	}

}
