package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.AtendimentoIdentificado;
import br.com.portovelho.upa24h.model.Paciente;


public interface PacientesRepository extends JpaRepository<Paciente, Long>{

	List<AtendimentoIdentificado> findByNomeCompletoContainingOrderByNomeCompletoAsc(String nome);

}
