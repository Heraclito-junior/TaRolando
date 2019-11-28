package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.*;
import br.com.caelum.vraptor.model.*;
import br.com.caelum.vraptor.util.OpcaoSelect;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import br.com.caelum.vraptor.util.exception.UsuarioInexistenteException;
import br.com.caelum.vraptor.util.exception.VagasInvalidasException;
import framework.negocio.EntidadeNegocio;
import framework.negocio.IEntidadeNegocio;
import framework.negocio.IEventoNegocio;
import framework.negocio.IRelatorioNegocio;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named(value = "tarolandoevento")
public class EventoNegocio extends EntidadeNegocio implements IEventoNegocio, IRelatorioNegocio {

	private EsporteDAO esporteDAO;
	@Inject
	private EventoDAO dao;
	@Inject
	private EventoJpaDao daoJpa;
	@Inject
	private AtletaDAO atletaDAO;
	@Inject
	private AtletaEventoDAO atletaEventoDAO;

	@Inject
	private UsuarioLogado usuarioLogado;

	@Deprecated
	public EventoNegocio() {
		this(null);
	}

	@Inject
	public EventoNegocio(EsporteDAO esporteDAO) {
		this.esporteDAO = esporteDAO;
	}


	public void definirAdministradorESalvar(Evento evento) throws VagasInvalidasException {
		if (evento.getParticipantes() == null) {
			evento.setParticipantes(new ArrayList<>());
		}
		if(evento.getNumVagasMin()>evento.getNumVagasMax()) {
			throw new VagasInvalidasException("Numero de vagas minimas nao pode ser superior as maximas");
		}
		evento.setOrganizador((Atleta) this.usuarioLogado.getUsuario());
//		evento.getParticipantes().add((Atleta) usuarioLogado.getUsuario());
		this.dao.salvar(evento);
		return;
	}
	
	public void modificarEvento(Evento evento) {
////	evento.setOrganizador(this.atletaLogado.getAtleta());
//	System.out.println("organizador "+evento.getOrganizador());
//	System.out.println("evento "+evento.getTitulo());


//	evento.setOrganizador(this.usuarioLogado.getUsuario());

	this.dao.salvar(evento);
//	this.dao.
	return;
}

	public void buscarEDeletar(Long id) throws UsuarioInexistenteException {
		Evento evento = this.dao.buscarPorId(id);
		if (evento == null) {
			throw new UsuarioInexistenteException("Usuário Não Encontrado");
		}
		evento.setDeletado(true);
		this.dao.salvar(evento);
	}

	public Object listar() {
		return this.dao.listar();
	}

	public Evento detalhar(Long id) {
		return this.dao.buscarPorId(id);
	}

	public void inserirUsuario(Long id, String login) throws UsuarioInexistenteException {
		Evento evento = detalhar(id);

		AtletaEvento atleta = this.atletaEventoDAO.buscarPorLogin(login);
		if (atleta.getId() == null) {
			throw new UsuarioInexistenteException("Usuário Não Existe");
		}
		if (!evento.getParticipantes().contains(atleta)) {
			evento.getParticipantes().add(atleta);

		}
		this.dao.salvar(evento);

	}

	public void removerUsuario(Long id, String login) {
		Evento evento = detalhar(id);

		Atleta atleta = this.atletaDAO.buscarPorLogin(login);
		if (atleta.getId() == null) {
			return;
		}
		if (evento.getParticipantes().contains(atleta)) {
			evento.getParticipantes().remove(atleta);
		}
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
		for (AtletaEvento i : evento.getParticipantes()) {
			Optional<Alerta> teste = daoJpa.buscarUltimoAlerta();
			if (teste.isPresent()) {
				ultimoNumero = teste.get().getId();
				ultimoNumero = ultimoNumero + 1;

			}

			daoJpa.inserirAlerta(ultimoNumero, login, id, i.getId());
			if (!teste.isPresent()) {
				ultimoNumero = (long) 1;

			}

		}

	}

	public Relatorio gerarRelatorio(Long id) {
		return null;
	}
}
