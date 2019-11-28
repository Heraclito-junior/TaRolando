package framework.negocio;

import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.util.OpcaoSelect;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class EntidadeNegocio implements IEntidadeNegocio {

    @Inject
    protected EsporteDAO esporteDAO;

    @Inject
    protected EventoDAO eventoDAO;


    public List<OpcaoSelect> geraListaOpcoesEsportes() {
        List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
        return todos.stream().map(esporte -> new OpcaoSelect(esporte.getNome(), esporte.getId()))
                .collect(Collectors.toList());
    }

    public List<OpcaoSelect> geraListaOpcoesEventos() {
        List<Evento> todos = this.eventoDAO.listar().stream().collect(Collectors.toList());
        return todos.stream().map(evento -> new OpcaoSelect(evento.getTitulo(), evento.getId()))
                .collect(Collectors.toList());
    }
}
