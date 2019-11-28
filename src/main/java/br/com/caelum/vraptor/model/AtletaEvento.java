package br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class AtletaEvento extends Entidade{

    @Id
    @GeneratedValue
    private Long id;

    private boolean confirmado;
    private boolean presente;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Atleta atleta;

    @Deprecated
    public AtletaEvento() {

    }

    public AtletaEvento(Atleta atleta, Evento evento) {
        this.atleta = atleta;
        this.evento = evento;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
}
