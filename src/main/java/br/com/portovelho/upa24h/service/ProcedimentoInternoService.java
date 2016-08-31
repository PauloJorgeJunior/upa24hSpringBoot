package br.com.portovelho.upa24h.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.portovelho.upa24h.model.ProcedimentoInterno;
import br.com.portovelho.upa24h.repository.ProcedimentoInternoRepository;
import br.com.portovelho.upa24h.repository.filter.ProcedimentoInternoFiltro;


@Service
public class ProcedimentoInternoService {

	@Autowired
	private ProcedimentoInternoRepository procedimentoInternoRepository;

	public List<ProcedimentoInterno> filtrar(ProcedimentoInternoFiltro filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return procedimentoInternoRepository.findByDescricaoContainingOrderByDescricaoAsc(descricao);
	}

	public String mudarStatus(Long id) {
		ProcedimentoInterno procedimentoInterno = procedimentoInternoRepository.findOne(id);
		if (procedimentoInterno.getStatus()) {
			procedimentoInterno.setStatus(false);
		} else {
			procedimentoInterno.setStatus(true);
		}
		procedimentoInternoRepository.save(procedimentoInterno);
		return "Status alterado com sucesso.";
	}

	public void salvar(ProcedimentoInterno procedimentoInterno) {
		try {
			procedimentoInternoRepository.save(procedimentoInterno);
		} catch (DataIntegrityViolationException e) {
			throw (ConstraintViolationException) e.getCause();
		}
	}
}
