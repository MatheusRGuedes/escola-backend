package br.com.matheus.escola.api.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheus.escola.api.models.Professor;
import br.com.matheus.escola.api.repositories.FormacaoRepository;
import br.com.matheus.escola.api.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private EntityManager manager;
	
	@Autowired
	private ProfessorRepository repository;
	
	@Autowired
	private FormacaoRepository formacaoRepository;
	
	
	public List<Professor> listar() {
		return repository.findAll();
	}
	
	public Professor encontrar(Long id) {//não retornar nulo, testar com exceções
		Optional<Professor> professor = repository.findById(id);
		if (professor.isPresent()) {
			return professor.get();
		} 
		return null;
	}
	
	public Professor criar(Professor professor) {
		return repository.save(professor);
	}
	
	public Professor atualizar(Long id, Professor professor) {
		
		Optional<Professor> professorAchado = repository.findById(id);
		
		if (professorAchado.isPresent()) {
			professor.setId(id);
			//atualiza o endereço
			professor.getEndereco()
				.setId(professorAchado.get().getEndereco().getId());
			
			return repository.save(professor);
		}
		
		return null;
	}
	
	public boolean deletarPorId(Long id) {
		
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		
		return false;
	}

	public boolean deletarFormacao(Long id, Long formacaoId) {
		
		if (formacaoRepository.existsByIdAndProfessorId(formacaoId, id)) {
			//System.out.printf("Existe a formacao id=%d para o professor id=%d", formacaoId, id);
			formacaoRepository.deleteById(formacaoId);
			return true;
		}
		
		return false;
	}

	public List<Professor> buscar(Optional<String> nome, Optional<LocalDate> dataNascimento, 
			Optional<String> cep) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select a from Professor a where 1 = 1 ");
		
		if (!"".equals(nome.get().trim())) {
			sql.append(" and a.nome = '"+nome.get()+"'");
		} if (dataNascimento.isPresent()) {
			sql.append(" and a.dataNascimento = '"+dataNascimento.get()+"' ");
		} if (!"".equals(cep.get().trim())) {
			sql.append(" and a.endereco.cep = '"+cep.get()+"' ");
		}
		return manager.createQuery(sql.toString(), Professor.class)
				.getResultList();
	}
}
