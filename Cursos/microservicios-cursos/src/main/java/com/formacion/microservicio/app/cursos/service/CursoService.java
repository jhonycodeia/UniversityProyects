package com.formacion.microservicio.app.cursos.service;


import com.formacion.microservicio.app.cursos.model.entity.Curso;
import com.formacion.microservicio.commons.service.CommonService;

public interface CursoService extends CommonService<Curso> {

	public Curso findCursoByAlumnoId(Long id);
	
	public Iterable<Long> obtenerExamenesIdPorAlumno(Long alumnoId);
}
