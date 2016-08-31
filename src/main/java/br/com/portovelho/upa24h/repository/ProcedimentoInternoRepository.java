package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.ProcedimentoInterno;

public interface ProcedimentoInternoRepository extends JpaRepository<ProcedimentoInterno, Long> {

	List<ProcedimentoInterno> findByDescricaoContainingOrderByDescricaoAsc(String descricao);

	ProcedimentoInterno findByDescricaoOrCodigo(String descricao, String codigo);
}
