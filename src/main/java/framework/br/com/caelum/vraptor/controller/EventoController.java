package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.dao.EventoDAO;
import framework.br.com.caelum.vraptor.model.Evento;
import framework.br.com.caelum.vraptor.model.EventoAjudando;
import framework.br.com.caelum.vraptor.model.Relatorio;
//import framework.br.com.caelum.vraptor.negocio.EventoNegocio;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import framework.br.com.caelum.vraptor.util.exception.VagasInvalidasException;

import javax.inject.Inject;

import ajudando.negocio.EventoAjudandoNegocio;

@Path("/evento")
@Controller
public class EventoController extends ControladorTaRolando<Evento> {

	private EventoAjudandoNegocio negocio;
	private Validator validator;

	@Deprecated
	public EventoController() {
		this(null, null, null);
	}

	@Inject
	public EventoController(Result resultado, EventoAjudandoNegocio negocio, Validator validator) {
		super(resultado);
		this.negocio = negocio;
		this.validator = validator;
	}

	public void form() {
		resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
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
		EventoAjudando evento = negocio.detalhar(id);
		this.resultado.include("numParticipantes", evento.getParticipantes().size());
		this.resultado.include("evento", evento);
		this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
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
	public void salvar(EventoAjudando evento) {
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
        this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());		
	
    }
	
	
	public void teste() {
	}

	@Transacional		
	@Post		
	public void modificar(EventoAjudando evento) {		
		evento.setOrganizador(this.negocio.detalhar(evento.getId()).getOrganizador());		
		this.validator.onErrorRedirectTo(this).form();		
		negocio.modificarEvento(evento);		
		this.resultado.redirectTo(this).lista();		
	}
	
	public void relatorio(Long idEvento) {
		negocio.relatorio(idEvento);
//		Relatorio relatorio = negocio.relatorio(idEvento);
//		resultado.include()
	}

}
