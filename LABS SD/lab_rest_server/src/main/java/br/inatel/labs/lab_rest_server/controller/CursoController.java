package br.inatel.labs.lab_rest_server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.inatel.labs.lab_rest_server.exception.CursoNaoEncontradoException;
import br.inatel.labs.lab_rest_server.model.Curso;
import br.inatel.labs.lab_rest_server.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@GetMapping("/listar")
	public List<Curso> listar(){
		return service.pesquisarCurso();
	}
	
	@GetMapping("/search/{id}")
	public Curso searchById(@PathVariable("id") Long cursoId) {
		Optional<Curso> curso = service.searchCourseById(cursoId);
		
		if(curso.isPresent()) {
			return curso.get();
		}
		throw new CursoNaoEncontradoException(cursoId);		
	}
	
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Curso create(@RequestBody Curso curso) {
		return service.createCourse(curso);		
	}
	
	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void atualizar(@RequestBody Curso curso) {
		service.updateCourse(curso);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable("id") Long id) {
		Optional<Curso> curso = service.searchCourseById(id);
		if(curso.isEmpty()) {
			throw new CursoNaoEncontradoException(id);
		}
		 service.delete(curso.get());
	}

}
