package com.br.fiap.postech.soat7grupo5_producao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fiap.postech.soat7grupo5_producao.dto.ProducaoDto;
import com.br.fiap.postech.soat7grupo5_producao.service.ProducaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Produção", description = "Recursos relacionados à produção.")
@RequestMapping(path="producao", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProducaoController {

	@Autowired
	ProducaoService producaoService;
	
	@GetMapping(path="/buscar-pedidos-cozinha")
	@Operation(summary = "Retorna lista com pedidos em produção(visão cozinha).")
	ResponseEntity<?> buscarPedidosProducaoCozinha() {
		return new ResponseEntity<>(producaoService.buscarPedidosProducaoCozinha(), HttpStatus.OK);
	}
	@PutMapping(path="{idPedido}/status/{idStatus}")
	@Operation(summary = "Atualizar status da produção no pedido")
	ResponseEntity<?> atualizarStatusProducaoNoPedido(@Parameter(description = "ID do pedido.", example = "1") @PathVariable String idPedido, @Parameter(description = "ID do status do pedido (1: Recebido, 2: Em preparação, 3: Pronto).", example = "1") @PathVariable String idStatus) {
		return new ResponseEntity<>(producaoService.atualizarStatusProducaoNoPedido(idPedido, idStatus), HttpStatus.OK);
	}
	
	@PostMapping(path="/registrar")
	@Operation(summary = "Registrar pedido.")
	ResponseEntity<?>  registrarPedido(@RequestBody ProducaoDto pedidoDto) {
		ProducaoDto pedidoRetornoDto = producaoService.salvarPedido(pedidoDto);
		return new ResponseEntity<>(pedidoRetornoDto, HttpStatus.CREATED);
	}
}
