package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.my.spring.dao.UsuarioDAO;
import com.my.spring.exception.UsuarioException;
import com.my.spring.pojo.Usuario;

@SpringBootApplication
public class NexusApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexusApplication.class, args);
		try {
			run();
		} catch (UsuarioException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void run() throws UsuarioException {
		
		UsuarioDAO ud = new UsuarioDAO();
		Usuario u = ud.get(1);
		System.out.println(u.getNome());
		
		for(Usuario usuario : ud.listarTodos()) {
			System.out.println(usuario.getNome());
			
		}
		
		
		System.out.println("Finished Testing...");

		
	}

}
