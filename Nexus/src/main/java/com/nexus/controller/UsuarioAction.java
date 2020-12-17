package com.nexus.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nexus.dao.UsuarioDAO;
import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Grupo;
import com.nexus.pojo.Usuario;
import com.nexus.utils.Utils;


@Controller
public class UsuarioAction  {
	
		@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
		public String cadastrarUsuario(@RequestParam(value = "nome") String nome,  @RequestParam(value = "email") String email ,@RequestParam(value = "senha") String senha,Model model, HttpSession session) {
			try {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			//usuario.setGrupo(new Grupo());
			Usuario novoUsuario = new UsuarioDAO().cadastrar(usuario);
			if(novoUsuario!= null) {
				return "cadastrarUsuario";
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "cadastrarUsuario";
		}
		
		@RequestMapping(value = "/cadastrarUsuarioExterno", method = RequestMethod.POST)
		public String cadastrarUsuarioExterno(@RequestParam(value = "nome") String nome,  @RequestParam(value = "email") String email ,@RequestParam(value = "senha") String senha,Model model, HttpSession session) {
			try {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			//usuario.setGrupo(99);
			Usuario novoUsuario = new UsuarioDAO().cadastrar(usuario);
			if(novoUsuario!= null) {
				return  LinksUtils.sucesso(session, "Conta criada com sucesso");
			}
			} catch (Exception e) {
				e.printStackTrace();
				return  LinksUtils.sucesso(session, "Erro ao criar conta");
			}
			return "login";
		}
		
		@RequestMapping(value = "/pesquisarUsuario")
		public String consultar( @RequestParam(value = "pesquisarUsuario") String pesquisa, Model model) {
			if(Utils.isPreenchido(pesquisa)) {
				List<Usuario> lsUsuario	= new UsuarioDAO().pesquisa(pesquisa);
				model.addAttribute("lsUsuario", lsUsuario);
			}else {
				List<Usuario> lsUsuario	= new UsuarioDAO().listarTodos();
				model.addAttribute("lsUsuario", lsUsuario);
			}
			return "usuario/consultarUsuario";
		}
		
}
