package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.model.Atividade;
import br.com.caelum.vraptor.model.StatusPagamento;
import br.com.caelum.vraptor.negocio.AtividadeNegocio;
import br.com.caelum.vraptor.negocio.EspacoNegocio;
import br.com.caelum.vraptor.negocio.EsporteNegocio;
import br.com.caelum.vraptor.negocio.HorarioNegocio;
import br.com.caelum.vraptor.util.OpcaoSelect;

import javax.inject.Inject;

@Controller
public class AtividadeController extends ControladorTaRolando<Atividade> {

    private AtividadeNegocio atividadeNegocio;
    private EspacoNegocio espacoNegocio;
    private HorarioNegocio horarioNegocio;

    @Deprecated
    public AtividadeController() { this(null, null, null, null); }

    @Inject
    public AtividadeController(Result resultado, AtividadeNegocio atividadeNegocio, EspacoNegocio espacoNegocio, HorarioNegocio horarioNegocio) {
        super(resultado);
        this.atividadeNegocio = atividadeNegocio;
        this.espacoNegocio = espacoNegocio;
        this.horarioNegocio = horarioNegocio;
    }

    @Path("/form")
    public void form(Long id) {
        resultado.include("espaco", espacoNegocio.detalhar(id));
        resultado.include("esportes", espacoNegocio.geraListaOpcoesEsportes());
    }

    @Post
    @Transacional
    public void salvar(Atividade atividade) {
        atividadeNegocio.salvar(atividade);
        resultado.redirectTo(this).minhasAtividades(atividade.getEspaco().getId());
    }

    public void editar(Long id) {
        Atividade atividade = atividadeNegocio.editar(id);
        resultado.of(this).form(atividade.getEspaco().getId());
    }

    @Post
    @Transacional
    public void remover(Long id) {
        atividadeNegocio.remover(id);
        resultado.redirectTo(this).lista();
    }

    @Get
    public void detalhar(Long id) {
        resultado.include("atividade", atividadeNegocio.detalhar(id));
        resultado.include("horarios", horarioNegocio.meusHorarios(id));
    }

    @Get
    public void lista() {
        resultado.include("atividades", atividadeNegocio.listar());
    }

    @Get
    public void minhasAtividades(Long id) {
        resultado.include("atividades", atividadeNegocio.minhasAtividades(id));
    }

    @Get
    public void visualizar(Long idAtividade) {
        resultado.include("atividade", atividadeNegocio.detalhar(idAtividade));
        resultado.include("horarios", horarioNegocio.meusHorariosLivres(idAtividade));
    }
}

