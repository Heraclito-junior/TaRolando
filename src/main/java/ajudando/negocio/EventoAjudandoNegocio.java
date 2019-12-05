package ajudando.negocio;

import br.com.caelum.vraptor.observer.download.Download;
import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.dao.EsporteDAO;
import framework.br.com.caelum.vraptor.model.*;
import framework.br.com.caelum.vraptor.negocio.EventoNegocio;
import framework.br.com.caelum.vraptor.strategy.GeradorRelatorio;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import framework.br.com.caelum.vraptor.util.exception.VagasInvalidasException;

import javax.inject.Inject;

//import ajudando.dao.EventoCasamentoDAO;
//import ajudando.dao.EventoCasamentoJpaDao;
import ajudando.negocio.strategy.GeradorRelatorioAjudando;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventoAjudandoNegocio extends EventoNegocio {

	private EsporteDAO esporteDAO;
//	@Inject
//	private EventoCasamentoDAO dao;

	private GeradorRelatorio relat;
	
//	@Inject
//	private EventoCasamentoJpaDao daoJpa;
	
//	@Inject
	private AtletaDAO atletaDAO;

//	@Inject
	private UsuarioLogado usuarioLogado;

	@Deprecated
	public EventoAjudandoNegocio() {
		this(null,null);
	}

//	@Inject
	public EventoAjudandoNegocio(EsporteDAO esporteDAO, GeradorRelatorioAjudando relat2) {
		this.esporteDAO = esporteDAO;
		this.relat=relat2;
	}

	public List<OpcaoSelect> geraListaOpcoesEsportes() {
		List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
		return todos.stream().map(esporte -> new OpcaoSelect(esporte.getNome(), esporte.getId()))
				.collect(Collectors.toList());
	}

	public List<OpcaoSelect> geraListaOpcoesEventos() {
//		List<EventoCasamento> todos = this.dao.listar().stream().collect(Collectors.toList());
//		return todos.stream().map(evento -> new OpcaoSelect(evento.getTitulo(), evento.getId()))
//				.collect(Collectors.toList());
		return null;
	}


	public void definirAdministradorESalvar(EventoCasamento evento) throws VagasInvalidasException {
//		if (evento.getParticipantes() == null) {
//			evento.setParticipantes(new ArrayList<>());
//		}
//		if(evento.getNumVagasMin()>evento.getNumVagasMax()) {
//			throw new VagasInvalidasException("Numero de vagas minimas nao pode ser superior as maximas");
//		}
		evento.setOrganizador((Atleta) this.usuarioLogado.getUsuario());
//		evento.getParticipantes().add((Atleta) usuarioLogado.getUsuario());
//		this.dao.salvar(evento);
		return;
	}
	
	public void modificarEvento(EventoCasamento evento) {
////	evento.setOrganizador(this.atletaLogado.getAtleta());
//	System.out.println("organizador "+evento.getOrganizador());
//	System.out.println("evento "+evento.getTitulo());


//	evento.setOrganizador(this.usuarioLogado.getUsuario());

//	this.dao.salvar(evento);
//	this.dao.
	return;
}

	public void buscarEDeletar(Long id) throws AtletaInexistenteException {
//		EventoCasamento evento = this.dao.buscarPorId(id);
//		if (evento == null) {
//			throw new AtletaInexistenteException("Atleta Não Existe");
//		}
//		evento.setDeletado(true);
//		this.dao.salvar(evento);
	}

	public Object listar() {
//		return this.dao.listar();
		return null;
	}

	public EventoCasamento detalhar(Long id) {
//		return this.dao.buscarPorId(id);
		return null;
	}

	public void inserirAtleta(Long id, String login) throws AtletaInexistenteException {
		EventoCasamento evento = detalhar(id);

		Atleta atleta = this.atletaDAO.buscarPorLogin(login);
		if (atleta.getId() == null) {
			throw new AtletaInexistenteException("Atleta Não Existe");
		}
//		if (!evento.getParticipantes().contains(atleta)) {
//			evento.getParticipantes().add(atleta);
//
//		}
//		this.dao.salvar(evento);

	}

	public void removerAtleta(Long id, String login) {
		EventoCasamento evento = detalhar(id);

		Atleta atleta = this.atletaDAO.buscarPorLogin(login);
		if (atleta.getId() == null) {
			return;
		}
//		if (evento.getParticipantes().contains(atleta)) {
//			evento.getParticipantes().remove(atleta);
//		}
//		this.dao.salvar(evento);
	}

	public Object meusEventos() {
//		return this.dao.meusEventos();
		return null;
	}


	public Object meusAlertas() {
//		return this.dao.meusAlertas();
		return null;
	}

	public void criarAlerta(Long id, String login) {

//		Evento evento = detalhar(id);
//		Long ultimoNumero = (long) 0;
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
//		EventoCasamento eventoAjudando = dao.buscarPorId(id);

//		return relat.GerarRelatorio(eventoAjudando);
		return null;
	}

}
