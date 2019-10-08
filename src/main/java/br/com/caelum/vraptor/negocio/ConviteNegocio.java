package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.dao.ConviteDAO;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.Convite;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class ConviteNegocio {

    private ConviteDAO conviteDAO;
    private AtletaDAO atletaDAO;
    private EventoDAO eventoDAO;

    @Deprecated
    public ConviteNegocio() { this(null, null, null); }

    @Inject
    public ConviteNegocio(ConviteDAO conviteDAO, AtletaDAO atletaDAO, EventoDAO eventoDAO) {
        this.conviteDAO = conviteDAO;
        this.atletaDAO = atletaDAO;
        this.eventoDAO = eventoDAO;
    }


    public void convidar(Long id, String login) throws AtletaInexistenteException {

        Evento evento = eventoDAO.buscarPorId(id);
        Atleta convidado = atletaDAO.buscarPorLogin(login);

        if (convidado == null) {
            throw new AtletaInexistenteException("Atleta não existe");
        }
        if (!evento.getParticipantes().contains(convidado)) {
            Convite convite = new Convite(evento, convidado);
//            convite.getEvento().getParticipantes().add(convidado.get());
            conviteDAO.salvar(convite);
        } else {

        }
    }

    public void aceitar(Long id) {
        Convite convite = conviteDAO.buscarPorId(id);
        convite.getEvento().getParticipantes().add(convite.getConvidado());
        convite.getConvidado().getEventos().add(convite.getEvento());
        convite.setAceito(true);
        eventoDAO.salvar(convite.getEvento());
    }

    public void rejeitar(Long id) {
        Convite convite = conviteDAO.buscarPorId(id);
        convite.setAceito(false);
        convite.setDeletado(true);
        conviteDAO.salvar(convite);
    }

    public void remover(Long id) {
        Convite convite = conviteDAO.buscarPorId(id);
        convite.setDeletado(true);
        conviteDAO.salvar(convite);
    }

    public List<Convite> meusConvites() {
        return conviteDAO.meusConvites();
    }

    public List<Convite> meusConvitesEnviados() {
        return conviteDAO.meusConvitesEnviados();
    }


}
