package com.formacion.microservicio.app.cursos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.microservicio.app.cursos.clients.RespuestaFeignCliente;
import com.formacion.microservicio.app.cursos.model.entity.Curso;
import com.formacion.microservicio.app.cursos.model.repository.CursoRespository;
import com.formacion.microservicio.commons.service.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso,CursoRespository> implements CursoService {

	@Autowired
	private RespuestaFeignCliente cliente;
	
	@Override
	@Transactional(readOnly = true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesIdPorAlumno(Long alumnoId) {
		return cliente.obtenerExamenesIdPorAlumno(alumnoId);
	}

}
