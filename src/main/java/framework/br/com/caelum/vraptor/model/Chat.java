package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chat extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataAbertura;

    @ManyToOne
    private Atleta administrador;

    @OneToOne
    private EventoAjudando evento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Mensagem> mensagens;

    @ManyToMany
    private List<Atleta> atletas;

    public Chat() {
        mensagens = new ArrayList<Mensagem>();
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Atleta getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Atleta administrador) {
        this.administrador = administrador;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(EventoAjudando evento) {
        this.evento = evento;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }
}
