package br.com.caelum.vraptor.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.TipoAtleta;

import javax.inject.Inject;

@Intercepts
public class AutenticacaoInterceptor {

    private AtletaLogado atleta;
    private Result resultado;

    @Inject
    public AutenticacaoInterceptor(AtletaLogado atletaLogado, Result resultado) {
        this.atleta = atletaLogado;
        this.resultado = resultado;
    }

    @Deprecated AutenticacaoInterceptor(){}

    @AroundCall
    public void autentica(SimpleInterceptorStack stack){
        if(atleta.isLogado()){
            inserirPermissoes(atleta);
            resultado.include("atletaLogado", atleta);
            stack.next();
        } else {
            resultado.redirectTo(LoginController.class).form();
        }
    }

    @Accepts
    public boolean ehRestrito(ControllerMethod method){
        return !method.getController().getType().equals(LoginController.class);
    }

    private void inserirPermissoes(AtletaLogado atleta) {
        TipoAtleta permissao = atleta.getAtleta().getTipoAtleta();

        if(permissao.equals(TipoAtleta.ADMINISTRADOR)) {
            resultado.include("permitidoAdministrador", true);
        }
        if(permissao.equals(TipoAtleta.ATLETA) || permissao.equals(TipoAtleta.ADMINISTRADOR)){
            resultado.include("permitidoAtleta",true);
        }
    }



}
