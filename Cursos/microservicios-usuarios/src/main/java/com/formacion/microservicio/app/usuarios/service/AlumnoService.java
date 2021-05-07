package com.formacion.microservicio.app.usuarios.service;

import java.util.List;

import com.formacion.microservicio.commons.model.entity.Alumno;
import com.formacion.microservicio.commons.service.CommonService;

public interface AlumnoService extends CommonService<Alumno>{
	
	public List<Alumno> findByNombreOrApellido(String term);
}
