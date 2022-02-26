package br.com.matheus.escola.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matheus.escola.api.models.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
	
	public List<Disciplina> findDisciplinaByCodigo(String codigo);
	public List<Disciplina> findDisciplinaByNome(String nome);
	public List<Disciplina> findDisciplinaByCodigoAndNome(String codigo, String nome);
}
