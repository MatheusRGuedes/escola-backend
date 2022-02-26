package br.com.matheus.escola.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/*
 * @JsonValue 	--> Passa a aceitar as siglas como valores válidos na serialização das descrições permitidas;
 * @JsonCreator --> Usado para permitir que a deserialização de um json aceite valores minúsculos;
 * */

public enum Sexo {
	
	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminino");
	
	private String codigo;
	private String descricao;

	Sexo(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	@JsonValue
	public String getCodigo() {
		return codigo;
	}
	
	@JsonCreator
	public static Sexo forValue(String valor) {
		
		for (Sexo sexo : Sexo.values()) {			
			if (sexo.codigo.equalsIgnoreCase(valor) ||
					sexo.descricao.equals(valor)) {
				//System.out.println(sexo);
				return sexo;
			}
		}
		
		return null;
	}
}
