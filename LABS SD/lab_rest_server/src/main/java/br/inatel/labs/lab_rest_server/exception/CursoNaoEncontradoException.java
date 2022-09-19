package br.inatel.labs.lab_rest_server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CursoNaoEncontradoException extends ResponseStatusException{
	
	private static final long serialVersionUID = -25034009L;

	public CursoNaoEncontradoException(Long id) {
		super(HttpStatus.NOT_FOUND,  String.format("Nenhum curso encontrado com id ["+ id + "]"));
		// TODO Auto-generated constructor stub
	}

}
