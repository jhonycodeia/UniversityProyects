package com.co.microservicio.monitory.controller.commons;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.co.microservicio.monitory.service.commons.CommonService;



public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		Optional<E> entity = service.findById(id);
		if (entity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(entity.get());
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
	}

	@DeleteMapping("/id")
	public ResponseEntity<?> eliminar(@PathVariable String id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}

}
