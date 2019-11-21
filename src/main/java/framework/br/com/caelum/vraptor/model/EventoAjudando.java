package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

import framework.br.com.caelum.vraptor.model.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EventoAjudando extends Evento {

    
	private Double metaDoacoes;
    private int metaVoluntarios;

    public EventoAjudando() {
		super();
	}

	public Double getMetaDoacoes() {
		return metaDoacoes;
	}

	public void setMetaDoacoes(Double metaDoacoes) {
		this.metaDoacoes = metaDoacoes;
	}

	public int getMetaVoluntarios() {
		return metaVoluntarios;
	}

	public void setMetaVoluntarios(int metaVoluntarios) {
		this.metaVoluntarios = metaVoluntarios;
	}

    
	
	
	
}
