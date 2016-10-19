package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.AtendimentoNaoIdentificado;


public interface AtendimentoNaoIdentificadoRepository extends JpaRepository<AtendimentoNaoIdentificado, Long> {

	List<AtendimentoNaoIdentificado> findBySenhaContainingOrderBySenhaAsc(String descricao);
}
