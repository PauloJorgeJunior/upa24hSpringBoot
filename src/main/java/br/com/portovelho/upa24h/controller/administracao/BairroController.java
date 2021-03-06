package br.com.portovelho.upa24h.controller.administracao;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.portovelho.upa24h.model.Bairro;
import br.com.portovelho.upa24h.model.Municipio;
import br.com.portovelho.upa24h.model.UF;
import br.com.portovelho.upa24h.repository.MunicipiosRepository;
import br.com.portovelho.upa24h.repository.UfsRepository;
import br.com.portovelho.upa24h.repository.filter.BairroFiltro;
import br.com.portovelho.upa24h.service.BairroService;

@Controller
@RequestMapping("/administracao/bairro")
public class BairroController {

	private static final String BAIRRO_CAD_VIEW = "/administracao/bairro/CadastroBairro";
	private static final String BAIRRO_PESQUISA_VIEW = "/administracao/bairro/PesquisaBairro";

	@Autowired
	private MunicipiosRepository municipiosRepository;

	@Autowired
	private BairroService bairroService;

	@Autowired
	private UfsRepository ufsRepository;

	@ModelAttribute("todosUfs")
	public List<UF> todosUfs() {
		return ufsRepository.findAllByOrderByNome();
	}

	@ModelAttribute("todosMunicipios")
	public List<Municipio> todosMunicipios() {
		return municipiosRepository.findAllByOrderByNome();
	}

	@RequestMapping
	public ModelAndView listaBairro(@ModelAttribute("filtro") BairroFiltro filtro) {
		ModelAndView mv = new ModelAndView(BAIRRO_PESQUISA_VIEW);
		mv.addObject("bairros", bairroService.filtrar(filtro));
		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView novoBairro() {
		ModelAndView mv = new ModelAndView(BAIRRO_CAD_VIEW);
		mv.addObject(new Bairro());
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public String salvarBairro(@Validated Bairro bairro, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return BAIRRO_CAD_VIEW;
		}
		try {
			bairroService.salvar(bairro);
			attributes.addFlashAttribute("mensagem", "Bairro salvo com sucesso.");
			return "redirect:/administracao/bairro/novo";
		} catch (ConstraintViolationException e) {
			errors.rejectValue("nome", null, "Já existe uma cidade com esse nome nesse município!");
			return BAIRRO_CAD_VIEW;
		}
	}

	@RequestMapping("/{id}")
	public ModelAndView edicaoBairro(@PathVariable("id") Bairro bairro) {
		ModelAndView mv = new ModelAndView(BAIRRO_CAD_VIEW);
		mv.addObject(bairro);
		return mv;
	}

	@RequestMapping(value = "/{id}/status", method = RequestMethod.PUT)
	public @ResponseBody String mudaStatusBairro(@PathVariable Long id) {
		return bairroService.mudarStatus(id);
	}
}
