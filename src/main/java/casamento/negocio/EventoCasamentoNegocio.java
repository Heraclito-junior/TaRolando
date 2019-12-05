package casamento.negocio;

import br.com.caelum.vraptor.observer.download.Download;
import casamento.dao.EventoCasamentoDAO;
import casamento.dao.EventoCasamentoJpaDao;
import casamento.negocio.strategy.GeradorRelatorioCasamento;
import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.dao.EsporteDAO;
import framework.br.com.caelum.vraptor.dao.UsuarioCasamentoDAO;
import framework.br.com.caelum.vraptor.model.*;
import framework.br.com.caelum.vraptor.negocio.EventoNegocio;
import framework.br.com.caelum.vraptor.strategy.GeradorRelatorio;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import framework.br.com.caelum.vraptor.util.exception.VagasInvalidasException;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventoCasamentoNegocio extends EventoNegocio {

	@Inject
	private EventoCasamentoDAO dao;

	private GeradorRelatorio relat;
	
	@Inject
	private EventoCasamentoJpaDao daoJpa;
	
	@Inject
	private UsuarioCasamentoDAO usuarioCasamentoDAO;

	@Inject
	private UsuarioLogado usuarioLogado;

	@Deprecated
	public EventoCasamentoNegocio() {
		this(null);
	}

	@Inject
	public EventoCasamentoNegocio(GeradorRelatorioCasamento relat2) {
		this.relat=relat2;
	}

	public List<OpcaoSelect> geraListaOpcoesEventos() {
		List<EventoCasamento> todos = this.dao.listar().stream().collect(Collectors.toList());
		return todos.stream().map(evento -> new OpcaoSelect(evento.getTitulo(), evento.getId()))
				.collect(Collectors.toList());
	}

	public void definirAdministradorESalvar(EventoCasamento evento) throws VagasInvalidasException {
//		if (evento.getParticipantes() == null) {
//			evento.setParticipantes(new ArrayList<>());
//		}
//		if(evento.getNumVagasMin()>evento.getNumVagasMax()) {
//			throw new VagasInvalidasException("Numero de vagas minimas nao pode ser superior as maximas");
//		}
		UsuarioCasamento usuarioCasamento = this.usuarioCasamentoDAO.buscarPorLogin(usuarioLogado.getUsuario().getLogin());
		evento.setOrganizador(this.usuarioLogado.getUsuario());
//		evento.getParticipantes().add((Atleta) usuarioLogado.getUsuario());
		this.dao.salvar(evento);
		return;
	}
	
	public void modificarEvento(EventoCasamento evento) {
////	evento.setOrganizador(this.usuarioLogado.getAtleta());
//	System.out.println("organizador "+evento.getOrganizador());
//	System.out.println("evento "+evento.getTitulo());


//	evento.setOrganizador(this.usuarioLogado.getUsuario());

	this.dao.salvar(evento);
//	this.dao.
	return;
}

	public void buscarEDeletar(Long id) throws AtletaInexistenteException {
		EventoCasamento evento = this.dao.buscarPorId(id);
		if (evento == null) {
			throw new AtletaInexistenteException("Usuario Não Existe");
		}
		evento.setDeletado(true);
		this.dao.salvar(evento);
	}

	public Object listar() {
		return this.dao.listar();
	}

	public EventoCasamento detalhar(Long id) {
		return this.dao.buscarPorId(id);
	}

//	public void inserirUsuarioCasamento(Long id, String login) throws AtletaInexistenteException {
//		EventoCasamento evento = detalhar(id);
//
////		Atleta usuario = this.usuarioDAO.buscarPorLogin(login);
//		UsuarioCasamento usuario = this.usuarioCasamentoDAO.buscarPorLogin(login);
//		if (usuario.getId() == null) {
//			throw new AtletaInexistenteException("Atleta Não Existe");
//		}
//		if (!evento.getParticipantes().contains(usuario)) {
//			evento.getParticipantes().add(usuario);
//
//		}
//		this.dao.salvar(evento);
//
//	}

	public void removerAtleta(Long id, String login) {
		EventoCasamento evento = detalhar(id);

		UsuarioCasamento usuario = this.usuarioCasamentoDAO.buscarPorLogin(login);
		if (usuario.getId() == null) {
			return;
		}
//		if (evento.getParticipantes().contains(usuario)) {
//			evento.getParticipantes().remove(usuario);
//		}
		this.dao.salvar(evento);
	}

	public Object meusEventos() {
		return this.dao.meusEventos();
	}

	public Object meusAlertas() {
		return this.dao.meusAlertas();
	}

	public void criarAlerta(Long id, String login) {

		Evento evento = detalhar(id);
		Long ultimoNumero = (long) 0;
//		for (Atleta i : evento.getParticipantes()) {
//			Optional<Alerta> teste = daoJpa.buscarUltimoAlerta();
//			if (teste.isPresent()) {
//				ultimoNumero = teste.get().getId();
//				ultimoNumero = ultimoNumero + 1;
//
//			}
//
//			daoJpa.inserirAlerta(ultimoNumero, login, id, i.getId());
//			if (!teste.isPresent()) {
//				ultimoNumero = (long) 1;
//
//			}
//
//		}

	}
	
	public Download relatorio(Long id) {
		return relat.gerarRelatorio(id);
	}

}
