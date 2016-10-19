package br.com.portovelho.upa24h.repository.helper.profissionalSaude;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.portovelho.upa24h.model.ProfissionalSaude;
import br.com.portovelho.upa24h.repository.filter.ProfissionalSaudeFiltro;

public interface ProfissionalSaudeRepositoryQueries {

	public Page<ProfissionalSaude> filtrar(ProfissionalSaudeFiltro filtro, Pageable pageable);

}
