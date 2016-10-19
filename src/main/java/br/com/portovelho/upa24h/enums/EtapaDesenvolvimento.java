package br.com.portovelho.upa24h.enums;

public enum EtapaDesenvolvimento {

	CRIANÇA("Criança"),
	ADOLESCENTE("Adolescente"),
	ADULTO("Adulto"),
	IDOSO("Idoso");

	private String descricao;
	
	private EtapaDesenvolvimento(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
