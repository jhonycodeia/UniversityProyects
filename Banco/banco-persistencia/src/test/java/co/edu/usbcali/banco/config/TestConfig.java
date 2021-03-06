package co.edu.usbcali.banco.config;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.usbcali.banco.dao.TestClienteDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class TestConfig {

	private final static Logger log = LoggerFactory.getLogger(TestConfig.class);
	
	@Test
	public void test() {
		
	}

}
