package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class ConviteAjudando extends Convite {

    

    

    @ManyToOne
    private EventoAjudando eventoAjudando;

    @Deprecated
    public ConviteAjudando() {
    }

    public ConviteAjudando(EventoAjudando evento, Atleta convidado){
        this.setEventoAjudando(evento);
        this.convidado = convidado;
    }

	public EventoAjudando getEventoAjudando() {
		return eventoAjudando;
	}

	public void setEventoAjudando(EventoAjudando eventoAjudando) {
		this.eventoAjudando = eventoAjudando;
	}

    
}
