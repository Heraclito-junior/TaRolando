package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EventoJpaDao extends EntidadeJpaDao<Evento> implements EventoDAO {

    @Inject
    private AtletaLogado atletaLogado;

    private UsuarioLogado usuarioLogado;

    @Deprecated
    public EventoJpaDao() { this(null, null); }

    @Inject
    public EventoJpaDao(EntityManager entityManager, UsuarioLogado usuarioLogado) {
        super(entityManager, Evento.class);
        this.usuarioLogado = usuarioLogado;
    }


    @Override
    public List<Evento> meusEventos() {
        Query query = this.manager.createQuery("SELECT e FROM Evento e WHERE (:atleta MEMBER OF e.participantes OR " +
                                                  "e.organizador.id = :id) AND e.deletado = false")
                .setParameter("atleta", usuarioLogado.getUsuario())
                .setParameter("id", usuarioLogado.getUsuario().getId());
        List<Evento> tarefas = query.getResultList();
        return tarefas;
    }
    
    @Override
    public List<AlertaTabela> meusAlertas() {
        Query query = this.manager.createNativeQuery("SELECT a.nome, b.participantes_id,c.titulo FROM Alerta as a INNER JOIN evento_atleta as b on a.evento_id = b.evento_id and b.participantes_id=:atleta INNER JOIN evento as c on b.evento_id = c.id GROUP BY a.nome,b.participantes_id,c.titulo");

        query.setParameter("atleta", usuarioLogado.getUsuario().getId());
//        Object[] resultado = (Object[]) query.getResultList();
        List<Object[]> resultado = query.getResultList();

        List<AlertaTabela> tarefas = new ArrayList<AlertaTabela>();
        AlertaTabela temporario;
        for(int i=0; i<resultado.size();i++) {
        	temporario=new AlertaTabela();
        	temporario.setNome(resultado.get(i)[0].toString());
        	Long valor=Long.parseLong( resultado.get(i)[1].toString());
            temporario.setParticipante(valor);
            temporario.setTitulo(resultado.get(i)[2].toString());
        	tarefas.add(temporario);
        }
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

    
    public Optional<Alerta> buscarUltimoAlerta() {
        Query query = this.manager.createQuery("SELECT u from Alerta u order by id desc");
        return query.setMaxResults(1).getResultList().stream().findFirst();
    }

    
    public void inserirAlerta(Long id, String mensagem, Long eventoId, Long atleta) {
    	EntityTransaction txn = manager.getTransaction();
        txn.begin();
        Query query = this.manager.createNativeQuery("INSERT INTO alerta (id, nome,atleta_id,evento_id) VALUES (:id, :mensagem, :atleta, :evento)");
        query.setParameter("id", id);
        query.setParameter("mensagem", mensagem);
        query.setParameter("atleta", atleta);
        query.setParameter("evento", eventoId);
        


        query.executeUpdate();
        txn.commit();
        manager.joinTransaction();
        return;
    }
    
}
