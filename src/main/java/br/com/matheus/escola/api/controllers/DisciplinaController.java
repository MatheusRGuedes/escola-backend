package br.com.matheus.escola.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheus.escola.api.models.Disciplina;
import br.com.matheus.escola.api.services.DisciplinaService;

/*
 * @CrossOrigin --> Habilita um recurso único pr poder ser acessado por outras origens (no caso o angular)
 * 			    --> https://andreybleme.com/2016-11-27/cors-spring/
 * */

@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
	
	@GetMapping
	public List<Disciplina> listar() {
		
		List<Disciplina> disciplinas = service.listar();
		
		return disciplinas;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Disciplina> encontrar(@PathVariable Long id) {
		
		Disciplina discEncontrada = service.encontrarPorId(id);
		
		if (discEncontrada != null) {
			return ResponseEntity.ok(discEncontrada);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Disciplina> criar(@Valid @RequestBody Disciplina disciplina) {
		
		Disciplina novaDisciplina = service.criar(disciplina);
		
		if (novaDisciplina.getId() != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(novaDisciplina);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping(path = "/{disciplinaId}")
	public ResponseEntity<Disciplina> atualizar(@PathVariable("disciplinaId") Long id, 
			@Valid @RequestBody Disciplina disciplina) {
		
		Disciplina discAtualizada = service.atualizar(id, disciplina);
		
		if (discAtualizada != null) {
			return ResponseEntity.ok(discAtualizada);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		boolean deletado = service.deletarPorId(id);
		
		if (deletado) {
			
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/buscar")
	public List<Disciplina> buscar(
			@RequestParam(name = "codigo", required = false) String codigo, 
			@RequestParam(name = "nome", required = false) String nome,
			@RequestParam(name = "sort") Optional<String> sort) {
		
		List<Disciplina> disciplinas = service.buscar(codigo, nome, sort);
		
		return disciplinas;
	}
}