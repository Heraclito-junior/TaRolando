package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.model.Espaco;
import framework.br.com.caelum.vraptor.negocio.AtividadeNegocio;
import framework.br.com.caelum.vraptor.negocio.EspacoNegocio;

import javax.inject.Inject;

@Controller
public class EspacoController extends ControladorTaRolando<Espaco> {

    private EspacoNegocio espacoNegocio;
    private AtividadeNegocio atividadeNegocio;

    @Deprecated
    public EspacoController() { this(null, null, null); }

    @Inject
    public EspacoController(Result resultado, EspacoNegocio espacoNegocio, AtividadeNegocio atividadeNegocio) {
        super(resultado);
        this.espacoNegocio = espacoNegocio;
        this.atividadeNegocio = atividadeNegocio;
    }


    public void form () {

    }

    @Post
    @Transacional
    public void salvar(Espaco espaco) {
        espacoNegocio.salvar(espaco);
        resultado.redirectTo(this).meusEspacos();
    }

    public void editar(Long id) {
        Espaco espaco = espacoNegocio.editar(id);
        resultado.of(this).form();
    }

    @Post
    @Transacional
    public void remover(Long id) {
        espacoNegocio.remover(id);
        resultado.redirectTo(this).meusEspacos();
    }

    @Get
    public void meusEspacos() {
        resultado.include("espacos", espacoNegocio.meusEspacos());
    }

    @Get
    public void lista() {
        resultado.include("espacos", espacoNegocio.listar());
    }

    @Get
    public void detalhar(Long id) {
        resultado.include("espaco", espacoNegocio.detalhar(id));
        resultado.include("atividades", atividadeNegocio.minhasAtividades(id));
    }

    @Get
    public void visualizar(Long id) {
        resultado.include("espaco", espacoNegocio.detalhar(id));
        resultado.include("atividades", atividadeNegocio.minhasAtividades(id));
    }
}
