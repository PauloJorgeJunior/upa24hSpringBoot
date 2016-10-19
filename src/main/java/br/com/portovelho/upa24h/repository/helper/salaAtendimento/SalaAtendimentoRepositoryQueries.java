package br.com.portovelho.upa24h.repository.helper.salaAtendimento;

import java.util.List;

import br.com.portovelho.upa24h.model.SalaAtendimento;
import br.com.portovelho.upa24h.repository.filter.SalaAtendimentoFiltro;

public interface SalaAtendimentoRepositoryQueries {

	public List<SalaAtendimento> filtrar(SalaAtendimentoFiltro filtro);

}
