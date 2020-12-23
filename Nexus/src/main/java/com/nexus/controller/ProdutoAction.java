package com.nexus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nexus.dao.ProdutoDAO;
import com.nexus.dao.UsuarioDAO;
import com.nexus.pojo.Produto;
import com.nexus.pojo.Usuario;
import com.nexus.utils.Utils;

@Controller
public class ProdutoAction {
	
	@RequestMapping(value = "/pesquisarProduto")
	public String consultar(@RequestParam(value = "pesquisarProduto") String pesquisa, Model model) {
		if (Utils.isPreenchido(pesquisa)) {
			List<Produto> lsProduto = pesquisaPorNomeOuCodigoDeBarras(pesquisa);
			model.addAttribute("lsProduto", lsProduto);
		} else {
			List<Produto> lsProduto = new ProdutoDAO().listarTodos();
			model.addAttribute("lsProduto", lsProduto);
		}
		return "produto/consultarProduto";
	}

	private List<Produto> pesquisaPorNomeOuCodigoDeBarras(String pesquisa) {
		List<Produto> lsProduto;
		if (Utils.isNumero(pesquisa)) {
			lsProduto = new ProdutoDAO().pesquisaPorCodigoBarras(pesquisa);
		} else {
			lsProduto = new ProdutoDAO().pesquisa(pesquisa);
		}
		return lsProduto;
	}

}
