package com.saberpro.utilities;


import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)

public class TestUtilities {

	private final static Logger log = LoggerFactory.getLogger(TestUtilities.class);

	@Autowired
	private Email email;
	
	@Autowired
	private Archivo archivo;

	@Test
	public void testaEmailSend(){
		
		List<Documento> list = new ArrayList<>();
		list.add(new Documento("monodevelop.jpg","/home/jhony/Imágenes/icon/monodevelop.jpg"));
		list.add(new Documento("monodevelop.jpg","/home/jhony/Imágenes/icon/monodevelop.jpg"));
		
		try {
			//email.sendSimpleMessage("jhonypk18@gmail.com", "prueba", "prueba");
			//email.sendSimpleHtml("jhonypk18@gmail.com", "prueba", "<h1>prueba</h1>");
			//email.sendMessageWithAttachmentHtml("jhonypk18@gmail.com", "prueba", "<h1>prueba</h1>",list);
			//email.sendMessageWithAttachment("jhonypk18@gmail.com", "prueba", "<h1>prueba</h1>",list);
			
		} catch (Exception e) {
			log.info(e.getMessage());
		}		

	}
	
	@Test
	public void testbArchivoCopiar(){
		
		try {
			//archivo.copyUrl("https://www.comunidadxbox.com/wp-content/imagenes/Tokyo_Ghoul.jpg","/home/jhony/Imágenes/prueba5.jpg");
			//archivo.move("/home/jhony/Imágenes/Tokyo_Ghoul.jpg","/home/jhony/Imágenes/prueba2.jpg");
			//archivo.delete("/home/jhony/Imágenes/prueba2.jpg");
			//log.info("El archivo es "+archivo.verifyDirectory("/home/jhony/Imágenes"));
			//log.info("El archivo es "+archivo.verifyFile("/home/jhony/Imágenes/prueba.jpg"));
			//log.info("el archivo "+archivo.verifyUrl("https://www.comunidadxbox.com/wp-content/imagenes/Tokyo_Ghoul.jpg"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
