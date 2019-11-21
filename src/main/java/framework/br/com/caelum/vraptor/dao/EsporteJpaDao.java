package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import framework.br.com.caelum.vraptor.model.Esporte;

import java.util.List;
import java.util.stream.Collectors;

public class EsporteJpaDao extends EntidadeJpaDao<Esporte> implements EsporteDAO {

    @Deprecated
    public EsporteJpaDao() { this(null); }

    @Inject
    public EsporteJpaDao(EntityManager entityManager) {
        super(entityManager, Esporte.class);
    }

    @Override
    public List<Esporte> listar() {
        return super.listar().stream().collect(Collectors.toList());
    }

    @Override
    public List<Esporte> todos() {
        return super.todos().stream().collect(Collectors.toList());
    }
}
