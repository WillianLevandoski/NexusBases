package com.nexus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nexus.dao.UsuarioDAO;
import com.nexus.pojo.Usuario;


@Controller
public class LoginAction {
    UsuarioDAO dao = new UsuarioDAO();

    @GetMapping({"/", "/login"})
	public String hello() {
		return "login";
	} 
	
	@RequestMapping(value = "/inicial", method = RequestMethod.POST)

	public String efetuaLogin(@RequestParam(value = "email") String nome, @RequestParam(value = "senha") String senha,
			Model model, HttpSession session) {
		try {
			// TODO Validar nome e senha
			Usuario usuario = new UsuarioDAO().getUsuarioPorNomeESenha(nome, senha).get();
			if (usuario != null) {
				setSessao(usuario, session);
				return "inicial";
			} else {
				//Logar quando usuário errar senha
				
		        session.setAttribute("erroAologar", "Usário ou Senha Inválidos");
				return "inicial";
			}

		} catch (Exception e) {
	        session.setAttribute("erroAologar", "Usário ou Senha Inválidos");
			return "inicial";
		}
	}

	public void setSessao(Usuario usuario, HttpSession session) {
	          session.setAttribute("usuarioLogado", usuario);
	      }
	
    
	@GetMapping({"/dashboard"})
	public String dashboard() {
		return "dashboard";
	}

}
