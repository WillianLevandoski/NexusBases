package com.nexus.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Utils {
	
	public static boolean validarEmail(String email) {
		// TODO Validar nome e senha
		return true;
	}
	
	public static void enviarEmail(String msg, String assunto, String usuario, String senha) throws EmailException{		
	     SimpleEmail email= new SimpleEmail();
           email.setHostName("smtp.googlemail.com");
           email.setSmtpPort(465);
           email.setAuthentication(usuario, senha);
           email.setSSL(true);
           email.setSubject(assunto);
           email.setMsg(msg);
           email.send();
	}

	public static boolean isPreenchido(String str) {
		return str!= null && !str.trim().contentEquals("")?true:false;
	}

	public static boolean isNumero(String pesquisa) {
		String regex =  "[0-9]+"; // Apenas número
		return isRegex(pesquisa, regex);
	}

	private static boolean isRegex(String pesquisa, String regex) {
		Pattern pattern = Pattern.compile(regex);
        return Pattern.matches(regex, pesquisa);
	}
	
	public static Double getDouble(String str) {
		if(isPreenchido(str)) {
		Double valor = Double.valueOf(str);
			return valor;
		}
		return null;
	}
	
	public static Double getDoubleNotNull(String str) {
		Double valor = getDouble(str);
		if (valor != null)
			return valor;
		return Double.valueOf(0.00);
	}
	
	public static Integer extractValor(String valor) {
		if (isPreenchido(valor)) {
			if (valor.contains(".")) {
				String[] valores = valor.split("\\.");
				if (valores[0] != null)
					return getInteger(valores[0]);
			}
		}
		return null;
	}
	
	public static Integer getInteger(String str) {
		if(isPreenchido(str) && isNumero(str)) {
			return Integer.valueOf(str);
		}
		return null;
	}
	
	public static Integer getIntegerNotNull(String str) {
		Integer inteiro = getInteger(str);
		return inteiro!= null ? inteiro : 0;
	}

}
