package br.com.caelum.vraptor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Atleta extends Usuario {

    @ManyToOne(fetch = FetchType.EAGER)
    protected Esporte esportePreferido;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Evento> eventos;
    
    @ManyToMany(cascade = CascadeType.ALL)
    protected List<Atleta> amigos;
    

//    @ManyToOne(cascade = CascadeType.ALL    )
//    private Convite convite;

    @Deprecated
    public Atleta() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Esporte getEsportePreferido() {
        return esportePreferido;
    }

    public void setEsportePreferido(Esporte esportePreferido) {
        this.esportePreferido = esportePreferido;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

	public List<Atleta> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Atleta> amigos) {
		this.amigos = amigos;
	}
}
