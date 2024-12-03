package com.br.fiap.postech.soat7grupo5_producao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.fiap.postech.soat7grupo5_producao.entity.ProducaoEntity;

public interface ProducaoRepository extends MongoRepository<ProducaoEntity, String>{

	ProducaoEntity findByIdPedido(String idPedido);

}
