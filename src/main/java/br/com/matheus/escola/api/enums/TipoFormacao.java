package br.com.matheus.escola.api.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoFormacao {

	BACHARELADO, 
	LICENCIATURA, 
	GRADUACAO, 
	POS_GRADUACAO;
	
	@JsonCreator
	public static TipoFormacao forValue(String input) {
		for(TipoFormacao tipo : TipoFormacao.values()) {
			//System.out.println(tipo);
			if (input.equals(tipo.toString())) {
				return tipo;
			}
		}
		return null;
 	}
}
