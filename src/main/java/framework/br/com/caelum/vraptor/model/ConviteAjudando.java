package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class ConviteAjudando extends Convite {

    
	private Double valor;
	
	private String ajuda;

    @ManyToOne
    private EventoAjudando eventoAjudando;

    @Deprecated
    public ConviteAjudando() {
    }

    public ConviteAjudando(EventoAjudando evento, Atleta convidado, Double val, String ajudas){
        this.setEventoAjudando(evento);
        this.convidado = convidado;
        this.valor=val;
        this.ajuda=ajudas;
    }

	public EventoAjudando getEventoAjudando() {
		return eventoAjudando;
	}

	public void setEventoAjudando(EventoAjudando eventoAjudando) {
		this.eventoAjudando = eventoAjudando;
	}

    
}
