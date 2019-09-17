package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.util.OpcaoSelect;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventoNegocio {

    @Inject
    private EsporteDAO esporteDAO;
    @Inject
	private EventoDAO dao;
    @Inject
	private AtletaDAO atletaDAO;
    
    @Inject
	private AtletaLogado atletaLogado;


    @Deprecated
    public EventoNegocio() { this(null); }

    public EventoNegocio(EsporteDAO esporteDAO) {
        this.esporteDAO = esporteDAO;
    }
    
    public List<OpcaoSelect> geraListaOpcoesEsportes() {
        List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
        return todos.stream().map(
                esporte -> new OpcaoSelect(esporte.getNome(), esporte.getId()))
                .collect(Collectors.toList());
    }

	public void definirAdministradorESalvar(Evento evento) {
		evento.setOrganizador(this.atletaLogado.getAtleta());
		this.dao.salvar(evento);
		return;
	}

	public void buscar(Long id) throws AtletaInexistenteException {
		Evento evento = this.dao.buscarPorId(id);
		if(evento==null) {
			throw new AtletaInexistenteException("Atleta Não Existe");
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

	public void inserirAtleta(Long id, String login) throws AtletaInexistenteException{		
			Evento evento =detalhar(id);
			
			Optional<Atleta> atleta = this.atletaDAO.buscarPorLogin(login);
			if (!atleta.isPresent()) {
				throw new AtletaInexistenteException("Atleta Não Existe");
			}
			if (!evento.getParticipantes().contains(atleta)) {
				evento.getParticipantes().add(atleta.get());
			}
			this.dao.salvar(evento);

	}

	public void removerAtleta(Long id, String login) {
		Evento evento =detalhar(id);

		Optional<Atleta> atleta = this.atletaDAO.buscarPorLogin(login);

		if (!evento.getParticipantes().contains(atleta)) {
			evento.getParticipantes().remove(atleta.get());
		}
		
	}

	public Object meusEventos() {
		return this.dao.meusEventos();
	}
	
	
	
	
}
