package com.nexus.dao;

import java.util.ArrayList;
import java.util.List;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.NFE;
import com.nexus.pojo.Pojo;
import com.nexus.pojo.Produto;
import com.nexus.pojo.Usuario;

public class ProdutoDAO  extends SuperDAO<Produto> {
	
	public List<Produto> listarTodos() {
		return parse(super.listarTodos(Produto.class));
	}
	
	public  List<Produto> pesquisa(String nome) {
		return parse(super.pesquisa(nome, Produto.class));
	}
	
	public  List<Produto> pesquisaPorCodigoBarras(String codigo) {
		Busca busca = new Busca(Produto.class);
		busca.add("codigoDeBarras", codigo, busca.IGUAL);
		return parse(busca.listarTudo());
	}
	
	public Produto salvar(Produto produto){
		try {
			return (Produto)super.salvar(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Produto> parse(List<Pojo> lsPojo){
		List<Produto> produto = new ArrayList<Produto>();
		for(Pojo pojo : lsPojo)
			produto.add((Produto) pojo);
		return produto;
	}
}
