package br.com.portovelho.upa24h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @RequestMapping("/novo")
	public String novo() {
		return "/produto/cadastro-produto";
	}
	
	@RequestMapping
	public String pesquisa() {
		return "/produto/PesquisaProdutos";
	}
}
