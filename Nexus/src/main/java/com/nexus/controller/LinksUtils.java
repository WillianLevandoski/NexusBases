package com.nexus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LinksUtils {
	
	/*
	 Cadastro
	 */
	
	@GetMapping({"/cadastroUsuario"})
	public String cadastroUsuario() {
		return "usuario/cadastroUsuario";
	}
	
	@GetMapping({"/cadastroGrupo"})
	public String cadastroGrupo() {
		return "grupo/cadastroGrupo";
	}
	
	@GetMapping({"/cadastroFornecedor"})
	public String cadastroFornecedor() {
		return "fornecedor/cadastroFornecedor";
	}
	
	@GetMapping({"/cadastroProduto"})
	public String cadastroProduto() {
		return "produto/cadastroProduto";
	}
	
	@GetMapping({"/cadastroUsuarioExterno"})
	public String cadastroUsuarioExterno() {
		return "usuario/cadastroUsuarioExterno";
	}
	
	/*
	 Consulta
	 */
	@GetMapping({"/consultaUsuario"})
	public String consultarUsuario() {
		return "usuario/consultarUsuario";
	}
	
	@GetMapping({"/consultaGrupo"})
	public String consultarGrupo() {
		return "grupo/consultarGrupo";
	}
	
	@GetMapping({"/consultaFornecedor"})
	public String consultarFornecedor() {
		return "fornecedor/consultarFornecedor";
	}
	
	@GetMapping({"/consultaProduto"})
	public String consultarProduto() {
		return "produto/consultarProduto";
	}

	
	/*
	 Outros
	 */
	@GetMapping({"/sucesso"})
	public static String sucesso(HttpSession session, String msgSucesso) {
		session.setAttribute("msgSucesso", msgSucesso);
		return "utils/sucesso";
	}
	
	@GetMapping({"/menu"})
	public String menu() {
		return "menu";
	}

}
