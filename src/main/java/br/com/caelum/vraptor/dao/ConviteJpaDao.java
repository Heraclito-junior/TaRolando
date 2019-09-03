package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.Convite;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ConviteJpaDao extends EntidadeJpaDao<Convite> implements ConviteDAO {

    @Deprecated
    public ConviteJpaDao() {this(null);}

    @Inject
    public ConviteJpaDao(EntityManager entityManager) {
        super(entityManager, Convite.class);
    }
}
