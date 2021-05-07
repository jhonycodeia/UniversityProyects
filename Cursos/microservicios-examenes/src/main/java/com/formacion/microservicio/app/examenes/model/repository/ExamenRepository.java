package com.formacion.microservicio.app.examenes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacion.microservicio.commons.model.entity.Examen;

public interface ExamenRepository extends PagingAndSortingRepository<Examen, Long> {

	@Query("select e from Examen e where e.nombre like %?1%")
	public List<Examen> findByNombre(String term);
}
