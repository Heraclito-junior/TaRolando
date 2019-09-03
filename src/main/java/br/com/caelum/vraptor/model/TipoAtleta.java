package br.com.caelum.vraptor.model;

import br.com.caelum.vraptor.conversor.ConvertivelOpcaoSelect;

public enum TipoAtleta implements ConvertivelOpcaoSelect {
    ATLETA("Atleta"), ADMINISTRADOR("Administrador");

    private String chave;

    TipoAtleta(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public String getValor() {
        return this.toString();
    }
}
