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

public class EventoCasamentoNegocio implements EventoNegocio<EventoCasamento> {

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



	public void definirAdministradorESalvar(EventoCasamento evento) throws VagasInvalidasException {
		UsuarioCasamento usuarioCasamento = this.usuarioCasamentoDAO.buscarPorLogin(usuarioLogado.getUsuario().getLogin());
		evento.setOrganizador(this.usuarioLogado.getUsuario());
		this.dao.salvar(evento);
		return;
	}
	
	public void modificarEvento(EventoCasamento evento) {
	this.dao.salvar(evento);
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


	public Object meusEventos() {
		return this.dao.meusEventos();
	}

	public Download relatorio(Long id) {
		return relat.gerarRelatorio(id);
	}

	



}
