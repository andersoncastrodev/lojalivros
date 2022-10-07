package br.com.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidationError(Long timestampo, Integer status, String error) {
		super(timestampo, status, error);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fielName, String message) {
		//Adicionando na lista erros de cada Vez.
		this.erros.add(new FieldMessage(fielName ,message ) );
	}

	
}
