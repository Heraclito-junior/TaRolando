package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
public abstract class Evento extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String titulo;
    protected String dataInicio;
    protected String dataFim;
    protected String horaInicio;
    protected String horaFim;
//    protected String frequencia;
    protected String latitude;
    protected String longitude;
//    protected int numVagasMin;
//    protected int numVagasMax;
    protected String descricao;
    protected boolean deletado;

//    @ManyToOne(fetch = FetchType.EAGER)
//    protected Esporte tipoEsporte;

    @OneToOne
    protected Atleta organizador;

    @ManyToMany(cascade = CascadeType.ALL )
    protected List<Atleta> participantes;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Endereco localizacao;

    @OneToOne(cascade = CascadeType.ALL)
    protected Chat chat;

    @OneToOne(cascade = CascadeType.ALL)
    protected Horario horario;

//    @ManyToOne
//    private Convite convite;

    @Deprecated
    public Evento() {
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) { this.titulo = titulo;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFim(String horaFim) { this.horaFim = horaFim;
    }

    public Atleta getOrganizador() {
        return organizador;
    }

//    public void setOrganizador(Atleta organizador) { this.organizador = organizador; }
    public void setOrganizador(Usuario organizador) { this.organizador = (Atleta) organizador; }
    public List<Atleta> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Atleta> participantes) {
        this.participantes = participantes;
    }

//    public Esporte getTipoEsporte() {
//        return tipoEsporte;
//    }
//
//    public void setTipoEsporte(Esporte tipoEsporte) {
//        this.tipoEsporte = tipoEsporte;
//    }

    public Endereco getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Endereco localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
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

    public String getHoraFim() {
        return horaFim;
    }

//    public String getFrequencia() {
//        return frequencia;
//    }
//
//    public void setFrequencia(String frequencia) {
//        this.frequencia = frequencia;
//    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

//    public int getNumVagasMin() {
//        return numVagasMin;
//    }
//
//    public void setNumVagasMin(int numVagasMin) {
//        this.numVagasMin = numVagasMin;
//    }
//
//    public int getNumVagasMax() {
//        return numVagasMax;
//    }
//
//    public void setNumVagasMax(int numVagasMax) {
//        this.numVagasMax = numVagasMax;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
