package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.util.OpcaoSelect;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventoNegocio {

    @Inject
    private EsporteDAO esporteDAO;

    @Deprecated
    public EventoNegocio() { this(null); }

    public EventoNegocio(EsporteDAO esporteDAO) {
        this.esporteDAO = esporteDAO;
    }

    public List<OpcaoSelect> geraListaOpcoesEsportes() {
        List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
        return todos.stream().map(
                esporte -> new OpcaoSelect(esporte.getNome(), esporte.getId()))
                .collect(Collectors.toList());
    }

    public void convidarAtleta(Long id, String login){


    }
}
