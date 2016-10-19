package br.com.portovelho.upa24h.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.envers.Audited;

@Entity
@Audited
public class Municipio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long codigoIbge;
	private String nome;
	@ManyToOne
	@JoinColumn(name="uf_id")
	private UF uf;
	@OneToMany(mappedBy="municipio")
	private List<Bairro> bairros;
		
	public Long getId() {
		return id;
	}

	public void setCodigoIbge(Long codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	public String getNome() {
	    return nome;
	}

	public void setNome(String nome) {
	    this.nome = nome;
	}

	public UF getUf() {
	    return uf;
	}

	public void setUf(UF uf) {
	    this.uf = uf;
	}

	public List<Bairro> getBairros() {
	    return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
	    this.bairros = bairros;
	}

	public Long getCodigoIbge() {
	    return codigoIbge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoIbge == null) ? 0 : codigoIbge.hashCode());
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
		Municipio other = (Municipio) obj;
		if (codigoIbge == null) {
			if (other.codigoIbge != null)
				return false;
		} else if (!codigoIbge.equals(other.codigoIbge))
			return false;
		return true;
	}
	
	
	
}
