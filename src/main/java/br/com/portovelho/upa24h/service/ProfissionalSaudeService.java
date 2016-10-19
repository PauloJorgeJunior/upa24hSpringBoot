package br.com.portovelho.upa24h.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.portovelho.upa24h.model.ProfissionalSaude;
import br.com.portovelho.upa24h.repository.ProfissionalSaudeRepository;


@Service
public class ProfissionalSaudeService {

	@Autowired
	private ProfissionalSaudeRepository profissionalSaudeRepository;

	/*
	 * @Autowired private CboRepository cboRepository;
	 */

	/*public List<ProfissionalSaude> buscarTodos() {

		return profissionalSaudeRepository.findAllByOrderByNomeCompletoAsc();

	}*/

	public void salvar(ProfissionalSaude profissionalSaude) {
		profissionalSaudeRepository.save(profissionalSaude);
	}

	public String mudarStatus(Long id) {
		ProfissionalSaude profissionalSaude = profissionalSaudeRepository.findOne(id);
		if (profissionalSaude.getAtivo()) {
			profissionalSaude.setAtivo(false);
		} else {
			profissionalSaude.setAtivo(true);
		}
		profissionalSaudeRepository.save(profissionalSaude);
		return "Status alterado com sucesso.";
	}

	/*public List<ProfissionalSaude> filtrar(ProfissionalSaudeFiltro filtro) {
		String nomeCompleto = filtro.getNomeCompleto() == null ? "%" : filtro.getNomeCompleto();
		return profissionalSaudeRepository.findByNomeCompletoContainingOrderByNomeCompletoAsc(nomeCompleto);
	}*/
}
