package com.formacion.microservicio.app.examenes.service;

import java.util.List;

import com.formacion.microservicio.commons.model.entity.Asignatura;
import com.formacion.microservicio.commons.model.entity.Examen;
import com.formacion.microservicio.commons.service.CommonService;

public interface ExamenService extends CommonService<Examen> {

	public List<Examen> findByNombre(String term);
	
	public List<Asignatura> findAllAsignaturas();
}
