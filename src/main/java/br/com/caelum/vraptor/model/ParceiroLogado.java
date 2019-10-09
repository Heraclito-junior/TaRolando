package br.com.caelum.vraptor.model;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class ParceiroLogado extends Sessao {

    private Parceiro parceiro;

    public void loga(Parceiro parceiro){
        this.parceiro = parceiro;
    }

    public boolean isLogado() {
        return this.parceiro != null;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public void desloga() {
        this.parceiro = null;
        //destruir();
    }

    public boolean isAdmin(){
        if(parceiro != null) {
            if(parceiro.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
                return true;
            }
        }
        return false;
    }

    public boolean isParceiroComum(){
        if(parceiro != null) {
            if(parceiro.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR) || parceiro.getTipoUsuario().equals(TipoUsuario.ATLETA)){
                return true;
            }
        }
        return false;
    }
}