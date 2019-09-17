package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.util.OpcaoSelect;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EsporteNegocio {

    @Inject
    private EsporteDAO dao;
    
    
//    @Inject
//	private EventoDAO dao;
   


//    @Deprecated
//    public EsporteNegocio() { this(null); }

    public EsporteNegocio() {}
    
    


	public Object listar() {
		return this.dao.listar();
	}


	public void salvar(Esporte esporte) {
        this.dao.salvar(esporte);

	}

	public void remover(Long id) {
		Esporte esporte = this.dao.buscarPorId(id);
        esporte.setDeletado(true);
        this.dao.salvar(esporte);
	}
	
	
	
	
}
