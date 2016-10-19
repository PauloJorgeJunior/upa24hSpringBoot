package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.CBO;

public interface CboRepository extends JpaRepository<CBO, Long>{

	public List<CBO> findAllByOrderByDescricaoAsc();

	public List<CBO> findByDescricaoContainingOrderByDescricaoAsc(String descricao);
}
