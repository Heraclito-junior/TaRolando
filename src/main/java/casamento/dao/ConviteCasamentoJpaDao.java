package casamento.dao;

import framework.br.com.caelum.vraptor.dao.EntidadeJpaDao;
import framework.br.com.caelum.vraptor.model.ConviteCasamento;
import framework.br.com.caelum.vraptor.model.UsuarioLogado;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

//import framework.br.com.caelum.vraptor.dao.ConviteCasamentoDAO;
//import framework.br.com.caelum.vraptor.dao.ConviteDAO;

public class ConviteCasamentoJpaDao extends EntidadeJpaDao<ConviteCasamento> implements ConviteCasamentoDAO {

    private UsuarioLogado usuarioLogado;

    @Deprecated
    public ConviteCasamentoJpaDao() {this(null, null);}

    @Inject
    public ConviteCasamentoJpaDao(EntityManager entityManager, UsuarioLogado usuarioLogado) {
        super(entityManager, ConviteCasamento.class);
        this.usuarioLogado = usuarioLogado;
    }


    public List<ConviteCasamento> meusConvites() {
        Query query = manager.createQuery("SELECT c FROM ConviteCasamento c WHERE c.convidado.id = :id AND c.aceito = false AND" +
                " c.deletado = false")
                .setParameter("id", usuarioLogado.getUsuario().getId());
        return query.getResultList();
    }

    
    
    public List<ConviteCasamento> meusConvitesEnviados() {
        Query query = manager.createQuery("SELECT c FROM ConviteCasamento c WHERE c.eventoAjudando.organizador.id = :id AND c.aceito = false AND" +
                " c.deletado = false")
                .setParameter("id", usuarioLogado.getUsuario().getId());
        return query.getResultList();
    }


    @Override
    public List<ConviteCasamento> convitesPorEvento(Long idEvento) {
        Query query = manager.createQuery("SELECT c FROM ConviteCasamento c WHERE c.deletado = false AND " +
                "c.eventoCasamento.id = :idEvento")
                .setParameter("idEvento", idEvento);
        List<ConviteCasamento> convites = query.getResultList();
        return convites;
    }
}
