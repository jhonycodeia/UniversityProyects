package com.formacion.microservicio.app.cursos.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacion.microservicio.app.cursos.model.entity.Curso;

public interface CursoRespository extends PagingAndSortingRepository<Curso,Long>{

	@Query("select c from Curso c join fetch c.alumnos a where a.id=?1")
	public Curso findCursoByAlumnoId(Long id);
}
