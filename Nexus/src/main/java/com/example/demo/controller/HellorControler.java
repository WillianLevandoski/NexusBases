package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HellorControler {
	
	@GetMapping({"/", "/hello"})
	public String hello(@RequestParam(value = "name", defaultValue = "World", required = true)String name,@RequestParam(value = "senha", defaultValue = "World", required = true)String senha, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("pass", senha);
		return "hello";
	}

}
