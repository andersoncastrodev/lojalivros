package br.com.controller.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String campoNome;
	
	private String message;

	public FieldMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FieldMessage(String campoNome, String message) {
		super();
		this.campoNome = campoNome;
		this.message = message;
	}

	public String getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(String campoNome) {
		this.campoNome = campoNome;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
