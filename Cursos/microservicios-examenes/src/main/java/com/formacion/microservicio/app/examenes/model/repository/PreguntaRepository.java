package com.formacion.microservicio.app.examenes.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.formacion.microservicio.commons.model.entity.Pregunta;

public interface PreguntaRepository extends CrudRepository<Pregunta,Long> {

}
