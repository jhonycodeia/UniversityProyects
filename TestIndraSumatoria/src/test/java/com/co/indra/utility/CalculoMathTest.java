package com.co.indra.utility;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CalculoMathTest {

	private static final Logger log = LoggerFactory.getLogger(CalculoMathTest.class);
	
	@Autowired
	private CalculoMath calculo;
	
	@Before
	public void before() {
		assertNotNull(calculo);
	}
	
	@Test
	public void test() {
		log.info("calculo es "+calculo.valor(1,92));
		
		
	}

}
