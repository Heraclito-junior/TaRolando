package framework.br.com.caelum.vraptor.interceptors;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import framework.br.com.caelum.vraptor.anotacoes.Seguranca;
import framework.br.com.caelum.vraptor.controller.LoginController;
import framework.br.com.caelum.vraptor.model.AtletaLogado;
import framework.br.com.caelum.vraptor.model.TipoUsuario;
import framework.br.com.caelum.vraptor.model.UsuarioLogado;

import javax.inject.Inject;

@Intercepts(after = AutenticacaoInterceptor.class)
public class SegurancaInterceptor {

    private Result resultado;
    private AtletaLogado atletaLogado;
    private UsuarioLogado usuarioLogado;

    @Inject
    public SegurancaInterceptor(Result resultado, AtletaLogado atletaLogado, UsuarioLogado usuarioLogado) {
        this.resultado = resultado;
        this.atletaLogado = atletaLogado;
        this.usuarioLogado = usuarioLogado;
    }

    @Deprecated SegurancaInterceptor(){}

    @Accepts
    public boolean verificarSegurança(ControllerMethod method){
        return !method.getController().getType().equals(LoginController.class);
    }

    private boolean verificarPermissao(ControllerMethod method){
        return method.getController().getType().getAnnotation(Seguranca.class) != null
                || method.containsAnnotation(Seguranca.class);
    }

    @AroundCall
    public void autoriza(SimpleInterceptorStack stack, ControllerMethod method) {
        acesso(method);
        stack.next();
    }

    /**
     * Verifica as permissões através da anotação @Seguranca
     * @param method
     * @return
     */
    public boolean acesso(ControllerMethod method){
        Seguranca anotacaoMethod = method.getMethod().getAnnotation(Seguranca.class);
        Seguranca anotacaoClasse = method.getController().getType().getAnnotation(Seguranca.class);
        if(possuiAnotacao(anotacaoMethod, anotacaoClasse)) {
            if(anotacaoMethod != null) {
                if(usuarioLogado.getUsuario().getTipoUsuario().equals(anotacaoMethod.tipoUsuario())
                        || usuarioLogado.getUsuario().getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
                    return true;
                } else {
                    resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
                }
            } else {
                if(anotacaoClasse != null) {
                    if(usuarioLogado.getUsuario().getTipoUsuario().equals(anotacaoClasse.tipoUsuario())
                            || usuarioLogado.getUsuario().getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)){
                        return true;
                    } else {
                        resultado.use(Results.http()).sendError(403, "Usuário não autorizado");
                    }
                }
            }
        }

        return true;
    }

    public boolean acessoMethod(Seguranca anotacao){
        boolean permitido = anotacao.tipoUsuario().equals(usuarioLogado.getUsuario().getTipoUsuario());
        return permitido;
    }

    public boolean possuiAnotacao(Seguranca anotacaoMethod, Seguranca anotacaoClasse) {
        return (anotacaoMethod != null || anotacaoClasse != null);
    }
    public boolean apenasMetodoAnotado(Seguranca anotacaoMethod, Seguranca anotacaoClasse) {
        return (anotacaoMethod != null && anotacaoClasse == null);
    }
}
