package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.model.Convite;
import framework.br.com.caelum.vraptor.negocio.ConviteNegocio;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;

import ajudando.negocio.ConviteNegocioAjudando;

@Controller
public class ConviteController extends ControladorTaRolando<Convite> {

    private ConviteNegocioAjudando conviteNegocio;
    
    @Deprecated
    public ConviteController() { this(null, null); }

    @Inject
    public ConviteController(Result resultado, ConviteNegocioAjudando conviteNegocio) {
        super(resultado);
        this.conviteNegocio = conviteNegocio;
    }
    @Transacional
    public void convidar(Long id, String login, Double val, String participacao) {
        try {
            conviteNegocio.convidar(id, login, val, participacao);
            resultado.include("mensagem", new SimpleMessage("success", "mensagem.convite.convidar.sucesso"));
        } catch (AtletaInexistenteException at) {
            resultado.include("mensagem", new SimpleMessage("error", "mensagem.atleta.inexistente"));
        }  finally {
            resultado.redirectTo(EventoController.class).detalhar(id);
        }
//        resultado.include(new SimpleMessage("error", "mensagem.atleta.inexistente"));
    }
    
    @Transacional
    public void participar(Long id, String login, double valor, String contribuicaoLaboral) {
    	try {
			conviteNegocio.participar(id, login, valor, contribuicaoLaboral);
		} catch (AtletaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        resultado.redirectTo(EventoController.class).detalhar(id);
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
