package co.edu.usbcali.banco.logica;

import static org.junit.Assert.*;

import java.math.BigDecimal;
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

import co.edu.usbcali.banco.modelo.TipoDocumento;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestTipoDocumentoLogica {

	private final static Logger log=LoggerFactory.getLogger(TestTipoDocumentoLogica.class);
	private static long tipoId= 5L;	
	
	@Autowired
	private ITipoDocumentoLogica tipoDocumentoLogica;


	@Test
	//Crear
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest()throws Exception {		
		
		assertNotNull("El tipoDocumentoLogica es nulo",tipoDocumentoLogica);
		
		
		TipoDocumento tipoDocumento=tipoDocumentoLogica.find(tipoId);
		
		assertNull("El tipoDocumento ya existe",tipoDocumento);
		
		tipoDocumento =new TipoDocumento();
		tipoDocumento.setActivo('S');
		tipoDocumento.setNombre("Cedula Extranjera");				

		tipoDocumentoLogica.create(tipoDocumento);
		tipoId = tipoDocumento.getTdocId();
		
	}
	
	@Test
	//Consultar
	@Transactional(readOnly=true)
	public void btest() {
		
		assertNotNull("El tipoDocumentoLogica es nulo", tipoDocumentoLogica);

		TipoDocumento tipoDocumento = tipoDocumentoLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoDocumento);
		
		log.info(tipoDocumento.toString());
		
	}
	
	@Test
	//Modificar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest()throws Exception {
		
		assertNotNull("El tipoDocumentoLogica es nulo", tipoDocumentoLogica);

		TipoDocumento tipoDocumento = tipoDocumentoLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoDocumento);
		
		tipoDocumento.setNombre("Targeta de identidad");
		
		tipoDocumentoLogica.update(tipoDocumento);	
	}	
		
	@Test
	//Borrar
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest()throws Exception {
		
		assertNotNull("El tipoDocumentoLogica es nulo", tipoDocumentoLogica);

		TipoDocumento tipoDocumento = tipoDocumentoLogica.find(tipoId);
		assertNotNull("El tipoDocumento no existe",tipoDocumento);
		
		tipoDocumento.setNombre("Targeta de identidad");
		
		tipoDocumentoLogica.delete(tipoDocumento);
	}
	
	@Test
	//selectall
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void etest()throws Exception {
		
		
		assertNotNull("El tipoDocumentoLogica es nulo", tipoDocumentoLogica);
		
		List<TipoDocumento> losDocumentos = tipoDocumentoLogica.findAll();
		for (TipoDocumento tipoDocumento : losDocumentos) {
			log.info(tipoDocumento.toString());
			
		}
	}
}
