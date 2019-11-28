package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.*;
import framework.negocio.IRelatorioNegocio;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "tarolandorelatorio")
public class RelatorioNegocio implements IRelatorioNegocio<RelatorioTaRolando> {

    private EventoDAO eventoDAO;

    @Deprecated
    public RelatorioNegocio() {
        this(null);
    }

    @Inject
    public RelatorioNegocio(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
    }


    @Override
    public RelatorioTaRolando gerarRelatorio(Long id) {
        Evento evento = eventoDAO.buscarPorId(id);

        RelatorioTaRolando relatorio = new RelatorioTaRolando();

        relatorio.setEvento(evento);
        relatorio.setTitulo(evento.getTitulo());
        relatorio.setDataInicio(evento.getDataInicio());
        relatorio.setDataFim(evento.getDataFim());
        relatorio.setHoraInicio(evento.getHoraInicio());
        relatorio.setHoraFim(evento.getHoraFim());
        relatorio.setOrganizador(evento.getOrganizador());
        relatorio.setTipoEsporte(evento.getTipoEsporte());

        relatorio.setAtletasConfirmados(atletasConfirmados(evento));
        relatorio.setAtletasPresentes(atletasPresentes(evento));
        relatorio.setAtletasFaltantes(atletasFaltosos(evento));

        return relatorio;
    }


    private List<AtletaEvento> atletasConfirmados(Evento evento) {

        List<AtletaEvento> atletasConfirmados = new ArrayList<>();

        for (AtletaEvento atleta : evento.getParticipantes()) {
            if (atleta.isConfirmado()) {
                atletasConfirmados.add(atleta);
            }
        }
        return atletasConfirmados;
    }

    private List<AtletaEvento> atletasPresentes(Evento evento) {
        List<AtletaEvento> atletasPresentes = new ArrayList<>();

        for (AtletaEvento atleta : evento.getParticipantes()) {
            if (atleta.isPresente()) {
                atletasPresentes.add(atleta);
            }
        }
        return atletasPresentes;
    }

    private List<AtletaEvento> atletasFaltosos(Evento evento) {
        List<AtletaEvento> atletasFaltosos = new ArrayList<>();

        for (AtletaEvento atleta : evento.getParticipantes()) {
            if (!atleta.isPresente()) {
                atletasFaltosos.add(atleta);
            }
        }
        return atletasFaltosos;
    }
}
