package com.formacion.microservicio.app.respuestas.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.formacion.microservicio.commons.model.entity.Alumno;
import com.formacion.microservicio.commons.model.entity.Pregunta;

import lombok.Data;

@Entity
@Table(name = "respuestas")
@Data
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String texto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Alumno alumno;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Pregunta pregunta;
}
