package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class ConviteAjudando extends Convite {

    
	private Double valor;
	
	private String ajuda;
	
	private Boolean participou;

    @ManyToOne
    private EventoAjudando eventoAjudando;

    @Deprecated
    public ConviteAjudando() {

    }

    public ConviteAjudando(EventoAjudando evento, Atleta convidado, Double val, String ajudas){
        this.setEventoAjudando(evento);
        this.convidado = convidado;
        this.setValor(val);
        this.setAjuda(ajudas);
        this.participou = false;
    }

	public EventoAjudando getEventoAjudando() {
		return eventoAjudando;
	}

	public void setEventoAjudando(EventoAjudando eventoAjudando) {
		this.eventoAjudando = eventoAjudando;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getAjuda() {
		return ajuda;
	}

	public void setAjuda(String ajuda) {
		this.ajuda = ajuda;
	}

	public Boolean getParticipou() {
		return participou;
	}

	public void setParticipou(Boolean participou) {
		this.participou = participou;
	}

    
}
