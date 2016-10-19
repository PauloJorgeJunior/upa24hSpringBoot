package br.com.portovelho.upa24h.enums;

public enum PerfilDeAcesso {
	ATD("Atendente"),ADM("Administrador"), EF("Enfermeiro"),MD("Médico");
	
	private String descricao;

	private PerfilDeAcesso(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
}
