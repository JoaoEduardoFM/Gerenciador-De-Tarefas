package com.br.tarefas.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.tarefas.model.entity.UsuarioEntity;
import com.br.tarefas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public ResponseEntity<?> buscaTodosUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());

	}

	public ResponseEntity<?> buscaPorId(BigInteger id) {
		Optional<UsuarioEntity> buscaPorId = repository.findById(id);
		if (!buscaPorId.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
	}

	public ResponseEntity<?> cadastraRegistro(@RequestBody UsuarioEntity usuarioEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuarioEntity));

	}

	public ResponseEntity<?> atualizaRegistro(@PathVariable BigInteger id, @RequestBody UsuarioEntity usuarioEntity) {
		Optional<UsuarioEntity> buscaPorId = repository.findById(id);
		if (!buscaPorId.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe.");
		}
		usuarioEntity.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuarioEntity));

	}

	public void deletaRegistro(BigInteger id) {
		repository.deleteById(id);
	}

	public ResponseEntity<?> atulizaParcialmente(BigInteger id, @RequestBody UsuarioEntity usuarioEntity) {
		Optional<UsuarioEntity> buscaPorId = repository.findById(id);
		if (!buscaPorId.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O id informado não existe.");
		}
		usuarioEntity.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuarioEntity));

	}
}
