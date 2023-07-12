package com.br.tarefas.model.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "tarefa")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TarefaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	BigInteger id;

	String titulo;

	String descricao;

	String dataConclusao;

	Boolean status;

	String prioridade;
}
