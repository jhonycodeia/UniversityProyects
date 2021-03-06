package com.saberpro.utilities;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.commons.validator.UrlValidator;
import org.springframework.stereotype.Component;

@Component
public class Archivo {

	public void copy(InputStream origen, String destino) throws Exception {
		
		Path destinoPath = FileSystems.getDefault().getPath(destino);

		try {
			Files.copy(origen, destinoPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new Exception("Error de " + e.getMessage());
		}
	}

	public void copyUrl(String origen, String destino) throws Exception {
		
		if(verifyUrl(origen)) {
			URL url = new URL(origen);
			URLConnection urlCon = url.openConnection();

			Path destinoPath = FileSystems.getDefault().getPath(destino);

			try {
				Files.copy(urlCon.getInputStream(), destinoPath, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				throw new Exception("Error de " + e.getMessage());
			}
		}
		else {
			throw new Exception("El archivo no fue encontrado");
		}
		
	}

	public void move(String origen, String destino) throws Exception {

		Path origenPath = FileSystems.getDefault().getPath(origen);
		Path destinoPath = FileSystems.getDefault().getPath(destino);

		try {
			Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			throw new Exception("Error de " + e.getMessage());
		}
	}

	public void delete(String origen) throws Exception {

		Path archivo = FileSystems.getDefault().getPath(origen);

		try {
			Files.delete(archivo);
		} catch (Exception e) {
			throw new Exception("Error de " + e.getMessage());
		}
	}

	public boolean verifyFile(String origen) throws Exception {

		Path archivo = FileSystems.getDefault().getPath(origen);

		try {
			return Files.exists(archivo);
		} catch (Exception e) {
			throw new Exception("Error de " + e.getMessage());
		}
	}

	public boolean verifyDirectory(String origen) throws Exception {

		Path archivo = FileSystems.getDefault().getPath(origen);

		try {
			return Files.isDirectory(archivo);
		} catch (Exception e) {
			throw new Exception("Error de " + e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean verifyUrl(String origen) throws Exception {

		UrlValidator defaultValidator = new UrlValidator();
		return defaultValidator.isValid(origen);

	}

	public void crearDirectory(String origen) throws Exception {

		Path archivo = FileSystems.getDefault().getPath(origen);

		try {
			if (!verifyDirectory(origen)) {
				Files.createDirectories(archivo);
			}
		} catch (Exception e) {
			throw new Exception("Error de " + e.getMessage());
		}
	}

	public File leer(String origen) throws Exception {

		try {
			if (!verifyFile(origen)) {
				throw new Exception("El archivo no se encontro");
			}

			return new File(origen);

		} catch (Exception e) {
			throw new Exception("Error de " + e.getMessage());
		}
	}

	

}
