package br.com.portovelho.upa24h.enums;

public enum Estrutura {
	NORMAL("Normal"), ALTO("Alto"), BAIXO("Baixo");

	private String descricao;

	private Estrutura(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
