package com.formacion.microservicio.commons.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "asignaturas")
@Data
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@JsonIgnoreProperties(value = {"hijos"},allowSetters = true)
	@ManyToOne(fetch = FetchType.LAZY)
	private Asignatura padre;
	
	@JsonIgnoreProperties(value = {"padre"},allowSetters = true)
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "padre",cascade = CascadeType.ALL)
	private List<Asignatura> hijos;
	
	public Asignatura() {
		this.hijos = new ArrayList<>();
	}
}
