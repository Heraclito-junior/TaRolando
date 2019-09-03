package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.dao.ConviteDAO;
import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.Convite;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.util.OpcaoSelect;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AtletaNegocio {

    private AtletaDAO atletaDAO;
    private EsporteDAO esporteDAO;

    public AtletaNegocio() {this(null, null);}

    @Inject
    public AtletaNegocio(AtletaDAO atletaDAO, EsporteDAO esporteDAO) {
        this.atletaDAO = atletaDAO;
        this.esporteDAO = esporteDAO;
    }

    public List<OpcaoSelect> geraListaOpcoesEsportes() {
        List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
        return todos.stream().map(
                esportes -> new OpcaoSelect(esportes.getNome(), esportes.getId()))
                .collect(Collectors.toList());
    }
}
