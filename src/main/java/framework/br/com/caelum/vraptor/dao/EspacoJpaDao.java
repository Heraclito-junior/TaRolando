package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import framework.br.com.caelum.vraptor.model.Espaco;

import java.util.List;

public class EspacoJpaDao extends EntidadeJpaDao<Espaco> implements EspacoDAO {

    @Deprecated
    public EspacoJpaDao() { this(null); }

    @Inject
    public EspacoJpaDao(EntityManager entityManager) {
        super(entityManager, Espaco.class);
    }

    @Override
    public List<Espaco> meusEspacos(Long id) {
        Query query = manager.createQuery("SELECT e FROM Espaco e WHERE e.proprietario.id = :id AND e.deletado = false")
                .setParameter("id", id);
        return query.getResultList();
    }

    public List<Espaco> espacosMaisReservados() {
        Query query = manager.createQuery("SELECT e FROM Espaco e WHERE e.deletado = false " +
                                             "ORDER BY e.numReservas");
        return query.setMaxResults(5).getResultList();
    }
}
