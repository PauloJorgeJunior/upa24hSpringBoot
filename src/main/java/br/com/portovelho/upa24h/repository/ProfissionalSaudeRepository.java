package br.com.portovelho.upa24h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.portovelho.upa24h.model.ProfissionalSaude;
import br.com.portovelho.upa24h.repository.helper.profissionalSaude.ProfissionalSaudeRepositoryQueries;

@Repository
public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaude, Long>,ProfissionalSaudeRepositoryQueries{

}
