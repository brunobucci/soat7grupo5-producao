package com.br.fiap.postech.soat7grupo5_producao.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Produção", description = "Recursos relacionados à produção.")
@RequestMapping(path="producao", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProducaoController {

	@GetMapping(path="/buscar-pedidos-cozinha")
	@Operation(summary = "Retorna lista com pedidos em produção(visão cozinha).")
	String buscarPedidosProducaoCozinha() {
		return null;
	}
	@PutMapping(path="{idPedido}/status/{idStatus}")
	@Operation(summary = "Atualizar status da produção no pedido")
	String atualizarStatusPagamentoNoPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable int idPedido, @Parameter(description = "ID do status do pedido (1: Recebido, 2: Em preparação, 3: Pronto, 4: Finalizado).", example = "1") @PathVariable int idStatus) {
		return null;
	}
}
