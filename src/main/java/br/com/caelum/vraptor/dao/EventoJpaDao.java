package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.Evento;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
    
    
    public void removerAtleta(Evento evento, Atleta atleta) {
        EntityTransaction txn = manager.getTransaction();
        txn.begin();
//        DELETE FROM public.evento_atleta
//    	WHERE evento_id=3 and participantes_id=3;
        
        Query query = this.manager.createNativeQuery("DELETE FROM evento_atleta WHERE evento_id=(:evento) AND participantes_id=(:atleta)");

//        Query query = this.manager.createNativeQuery("INSERT INTO evento_atleta (evento_id, participantes_id) VALUES (:evento, :atleta)");
        query.setParameter("evento", evento.getId());
        query.setParameter("atleta", atleta.getId());

        query.executeUpdate();
        txn.commit();
        manager.joinTransaction();
        return;
    }
    
}
