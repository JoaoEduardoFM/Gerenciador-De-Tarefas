package com.br.tarefas.model.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "Id usuário", required = false)
	BigInteger id;

	@ApiModelProperty(value = "titulo", required = false)
	String titulo;

	@ApiModelProperty(value = "descricao", required = false)
	String descricao;

	@ApiModelProperty(example = "10102025", value = "dataConclusao", required = false)
	String dataConclusao;
	
	@ApiModelProperty(example = "TRUE", value = "status", required = false)
	Boolean status;

	@ApiModelProperty(example = "ALTA", value = "prioridade", required = false)
	String prioridade;
}
