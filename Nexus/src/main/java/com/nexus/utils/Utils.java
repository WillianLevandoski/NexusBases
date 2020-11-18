package com.nexus.utils;

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

}
