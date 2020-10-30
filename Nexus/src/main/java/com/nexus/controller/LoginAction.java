package com.nexus.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nexus.dao.UsuarioDAO;
import com.nexus.pojo.Usuario;


@Controller
public class LoginAction {

	private Usuario usuario;
    private UserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;
    UsuarioDAO dao = new UsuarioDAO();

    
	@GetMapping({"/login"})
	public String hello() {
		return "login";
	}
	
	@RequestMapping("/efetuaLogin")
	public String efetuaLogin(@RequestParam(value = "nome") String nome, @RequestParam(value = "senha") String senha,
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
				return "login";
			}

		} catch (Exception e) {
	        session.setAttribute("erroAologar", "Usário ou Senha Inválidos");
			return "login";
		}

	}
	  
	  private Object loginInvalido() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSessao(Usuario usuario, HttpSession session) {
	          session.setAttribute("usuarioLogado", usuario);
	      }

}
