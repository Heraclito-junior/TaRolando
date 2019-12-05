package ajudando.negocio;

import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.dao.ConviteDAO;
//import framework.br.com.caelum.vraptor.dao.EventoAjudandoDAO;
//import framework.br.com.caelum.vraptor.dao.EventoAjudandoJpaDao;
import framework.br.com.caelum.vraptor.dao.EventoDAO;
import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.Convite;
import framework.br.com.caelum.vraptor.model.ConviteAjudando;
import framework.br.com.caelum.vraptor.model.Evento;
import framework.br.com.caelum.vraptor.model.EventoAjudando;
import framework.br.com.caelum.vraptor.negocio.*;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;

import ajudando.dao.*;

import java.util.List;
import java.util.Optional;

public class ConviteNegocioAjudando implements ConviteNegocio<ConviteAjudando>{

    protected AtletaDAO atletaDAO;

    protected EventoAjudandoDAO eventoDAO;
    
    @Inject
    protected EventoAjudandoJpaDao eventoJpaDAO;
	
    protected ConviteAjudandoDAO conviteDAO;

    @Deprecated
    public ConviteNegocioAjudando() { this(null, null, null); }

    @Inject
    public ConviteNegocioAjudando(ConviteAjudandoDAO conviteDAO, AtletaDAO atletaDAO, EventoAjudandoDAO eventoDAO) {
        this.conviteDAO = conviteDAO;
        this.atletaDAO = atletaDAO;
        this.eventoDAO = eventoDAO;
    }

    
    public List<ConviteAjudando> meusConvites() {
        return conviteDAO.meusConvites();
    }

    public List<ConviteAjudando> meusConvitesEnviados() {
        return conviteDAO.meusConvitesEnviados();
    }

	public void participar(Long id, String login, double valor, String participacao) throws AtletaInexistenteException {
		
    	EventoAjudando evento = eventoDAO.buscarPorId(id);

        Atleta convidado = atletaDAO.buscarPorLogin(login);


        if (convidado == null) {
        	System.out.println("não valeu");
            throw new AtletaInexistenteException("Atleta não existe");
        }
        if (!evento.getParticipantes().contains(convidado)) {

        	ConviteAjudando convite = new ConviteAjudando(evento, convidado, valor, participacao);
            convite.getEventoAjudando().getParticipantes().add(convidado);
            conviteDAO.salvar(convite);

        } else {

        }
	}


}