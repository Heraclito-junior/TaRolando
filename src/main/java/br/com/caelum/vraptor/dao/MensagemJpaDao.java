package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Mensagem;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class MensagemJpaDao extends EntidadeJpaDao<Mensagem> implements MensagemDAO {

    @Deprecated
    public MensagemJpaDao() { this(null); }

    @Inject
    public MensagemJpaDao(EntityManager entityManager) {
        super(entityManager, Mensagem.class);
    }
}
