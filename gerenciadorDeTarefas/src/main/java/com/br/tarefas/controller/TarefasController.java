package com.br.tarefas.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tarefas.model.entity.TarefaEntity;
import com.br.tarefas.service.tarefasService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/tarefas")
@Api(tags = "Tarefas", value ="Gerenciamento de tarefas")
public class TarefasController {

	@Autowired
	private tarefasService tarefasSevice;

	@GetMapping("/buscaTarefas")
	private ResponseEntity<?> buscaTodosRegistros() {
		return tarefasSevice.BuscaTodosRegistro();
	}

	@GetMapping("/buscaTarefaPorId/{id}")
	private ResponseEntity<?> buscaPorId(@PathVariable BigInteger id) {
		return tarefasSevice.BuscaRegistroPorId(id);
	}

	@PostMapping("/cadastraTarefa")
	private ResponseEntity<?> cadastraRegistro(@RequestBody TarefaEntity entity) {
		return tarefasSevice.SalvaRegistro(entity);
	}

	@PutMapping("/atualizaTarefa/{id}")
	private ResponseEntity<?> AtualizaRegistro(@RequestBody TarefaEntity entity) {
		return tarefasSevice.SalvaRegistro(entity);
	}

	@DeleteMapping("/deleta/{id}")
	private void deletaRegistro(BigInteger id) {
		tarefasSevice.DeletaRegistro(id);
	}
}
