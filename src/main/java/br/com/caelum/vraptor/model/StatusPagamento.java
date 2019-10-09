package br.com.caelum.vraptor.model;

import br.com.caelum.vraptor.conversor.ConvertivelOpcaoSelect;

public enum StatusPagamento implements ConvertivelOpcaoSelect {
    PAGO("Pago"),
    NAO_PAGO("Não Pago"),
    PAGO_PARCIALMENTE("Pago Parcialmente");

    private String chave;

    StatusPagamento(String chave) { this.chave = chave; }

    @Override
    public String getChave() { return chave; }

    @Override
    public String getValor() { return this.toString(); }
}
