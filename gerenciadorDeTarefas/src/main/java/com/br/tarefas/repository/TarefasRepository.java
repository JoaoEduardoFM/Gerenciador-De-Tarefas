package com.br.tarefas.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tarefas.model.entity.TarefaEntity;

public interface TarefasRepository extends JpaRepository<TarefaEntity, BigInteger> {

}