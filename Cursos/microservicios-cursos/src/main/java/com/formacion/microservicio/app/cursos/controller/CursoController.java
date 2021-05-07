package com.formacion.microservicio.app.cursos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.microservicio.app.cursos.model.entity.Curso;
import com.formacion.microservicio.app.cursos.service.CursoService;
import com.formacion.microservicio.commons.controller.CommonController;
import com.formacion.microservicio.commons.model.entity.Alumno;
import com.formacion.microservicio.commons.model.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

	@Value("${config.balanceador.test}")
	private String balanceador;
	
	@GetMapping("/balancedor-test")
	public ResponseEntity<?> listarTodos() {
		Map<String,Object> response = new HashMap<>();
		
		response.put("balanceador", balanceador);
		response.put("cursos", service.findAll());
		
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso,BindingResult result, @PathVariable Long id) {
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Curso> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Curso dbCurso = o.get();

		dbCurso.setNombre(curso.getNombre());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbCurso));
	}

	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
		Optional<Curso> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso dbCurso = o.get();

		alumnos.forEach(a -> dbCurso.addAlumno(a));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbCurso));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		Optional<Curso> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso dbCurso = o.get();

		dbCurso.removeAlumno(alumno);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbCurso));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarAlumnoId(@PathVariable Long id) {
		Curso curso = service.findCursoByAlumnoId(id);
		
		if(curso!=null) {
			List<Long> examensId = (List<Long>) service.obtenerExamenesIdPorAlumno(id);
			
			List<Examen> examenes = curso.getExamenes().stream().map(examen ->{
				if(examensId.contains(examen.getId())) {
					examen.setRespondido(true);
				}
				return examen;
			}).collect(Collectors.toList());
			
			curso.setExamenes(examenes);
		}
		
		return ResponseEntity.ok(curso);
	}
	
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id) {
		Optional<Curso> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso dbCurso = o.get();

		examenes.forEach(a -> dbCurso.addExamen(a));

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbCurso));
	}
	
	@PutMapping("/{id}/eliminar-examen")
	public ResponseEntity<?> eliminarExamen(@RequestBody Examen examen, @PathVariable Long id) {
		Optional<Curso> o = service.findById(id);

		if (!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Curso dbCurso = o.get();

		dbCurso.removeExamen(examen);

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbCurso));
	}

	
	
	
}
