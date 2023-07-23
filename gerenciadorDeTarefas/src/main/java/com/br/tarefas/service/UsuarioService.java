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
import com.br.tarefas.model.response.responseModel;
import com.br.tarefas.repository.UsuarioRepository;

/**
 * @author João
 * @apiNote Service para manipular dados do usuário
 */

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public ResponseEntity<?> buscaTodosUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}

	public ResponseEntity<?> buscaPorId(BigInteger id) {
		responseModel response = new responseModel();
		response.setMensagem("O id informado não existe.");
		Optional<UsuarioEntity> buscaPorId = repository.findById(id);
		if (buscaPorId.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
	}

	public ResponseEntity<?> cadastraRegistro(@RequestBody UsuarioEntity usuarioEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuarioEntity));
	}

	public ResponseEntity<?> atualizaRegistro(@PathVariable BigInteger id, @RequestBody UsuarioEntity usuarioEntity) {
		responseModel response = new responseModel();
		response.setMensagem("O id informado não existe.");
		Optional<UsuarioEntity> buscaPorId = repository.findById(id);
		if (buscaPorId.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		usuarioEntity.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuarioEntity));
	}

	public void deletaRegistro(BigInteger id) {
		repository.deleteById(id);
	}

	public ResponseEntity<?> atulizaParcialmente(BigInteger id, @RequestBody UsuarioEntity usuarioEntity) {
		responseModel response = new responseModel();
		response.setMensagem("O id informado não existe.");
		Optional<UsuarioEntity> buscaPorId = repository.findById(id);
		if (buscaPorId.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		usuarioEntity.setId(id);
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuarioEntity));
	}
	
	public ResponseEntity<?> buscaPorTitulo(String titulo) {
		responseModel response = new responseModel();
		List<UsuarioEntity> buscaPorTitulo = repository.findByListaDeTarefas_Titulo(titulo);	
		response.setMensagem("O titulo informado não existe.");
		if (buscaPorTitulo.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaPorTitulo);
	}
	
	public ResponseEntity<?> buscaPorDescricao(String descricao) {
		responseModel response = new responseModel();
		response.setMensagem("A descrição informado não existe.");
		List<UsuarioEntity> buscaPorDescricao = repository.findByListaDeTarefas_Descricao(descricao);	
		if (buscaPorDescricao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaPorDescricao);
	}
	
	public ResponseEntity<?> buscaPorDataConclusao(String data) {
		responseModel response = new responseModel();
		response.setMensagem("A data informada não existe.");
		List<UsuarioEntity> buscaDataConclusao = repository.findByListaDeTarefas_DataConclusao(data);
		if (buscaDataConclusao.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaDataConclusao);
	}
	
	public ResponseEntity<?> buscaPorStatus(Boolean status) {
		responseModel response = new responseModel();
		response.setMensagem("O status informado não existe.");
		List<UsuarioEntity> buscaStatus = repository.findByListaDeTarefas_Status(status);
		if (buscaStatus.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaStatus);
	}
	
	public ResponseEntity<?> buscaPorPrioridade(String prioridade) {
		responseModel response = new responseModel();
		response.setMensagem("A prioridade informada não existe.");
		List<UsuarioEntity> buscaPrioridade = repository.findByListaDeTarefas_Prioridade(prioridade);
		if (buscaPrioridade.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(buscaPrioridade);
	}
}
