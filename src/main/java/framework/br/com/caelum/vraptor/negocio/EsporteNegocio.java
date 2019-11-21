package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.dao.EsporteDAO;
import framework.br.com.caelum.vraptor.model.Esporte;

import javax.inject.Inject;

public class EsporteNegocio {

    @Inject
    private EsporteDAO dao;

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
