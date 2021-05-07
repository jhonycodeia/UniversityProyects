package com.formacion.microservicio.app.examenes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.microservicio.app.examenes.model.repository.AsignaturaRepository;
import com.formacion.microservicio.app.examenes.model.repository.ExamenRepository;
import com.formacion.microservicio.commons.model.entity.Asignatura;
import com.formacion.microservicio.commons.model.entity.Examen;
import com.formacion.microservicio.commons.service.CommonServiceImpl;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements ExamenService {

	@Autowired
	private AsignaturaRepository asignaturaRespository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Asignatura> findAllAsignaturas() {
		return (List<Asignatura>) asignaturaRespository.findAll();
	}

}
