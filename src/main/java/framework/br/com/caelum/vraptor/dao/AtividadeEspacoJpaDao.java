package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import framework.br.com.caelum.vraptor.model.AtividadeEspaco;

public class AtividadeEspacoJpaDao extends EntidadeJpaDao<AtividadeEspaco> implements AtividadeEspacoDAO {

    @Deprecated
    public AtividadeEspacoJpaDao() { this(null); }

    @Inject
    public AtividadeEspacoJpaDao(EntityManager entityManager) {
        super(entityManager, AtividadeEspaco.class);
    }
}
