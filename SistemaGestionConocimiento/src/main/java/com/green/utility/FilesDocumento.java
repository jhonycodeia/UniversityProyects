package com.green.utility;

import java.io.InputStream;

public class FilesDocumento {
	
	private long id;
	private String name;
	private InputStream inputStream;
	private String contentType;

	public FilesDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public FilesDocumento(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public FilesDocumento(String name) {
		super();
		this.name = name;
	}

	public FilesDocumento(String name, InputStream inputStream, String contentType) {
		super();
		this.name = name;
		this.inputStream = inputStream;
		this.contentType = contentType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}
	
	

}
