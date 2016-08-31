package br.com.portovelho.upa24h.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Audited
public class MotivoAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //marcar como unico
    @NotBlank(message = "O campo Descrição é obrigatório!")
    @Size(min = 2, message = "A descrição não pode ser menor que 2 caracteres!")
    private String descricao;

    private Boolean status;

    public MotivoAtendimento() {
	this.status = true;
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

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	MotivoAtendimento other = (MotivoAtendimento) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
    
    
}
