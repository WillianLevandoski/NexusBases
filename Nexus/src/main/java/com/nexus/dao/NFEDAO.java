package com.nexus.dao;

import com.nexus.exception.UsuarioException;
import com.nexus.pojo.NFE;
import com.nexus.pojo.Usuario;

public class NFEDAO extends SuperDAO<Usuario> {
	
	
	public NFE salvar(NFE nfe)throws UsuarioException {
		return (NFE)super.salvar(nfe);
	}

	public static NFE obter(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
