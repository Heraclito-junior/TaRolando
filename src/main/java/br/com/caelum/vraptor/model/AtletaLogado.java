package br.com.caelum.vraptor.model;


import javax.enterprise.context.SessionScoped;

@SessionScoped
public class AtletaLogado extends Sessao {

    private Atleta atleta;

    public void loga(Atleta atleta){
        this.atleta = atleta;
    }

    public boolean isLogado() {
        return this.atleta != null;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public void desloga() {
        this.atleta = null;
        //destruir();
    }

    public boolean isAdmin(){
        if(atleta != null) {
            if(atleta.getTipoAtleta().equals(TipoAtleta.ADMINISTRADOR)){
                return true;
            }
        }
        return false;
    }

    public boolean isAtletaComum(){
        if(atleta != null) {
            if(atleta.getTipoAtleta().equals(TipoAtleta.ADMINISTRADOR) || atleta.getTipoAtleta().equals(TipoAtleta.ATLETA)){
                return true;
            }
        }
        return false;
    }
}
