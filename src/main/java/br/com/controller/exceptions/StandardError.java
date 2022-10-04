package br.com.controller.exceptions;

public class StandardError {

	private Long timestampo;
	
	private Integer status;
	
	private String error;

	public StandardError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandardError(Long timestampo, Integer status, String error) {
		super();
		this.timestampo = timestampo;
		this.status = status;
		this.error = error;
	}

	public Long getTimestampo() {
		return timestampo;
	}

	public void setTimestampo(Long timestampo) {
		this.timestampo = timestampo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
