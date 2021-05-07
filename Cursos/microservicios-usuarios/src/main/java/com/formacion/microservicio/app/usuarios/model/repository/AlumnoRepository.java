package com.formacion.microservicio.app.usuarios.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacion.microservicio.commons.model.entity.Alumno;

public interface AlumnoRepository extends PagingAndSortingRepository<Alumno,Long>{

	@Query("Select a From Alumno a where a.nombre like %?1% or a.apellido like %?1%")
	public List<Alumno> findByNombreOrApellido(String term);
}
