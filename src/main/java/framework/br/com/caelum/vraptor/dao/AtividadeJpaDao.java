package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import framework.br.com.caelum.vraptor.model.Atividade;

import java.util.List;

public class AtividadeJpaDao extends EntidadeJpaDao<Atividade> implements AtividadeDAO {

    @Deprecated
    public AtividadeJpaDao() { this(null); }

    @Inject
    public AtividadeJpaDao(EntityManager entityManager) {
        super(entityManager, Atividade.class);
    }

    @Override
    public List<Atividade> minhasAtividades(Long id) {
        Query query = manager.createQuery("SELECT a FROM Atividade a WHERE a.espaco.id = :id AND a.deletado = false")
                .setParameter("id", id);
        return query.getResultList();
    }
}
