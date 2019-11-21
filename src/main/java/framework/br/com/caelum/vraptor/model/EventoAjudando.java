package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

import framework.br.com.caelum.vraptor.model.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EventoAjudando extends Evento {

    
	private Double metaDoacoes;
    private Double metaVoluntarios;
    private Double doacoesEfetivadas;

    public EventoAjudando() {
		super();
	}

	public Double getMetaDoacoes() {
		return metaDoacoes;
	}

	public void setMetaDoacoes(Double metaDoacoes) {
		this.metaDoacoes = metaDoacoes;
	}

	public Double getMetaVoluntarios() {
		return metaVoluntarios;
	}

	public void setMetaVoluntarios(Double metaVoluntarios) {
		this.metaVoluntarios = metaVoluntarios;
	}

	public Double getDoacoesEfetivadas() {
		return doacoesEfetivadas;
	}

	public void setDoacoesEfetivadas(Double doacoesEfetivadas) {
		this.doacoesEfetivadas = doacoesEfetivadas;
	}
    
	
	
	
}
