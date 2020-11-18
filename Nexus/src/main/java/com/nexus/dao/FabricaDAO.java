package com.nexus.dao;

public class FabricaDAO {
	
	private static UsuarioDAO UsuarioDAO;
	
	public static UsuarioDAO getUsuarioDAO() {
		if (UsuarioDAO == null)
			UsuarioDAO = new UsuarioDAO();
		return UsuarioDAO;
	}
	

}
