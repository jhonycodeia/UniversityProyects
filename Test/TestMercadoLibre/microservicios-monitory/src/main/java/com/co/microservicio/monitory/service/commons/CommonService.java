package com.co.microservicio.monitory.service.commons;

import java.util.Optional;

public interface CommonService<E> {

	public Iterable<E> findAll();
	
	public Optional<E> findById(String id);
	
	public E save(E entity);
	
	public void delete(String id);
}
