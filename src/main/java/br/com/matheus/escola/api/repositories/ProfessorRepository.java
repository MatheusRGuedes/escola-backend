package br.com.matheus.escola.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.matheus.escola.api.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
