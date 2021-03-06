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
import com.saberpro.dataaccess.dao.IGrupoOpcionDAO;
import com.saberpro.dataaccess.dao.IImagenDAO;
import com.saberpro.dataaccess.dao.IPreguntaDAO;
import com.saberpro.modelo.GrupoOpcion;
import com.saberpro.modelo.Imagen;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestImagenDao {

	private final static Logger log = LoggerFactory.getLogger(TestImagenDao.class);
	private static long imgId = 3L;
	
		
	@Autowired
	IImagenDAO imagenDao;
	
	@Autowired
	IPreguntaDAO preguntaDao;
	
		
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testaCreate() throws DaoException {
		
		assertNotNull("El imagenDao es null",imagenDao);
		assertNotNull("El preguntaDao es null",preguntaDao);
		
		Imagen imagen = imagenDao.findById(imgId);
		
		assertNull("grupoOpcion ya existe",imagen);		
		
		imagen = new Imagen();
		imagen.setActivo("S");
		imagen.setDescripcion("prueba");
		imagen.setFechaCreacion(new Date());
		imagen.setNombre("ruta");
		imagen.setPregunta(preguntaDao.findById(1L));
		imagen.setRuta("tr.jpg");
		imagen.setUsuCreador(0L);
						
		imagenDao.save(imagen);
		imgId = imagen.getIdImagen();
		
		log.info("Se creo la imagen "+imagen.toString());		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testbUpdate() throws DaoException {
		
		assertNotNull("El imagenDao es null",imagenDao);
		assertNotNull("El preguntaDao es null",preguntaDao);
		
		Imagen imagen = imagenDao.findById(imgId);
		
		assertNotNull("imagen no ya existe",imagen);	
			
		imagen.setActivo("N");	
				
		imagenDao.update(imagen);		
		
		log.info("Se creo la imagen "+imagen.toString());	
		
		
	}
	
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testcDelete() throws DaoException {
		
		assertNotNull("El imagenDao es null",imagenDao);
		assertNotNull("El preguntaDao es null",preguntaDao);
		
		Imagen imagen = imagenDao.findById(imgId);
		
		assertNotNull("imagen no ya existe",imagen);							
			
				
		imagenDao.deleteById(imgId);
		
		
		log.info("Se creo la imagen "+imagen.toString());		
		
	}
	
	@Test	
	@Transactional(readOnly = true)
	public void testdConsulta() {

		assertNotNull("El imagenDao es null",imagenDao);
		assertNotNull("El preguntaDao es null",preguntaDao);	
		
		
		List<Imagen> list = imagenDao.findAll();
		
		for (Imagen imagen : list) {
			log.info(imagen.toString());
		}
		

	}

}
