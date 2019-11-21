package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Atleta extends Usuario {

    @ManyToOne(fetch = FetchType.EAGER)
    private Esporte esportePreferido;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<EventoAjudando> eventos;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Atleta> amigos;
    

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

    public List<EventoAjudando> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoAjudando> eventos) {
        this.eventos = eventos;
    }

	public List<Atleta> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Atleta> amigos) {
		this.amigos = amigos;
	}
}
