package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import framework.br.com.caelum.vraptor.model.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EnderecoJpaDao extends EntidadeJpaDao<Endereco> implements EnderecoDAO {

    public EnderecoJpaDao() { this(null); }

    @Inject
    public EnderecoJpaDao(EntityManager entityManager) {
        super(entityManager, Endereco.class);
    }

  }
