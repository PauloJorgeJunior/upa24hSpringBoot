package br.com.portovelho.upa24h.enums;

public enum StatusSalaAtendimento {
	ABERTA("Aberta"),EM_MANUTENCAO("Em Manutenção"),INATIVO("Inativo"),OCUPADA("Ocupada");

	private String descricao;

	private StatusSalaAtendimento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
