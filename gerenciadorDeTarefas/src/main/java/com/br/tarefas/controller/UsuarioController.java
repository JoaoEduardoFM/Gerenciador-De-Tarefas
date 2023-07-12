package com.br.tarefas.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.tarefas.model.entity.UsuarioEntity;
import com.br.tarefas.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
@Api(tags = "Usuarios", value = "Gerenciamento de usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@ApiOperation(
			value = "Busca usuarios.", 
			notes = "Bista todos usuários cadastrados.")
	@GetMapping("/buscaRegistros")
	private ResponseEntity<?> buscaUsuarios() {
		return usuarioService.buscaTodosUsuarios();
	}

	@ApiOperation(
			value = "Busca registro por id.", 
			notes = "Busca usuário por id.")
	@GetMapping("/buscaPorId/{id}")
	private ResponseEntity<?> buscaPorId(@PathVariable BigInteger id) {
		return usuarioService.buscaPorId(id);
	}
	
	@ApiOperation(
			value = "Busca usuário pelo titulo.", 
			notes = "Busca registro pelo titulo.")
	@GetMapping("/buscaPorTitulo/{titulo}")
	private ResponseEntity<?> buscaPorTitulo(@PathVariable String titulo) {
		return usuarioService.buscaPorTitulo(titulo);
	}
	
	@ApiOperation(
			value = "Busca usuário pela descrição.", 
			notes = "Busca registro pela descrição.")
	@GetMapping("/buscaPorTitulo/{descricao}")
	private ResponseEntity<?> buscaPorDescricao(@PathVariable String descricao) {
		return usuarioService.buscaPorDescricao(descricao);
	}
	
	@ApiOperation(
			value = "Busca usuário pela data de conclusão.", 
			notes = "Busca registro pela data de conclusão.")
	@GetMapping("/buscaPorDataConclusao/{data}")
	private ResponseEntity<?> buscaPorDataConclusao(@PathVariable String data) {
		return usuarioService.buscaPorDataConclusao(data);
	}
	
	@ApiOperation(
			value = "Busca usuário pelo status.", 
			notes = "Busca registro pelo status.")
	@GetMapping("/buscaPorStatus/{status}")
	private ResponseEntity<?> buscaPorStatus(@PathVariable Boolean status) {
		return usuarioService.buscaPorStatus(status);
	}
	
	@ApiOperation(
			value = "Busca usuário pela prioridade.", 
			notes = "Busca registro pela prioridade.")
	@GetMapping("/buscaPorPrioridade/{prioridade}")
	private ResponseEntity<?> buscaPorPrioridade(@PathVariable String prioridade) {
		return usuarioService.buscaPorPrioridade(prioridade);
	}

	@ApiOperation(
			value = "Cadastra registro.", 
			notes = "Cadastra usuário ")
	@PostMapping("/cadastraRegistro")
	private ResponseEntity<?> cadastraRegistro(@RequestBody UsuarioEntity usuarioEntity) {
		return usuarioService.cadastraRegistro(usuarioEntity);
	}

	@ApiOperation(
			value = "Atualiza registro.", 
			notes = "Atualiza usuário ")
	@PutMapping("/atualizaRegistro/{id}")
	private ResponseEntity<?> atualizaRegistro(@RequestBody UsuarioEntity usuarioEntity, @PathVariable BigInteger id) {
		return usuarioService.atualizaRegistro(id, usuarioEntity);
	}

	@ApiOperation(
			value = "Atualiza parcialmento registro.", 
			notes = "Atualiza parcialmento usuário.")
	@PatchMapping
	@PutMapping("/atualizaParcialmente/{id}")
	private ResponseEntity<?> atualizaParcialmento(@RequestBody UsuarioEntity usuarioEntity, BigInteger id){
		return usuarioService.atulizaParcialmente(id, usuarioEntity);
	}
	
	@ApiOperation(
			value = "Deleta registro.", 
			notes = "Deleta usuário.")
	@DeleteMapping("/deletaUsuario/{id}")
	private void deletaRegistro(BigInteger id) {
		usuarioService.deletaRegistro(id);
	}
}
