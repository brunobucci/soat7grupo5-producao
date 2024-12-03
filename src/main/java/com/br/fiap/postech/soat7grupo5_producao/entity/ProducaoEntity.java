package com.br.fiap.postech.soat7grupo5_producao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "pedido")
public class ProducaoEntity {

	@Id
	private String id;
	private String idPedido;
	private String status;

}
