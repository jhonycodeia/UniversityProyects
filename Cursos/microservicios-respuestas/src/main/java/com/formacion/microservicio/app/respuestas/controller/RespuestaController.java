package com.formacion.microservicio.app.respuestas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.microservicio.app.respuestas.model.entity.Respuesta;
import com.formacion.microservicio.app.respuestas.service.RespuestaService;

@RestController
public class RespuestaController {

	@Autowired
	private RespuestaService service;
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(respuestas));
	}
	
	@GetMapping("/alumno/{alumnoId}/examen/{examenId}")
	public ResponseEntity<?> obtenerRespuestasPorAlumnoPorExamen(@PathVariable Long alumnoId,@PathVariable Long examenId){
		return ResponseEntity.ok().body(service.findRespuestaByAlumnoByExamen(alumnoId, examenId));
	}
	
	@GetMapping("/alumno/{alumnoId}/examenes-respondidos")
	public ResponseEntity<?> obtenerExamenesIdPorAlumno(@PathVariable Long alumnoId){
		return ResponseEntity.ok().body(service.findExamenesIdsConRespuestasByAlumnos(alumnoId));
	}
}
