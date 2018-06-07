package com.algaworks.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.brewer.model.Redacao;
import com.algaworks.brewer.repository.Redacoes;

@Service
public class CadastroRedacaoService {

	@Autowired
	private Redacoes redacoes;
	
	@Transactional
	public void salvar(Redacao redacao) {
		
		redacoes.save(redacao);
	}
	
}
