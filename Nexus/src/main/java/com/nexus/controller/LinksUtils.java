package com.nexus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinksUtils {
	
	@GetMapping({"/cadastroUsuario"})
	public String cadastroUsuario() {
		return "cadastroUsuario";
	}
	
	@GetMapping({"/cadastroUsuarioExterno"})
	public String cadastroUsuarioExterno() {
		return "cadastroUsuarioExterno";
	}
	
	@GetMapping({"/menu"})
	public String menu() {
		return "menu";
	}

}
