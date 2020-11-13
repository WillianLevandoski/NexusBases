package com.nexus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinksUtils {
	
	@GetMapping({"/cadastroUsuario"})
	public String cadastroUsuario() {
		return "usuario/cadastroUsuario";
	}
	
	@GetMapping({"/cadastroUsuarioExterno"})
	public String cadastroUsuarioExterno() {
		return "usuario/cadastroUsuarioExterno";
	}
	
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
