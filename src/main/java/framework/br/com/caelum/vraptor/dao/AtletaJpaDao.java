package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import framework.br.com.caelum.vraptor.model.Atleta;

import java.util.Optional;

public class AtletaJpaDao extends EntidadeJpaDao<Atleta> implements AtletaDAO {

    @Deprecated
    public AtletaJpaDao() {this(null);}

    @Inject
    public AtletaJpaDao(EntityManager entityManager) {
        super(entityManager, Atleta.class);
    }

    @Override
    public Optional<Atleta> buscarPorLogin(String login) {
        Query query = this.manager.createQuery("SELECT p from Atleta p where p.login = :login");
        query.setParameter("login",login);
        return query.setMaxResults(1).getResultList().stream().findFirst();
    }
}
