package casamento.negocio;

import casamento.dao.ConviteCasamentoDAO;
import casamento.dao.EventoCasamentoDAO;
import casamento.dao.EventoCasamentoJpaDao;
import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.dao.UsuarioCasamentoDAO;
import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.ConviteCasamento;
import framework.br.com.caelum.vraptor.model.EventoCasamento;
import framework.br.com.caelum.vraptor.model.UsuarioCasamento;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;
import java.util.List;

//import framework.br.com.caelum.vraptor.dao.EventoCasamentoDAO;
//import framework.br.com.caelum.vraptor.dao.EventoCasamentoJpaDao;

public class ConviteCasamentoNegocio {

    protected UsuarioCasamentoDAO usuarioDAO;

    protected EventoCasamentoDAO eventoDAO;
    
    @Inject
    protected EventoCasamentoJpaDao eventoJpaDAO;
	
    protected ConviteCasamentoDAO conviteDAO;



    @Deprecated
    public ConviteCasamentoNegocio() { this(null, null, null); }

    @Inject
    public ConviteCasamentoNegocio(ConviteCasamentoDAO conviteDAO, UsuarioCasamentoDAO usuarioDAO, EventoCasamentoDAO eventoDAO) {
        this.conviteDAO = conviteDAO;
        this.usuarioDAO = usuarioDAO;
        this.eventoDAO = eventoDAO;
    }


    public void convidar(Long id, String login, Double val, String participacao) throws AtletaInexistenteException {

    	System.out.println("convite 1");
    	EventoCasamento evento = eventoDAO.buscarPorId(id);
    	System.out.println("convite 2");

        UsuarioCasamento convidado = usuarioDAO.buscarPorLogin(login);
    	System.out.println("convite 3");


        if (convidado == null) {
        	System.out.println("não valeu");
            throw new AtletaInexistenteException("Usuario não existe");
        }

        	System.out.println("convite 4");

        	ConviteCasamento convite = new ConviteCasamento(evento, convidado, val, participacao);
//            convite.getEvento().getParticipantes().add(convidado.get());
            conviteDAO.salvar(convite);
        	System.out.println("convite 5");


    	
    	
    }

    public void aceitar(Long id) {
//        ConviteCasamento convite = conviteDAO.buscarPorId(id);
//        convite.getEvento().getParticipantes().add(convite.getConvidado());
//        convite.getConvidado().getEventos().add(convite.getEvento());
//        convite.setAceito(true);
//        eventoDAO.salvar(convite.getEvento());
    }

    public void rejeitar(Long id) {
    	ConviteCasamento convite = conviteDAO.buscarPorId(id);
        convite.setAceito(false);
        convite.setDeletado(true);
        conviteDAO.salvar(convite);
    }

    public void remover(Long id) {
    	ConviteCasamento convite = conviteDAO.buscarPorId(id);
        convite.setDeletado(true);
        conviteDAO.salvar(convite);
    }
    
    
    public List<ConviteCasamento> meusConvites() {
        return conviteDAO.meusConvites();
    }

    public List<ConviteCasamento> meusConvitesEnviados() {
        return conviteDAO.meusConvitesEnviados();
    }

	public void participar(Long id, String login, double valor, String participacao) throws AtletaInexistenteException {
		
		System.out.println("convite 1");
    	EventoCasamento evento = eventoDAO.buscarPorId(id);
    	System.out.println("convite 2");

        UsuarioCasamento convidado = usuarioDAO.buscarPorLogin(login);
    	System.out.println("convite 3");
    	
    	


        if (convidado == null) {
        	System.out.println("não valeu");
            throw new AtletaInexistenteException("Usuário não existe");
        }
//        if (!evento.getParticipantes().contains(convidado)) {
//        	System.out.println("convite 4");
//
//        	ConviteCasamento convite = new ConviteCasamento(evento, convidado, valor, participacao);
//            convite.getEventoCasamento().getParticipantes().add(convidado);
//            conviteDAO.salvar(convite);
//        	System.out.println("convite 5");
//
//        } else {
//        	System.out.println("convite 6");
//
//        }
	}


}