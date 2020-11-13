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
import com.nexus.pojo.Usuario;
import com.nexus.utils.Utils;


@Controller
public class UsuarioAction  {
	
		@GetMapping({"/usuario"})
		public String hello(@RequestParam(value = "name", defaultValue = "World", required = true)String name,@RequestParam(value = "senha", defaultValue = "World", required = true)String senha, Model model) {
			model.addAttribute("name", name);
			model.addAttribute("pass", senha);
			return "usuario";
		}
		
		@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
		public String cadastrarUsuario(@RequestParam(value = "nome") String nome,  @RequestParam(value = "email") String email ,@RequestParam(value = "senha") String senha,Model model, HttpSession session) {
			try {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setNivel(2);
			Usuario novoUsuario = new UsuarioDAO().register(usuario);
			if(novoUsuario!= null) {
				return "cadastrarUsuario";
			}
			} catch (Exception e) {
				// TODO: handle exception
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
			usuario.setNivel(99);
			Usuario novoUsuario = new UsuarioDAO().register(usuario);
			if(novoUsuario!= null) {
				return  LinksUtils.sucesso(session, "Conta criada com sucesso");
			}
			} catch (Exception e) {
				e.printStackTrace();
				return  LinksUtils.sucesso(session, "Erro ao criar conta");
			}
			return "login";
		}
		
		@RequestMapping(value = "/consultaUsuario")
		public String consultar( Model model) {
			List<Usuario> lsUsuario	= new UsuarioDAO().listarTodos();
			model.addAttribute("lsUsuario", lsUsuario);
			return "consultarUsuario";
		}
		
}
