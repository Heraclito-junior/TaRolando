package br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class Convite extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean aceito;
    private boolean pendente;

    @OneToOne
    private Atleta atleta;

    @OneToOne
    private Evento evento;

    @Deprecated
    public Convite() {
    }

    public Convite(Evento evento, Atleta atleta){
        this.evento = evento;
        this.atleta = atleta;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }

    public boolean isPendente() {
        return pendente;
    }

    public void setPendente(boolean pendente) {
        this.pendente = pendente;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
