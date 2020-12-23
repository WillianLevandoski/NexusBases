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
import com.nexus.utils.Utils;

@Controller
public class LoginAction {

	@GetMapping({ "/", "/login" })
	public String hello() {
		return "login";
	}

	@RequestMapping(value = "/inicial", method = {RequestMethod.POST, RequestMethod.GET})
	public String efetuaLogin(@RequestParam(value = "email") String email, @RequestParam(value = "senha") String senha,Model model, HttpSession session) {
		try {
			if (Utils.validarEmail(email)) {
				Usuario usuario = new UsuarioDAO().getUsuarioPorEmailESenha(email, senha);
				if (usuario != null) {
					setSessao(usuario, session);
					return "inicial";
				} else {
					return erroAoLogar(session);
				}
			}
		} catch (Exception e) {
			return erroAoLogar(session);
		}
		return erroAoLogar(session);
	}
	
	@RequestMapping(value = "/deslogar", method =  RequestMethod.GET)
	public String deslogar(HttpSession session) {
		removerSessao(session);
		return "login";

	}
	
	private void removerSessao(HttpSession session) {
		if(session.getAttribute("usuarioLogado")!= null) {
			session.removeAttribute("usuarioLogado");
		}else {
			session.setAttribute("usuarioLogado", null);
		}
	}

	private String erroAoLogar(HttpSession session) {
		session.setAttribute("erroAologar", "Usário ou Senha Inválidos");
		return "login";
	}

	public void setSessao(Usuario usuario, HttpSession session) {
		session.setAttribute("usuarioLogado", usuario);
		session.setAttribute("erroAologar", "");
	}

	@GetMapping({ "/dashboard" })
	public String dashboard() {
		return "dashboard";
	}

}
