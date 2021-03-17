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

import com.saberpro.dao.TestOpcionDao;
import com.saberpro.modelo.control.IGrupoOpcionLogic;
import com.saberpro.modelo.dto.GrupoOpcionDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestGrupoOpcionLogic {
	
	private final static Logger log = LoggerFactory.getLogger(TestGrupoOpcionLogic.class);
	
	@Autowired
	IGrupoOpcionLogic grupoOpcionLogic;
	
	@Test
	public void test() {
		
		try {
			List<GrupoOpcionDTO> list = grupoOpcionLogic.findByDataTipoUsuario(5L,"S");
			log.info("trajo "+list.size());
		} catch (Exception e) {
			log.info("Error de "+e.getMessage());
		}
	}

}
