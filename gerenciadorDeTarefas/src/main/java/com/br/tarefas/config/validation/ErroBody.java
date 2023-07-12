package com.br.tarefas.config.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroBody {

	private String campo;
	private String mensagem;
}
