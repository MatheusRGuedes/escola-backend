package br.com.matheus.escola.api.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheus.escola.api.models.Disciplina;
import br.com.matheus.escola.api.repositories.DisciplinaRepository;

/*
 * Classe facilitadora do Model e regras de negócio da disciplina;
 * */

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repository;
	
	@Autowired
	private EntityManager entityManager;
	
	
	public List<Disciplina> listar() {	

		return repository.findAll();
	}
	
	public Disciplina encontrarPorId(Long id) {
		
		Optional<Disciplina> discEncontrada = repository.findById(id);
		
		return discEncontrada.orElse(null);
	}
	
	public Disciplina criar(Disciplina disciplina) {
		
		return repository.save(disciplina);
	}
	
	public Disciplina atualizar(Long id, Disciplina disciplina) {
		
		if (repository.existsById(id)) {
			
			disciplina.setId(id);
			return repository.save(disciplina);
		}
		
		return null;
	}
	
	public boolean deletarPorId(Long id) {
		
		Disciplina discEncontrada = encontrarPorId(id);
		
		if (discEncontrada != null) {
			repository.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	public List<Disciplina> buscar(String codigo, String nome, Optional<String> sort) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select a from Disciplina a where 1 = 1");
		
		if (codigo != null) {
			sql.append(" and a.codigo = '"+ codigo +"'");
		} if (nome != null) {
			sql.append(" and a.nome = '"+ nome +"'");
		} if (sort.isPresent()) {
			sql.append(" order by a." + sort.get());
		}
		
		return entityManager
				.createQuery(sql.toString(), Disciplina.class)
				.getResultList();
	}
}
