package br.com.matheus.escola.api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.matheus.escola.api.enums.Sexo;

/*
 * Classe de domínio dos Professores
 * 
 * mappedBy   	   		 --> indica um relacionamento bidirecional, ou seja, cada entidade da relação se acessa.
 * cascadeType.All 		 --> Resolver problema de persistencia com chave estrangeira nula
 * @Enumerated	   		 --> Usado pr definir o dado q irá ser deserializado, string para o valor cheio, por padrao é inteiro;
 * @JsonManagedReference --> Usado para resolver problema de recursão na serialização numa relação bidirecional;
 * 						 --> Usada na entidade que é serializada normalmente ("pai");
 * @JsonBackReference 	 --> Usada na entidade q é serializada logo depois a do "pai";
 * @Past				 --> Deve ser anterior a data atual;
 * */

@Entity
@Table(name = "PROFESSORES")
public class Professor {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Size(max = 255)
	@NotBlank
	private String nome;
	
	@NotNull(message = "O sexo deve ser Masculino(M/n) ou Feminino(F/f).")
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Past(message = "Data de nascimento deve ser anterior a data atual.")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate dataNascimento;
	
	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	
	@JsonManagedReference 
	@Valid
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private List<Formacao> formacoes = new ArrayList<>();
	
	
	public Professor() {}
	
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
	
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Formacao> getFormacoes() {
		return formacoes;
	}
	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}	
}
