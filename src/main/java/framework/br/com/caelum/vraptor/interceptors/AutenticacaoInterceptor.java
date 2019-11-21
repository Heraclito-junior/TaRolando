package framework.br.com.caelum.vraptor.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import framework.br.com.caelum.vraptor.controller.LoginController;
import framework.br.com.caelum.vraptor.model.AtletaLogado;
import framework.br.com.caelum.vraptor.model.TipoAtleta;
import framework.br.com.caelum.vraptor.model.TipoUsuario;
import framework.br.com.caelum.vraptor.model.UsuarioLogado;

import javax.inject.Inject;

@Intercepts
public class AutenticacaoInterceptor {

    private UsuarioLogado usuario;
    private AtletaLogado atleta;
    private Result resultado;

    @Inject
    public AutenticacaoInterceptor(AtletaLogado atletaLogado, Result resultado, UsuarioLogado usuarioLogado) {
        this.atleta = atletaLogado;
        this.resultado = resultado;
        this.usuario = usuarioLogado;
    }

    @Deprecated AutenticacaoInterceptor(){}

    @AroundCall
    public void autentica(SimpleInterceptorStack stack){
        if(usuario.isLogado()){
            inserirPermissoes(usuario);
            resultado.include("usuarioLogado", usuario);
            stack.next();
        } else {
            resultado.redirectTo(LoginController.class).form();
        }
    }

    @Accepts
    public boolean ehRestrito(ControllerMethod method){
        return !method.getController().getType().equals(LoginController.class);
    }

    private void inserirPermissoes(UsuarioLogado usuarioLogado) {
        TipoUsuario permissao = usuarioLogado.getUsuario().getTipoUsuario();

        if(permissao.equals(TipoUsuario.ADMINISTRADOR)) {
            resultado.include("permitidoAdministrador", true);
            resultado.include("permitidoAtleta",false);
            resultado.include("permitidoParceiro", false);
        }
        if(permissao.equals(TipoUsuario.ATLETA) || permissao.equals(TipoUsuario.ADMINISTRADOR)){
            resultado.include("permitidoAtleta",true);
            resultado.include("permitidoParceiro", false);
        }
        if (permissao.equals(TipoUsuario.PARCEIRO)) {
            resultado.include("permitidoParceiro", true);
            resultado.include("permitidoAtleta",false);
        }
    }



}
