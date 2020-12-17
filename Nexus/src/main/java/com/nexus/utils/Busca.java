package com.nexus.utils;

import java.util.LinkedHashMap;

import com.nexus.pojo.Usuario;

public class Busca {
	
	LinkedHashMap<String, String> busca = new LinkedHashMap<String, String>();
	
	public Busca(Class<?>  clazz) {
		String classe = clazz.getName();
		busca = new LinkedHashMap<String, String>();
		busca.put("clazz", classe);
	}
	
	public void add(String chave, String valor) {
		busca.put(chave, valor);
	}
	
	public LinkedHashMap<String, String> getBusca(){
		return busca;
	}
	
}
