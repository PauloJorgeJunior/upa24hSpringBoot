package br.com.portovelho.upa24h.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited

public class AtendimentoIdentificado extends Atendimento {

	@OneToOne
	private Paciente paciente;
	
	@OneToMany(mappedBy = "atendimentoIdentificado")
	private List<Triagem> triagens;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Triagem> getTriagens() {
		return triagens;
	}

	public void setTriagens(List<Triagem> triagens) {
		this.triagens = triagens;
	}

}
