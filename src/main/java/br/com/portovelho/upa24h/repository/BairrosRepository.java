package br.com.portovelho.upa24h.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.portovelho.upa24h.model.Bairro;


public interface BairrosRepository extends JpaRepository<Bairro, Long> {
	public List<Bairro> findAllByOrderByNomeAsc();

	public List<Bairro> findByNomeContainingOrderByNomeAsc(String nome);
}
