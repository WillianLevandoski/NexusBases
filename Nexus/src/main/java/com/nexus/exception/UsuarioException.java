package com.nexus.exception;

public class UsuarioException extends Exception {

	public UsuarioException(String message)
	{
		super("UserException-"+message);
	}
	
	public UsuarioException(String message, Throwable cause) {
		super("UsuarioException-" + message, cause);
	}

}
