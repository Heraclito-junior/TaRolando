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

public class ConviteNegocioAjudando {

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


    public void convidar(Long id, String login, Double val, String participacao) throws AtletaInexistenteException {

    	System.out.println("convite 1");
    	EventoAjudando evento = eventoDAO.buscarPorId(id);
    	System.out.println("convite 2");

        Atleta convidado = atletaDAO.buscarPorLogin(login);
    	System.out.println("convite 3");


        if (convidado == null) {
        	System.out.println("não valeu");
            throw new AtletaInexistenteException("Atleta não existe");
        }
        if (!evento.getParticipantes().contains(convidado)) {
        	System.out.println("convite 4");

        	ConviteAjudando convite = new ConviteAjudando(evento, convidado, val, participacao);
//            convite.getEvento().getParticipantes().add(convidado.get());
            conviteDAO.salvar(convite);
        	System.out.println("convite 5");

        } else {
        	System.out.println("convite 6");

        }
    	
    	
    }

    public void aceitar(Long id) {
//        ConviteAjudando convite = conviteDAO.buscarPorId(id);
//        convite.getEvento().getParticipantes().add(convite.getConvidado());
//        convite.getConvidado().getEventos().add(convite.getEvento());
//        convite.setAceito(true);
//        eventoDAO.salvar(convite.getEvento());
    }

    public void rejeitar(Long id) {
    	ConviteAjudando convite = conviteDAO.buscarPorId(id);
        convite.setAceito(false);
        convite.setDeletado(true);
        conviteDAO.salvar(convite);
    }

    public void remover(Long id) {
    	ConviteAjudando convite = conviteDAO.buscarPorId(id);
        convite.setDeletado(true);
        conviteDAO.salvar(convite);
    }
    
    
    public List<ConviteAjudando> meusConvites() {
        return conviteDAO.meusConvites();
    }

    public List<ConviteAjudando> meusConvitesEnviados() {
        return conviteDAO.meusConvitesEnviados();
    }


}