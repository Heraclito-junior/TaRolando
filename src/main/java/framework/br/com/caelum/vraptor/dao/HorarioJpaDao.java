package framework.br.com.caelum.vraptor.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import framework.br.com.caelum.vraptor.model.Horario;
import framework.br.com.caelum.vraptor.model.Usuario;
import framework.br.com.caelum.vraptor.model.UsuarioLogado;

import java.util.List;

public class HorarioJpaDao extends EntidadeJpaDao<Horario> implements HorarioDAO {

    @Inject
    private UsuarioLogado usuarioLogado;

    public HorarioJpaDao() { this(null); }

    @Inject
    public HorarioJpaDao(EntityManager entityManager) {
        super(entityManager, Horario.class);
    }


    @Override
    public List<Horario> meusHorarios(Long id) {
        Query query = manager.createQuery("SELECT h FROM Horario h WHERE h.atividade.id = :id AND h.deletado = false")
                .setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Horario> meusHorariosLivres(Long id) {
        Query query = manager.createQuery("SELECT h FROM Horario h WHERE h.disponivel = true AND h.atividade.id = :id " +
                                             "AND h.deletado = false")
                .setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<Horario> minhasReservas() {
        Query query = manager.createQuery("SELECT h FROM Horario h WHERE h.atleta.id = :id AND h.deletado = false")
                .setParameter("id", usuarioLogado.getUsuario().getId());
        return query.getResultList();
    }
}
