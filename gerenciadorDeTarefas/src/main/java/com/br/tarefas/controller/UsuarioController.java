package com.br.tarefas.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/usuario")
@Api(tags = "Usuarios", value = "Gerenciamento de usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/buscaRegistros")
	private ResponseEntity<?> buscaUsuarios() {
		return usuarioService.buscaTodosUsuarios();
	}

	@GetMapping("/buscaPorId/{{id}")
	private ResponseEntity<?> buscaPorId(@PathVariable BigInteger id) {
		return usuarioService.buscaPorId(id);
	}

	@PostMapping("/cadastraRegistro")
	private ResponseEntity<?> cadastraRegistro(@RequestBody UsuarioEntity usuarioEntity) {
		return usuarioService.cadastraRegistro(usuarioEntity);
	}

	@PutMapping("/atualizaRegistro/{id}")
	private ResponseEntity<?> atualizaRegistro(@RequestBody UsuarioEntity usuarioEntity, @PathVariable BigInteger id) {
		return usuarioService.atualizaRegistro(id, usuarioEntity);
	}

	@PatchMapping
	@PutMapping("/atualizaParcialmente/{id}")
	private ResponseEntity<?> atualizaParcialmento(@RequestBody UsuarioEntity usuarioEntity, BigInteger id){
		return usuarioService.atulizaParcialmente(id, usuarioEntity);
	}
}
