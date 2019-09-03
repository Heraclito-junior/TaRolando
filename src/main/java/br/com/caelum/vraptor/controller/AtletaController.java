package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.TipoAtleta;
import br.com.caelum.vraptor.negocio.AtletaNegocio;
import br.com.caelum.vraptor.util.Criptografia;
import br.com.caelum.vraptor.util.OpcaoSelect;

import javax.inject.Inject;

@Controller
public class AtletaController extends ControladorTaRolando<Atleta> {

    private AtletaDAO dao;
    private AtletaNegocio negocio;

    @Deprecated
    public AtletaController() { this(null, null, null);}

    @Inject
    public AtletaController(Result resultado, AtletaDAO dao, AtletaNegocio negocio) {
        super(resultado);
        this.dao = dao;
        this.negocio = negocio;
    }

    public void form() {
        resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
    }

    @Post
    @Transacional
    public void salvar(Atleta atleta) {

        atleta.setSenha(criptografarSenha(atleta.getSenha()));

        if (atleta.getId() == null) {
            this.dao.salvar(atleta);
            this.resultado.redirectTo(LoginController.class).form();
        } else {
            this.dao.salvar(atleta);
            this.resultado.redirectTo(InicioController.class).index();
        }

    }

    public void atualizarSenha(){}

    public void remover(Long id) {

    }

    public void perfil(Long id) {
        Atleta atleta = this.dao.buscarPorId(id);
        this.resultado.include("atleta", atleta);
        this.resultado.include("tipoAtleta", OpcaoSelect.toListaOpcoes(TipoAtleta.values()));
        this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());

    }

    private String criptografarSenha(String senha) {
        return Criptografia.criptografar(senha);
    }

}
