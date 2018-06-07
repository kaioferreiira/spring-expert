package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EstudantesController {

	@RequestMapping("/estudantes/novo")
	public String novo() {
		return "estudante/CadastroEstudante";
	}
}
