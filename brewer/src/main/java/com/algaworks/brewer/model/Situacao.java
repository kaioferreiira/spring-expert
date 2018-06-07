package com.algaworks.brewer.model;


public enum Situacao {

    EMBRANCO("Em branco"),
    FORMASDEANULACAO("Formas de Anulação"),
    TEXTOINSUFICIENTE("Texto Insuficiente"),
    FUGAAOTEMA("Fuga ao Tema"),
    NAOATENDIMENTOAOTIPOTEXTUAL("Não atendimento ao tipo textual"),
    PARTEDESCONECTADA("Parte desconectada");

    private String situacao;


    Situacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }
}
