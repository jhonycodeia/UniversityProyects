package com.saberpro.logic;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.saberpro.dao.TestModuloDao;
import com.saberpro.modelo.Modulo;
import com.saberpro.modelo.control.IModuloLogic;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestModuloLogic {
	
	private final static Logger log = LoggerFactory.getLogger(TestModuloLogic.class);
	
	@Autowired
	IModuloLogic moduloLogic;
	
	@Test
	public void test() {
		Object[] variable = {"tipoModulo",true,-1,"=","activo",true,"S","="};
		
		List<Modulo> list;
		try {
			list = moduloLogic.findByCriteria(variable,null,null);
			for (Modulo modulo : list) {
				log.info(modulo.toString());
			}
		} catch (Exception e) {
			log.info("error de " +e.getMessage());
		}
		
		
	}

}
