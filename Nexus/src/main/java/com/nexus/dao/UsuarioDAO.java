package com.nexus.dao;

import java.util.List;
import java.util.Optional;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Usuario;


public class UsuarioDAO extends SuperDAO<Usuario> {
	
	
	
	public List<Usuario> listarTodos() {
		return super.listarTodos();
	}
	
	public  List<Usuario> pesquisa(String nome) {
		return super.pesquisa(nome);
	}

	public Usuario register(Usuario u)throws UsuarioException {
		return super.register(u);
	}

	public Optional<Usuario> getUsuarioPorEmailESenha(String email, String senha){
		return super.getUsuarioPorEmailESenha(email, senha);
	}
	
}