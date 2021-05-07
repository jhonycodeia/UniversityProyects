package com.formacion.microservicio.app.usuarios.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.microservicio.app.usuarios.model.repository.AlumnoRepository;
import com.formacion.microservicio.commons.model.entity.Alumno;
import com.formacion.microservicio.commons.service.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno,AlumnoRepository> implements AlumnoService {

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

}
