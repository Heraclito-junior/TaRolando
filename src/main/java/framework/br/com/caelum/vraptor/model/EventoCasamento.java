package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

import framework.br.com.caelum.vraptor.model.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EventoCasamento extends Evento {

    
	private String listaDePresentes;
	
	private int numVagasMax;
	
	private double custoPessoa;
	

    public EventoCasamento() {
		super();
	}


	public String getListaDePresentes() {
		return listaDePresentes;
	}


	public void setListaDePresentes(String listaDePresentes) {
		this.listaDePresentes = listaDePresentes;
	}


	public int getNumVagasMax() {
		return numVagasMax;
	}


	public void setNumVagasMax(int numVagasMax) {
		this.numVagasMax = numVagasMax;
	}


	public double getCustoPessoa() {
		return custoPessoa;
	}


	public void setCustoPessoa(double custoPessoa) {
		this.custoPessoa = custoPessoa;
	}



    
	
	
	
}
