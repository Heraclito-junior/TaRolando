package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import framework.br.com.caelum.vraptor.model.Chat;

public class ChatJpaDao  extends EntidadeJpaDao<Chat> implements ChatDAO {

    @Deprecated
    public ChatJpaDao() { this(null);}

    @Inject
    public ChatJpaDao(EntityManager entityManager) {
        super(entityManager, Chat.class);
    }
}
