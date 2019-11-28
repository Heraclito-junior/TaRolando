package framework.negocio;

import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.util.OpcaoSelect;

import java.util.List;
import java.util.stream.Collectors;

public interface IEntidadeNegocio {

    List<OpcaoSelect> geraListaOpcoesEsportes();
    List<OpcaoSelect> geraListaOpcoesEventos();
}
