package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class ConviteCasamento extends Convite {

    private String email;
    
    private boolean apareceu;
    
    private String grupo;
    
    private String trouxePresente;
    
    
	

    @ManyToOne
    private EventoCasamento eventoAjudando;

    @Deprecated
    public ConviteCasamento() {
    }

    

	public EventoCasamento getEventoAjudando() {
		return eventoAjudando;
	}

	public void setEventoAjudando(EventoCasamento eventoAjudando) {
		this.eventoAjudando = eventoAjudando;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isApareceu() {
		return apareceu;
	}



	public void setApareceu(boolean apareceu) {
		this.apareceu = apareceu;
	}



	public String getGrupo() {
		return grupo;
	}



	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}



	public String getTrouxePresente() {
		return trouxePresente;
	}



	public void setTrouxePresente(String trouxePresente) {
		this.trouxePresente = trouxePresente;
	}

	

    
}
