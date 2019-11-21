package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class Convite extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean aceito;
    private boolean deletado;

    @ManyToOne
    private Atleta convidado;

    @ManyToOne
    private Evento evento;

    @Deprecated
    public Convite() {
    }

    public Convite(Evento evento, Atleta convidado){
        this.evento = evento;
        this.convidado = convidado;
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

    public Atleta getConvidado() {
        return convidado;
    }

    public void setConvidado(Atleta convidado) {
        this.convidado = convidado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }
}
