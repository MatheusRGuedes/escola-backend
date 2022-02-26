package br.com.matheus.escola.api.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.matheus.escola.api.enums.TipoFormacao;

/*
 * Verificar valor padrão coluna tipo
 */

@Entity
@Table(name = "FORMACOES")
public class Formacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Length(max = 255)
	@NotBlank
	private String nome;

	@Enumerated(EnumType.STRING)
	private TipoFormacao tipo;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	@JsonBackReference
	private Professor professor;
	
	
	public Formacao() {}

	public Formacao(String nome, TipoFormacao tipo, Professor professor) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.professor = professor;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public TipoFormacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoFormacao tipo) {
		this.tipo = tipo;
	}

	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
