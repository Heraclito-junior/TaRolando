package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.model.Convite;
import br.com.caelum.vraptor.negocio.ConviteNegocio;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import br.com.caelum.vraptor.validator.SimpleMessage;

import javax.inject.Inject;

@Controller
public class ConviteController extends ControladorTaRolando<Convite> {

    private ConviteNegocio conviteNegocio;

    @Deprecated
    public ConviteController() { this(null, null); }

    @Inject
    public ConviteController(Result resultado, ConviteNegocio conviteNegocio) {
        super(resultado);
        this.conviteNegocio = conviteNegocio;
    }

    @Transacional
    public void convidar(Long id, String login) {
        try {
            conviteNegocio.convidar(id, login);
            resultado.include("mensagem", new SimpleMessage("success", "mensagem.convite.convidar.sucesso"));
        } catch (AtletaInexistenteException at) {
            resultado.include("mensagem", new SimpleMessage("error", "mensagem.atleta.inexistente"));
        }  finally {
            resultado.redirectTo(EventoController.class).detalhar(id);
        }
//        resultado.include(new SimpleMessage("error", "mensagem.atleta.inexistente"));
    }

    @Transacional
    public void remover(Long id) {
        conviteNegocio.remover(id);
        resultado.redirectTo(this).meusConvites();
    }

    @Transacional
    public void aceitar(Long id) {
        conviteNegocio.aceitar(id);
        resultado.redirectTo(this).meusConvites();
    }

    @Transacional
    public void rejeitar(Long id) {
        conviteNegocio.rejeitar(id);
        resultado.redirectTo(this).meusConvites();
    }

    @Get
    public void meusConvites() {
        resultado.include("convitesRecebidos", conviteNegocio.meusConvites());
        resultado.include("convitesEnviados", conviteNegocio.meusConvitesEnviados());
    }
}
