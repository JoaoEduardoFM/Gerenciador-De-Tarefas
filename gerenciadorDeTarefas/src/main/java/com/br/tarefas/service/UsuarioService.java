package com.br.tarefas.service;

import java.math.BigInteger;
import java.util.List;
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
	
	public ResponseEntity<?> buscaPorTitulo(String titulo) {
		Optional<List<UsuarioEntity>> buscaPorTitulo = repository.findByListaDeTarefas_Titulo(titulo);
		if (!buscaPorTitulo.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O titulo informado não existe.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaPorTitulo);
	}
	
	public ResponseEntity<?> buscaPorDescricao(String descricao) {
		Optional<List<UsuarioEntity>> buscaPorDescricao = repository.findByListaDeTarefas_Descricao(descricao);
		if (!buscaPorDescricao.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A descrição informado não existe.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaPorDescricao);
	}
	
	public ResponseEntity<?> buscaPorDataConclusao(String data) {
		Optional<List<UsuarioEntity>> buscaDataConclusao = repository.findByListaDeTarefas_DataConclusao(data);
		if (!buscaDataConclusao.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A data informada não existe.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaDataConclusao);
	}
	
	public ResponseEntity<?> buscaPorStatus(Boolean status) {
		Optional<List<UsuarioEntity>> buscaStatus = repository.findByListaDeTarefas_Status(status);
		if (!buscaStatus.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O status informado não existe.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaStatus);
	}
	
	public ResponseEntity<?> buscaPorPrioridade(String prioridade) {
		Optional<List<UsuarioEntity>> buscaPrioridade = repository.findByListaDeTarefas_Prioridade(prioridade);
		if (!buscaPrioridade.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A prioridade informada não existe.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaPrioridade);
	}
}
