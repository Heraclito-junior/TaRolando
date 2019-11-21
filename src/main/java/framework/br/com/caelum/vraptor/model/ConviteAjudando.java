package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@MappedSuperclass
public class ConviteAjudando extends Convite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean aceito;
    private boolean deletado;

    @ManyToOne
    private Atleta convidado;

    @ManyToOne
    private EventoAjudando eventoAjudando;

    @Deprecated
    public ConviteAjudando() {
    }

    public ConviteAjudando(EventoAjudando evento, Atleta convidado){
        this.eventoAjudando = evento;
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

    public EventoAjudando getEvento() {
        return eventoAjudando;
    }

    public void setEvento(EventoAjudando evento) {
        this.eventoAjudando = evento;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }
}
