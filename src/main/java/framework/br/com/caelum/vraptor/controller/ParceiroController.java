package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.model.Parceiro;
import framework.br.com.caelum.vraptor.negocio.ParceiroNegocio;

import javax.inject.Inject;

@Controller
public class ParceiroController extends ControladorTaRolando<Parceiro> {

    private ParceiroNegocio parceiroNegocio;

    public ParceiroController() { this(null, null); }

    @Inject
    public ParceiroController(Result resultado, ParceiroNegocio parceiroNegocio) {
        super(resultado);
        this.parceiroNegocio = parceiroNegocio;
    }


    public void form() {

    }

    @Transacional
    @Post
    public void salvar(Parceiro parceiro) {
        parceiroNegocio.salvar(parceiro);
        resultado.redirectTo(this).listar();
    }

    public void editar(Long id) {
        resultado.include("parceiro", parceiroNegocio.editar(id));
        resultado.of(this).form();
    }

    @Transacional
    @Post
    public void remover(Long id) {
        parceiroNegocio.remover(id);
        resultado.redirectTo(this).listar();
    }

    @Get
    public void listar() {
        resultado.include("parceiros", parceiroNegocio.listar());
    }
}
