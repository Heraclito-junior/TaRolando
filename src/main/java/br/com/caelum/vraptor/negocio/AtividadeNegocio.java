package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.AtividadeDAO;
import br.com.caelum.vraptor.model.Atividade;
import br.com.caelum.vraptor.model.Parceiro;
import br.com.caelum.vraptor.model.UsuarioLogado;

import javax.inject.Inject;
import java.util.List;

public class AtividadeNegocio {

    private AtividadeDAO atividadeDAO;
    private UsuarioLogado usuarioLogado;

    @Deprecated
    public AtividadeNegocio() { this(null, null);}

    @Inject
    public AtividadeNegocio(AtividadeDAO atividadeDAO, UsuarioLogado usuarioLogado) {
        this.atividadeDAO = atividadeDAO;
        this.usuarioLogado = usuarioLogado;
    }

    public void salvar(Atividade atividade) {
        atividadeDAO.salvar(atividade);
    }

    public Atividade editar(Long id) {
        return atividadeDAO.buscarPorId(id);
    }

    public void remover(Long id) {
        Atividade atividade = atividadeDAO.buscarPorId(id);
        atividade.setDeletado(true);
        atividadeDAO.salvar(atividade);
    }

    public List<Atividade> listar() {
        return (List<Atividade>) atividadeDAO.listar();
    }

    public List<Atividade> minhasAtividades(Long id) {
        return (atividadeDAO.minhasAtividades(id));
    }

    public Atividade detalhar(Long id) {
        return  atividadeDAO.buscarPorId(id);
    }
}
