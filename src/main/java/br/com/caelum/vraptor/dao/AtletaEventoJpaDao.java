package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaEvento;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

public class AtletaEventoJpaDao extends EntidadeJpaDao<AtletaEvento> implements AtletaEventoDAO {

    @Deprecated
    public AtletaEventoJpaDao() { this(null); }

    @Inject
    public AtletaEventoJpaDao(EntityManager entityManager) {
        super(entityManager, AtletaEvento.class);
    }

    @Override
    public AtletaEvento buscarPorLogin(String login) {
        Query query = manager.createQuery("SELECT a FROM AtletaEvento a WHERE a.deletado = false AND a.login = :login")
                .setParameter("login", login);
        Optional<AtletaEvento> atleta = query.setMaxResults(1).getResultList().stream().findFirst();
        if (atleta.isPresent()) {
            return atleta.get();
        } else {
            return null;
        }
    }
}
