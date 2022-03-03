package br.com.matheus.escola.api.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheus.escola.api.models.Professor;
import br.com.matheus.escola.api.services.ProfessorService;

/* http://localhost:8080/escola-api/h2/
 *
 */

@RestController
@RequestMapping(path = "/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public List<Professor> listar() {
		List<Professor> professores = service.listar();
		return professores;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Professor> encontrar(@PathVariable Long id) {
		Professor professor = service.encontrar(id);
		
		if (professor == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(professor);
	}
	
	@PostMapping
	public Professor criar(@RequestBody @Valid Professor professor) {
		Professor novoProfessor = service.criar(professor);
		return novoProfessor;
	}
	
	@PutMapping(path = "/{professorId}")
	public ResponseEntity<Professor> atualizar(@PathVariable("professorId") Long id,
			@RequestBody @Valid Professor professor) {
		
		Professor professorAtualizado = service.atualizar(id, professor);
		
		if (professorAtualizado == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(professorAtualizado);
	}
	
	@DeleteMapping(path = "/{professorId}")
	public ResponseEntity<Void> deletar(@PathVariable("professorId") Long id) {
		
		boolean deleted = service.deletarPorId(id);
		
		if (!deleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}/formacoes/{formacaoId}")
	public ResponseEntity<String> deletarFormacao(@PathVariable Long id, 
			@PathVariable("formacaoId") Long formacaoId) {
		
		boolean deleted = service.deletarFormacao(id, formacaoId);
		
		if (!deleted) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Nenhum dado foi encontrado para os parâmetros informados.");
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = "/buscar")
	public ResponseEntity<List<Professor>> buscar(
			@RequestParam("nome") Optional<String> nome,
			@RequestParam("dataNascimento") @DateTimeFormat(iso = ISO.DATE) Optional<LocalDate> dataNascimento,
			@RequestParam("cep") Optional<String> cep) {
		
		List<Professor> professores = service.buscar(nome, dataNascimento, cep);
		return ResponseEntity.ok(professores);
	}
}
