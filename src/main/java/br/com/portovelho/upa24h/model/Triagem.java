package br.com.portovelho.upa24h.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Triagem {
	@Id
	private Long id;
	@ManyToOne
	@JoinColumn(name = "atendimentoIdentificado_id")
	private AtendimentoIdentificado atendimentoIdentificado;
}
