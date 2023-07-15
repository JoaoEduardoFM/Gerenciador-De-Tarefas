package com.br.tarefas;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.br.tarefas.model.entity") // Escaneia o pacote com as entidades JPA
@EnableJpaRepositories("com.br.tarefas.repository") // Configuração do pacote com os repositórios JPA
public class GerenciadorDeTarefasApplication {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDeTarefasApplication.class, args);
		System.err.println(" {Bem-vindo à nossa API! \n "
				+ "Para acessar as funcionalidades acesse o swagger no seguinte link. \n "
				+ "http://localhost:8080/swagger-ui.html#/} \n" + " Créditos: João Eduardo");
	}

}
