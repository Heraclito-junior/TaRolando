package ajudando.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

//import framework.br.com.caelum.vraptor.dao.ConviteAjudandoDAO;
//import framework.br.com.caelum.vraptor.dao.ConviteDAO;
import framework.br.com.caelum.vraptor.dao.EntidadeJpaDao;
import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.Convite;
import framework.br.com.caelum.vraptor.model.ConviteAjudando;
import framework.br.com.caelum.vraptor.model.UsuarioLogado;

import java.util.List;

public class ConviteAjudandoJpaDao extends EntidadeJpaDao<ConviteAjudando> implements ConviteAjudandoDAO {

    private UsuarioLogado usuarioLogado;

    @Deprecated
    public ConviteAjudandoJpaDao() {this(null, null);}

    @Inject
    public ConviteAjudandoJpaDao(EntityManager entityManager, UsuarioLogado usuarioLogado) {
        super(entityManager, ConviteAjudando.class);
        this.usuarioLogado = usuarioLogado;
    }


    public List<ConviteAjudando> meusConvites() {
        Query query = manager.createQuery("SELECT c FROM ConviteAjudando c WHERE c.convidado.id = :id AND c.aceito = false AND" +
                " c.deletado = false")
                .setParameter("id", usuarioLogado.getUsuario().getId());
        return query.getResultList();
    }

    
    
    public List<ConviteAjudando> meusConvitesEnviados() {
        Query query = manager.createQuery("SELECT c FROM ConviteAjudando c WHERE c.eventoAjudando.organizador.id = :id AND c.aceito = false AND" +
                " c.deletado = false")
                .setParameter("id", usuarioLogado.getUsuario().getId());
        return query.getResultList();
    }
    
    
}
