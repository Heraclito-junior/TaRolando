package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Relatorio;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class RelatorioJpaDao extends EntidadeJpaDao<Relatorio> implements RelatorioDAO{

    @Deprecated
    public RelatorioJpaDao() { this(null); }

    @Inject
    public RelatorioJpaDao(EntityManager entityManager) {
        super(entityManager, Relatorio.class);
    }
}
