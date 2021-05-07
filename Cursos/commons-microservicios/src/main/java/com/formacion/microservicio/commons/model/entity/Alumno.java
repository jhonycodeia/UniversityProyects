package com.formacion.microservicio.commons.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "alumnos")
@Data
@NoArgsConstructor
@ToString
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	@Email
	private String email;

	@Lob
	@JsonIgnore
	private byte[] foto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creat_at")
	private Date creatAt;

	@PrePersist
	public void prePersist() {
		this.creatAt = new Date();
	}

	public Integer getFotoHashCode() {
		return this.foto != null ? this.foto.hashCode() : null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Alumno)) {
			return false;
		}

		Alumno a = (Alumno) obj;

		return a.getId() != null && a.getId() == this.id;
	}
}
