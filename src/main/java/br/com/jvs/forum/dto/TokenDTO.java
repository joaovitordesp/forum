package br.com.jvs.forum.dto;

public class TokenDTO {

	private String token;
	private String tipo;

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}

	public TokenDTO(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}
}
