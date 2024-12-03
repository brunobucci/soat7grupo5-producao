package com.br.fiap.postech.soat7grupo5_producao.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.br.fiap.postech.soat7grupo5_producao.dto.ProducaoDto;
import com.br.fiap.postech.soat7grupo5_producao.entity.ProducaoEntity;
import com.br.fiap.postech.soat7grupo5_producao.repository.ProducaoRepository;

@Service
public class ProducaoService {

	@Autowired
	private ProducaoRepository producaoRepository;

	@Value("${url.api.pedidos}")
    String urlApiPedido;

	public List<ProducaoEntity> buscarPedidosProducaoCozinha() {
		return producaoRepository.findAll();
	}

	public ProducaoEntity atualizarStatusProducaoNoPedido(String idPedido, String status) {
		ProducaoEntity pedidoEntity = producaoRepository.findByIdPedido(idPedido);

		if(Objects.nonNull(pedidoEntity)) {
			pedidoEntity.setStatus(status);
			producaoRepository.save(pedidoEntity);
		}

		if(status.equals("3")) {
			atualizaStatusNoPedidoAPI(idPedido, "4");
		}
		
		return pedidoEntity;
	}

	private void atualizaStatusNoPedidoAPI(String idPedido, String status) {
		try {
			RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> request = new HttpEntity<>(headers);

			restTemplate.exchange(
					urlApiPedido + idPedido + "/status/" + status,
                    HttpMethod.PUT,
                    request,
                    String.class
            );

            //String retorno = response.getBody().toString();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	public ProducaoDto salvarPedido(ProducaoDto producaoDto) {
		ProducaoEntity producaoEntity = new ProducaoEntity();
		producaoEntity.setIdPedido(producaoDto.getIdPedido());
		producaoEntity.setStatus(producaoDto.getStatus());
		
		ProducaoEntity producaoRegistradaEntity = producaoRepository.save(producaoEntity);
		producaoDto.setId(producaoRegistradaEntity.getId());
		producaoDto.setDescricaoStatus(geraDescricao(producaoRegistradaEntity.getStatus()));
		return producaoDto;
	}

	public String geraDescricao(String status) {
		String descricao = "";
		if(status.equals("1")) {
			descricao = "Pedido recebido";
		}else if(status.equals("2")){
			descricao = "Pedido em preparação";
		}else {
			descricao = "Pedido finalizado";
		}
		return descricao;
	}
}
