package br.com.matheus.escola.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.matheus.escola.api.enums.Sexo;
import br.com.matheus.escola.api.models.Endereco;
import br.com.matheus.escola.api.models.Formacao;
import br.com.matheus.escola.api.models.Professor;
import br.com.matheus.escola.api.repositories.ProfessorRepository;

@SpringBootApplication
public class BackendApplication implements CommandLineRunner {

	//@Autowired
	//private ProfessorRepository professorRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
		 * */
		
		/*Endereco endereco = new Endereco("20973055", "aaa", "fggg", "fefe", "rj");
		
		Professor professor = new Professor();
		professor.setNome("Baianor");
		professor.setSexo(Sexo.MASCULINO);
		professor.setEndereco(endereco);
		professor.setFormacoes(new ArrayList<>());
		
		//Professor professorSalvo = professorRepository.save(professor);
		
		//professor.setId(professorSalvo.getId());
		
		Formacao f1 = new Formacao("Informática", "Licenciatura", professor);
		List<Formacao> formacoes = new ArrayList<>();
		formacoes.add(f1);
		
		professor.setFormacoes(formacoes);
		
		//professorRepository.save(professor); //atualiza
		
		//String json = new ObjectMapper().writeValueAsString(professor);
		//System.out.println(json); 
		 */
	}
}
