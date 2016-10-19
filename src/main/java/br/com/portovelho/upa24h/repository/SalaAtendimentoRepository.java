package br.com.portovelho.upa24h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portovelho.upa24h.model.SalaAtendimento;
import br.com.portovelho.upa24h.repository.helper.salaAtendimento.SalaAtendimentoRepositoryQueries;

@Repository
public interface SalaAtendimentoRepository extends JpaRepository<SalaAtendimento, Long>, SalaAtendimentoRepositoryQueries{
}
