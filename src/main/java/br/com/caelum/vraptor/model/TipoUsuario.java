package br.com.caelum.vraptor.model;

import br.com.caelum.vraptor.conversor.ConvertivelOpcaoSelect;

public enum TipoUsuario implements ConvertivelOpcaoSelect {
    ATLETA("Atleta"),
    ADMINISTRADOR("Administrador"),
    PARCEIRO("Parceiro");

    private String chave;

    TipoUsuario(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public String getValor() {
        return this.toString();
    }
}
