package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.EspacoDAO;
import br.com.caelum.vraptor.model.Espaco;
import br.com.caelum.vraptor.model.Parceiro;
import br.com.caelum.vraptor.model.UsuarioLogado;

import javax.inject.Inject;
import java.util.List;

public class EspacoNegocio {

    private EspacoDAO espacoDAO;
    private UsuarioLogado usuarioLogado;

    @Deprecated
    public EspacoNegocio() { this(null, null); }

    @Inject
    public EspacoNegocio(EspacoDAO espacoDAO, UsuarioLogado usuarioLogado) {
        this.espacoDAO = espacoDAO;
        this.usuarioLogado = usuarioLogado;
    }

    public void salvar(Espaco espaco) {
        espaco.setProprietario((Parceiro) usuarioLogado.getUsuario());
        espacoDAO.salvar(espaco);
    }

    public Espaco editar(Long id) {
        return espacoDAO.buscarPorId(id);
    }

    public void remover(Long id) {
        Espaco espaco = espacoDAO.buscarPorId(id);
        espaco.setDeletado(true);
        espacoDAO.salvar(espaco);
    }

    public List<Espaco> listar() {
        return (List<Espaco>) espacoDAO.listar();
    }

    public List<Espaco> meusEspacos() {
        return espacoDAO.meusEspacos(usuarioLogado.getUsuario().getId());
    }

    public Espaco detalhar(Long id) {
        return espacoDAO.buscarPorId(id);
    }
}
