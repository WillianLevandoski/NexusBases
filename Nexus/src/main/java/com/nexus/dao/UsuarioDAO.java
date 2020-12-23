package com.nexus.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Fornecedor;
import com.nexus.pojo.Pojo;
import com.nexus.pojo.Usuario;


public class UsuarioDAO extends SuperDAO<Usuario> {
	
	public List<Usuario> listarTodos() {
		return parse(super.listarTodos(Usuario.class));
	}

	//Rever
	public Usuario cadastrar(Usuario u)throws UsuarioException {
		return (Usuario)super.salvar(u);
	}
	
	public  List<Usuario> pesquisa(String nome) {
		return parse(super.pesquisa(nome, Usuario.class));
	}
	
	public Usuario obter(Integer id) {
		Busca busca = new Busca(Usuario.class);
		busca.add(id);
		return   (Usuario) busca.obter();
	}
	
	public Usuario getUsuarioPorEmailESenha(String email, String senha) {
		Busca busca = new Busca(Usuario.class);
		busca.add("email", email);
		busca.add("senha", senha);
		return   (Usuario) busca.obter();
	}

	
	public List<Usuario> parse(List<Pojo> lsPojo){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for(Pojo pojo : lsPojo)
			usuarios.add((Usuario) pojo);
		return usuarios;
	}

}