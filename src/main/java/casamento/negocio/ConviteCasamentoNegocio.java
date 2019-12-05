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
import framework.br.com.caelum.vraptor.negocio.ConviteNegocio;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;
import java.util.List;




public class ConviteCasamentoNegocio implements ConviteNegocio<ConviteCasamento>{

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


    public void convidar(Long id, String nome, String email, String grupo) throws AtletaInexistenteException {

    		EventoCasamento evento = eventoDAO.buscarPorId(id);
        	ConviteCasamento convite = new ConviteCasamento(evento, nome, email, grupo);
            conviteDAO.salvar(convite);    	
    	
    }

    
    
    
    public List<ConviteCasamento> meusConvites() {
        return conviteDAO.meusConvites();
    }

    public List<ConviteCasamento> meusConvitesEnviados() {
        return conviteDAO.meusConvitesEnviados();
    }




    public List<ConviteCasamento> convitesPorEvento(Long id) {
        List<ConviteCasamento> convites = conviteDAO.convitesPorEvento(id);
        return convites;
    }
    
    public void remover(String nome) {

		//TODO   	
	
    }
}