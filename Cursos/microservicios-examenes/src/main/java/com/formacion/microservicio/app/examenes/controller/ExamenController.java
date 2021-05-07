package com.formacion.microservicio.app.examenes.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.microservicio.app.examenes.service.ExamenService;
import com.formacion.microservicio.commons.controller.CommonController;
import com.formacion.microservicio.commons.model.entity.Examen;

@RestController
public class ExamenController extends CommonController<Examen,ExamenService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Examen examen,BindingResult result,@PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		
		Optional<Examen> o = service.findById(id);
		
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Examen dbExamen = o.get();
			
		dbExamen.setNombre(examen.getNombre());
		
		dbExamen.getPreguntas()
			.stream()
			.filter(pdb->!examen.getPreguntas().contains(pdb))
			.forEach(dbExamen::removePregunta);
		
		dbExamen.setPreguntas(examen.getPreguntas());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbExamen));
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term) {
		return ResponseEntity.ok(service.findByNombre(term));
	}
	
	@GetMapping("/asignaturas")
	public ResponseEntity<?> asignaturas() {
		return ResponseEntity.ok(service.findAllAsignaturas());
	}
}
