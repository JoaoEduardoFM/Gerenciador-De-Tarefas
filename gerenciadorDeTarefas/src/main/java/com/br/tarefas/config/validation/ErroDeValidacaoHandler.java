package com.br.tarefas.config.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource; //classe que ajuda a pegar mensagens de erro, de acordo com o idioma da requisicao
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) //fala que deve retornar 400, se nao tivesse feito isso, o spring iria entender que tratamos o erro, e iria retornar 200
	@ExceptionHandler(MethodArgumentNotValidException.class) //diz para o spring que o metodo abaixo deve ser chamado quando houver alguma exeção dentro de algum controller
	public List<ErroBody> handleBadRequest(MethodArgumentNotValidException exception) {
		List<ErroBody> dto = new ArrayList<ErroBody>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroBody erro = new ErroBody(e.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}
	
	@ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<String> handleIllegalAccessException(IllegalAccessException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro de acesso ilegal.");
    }
	
	@ExceptionHandler(InvocationTargetException.class)
    public ResponseEntity<String> handleInvocationTargetException(InvocationTargetException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro durante a invocação do método.");
    }
	
	
	/* esta classe funciona como uma espécie de interceptador, 
	 * sempre que tiver um erro, o spring virá nela para ser tratadp */
	
}