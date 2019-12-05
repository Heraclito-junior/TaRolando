package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UsuarioCasamento extends Usuario {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<EventoCasamento> eventos;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<UsuarioCasamento> amigos;


//    @ManyToOne(cascade = CascadeType.ALL    )
//    private Convite convite;

    @Deprecated
    public UsuarioCasamento() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<EventoCasamento> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoCasamento> eventos) {
        this.eventos = eventos;
    }

    public List<UsuarioCasamento> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<UsuarioCasamento> amigos) {
        this.amigos = amigos;
    }
}