package com.saberpro.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TestConfig {

	private final static Logger log = LoggerFactory.getLogger(TestConfig.class);
	private final static String persistenceUnit = "saber-pro-appPU";
	
	EntityManagerFactory entityManagerFactory = null;
	EntityManager entityManager = null;
	
	@Before
	public void before() {
		log.info("Ejecuto antes");
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@After
	public void after() {
		log.info("Ejecuto despues");
		entityManager.close();
		entityManagerFactory.close();
	}
	
	
	@Test
	public void test() {
		log.info("Conectando .....");
	}

}
