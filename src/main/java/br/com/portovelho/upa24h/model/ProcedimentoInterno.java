package br.com.portovelho.upa24h.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Audited
public class ProcedimentoInterno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	MUDAR O NOME DA CONSTRAINT NO BANCO DE DADOS PARA: unique_codigo
	@NotBlank(message = "O campo Código é obrigatório!")
	@Column(unique=true)
	private String codigo;

//	MUDAR O NOME DA CONSTRAINT NO BANCO DE DADOS PARA: unique_descricao
	@NotBlank(message = "O campo Descrição é obrigatório!")
	@Column(unique=true)
	private String descricao;

	/*@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo Tipo de Sala é obrigatório!")
	private TipoSalaAtendimento tipoSalaAtendimento;*/

	private Boolean status;

	public ProcedimentoInterno() {
		this.status = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public Long getId() {
		return id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcedimentoInterno other = (ProcedimentoInterno) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
