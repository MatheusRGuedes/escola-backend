package br.com.matheus.escola.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheus.escola.api.models.Formacao;

public interface FormacaoRepository extends JpaRepository<Formacao, Long> {

	boolean existsByIdAndProfessorId(Long id, Long professorId);
}
