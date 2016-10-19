package br.com.portovelho.upa24h.enums;

public enum PorteFisico {
	NORMAL("Normal"), GORDO("Gordo"), MAGRO("Magro");

	private String descricao;

	private PorteFisico(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
