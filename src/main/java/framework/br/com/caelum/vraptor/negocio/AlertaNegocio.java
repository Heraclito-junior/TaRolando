package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.dao.EsporteDAO;
import framework.br.com.caelum.vraptor.dao.EventoDAO;
import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.Esporte;
import framework.br.com.caelum.vraptor.util.Criptografia;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

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
