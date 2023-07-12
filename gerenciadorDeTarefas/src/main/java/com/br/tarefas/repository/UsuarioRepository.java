package com.br.tarefas.repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tarefas.model.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger>{
	
	public Optional<List<UsuarioEntity>> findByListaDeTarefas_Titulo(String titulo);
	
	public Optional<List<UsuarioEntity>> findByListaDeTarefas_Descricao(String descricao);
	
	public Optional<List<UsuarioEntity>> findByListaDeTarefas_DataConclusao(String dataConclusao);
	
	public Optional<List<UsuarioEntity>> findByListaDeTarefas_Status(Boolean status);
	
	public Optional<List<UsuarioEntity>> findByListaDeTarefas_Prioridade(String prioridade);

}
