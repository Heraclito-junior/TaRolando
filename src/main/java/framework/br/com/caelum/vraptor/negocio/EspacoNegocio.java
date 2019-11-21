package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.dao.EspacoDAO;
import framework.br.com.caelum.vraptor.dao.EsporteDAO;
import framework.br.com.caelum.vraptor.dao.ParceiroDAO;
import framework.br.com.caelum.vraptor.model.*;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class EspacoNegocio {

    private EspacoDAO espacoDAO;
    private EsporteDAO esporteDAO;
    private UsuarioLogado usuarioLogado;
    private ParceiroDAO parceiroDAO;


    @Deprecated
    public EspacoNegocio() { this(null, null, null, null); }

    @Inject
    public EspacoNegocio(EspacoDAO espacoDAO, ParceiroDAO parceiroDAO, EsporteDAO esporteDAO, UsuarioLogado usuarioLogado) {
        this.espacoDAO = espacoDAO;
        this.esporteDAO = esporteDAO;
        this.parceiroDAO = parceiroDAO;
        this.usuarioLogado = usuarioLogado;
    }

    public void salvar(Espaco espaco) {
        Parceiro parceiro = parceiroDAO.buscarPorId(usuarioLogado.getUsuario().getId());
        espaco.setProprietario(parceiro);
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

    public List<OpcaoSelect> geraListaOpcoesEsportes() {
        List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
        return todos.stream().map(esportes -> new OpcaoSelect(esportes.getNome(), esportes.getId()))
                .collect(Collectors.toList());
    }

    public List<Espaco> espacosMaisReservados() {
        return espacoDAO.espacosMaisReservados();
    }
}
