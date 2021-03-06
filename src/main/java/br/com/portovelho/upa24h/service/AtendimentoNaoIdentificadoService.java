package br.com.portovelho.upa24h.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portovelho.upa24h.enums.StatusAtendimento;
import br.com.portovelho.upa24h.model.AtendimentoNaoIdentificado;
import br.com.portovelho.upa24h.repository.AtendimentoNaoIdentificadoRepository;
import br.com.portovelho.upa24h.repository.filter.AtendimentoNaoIdentificadoFiltro;
import br.com.portovelho.upa24h.util.MensagemDeErro;


@Service
public class AtendimentoNaoIdentificadoService {

	@Autowired
	private AtendimentoNaoIdentificadoRepository atendimentoNaoIdentificadoRepository;

	public List<AtendimentoNaoIdentificado> filtrar(AtendimentoNaoIdentificadoFiltro filtro) {
		String descricao = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		return atendimentoNaoIdentificadoRepository.findBySenhaContainingOrderBySenhaAsc(descricao);
	}

	public MensagemDeErro salvar(AtendimentoNaoIdentificado atendimentoNaoIdentificado) {
		MensagemDeErro mensagemDeErro = new MensagemDeErro();
		try {
			/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
			String dataFormatada = sdf.format(hora);*/
		
			
			atendimentoNaoIdentificado.setCriadoEm(Calendar.getInstance().getTime());
			
			atendimentoNaoIdentificado.setStatusAtendimento(StatusAtendimento.ABERTO);
			
			atendimentoNaoIdentificado.setProcedenciaDoFato(atendimentoNaoIdentificado.getProcedenciaDoFato().trim());
			atendimentoNaoIdentificado.setResponsavelPaciente(atendimentoNaoIdentificado.getResponsavelPaciente().trim());
			atendimentoNaoIdentificado.setSenha(atendimentoNaoIdentificado.getSenha().trim());
			
			atendimentoNaoIdentificadoRepository.save(atendimentoNaoIdentificado);
		} catch (Exception e) {
			mensagemDeErro.setMensagem("Erro ao cadastrar: " + e.getMessage());
			mensagemDeErro.setErro(true);
			return mensagemDeErro;
		}
		mensagemDeErro.setMensagem("Atendimento não identificado cadastrado com sucesso.");
		mensagemDeErro.setErro(false);
		return mensagemDeErro;
	}
}
