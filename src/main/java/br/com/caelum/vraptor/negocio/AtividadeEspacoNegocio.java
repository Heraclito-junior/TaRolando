package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.AtividadeEspacoDAO;
import br.com.caelum.vraptor.model.AtividadeEspaco;

import javax.inject.Inject;
import java.util.List;

public class AtividadeEspacoNegocio {

    private AtividadeEspacoDAO atividadeEspacoDAO;

    @Deprecated
    public AtividadeEspacoNegocio() { this(null);}

    @Inject
    public AtividadeEspacoNegocio(AtividadeEspacoDAO atividadeEspacoDAO) {
        this.atividadeEspacoDAO = atividadeEspacoDAO;
    }

    public void salvar(AtividadeEspaco atividadeEspaco) {
        atividadeEspacoDAO.salvar(atividadeEspaco);
    }

    public AtividadeEspaco editar(Long id) {
        return atividadeEspacoDAO.buscarPorId(id);
    }

    public void remover(Long id) {
        AtividadeEspaco atividadeEspaco = atividadeEspacoDAO.buscarPorId(id);
        atividadeEspaco.setDeletado(true);
        atividadeEspacoDAO.salvar(atividadeEspaco);
    }

    public List<AtividadeEspaco> listar() {
        return (List<AtividadeEspaco>) atividadeEspacoDAO.listar();
    }

}
