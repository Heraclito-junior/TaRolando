package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Chat;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ChatJpaDao  extends EntidadeJpaDao<Chat> implements ChatDAO {

    @Deprecated
    public ChatJpaDao() { this(null);}

    @Inject
    public ChatJpaDao(EntityManager entityManager) {
        super(entityManager, Chat.class);
    }
}
