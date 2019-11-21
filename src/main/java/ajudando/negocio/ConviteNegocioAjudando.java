//package ajudando.negocio;
//
//import framework.br.com.caelum.vraptor.dao.AtletaDAO;
//import framework.br.com.caelum.vraptor.dao.ConviteDAO;
//import framework.br.com.caelum.vraptor.dao.EventoAjudandoDAO;
//import framework.br.com.caelum.vraptor.dao.EventoAjudandoJpaDao;
//import framework.br.com.caelum.vraptor.dao.EventoDAO;
//import framework.br.com.caelum.vraptor.model.Atleta;
//import framework.br.com.caelum.vraptor.model.Convite;
//import framework.br.com.caelum.vraptor.model.ConviteAjudando;
//import framework.br.com.caelum.vraptor.model.Evento;
//import framework.br.com.caelum.vraptor.model.EventoAjudando;
//import framework.br.com.caelum.vraptor.negocio.*;
//import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
//
//import javax.inject.Inject;
//import java.util.List;
//import java.util.Optional;
//
//public class ConviteNegocioAjudando extends ConviteNegocio{
//
//    
//    protected EventoAjudandoDAO eventoDAO;
//    protected EventoAjudandoJpaDao eventoJpaDAO;
//
//
//    @Deprecated
//    public ConviteNegocioAjudando() { this(null, null, null); }
//
//    @Inject
//    public ConviteNegocioAjudando(ConviteDAO conviteDAO, AtletaDAO atletaDAO, EventoDAO eventoDAO) {
//        this.conviteDAO = conviteDAO;
//        this.atletaDAO = atletaDAO;
//        this.eventoDAO = eventoDAO;
//    }
//
//
//    public void convidar(Long id, String login) throws AtletaInexistenteException {
//
////        EventoAjudando evento = EventoAjudandoDAO.buscarPorId(id);
//        Optional<EventoAjudando> evento3;
//        evento3 = eventoJpaDAO.buscarId(id);
//        Evento teste=evento3.get();
//        Atleta convidado = atletaDAO.buscarPorLogin(login);
//
//        if (convidado == null) {
//            throw new AtletaInexistenteException("Atleta não existe");
//        }
//        if (!teste.getParticipantes().contains(convidado)) {
////            Convite convite = new ConviteAjudando();
//            Convite convite = new ConviteAjudando(evento, convidado);
//
////            convite.getEvento().getParticipantes().add(convidado.get());
//            conviteDAO.salvar(convite);
//        } else {
//
//        }
//    }
//
//    public void aceitar(Long id) {
//        Convite convite = conviteDAO.buscarPorId(id);
//        convite.getEvento().getParticipantes().add(convite.getConvidado());
//        convite.getConvidado().getEventos().add(convite.getEvento());
//        convite.setAceito(true);
//        eventoDAO.salvar(convite.getEvento());
//    }
//
//    public void rejeitar(Long id) {
//        Convite convite = conviteDAO.buscarPorId(id);
//        convite.setAceito(false);
//        convite.setDeletado(true);
//        conviteDAO.salvar(convite);
//    }
//
//    public void remover(Long id) {
//        Convite convite = conviteDAO.buscarPorId(id);
//        convite.setDeletado(true);
//        conviteDAO.salvar(convite);
//    }
//
//    public List<Convite> meusConvites() {
//        return conviteDAO.meusConvites();
//    }
//
//    public List<Convite> meusConvitesEnviados() {
//        return conviteDAO.meusConvitesEnviados();
//    }
//
//
//}