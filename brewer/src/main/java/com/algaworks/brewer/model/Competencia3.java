package com.algaworks.brewer.model;




public enum Competencia3 {

    ZERO("0"),
    UM("20"),
    DOIS("40"),
    TRES("60"),
    QUATRO("80"),
    CINCO("100");

    private String nota;


    Competencia3(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }
}
