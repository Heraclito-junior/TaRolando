package framework.br.com.caelum.vraptor.model;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UsuarioLogado extends Sessao {

    private Usuario usuario;

    public void loga(Usuario usuario){
        this.usuario = usuario;
    }

    public boolean isLogado() {
        return this.usuario != null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void desloga() {
        this.usuario = null;
        //destruir();
    }

    public boolean isAdmin(){
        if(usuario != null) {
            if(usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
                return true;
            }
        }
        return false;
    }

    public boolean isUsuarioComum(){
        if(usuario != null) {
            if(usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR) || usuario.getTipoUsuario().equals(TipoUsuario.ATLETA)){
                return true;
            }
        }
        return false;
    }
    public Long retornarUsuario() {
    	if(usuario==null) {
    		return (long) -10;
    	}else {
    		return usuario.getId();
    	}
    }
}