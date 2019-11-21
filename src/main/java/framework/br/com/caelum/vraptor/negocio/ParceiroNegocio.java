package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.dao.ParceiroDAO;
import framework.br.com.caelum.vraptor.model.Parceiro;

import java.util.List;

public class ParceiroNegocio {

    private ParceiroDAO parceiroDAO;

    public ParceiroNegocio() { this(null); }

    public ParceiroNegocio(ParceiroDAO parceiroDAO) {
        this.parceiroDAO = parceiroDAO;
    }

    public void salvar(Parceiro parceiro) {
        parceiroDAO.salvar(parceiro);
    }

    public Parceiro editar(Long id) {
        return parceiroDAO.buscarPorId(id);
    }

    public void remover(Long id) {
        Parceiro parceiro = parceiroDAO.buscarPorId(id);
        parceiro.setDeletado(true);
        parceiroDAO.salvar(parceiro);
    }

    public List<Parceiro> listar() {
        return (List<Parceiro>) parceiroDAO.listar();
    }
}
