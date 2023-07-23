package com.br.tarefas.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.tarefas.model.entity.TarefaEntity;
import com.br.tarefas.model.response.responseModel;
import com.br.tarefas.repository.TarefasRepository;

/**
 * @author João
 * @apiNote Service para manipular dados de tarefas
 */

@Service
public class tarefasService {
	
	private final String ID_NAO_ENCONTRADO = "O id informado não existe.";
	
	@Autowired
	private TarefasRepository repository;
	
	//busca todos registros
	public ResponseEntity<?> BuscaTodosRegistro() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	//Busca registros po id
	public ResponseEntity<?> BuscaRegistroPorId(BigInteger id){
		Optional<TarefaEntity> tarefa = repository.findById(id);
		if(tarefa.isEmpty()) {
			responseModel response = new responseModel();
			response.setMensagem(ID_NAO_ENCONTRADO);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
	}
	
	//Salva registro e edita
	public ResponseEntity<?> SalvaRegistro(TarefaEntity entity){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(entity));
	}
	
	//deleta registro
	public void DeletaRegistro(BigInteger id) {	
		repository.deleteById(id);
	}
	
	public ResponseEntity<?> atualizaStatus(BigInteger id, Boolean status, TarefaEntity entity) {
		Optional<TarefaEntity> tarefa = repository.findById(id);
		if(tarefa.isEmpty()) {
			responseModel response = new responseModel();
			response.setMensagem(ID_NAO_ENCONTRADO);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response) ;
		}
		entity.setDataConclusao(tarefa.get().getDataConclusao());
		entity.setDescricao(tarefa.get().getDescricao());
		entity.setId(tarefa.get().getId());
		entity.setPrioridade(tarefa.get().getPrioridade());
		entity.setStatus(status);
		entity.setTitulo(tarefa.get().getTitulo());
		ResponseEntity<TarefaEntity> atualizarStatus = ResponseEntity.status(HttpStatus.OK).body(repository.save(entity));
		return atualizarStatus;
	}
}
