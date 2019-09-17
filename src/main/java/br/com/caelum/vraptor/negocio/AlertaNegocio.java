package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.util.Criptografia;
import br.com.caelum.vraptor.util.OpcaoSelect;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class AlertaNegocio {


    @Inject
    private EventoDAO dao;
    

    public AlertaNegocio() {
        
    }



	public Object meusAlertas() {
		// TODO Auto-generated method stub
		return this.dao.meusAlertas();
	}
	
}
