package br.com.portovelho.upa24h.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portovelho.upa24h.model.MotivoAtendimento;
import br.com.portovelho.upa24h.repository.MotivosAtendimentoRepository;
import br.com.portovelho.upa24h.repository.filter.MotivoAtendimentoFiltro;
import br.com.portovelho.upa24h.util.MensagemDeErro;


@Service
public class MotivoAtendimentoService {

	@Autowired
	private MotivosAtendimentoRepository motivosAtendimentoRepository;

	public List<MotivoAtendimento> filtrar(MotivoAtendimentoFiltro filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return motivosAtendimentoRepository.findByDescricaoContainingOrderByDescricaoAsc(descricao);
	}

	public MensagemDeErro salvar(MotivoAtendimento motivoAtendimento) {
		MensagemDeErro mensagem = new MensagemDeErro();
		MotivoAtendimento motivo = motivosAtendimentoRepository.findByDescricao(motivoAtendimento.getDescricao());
		if (motivo != null) {
			mensagem.setMensagem("Já existe um motivo do atendimento com essa descrição!");
			mensagem.setErro(true);
		} else {
			motivosAtendimentoRepository.save(motivoAtendimento);
			mensagem.setMensagem("Motivo de atendimento salvo com sucesso!");
			mensagem.setErro(false);
		}
		return mensagem;
	}

	public String mudarStatus(Long id) {
		MotivoAtendimento motivoAtendimento = motivosAtendimentoRepository.findOne(id);
		if (motivoAtendimento.getStatus()) {
			motivoAtendimento.setStatus(false);
		} else {
			motivoAtendimento.setStatus(true);
		}
		motivosAtendimentoRepository.save(motivoAtendimento);
		return "Status alterado com sucesso.";
	}

}
