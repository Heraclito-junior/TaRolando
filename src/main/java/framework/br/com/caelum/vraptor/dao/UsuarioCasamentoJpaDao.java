package framework.br.com.caelum.vraptor.dao;

import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.UsuarioCasamento;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

public class UsuarioCasamentoJpaDao extends EntidadeJpaDao<UsuarioCasamento> implements UsuarioCasamentoDAO{


    public UsuarioCasamentoJpaDao() {this(null);}

    @Inject
    public UsuarioCasamentoJpaDao(EntityManager entityManager) {
        super(entityManager, UsuarioCasamento.class);
    }

    @Override
    public UsuarioCasamento buscarPorLogin(String login) {
        Query query = this.manager.createQuery("SELECT u from UsuarioCasamento u where u.login = :login");
        query.setParameter("login",login);
        Optional<UsuarioCasamento> usuario = query.setMaxResults(1).getResultList().stream().findFirst();
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            return null;
        }
    }

}
