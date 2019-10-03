package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Parceiro;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

public class ParceiroJpaDao extends EntidadeJpaDao<Parceiro> implements ParceiroDAO {

    @Deprecated
    public ParceiroJpaDao() { this(null); }

    @Inject
    public ParceiroJpaDao(EntityManager entityManager) {
        super(entityManager, Parceiro.class);
    }

    @Override
    public Optional<Parceiro> buscarPorLogin(String login) {
        Query query = this.manager.createQuery("SELECT p from Parceiro p where p.login = :login")
                .setParameter("login", login);
        return query.setMaxResults(1).getResultList().stream().findFirst();
    }
}
