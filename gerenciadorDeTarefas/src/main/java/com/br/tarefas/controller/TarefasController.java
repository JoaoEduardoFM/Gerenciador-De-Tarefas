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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tarefas")
@Api(tags = "Tarefas", value ="Gerenciamento de tarefas")
public class TarefasController {

	@Autowired
	private tarefasService tarefasSevice;

	@ApiOperation(
			value = "Buscar tarefas.", 
			notes = "Busta todas tarefas cadastradas.")
	@GetMapping("/buscaTarefas")
	private ResponseEntity<?> buscaTodosRegistros() {
		return tarefasSevice.BuscaTodosRegistro();
	}

	@ApiOperation(
			value = "Buscar por id.", 
			notes = "Busta por id cadastrada.")
	@GetMapping("/buscaTarefaPorId/{id}")
	private ResponseEntity<?> buscaPorId(@PathVariable BigInteger id) {
		return tarefasSevice.BuscaRegistroPorId(id);
	}

	@ApiOperation(
			value = "Cadastra Tarefa", 
			notes = "Cadastra tarefa ao banco de dados")
	@PostMapping("/cadastraTarefa")
	private ResponseEntity<?> cadastraRegistro(@RequestBody TarefaEntity entity) {
		return tarefasSevice.SalvaRegistro(entity);
	}

	@ApiOperation(
			value = "atualiza Tarefa", 
			notes = "atualiza tarefa ao banco de dados")
	@PutMapping("/atualizaTarefa/{id}")
	private ResponseEntity<?> AtualizaRegistro(@RequestBody TarefaEntity entity) {
		return tarefasSevice.SalvaRegistro(entity);
	}

	@ApiOperation(
			value = "deleta Tarefa", 
			notes = "deleta tarefa do banco de dados")
	@DeleteMapping("/deleta/{id}")
	private void deletaRegistro(BigInteger id) {
		tarefasSevice.DeletaRegistro(id);
	}
}
