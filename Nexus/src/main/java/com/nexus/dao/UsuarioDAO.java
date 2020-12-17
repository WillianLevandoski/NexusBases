package com.nexus.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Pojo;
import com.nexus.pojo.Usuario;


public class UsuarioDAO extends SuperDAO<Usuario> {
	
	public List<Usuario> listarTodos() {
		return parse(super.listarTodos(Usuario.class));
	}

	public Usuario cadastrar(Usuario u)throws UsuarioException {
		return super.cadastrar(u);
	}

	public Optional<Usuario> getUsuarioPorEmailESenha(String email, String senha){
		return super.getUsuarioPorEmailESenha(email, senha);
	}
	
	public  List<Usuario> pesquisa(String nome) {
		return parse(super.pesquisa(nome, Usuario.class));
	}
	
	public List<Usuario> parse(List<Pojo> lsPojo){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for(Pojo pojo : lsPojo)
			usuarios.add((Usuario) pojo);
		return usuarios;
	}
	
}