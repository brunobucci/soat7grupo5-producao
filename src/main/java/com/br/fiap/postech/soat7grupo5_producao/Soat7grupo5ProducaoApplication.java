package com.br.fiap.postech.soat7grupo5_producao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = 
@Info(title = "Soat7grupo5 API - Produção", 
	version = "1.0", 
	description = "Página de referência da Soat7grupo5 API - Produção")
)
public class Soat7grupo5ProducaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Soat7grupo5ProducaoApplication.class, args);
	}

}
