package com.br.tarefas.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.tarefas.model.entity.TarefaEntity;
import com.br.tarefas.repository.TarefasRepository;

@Service
public class tarefasService {
	
	@Autowired
	private TarefasRepository repository;
	
	//busca todos registros
	public ResponseEntity<?> BuscaTodosRegistro() {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}
	
	//Busca registros po id
	public ResponseEntity<?> BuscaRegistroPorId(BigInteger id){
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

	
}
