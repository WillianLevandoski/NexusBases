package com.nexus.utils;

import java.util.LinkedHashMap;

public class Busca {
	
	LinkedHashMap<String, String> busca = new LinkedHashMap<String, String>();
	

	public void busca(Class<Object> clazz) {
		String classe = clazz.getName();
		busca = new LinkedHashMap<String, String>();
		busca.put("clazz", classe);
	}
	
	public void add(String chave, String valor) {
		busca.put(chave, valor);
	}
	
	public Busca getBusca(){
		return this;
	}
	
}
