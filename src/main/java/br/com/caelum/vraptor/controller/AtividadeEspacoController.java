package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.model.AtividadeEspaco;
import br.com.caelum.vraptor.model.Espaco;
import br.com.caelum.vraptor.negocio.AtividadeEspacoNegocio;
import br.com.caelum.vraptor.negocio.EspacoNegocio;

import javax.inject.Inject;

@Controller
@Path("/atividadeEspaco")
public class AtividadeEspacoController extends ControladorTaRolando<AtividadeEspaco> {

    private AtividadeEspacoNegocio atividadeEspacoNegocio;
    private EspacoNegocio espacoNegocio;

    @Deprecated
    public AtividadeEspacoController() { this(null, null, null); }

    @Inject
    public AtividadeEspacoController(Result resultado, AtividadeEspacoNegocio atividadeEspacoNegocio, EspacoNegocio espacoNegocio) {
        super(resultado);
        this.atividadeEspacoNegocio = atividadeEspacoNegocio;
        this.espacoNegocio = espacoNegocio;
    }

    @Path("/form")
    public void form(Long id) {
        resultado.include("espaco", espacoNegocio.detalhar(id));
    }

    @Post
    @Transacional
    public void salvar(AtividadeEspaco atividadeEspaco) {
        atividadeEspacoNegocio.salvar(atividadeEspaco);
        resultado.redirectTo(this).listar();
    }

    public void editar(Long id) {
        AtividadeEspaco atividadeEspaco = atividadeEspacoNegocio.editar(id);
        resultado.of(this).form(atividadeEspaco.getEspaco().getId());
    }

    @Post
    @Transacional
    public void remover(Long id) {
        atividadeEspacoNegocio.remover(id);
        resultado.redirectTo(this).listar();
    }

    @Get
    public void listar() {
        resultado.include("atividades", atividadeEspacoNegocio.listar());
    }
}

