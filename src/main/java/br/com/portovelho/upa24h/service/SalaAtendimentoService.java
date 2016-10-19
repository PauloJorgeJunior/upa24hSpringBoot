package br.com.portovelho.upa24h.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.portovelho.upa24h.model.SalaAtendimento;
import br.com.portovelho.upa24h.repository.SalaAtendimentoRepository;


@Service
public class SalaAtendimentoService {

	@Autowired
	private SalaAtendimentoRepository salaAtendimentoRepository;

	/*public List<SalaAtendimento> filtrar(SalaAtendimentoFiltro filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return salaAtendimentoRepository.findByDescricaoContainingOrderByDescricaoAsc(descricao);
	}*/

	public void salvar(SalaAtendimento salaAtendimento) {
		try {
			salaAtendimentoRepository.save(salaAtendimento);
		} catch (DataIntegrityViolationException e) {
			throw (ConstraintViolationException) e.getCause();
		}

	}

	/*public String mudarStatus(Long id) {
		SalaAtendimento salaAtendimento = salaAtendimentoRepository.findOne(id);
		if (salaAtendimento.getEmergencia()) {
			salaAtendimento.setEmergencia(false);
		} else {
			salaAtendimento.setEmergencia(true);
		}
		salaAtendimentoRepository.save(salaAtendimento);
		return "Status alterado com sucesso.";
	}*/
}
