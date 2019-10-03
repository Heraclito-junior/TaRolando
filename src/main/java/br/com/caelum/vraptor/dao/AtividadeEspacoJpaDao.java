package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.AtividadeEspaco;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class AtividadeEspacoJpaDao extends EntidadeJpaDao<AtividadeEspaco> implements AtividadeEspacoDAO {

    @Deprecated
    public AtividadeEspacoJpaDao() { this(null); }

    @Inject
    public AtividadeEspacoJpaDao(EntityManager entityManager) {
        super(entityManager, AtividadeEspaco.class);
    }
}
