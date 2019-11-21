package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import framework.br.com.caelum.vraptor.model.Mensagem;

public class MensagemJpaDao extends EntidadeJpaDao<Mensagem> implements MensagemDAO {

    @Deprecated
    public MensagemJpaDao() { this(null); }

    @Inject
    public MensagemJpaDao(EntityManager entityManager) {
        super(entityManager, Mensagem.class);
    }
}
