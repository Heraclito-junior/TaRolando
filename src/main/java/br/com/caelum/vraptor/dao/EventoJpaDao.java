package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.Evento;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EventoJpaDao extends EntidadeJpaDao<Evento> implements EventoDAO {

    @Inject
    private AtletaLogado atletaLogado;

    @Deprecated
    public EventoJpaDao() { this(null); }

    @Inject
    public EventoJpaDao(EntityManager entityManager) {
        super(entityManager, Evento.class);
    }


    @Override
    public List<Evento> meusEventos() {
        Query query = this.manager.createQuery("SELECT p FROM Evento p WHERE p.organizador.id = :atleta AND p.deletado = false");
        query.setParameter("atleta", atletaLogado.getAtleta().getId());
        List<Evento> tarefas = query.getResultList();
        return tarefas;
    }
}
