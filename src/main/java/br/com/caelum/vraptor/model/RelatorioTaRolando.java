package br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RelatorioTaRolando extends Relatorio {

    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private String horaFim;

    @ManyToOne(fetch = FetchType.EAGER)
    private Esporte tipoEsporte;

    @OneToOne
    private Atleta organizador;

    @OneToMany
    private List<AtletaEvento> atletasConfirmados;

    @OneToMany
    private List<AtletaEvento> atletasPresentes;

    @OneToMany
    private List<AtletaEvento> atletasFaltantes;


    public RelatorioTaRolando () {
        this(null, null, null,null, null, null, null,
                null, null, null, null);
    }

    public RelatorioTaRolando(String titulo, Evento evento, String dataInicio, String dataFim, String horaInicio,
                              String horaFim, Esporte tipoEsporte, Atleta organizador,
                              List<AtletaEvento> atletasConfirmados, List<AtletaEvento> atletasPresentes,
                              List<AtletaEvento> atletasFaltantes) {
        super(titulo, evento);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.tipoEsporte = tipoEsporte;
        this.organizador = organizador;
        this.atletasConfirmados = atletasConfirmados;
        this.atletasPresentes = atletasPresentes;
        this.atletasFaltantes = atletasFaltantes;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public Esporte getTipoEsporte() {
        return tipoEsporte;
    }

    public void setTipoEsporte(Esporte tipoEsporte) {
        this.tipoEsporte = tipoEsporte;
    }

    public Atleta getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Atleta organizador) {
        this.organizador = organizador;
    }

    public List<AtletaEvento> getAtletasConfirmados() {
        return atletasConfirmados;
    }

    public void setAtletasConfirmados(List<AtletaEvento> atletasConfirmados) {
        this.atletasConfirmados = atletasConfirmados;
    }

    public List<AtletaEvento> getAtletasPresentes() {
        return atletasPresentes;
    }

    public void setAtletasPresentes(List<AtletaEvento> atletasPresentes) {
        this.atletasPresentes = atletasPresentes;
    }

    public List<AtletaEvento> getAtletasFaltantes() {
        return atletasFaltantes;
    }

    public void setAtletasFaltantes(List<AtletaEvento> atletasFaltantes) {
        this.atletasFaltantes = atletasFaltantes;
    }
}
