package com.br.tarefas.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.tarefas.model.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger>{

}
