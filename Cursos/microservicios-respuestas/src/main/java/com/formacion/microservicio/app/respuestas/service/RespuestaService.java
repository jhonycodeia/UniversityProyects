package com.formacion.microservicio.app.respuestas.service;

import com.formacion.microservicio.app.respuestas.model.entity.Respuesta;

public interface RespuestaService {

	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas);
	
	public Iterable<Respuesta> findRespuestaByAlumnoByExamen(Long alumnoId, Long examenId);

	public Iterable<Long> findExamenesIdsConRespuestasByAlumnos(Long alumnoId);
}
