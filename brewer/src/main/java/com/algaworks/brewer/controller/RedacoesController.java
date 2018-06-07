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

import com.algaworks.brewer.model.Competencia1;
import com.algaworks.brewer.model.Competencia2;
import com.algaworks.brewer.model.Competencia3;
import com.algaworks.brewer.model.Competencia4;
import com.algaworks.brewer.model.Competencia5;
import com.algaworks.brewer.model.Redacao;
import com.algaworks.brewer.model.Situacao;
import com.algaworks.brewer.service.CadastroRedacaoService;

@Controller
public class RedacoesController {

	
	//injetando Autowired  para salvar os dados
	@Autowired
	private CadastroRedacaoService  cadastroRedacaoService;
	
	/* colocando objeto redacao na view*/
	@RequestMapping("/redacoes/novo")
	public ModelAndView novo(Redacao redacao) {
		ModelAndView mv = new ModelAndView("redacao/CorrecaoRedacao");
		
		//adicionando lista de redacao e enviando para a view
		mv.addObject("competencia1", Competencia1.values());
		mv.addObject("competencia2", Competencia2.values());
		mv.addObject("competencia3", Competencia3.values());
		mv.addObject("competencia4", Competencia4.values());
		mv.addObject("competencia5", Competencia5.values());
		mv.addObject("situacao", Situacao.values());
		
		//retornando tudo para a view
		return mv;
	}
	
	
	@RequestMapping(value = "/redacoes/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Redacao redacao, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(redacao);
		}
		
		
		/*System.out.println(">>> descrição: "  + redacao.getDescricao() );
		System.out.println("Competencia selecionada " + redacao.getCompetencia1().getNota());
		System.out.println("Competencia selecionada " + redacao.getCompetencia2().getNota());
		System.out.println("Competencia selecionada " + redacao.getCompetencia3().getNota());
		System.out.println("Competencia selecionada " + redacao.getCompetencia4().getNota());
		System.out.println("Competencia selecionada " + redacao.getCompetencia5().getNota());
		*/
		
		String valor1 =  redacao.getCompetencia1().getNota();
        String valor2 =  redacao.getCompetencia2().getNota();
        String valor3 =  redacao.getCompetencia3().getNota();
        String valor4 =  redacao.getCompetencia4().getNota();
        String valor5 =  redacao.getCompetencia5().getNota();

        int  v1 = Integer.parseInt(valor1);
        int  v2 = Integer.parseInt(valor2);
        int  v3  = Integer.parseInt(valor3) ;
        int  v4  = Integer.parseInt(valor4) ;
        int  v5  = Integer.parseInt(valor5) ;
        int total = 0;
        /*System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);*/
        
        total = v1+v2+v3+v4+v5;
        
       switch (redacao.getSituacao()) {
       	case EMBRANCO: case FORMASDEANULACAO: case TEXTOINSUFICIENTE: case FUGAAOTEMA: case NAOATENDIMENTOAOTIPOTEXTUAL: case PARTEDESCONECTADA:
       		total = 0;
		break;
       	default:
            System.out.println("total com valor");
		break;
       }
       
       System.out.println(total);
       System.out.println(">>> descrição: "  + redacao.getDescricao() );
       System.out.println(">>> situação: "  + redacao.getSituacao());
        
       
       
       //salavndo no banco de dados atraves do serviço
        redacao.setTotal(total);
        cadastroRedacaoService.salvar(redacao);
		
		//attributs para mensagem de sucesso!
		attributes.addFlashAttribute("mensagem", "Redação corrigida com sucesso! ");
		
		return new ModelAndView("redirect:/redacoes/novo");
	}
}
