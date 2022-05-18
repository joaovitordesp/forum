package br.com.jvs.forum.config.validacao;

public class ErroDeFormularioDTO {
	private String campo;
	
	private String mensagem;

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public ErroDeFormularioDTO(String campo, String mensagem) {
		this.campo = campo;
		this.mensagem = mensagem;
	}
	
}
