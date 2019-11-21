package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.Convite;

public class ConviteJpaDao extends EntidadeJpaDao<Convite> implements ConviteDAO {

    @Deprecated
    public ConviteJpaDao() {this(null);}

    @Inject
    public ConviteJpaDao(EntityManager entityManager) {
        super(entityManager, Convite.class);
    }
}
