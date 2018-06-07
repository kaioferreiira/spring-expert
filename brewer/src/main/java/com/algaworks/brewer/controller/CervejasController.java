package com.algaworks.brewer.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.model.Origem;
import com.algaworks.brewer.model.Sabor;
import com.algaworks.brewer.repository.Estilos;
import com.algaworks.brewer.service.CadastroCervejaService;

//controler
@Controller
public class CervejasController {

	//chamando interface estilos para acessar os estilos no banco
	@Autowired
	private Estilos estilos;
	
	
	@Autowired
	private CadastroCervejaService  cadastroCervejaService;
	
	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		
		ModelAndView mv =  new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores",Sabor.values()); // adicionando enum sabores 
		mv.addObject("estilos",estilos.findAll());
		mv.addObject("origens", Origem.values());
		
		return mv;
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)// 
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {

		if(result.hasErrors()) {
			//model.addAttribute("mensagem", "Erro no formulário");
			//return "cerveja/CadastroCerveja";
		return novo(cerveja);
		}
		
		/*System.out.println("Salvando cerveja ");
		System.out.println("Sku:  " + cerveja.getSku());
		System.out.println("Nome da cerveja:  " + cerveja.getNome());
		System.out.println("Decrição da cerveja:  " + cerveja.getDescricao());
		System.out.println("Sabor da cerveja:  " + cerveja.getSabor());
		System.out.println("Origem da cerveja:  " + cerveja.getOrigem());
		if (cerveja.getEstilo() != null) {
			System.out.println("Estilo da cerveja:  " + cerveja.getEstilo().getCodigo());	
		}
		*/
		
		
		cadastroCervejaService.salvar(cerveja);
		attributes.addFlashAttribute("mensagem", "Cerveja Salva om sucesso! ");
		return new ModelAndView ("redirect:/cervejas/novo");
	}
	
	@RequestMapping("/cervejas/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}
	
	
}