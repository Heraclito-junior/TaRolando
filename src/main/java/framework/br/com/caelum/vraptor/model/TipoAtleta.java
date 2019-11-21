package framework.br.com.caelum.vraptor.model;

import framework.br.com.caelum.vraptor.conversor.ConvertivelOpcaoSelect;

public enum TipoAtleta implements ConvertivelOpcaoSelect {
    ATLETA("Atleta"),
    ADMINISTRADOR("Administrador"),
    PARCEIRO("Parceiro");

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
