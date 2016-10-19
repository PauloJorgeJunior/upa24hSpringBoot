package br.com.portovelho.upa24h.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portovelho.upa24h.model.AtendimentoIdentificado;
import br.com.portovelho.upa24h.repository.PacientesRepository;
import br.com.portovelho.upa24h.repository.filter.AtendimentoIdentificadoFiltro;


@Service
public class AtendimentoIdentificadoService {

	/*@Autowired
	private AtendimentoIdentificadoRepository atendimentoIdentificadoRepository;*/
	
	@Autowired
	private PacientesRepository pacientesRepository;

	public List<AtendimentoIdentificado> filtrar(AtendimentoIdentificadoFiltro filtro) {
		String nome = filtro.getNomeCompleto() == null ? "%" : filtro.getNomeCompleto();
		return pacientesRepository.findByNomeCompletoContainingOrderByNomeCompletoAsc(nome);
	}
}
