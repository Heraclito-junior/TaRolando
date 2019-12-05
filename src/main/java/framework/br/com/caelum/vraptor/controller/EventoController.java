package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import casamento.negocio.ConviteCasamentoNegocio;
import casamento.negocio.EventoCasamentoNegocio;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.model.ConviteCasamento;
import framework.br.com.caelum.vraptor.model.Evento;
//import framework.br.com.caelum.vraptor.negocio.EventoNegocio;
import framework.br.com.caelum.vraptor.model.EventoCasamento;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import framework.br.com.caelum.vraptor.util.exception.VagasInvalidasException;

import javax.inject.Inject;
import java.util.List;


@Path("/evento")
@Controller
public class EventoController extends ControladorTaRolando<Evento> {

	private EventoCasamentoNegocio negocio;
	private Validator validator;

	@Inject
	private ConviteCasamentoNegocio conviteNegocio;

	@Deprecated
	public EventoController() {
		this(null, null, null);
	}

	@Inject
	public EventoController(Result resultado, EventoCasamentoNegocio negocio, Validator validator) {
		super(resultado);
		this.negocio = negocio;
		this.validator = validator;
	}

	public void form() {
//		resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
	}

	
	@Transacional
	public void remover(Long id) {
		try {
			negocio.buscarEDeletar(id);
			this.resultado.redirectTo(this).lista();
		} catch (AtletaInexistenteException e) {
			this.resultado.redirectTo(this).lista();

		}
	}


	public void lista() {
		this.resultado.include("eventos", negocio.listar());
	}

	public void meusEventos() {
		this.resultado.include("eventos", negocio.meusEventos());
	}

	public void detalhar(Long id) {
		EventoCasamento evento = negocio.detalhar(id);
//		this.resultado.include("numParticipantes", evento.getParticipantes().size());
		List<ConviteCasamento> convites = conviteNegocio.convitesPorEvento(evento.getId());
		this.resultado.include("convites", convites);
		this.resultado.include("evento", evento);
//		this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
	}

	@Transacional
	public void convidarAtleta(Long id, String login) {
		
		try {
			negocio.inserirAtleta(id, login);
		} catch (AtletaInexistenteException e) {
			this.resultado.redirectTo(this).detalhar(id);
			return;
		}
		this.resultado.redirectTo(this).detalhar(id);

	}

	@Transacional
	public void deletarAtleta(Long id, String login) {
		negocio.removerAtleta(id,login);
		this.resultado.redirectTo(this).detalhar(id);

	}
	@Transacional
	@Post
	public void salvar(EventoCasamento evento) {
		try {
		this.validator.onErrorRedirectTo(this).form();
		negocio.definirAdministradorESalvar(evento);
		}catch(VagasInvalidasException e) {
            resultado.include("mensagem", new SimpleMessage("error", e.getMessage()));
			this.resultado.redirectTo(this).form();
			return;
		}
		this.resultado.redirectTo(this).lista();

		
	}
	
	public void criarAlerta(Long id, String login) {
		negocio.criarAlerta(id,login);
		this.resultado.redirectTo(this).detalhar(id);


	}
	public void editar(Long id) {		
		
        Evento evento = this.negocio.detalhar(id);		
        this.resultado.include("evento", evento);		
//        this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
	
    }
	
	
	public void teste() {
	}

	@Transacional		
	@Post		
	public void modificar(EventoCasamento evento) {
		evento.setOrganizador(this.negocio.detalhar(evento.getId()).getOrganizador());		
		this.validator.onErrorRedirectTo(this).form();		
		negocio.modificarEvento(evento);		
		this.resultado.redirectTo(this).lista();		
	}
	
	public Download gerarRelatorio(Long idEvento) {
		Download download = null;

		try {
			download = negocio.relatorio(idEvento);
		} catch (Exception e) {
			resultado.include("mensagem", new SimpleMessage("error", "DEU BUG NO RELATORIO"));
			resultado.redirectTo(this).detalhar(idEvento);
		}
		return download;
	}

}
