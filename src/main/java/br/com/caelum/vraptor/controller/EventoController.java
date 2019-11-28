package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.model.RelatorioTaRolando;
import br.com.caelum.vraptor.negocio.EventoNegocio;
import br.com.caelum.vraptor.negocio.RelatorioNegocio;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import br.com.caelum.vraptor.util.exception.UsuarioInexistenteException;
import br.com.caelum.vraptor.util.exception.VagasInvalidasException;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import framework.negocio.IEntidadeNegocio;
import framework.negocio.IEventoNegocio;
import framework.negocio.IRelatorioNegocio;

import javax.inject.Inject;
import javax.inject.Named;

@Path("/evento")
@Controller
public class EventoController extends ControladorTaRolando<Evento> {

	@Inject
	private IEntidadeNegocio entityNegocio;

	@Inject
	@Named(value = "tarolandorelatorio")
	private IRelatorioNegocio<RelatorioTaRolando> relatorioNegocio;

	@Named(value = "tarolandoevento")
	private IEventoNegocio negocio;
	private Validator validator;

	@Deprecated
	public EventoController() {
		this(null, null, null);
	}

	@Inject
	public EventoController(Result resultado, IEventoNegocio negocio, Validator validator) {
		super(resultado);
		this.negocio = negocio;
		this.validator = validator;
	}

	public void form() {
		resultado.include("esportes", this.entityNegocio.geraListaOpcoesEsportes());
	}

	
	@Transacional
	public void remover(Long id) {
		try {
			negocio.buscarEDeletar(id);
			this.resultado.redirectTo(this).lista();
		} catch (UsuarioInexistenteException e) {
			resultado.include("mensagem", new SimpleMessage("error", e.getMessage()));
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
		Evento evento = negocio.detalhar(id);
		this.resultado.include("numParticipantes", evento.getParticipantes().size());
		this.resultado.include("evento", evento);
//		this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
	}

	@Transacional
	public void convidarAtleta(Long id, String login) {
		
		try {
			negocio.inserirUsuario(id, login);
		} catch (UsuarioInexistenteException e) {
			resultado.include("mensagem", new SimpleMessage("error", e.getMessage()));
			this.resultado.redirectTo(this).detalhar(id);
			return;
		}
		this.resultado.redirectTo(this).detalhar(id);

	}

	@Transacional
	public void deletarAtleta(Long id, String login) {
		negocio.removerUsuario(id,login);
		this.resultado.redirectTo(this).detalhar(id);

	}
	@Transacional
	@Post
	public void salvar(Evento evento) {
		try {
		this.validator.onErrorRedirectTo(this).form();
		negocio.definirAdministradorESalvar(evento);
//		this.resultado.redirectTo(this).lista();
		}catch(VagasInvalidasException e) {
            resultado.include("mensagem", new SimpleMessage("error", e.getMessage()));
			this.resultado.redirectTo(this).form();
			return;
		}
		this.resultado.redirectTo(this).lista();

		
	}
	
	public void criarAlerta(Long id, String login) {
//		negocio.criarAlerta(id,login);
		this.resultado.redirectTo(this).detalhar(id);


	}
	public void editar(Long id) {		
		
        Evento evento = this.negocio.detalhar(id);		
        this.resultado.include("evento", evento);		
//        this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
//        this.resultado.redirectTo(this).form();		
//        this.resultado.redirectTo(this).form();		
    }
	
	
	public void teste() {
	}

	@Transacional		
	@Post		
	public void modificar(Evento evento) {		
		evento.setOrganizador(this.negocio.detalhar(evento.getId()).getOrganizador());		
		this.validator.onErrorRedirectTo(this).form();		
		negocio.modificarEvento(evento);		
		this.resultado.redirectTo(this).lista();		
	}


	public void gerarRelatorio(Long id) {
		RelatorioTaRolando relatorioTaRolando = relatorioNegocio.gerarRelatorio(id);
		resultado.include("relatorio", relatorioTaRolando);
	}

}
