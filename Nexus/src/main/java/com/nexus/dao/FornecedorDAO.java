package com.nexus.dao;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.Fornecedor;
import com.nexus.pojo.NFE;
import com.nexus.pojo.Usuario;

public class FornecedorDAO   extends SuperDAO<Fornecedor> {
	
	public Fornecedor obter(Integer id) {
		Busca busca = new Busca(Fornecedor.class);
		busca.add(id);
		return   (Fornecedor) busca.obter();
	}
	
	public Fornecedor salvar(Fornecedor fornecedor) throws UsuarioException {
		return (Fornecedor) super.salvar(fornecedor);
	}

	public Fornecedor obter(String cnpj) {
		Busca busca = new Busca(Usuario.class);
		busca.add("cnpj", cnpj);
		return   (Fornecedor) busca.obter();
	}



}
