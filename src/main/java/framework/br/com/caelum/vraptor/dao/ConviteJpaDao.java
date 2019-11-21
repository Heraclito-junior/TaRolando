package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.Convite;
import framework.br.com.caelum.vraptor.model.UsuarioLogado;

import java.util.List;

public class ConviteJpaDao extends EntidadeJpaDao<Convite> implements ConviteDAO {

    private UsuarioLogado usuarioLogado;

    @Deprecated
    public ConviteJpaDao() {this(null, null);}

    @Inject
    public ConviteJpaDao(EntityManager entityManager, UsuarioLogado usuarioLogado) {
        super(entityManager, Convite.class);
        this.usuarioLogado = usuarioLogado;
    }


    public List<Convite> meusConvites() {
        Query query = manager.createQuery("SELECT c FROM Convite c WHERE c.convidado.id = :id AND c.aceito = false AND" +
                " c.deletado = false")
                .setParameter("id", usuarioLogado.getUsuario().getId());
        return query.getResultList();
    }

    public List<Convite> meusConvitesEnviados() {
        Query query = manager.createQuery("SELECT c FROM Convite c WHERE c.evento.organizador.id = :id AND c.aceito = false AND" +
                " c.deletado = false")
                .setParameter("id", usuarioLogado.getUsuario().getId());
        return query.getResultList();
    }
}
