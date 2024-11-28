package com.br.fiap.postech.soat7grupo5_producao.enums;

public enum StatusProducao {

	RECEBIDO("1"), EM_PREPARACAO("2"), PRONTO("3");

	private final String valor;
	StatusProducao(String valorOpcao){
		valor = valorOpcao;
	}
	public String getValor(){
		return valor;
	}
	
}
