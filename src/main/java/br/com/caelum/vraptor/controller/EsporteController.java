package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.anotacoes.Seguranca;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.model.TipoAtleta;

import javax.inject.Inject;

@Seguranca(tipoUsuario = TipoAtleta.ADMINISTRADOR)
@Path("/esporte")
@Controller
public class EsporteController extends Controlador{

    private EsporteDAO dao;
    @Inject
    private AtletaLogado atletaLogado;

    @Deprecated
    public EsporteController() { this(null, null);}

    @Inject
    public EsporteController(Result resultado, EsporteDAO dao) {
        super(resultado);
        this.dao = dao;
    }

    public void form() {}

    @Transacional
    public void salvar(Esporte esporte){
        this.dao.salvar(esporte);
        System.out.println(atletaLogado.getAtleta().getNome());
        this.resultado.redirectTo(EsporteController.class).lista();
    }

    @Transacional
    public void remover(Long id) {
        Esporte esporte = this.dao.buscarPorId(id);
        esporte.setDeletado(true);
        this.dao.salvar(esporte);
        this.resultado.redirectTo(this).lista();
    }

    public void lista() { this.resultado.include("esportes", this.dao.listar()); }
}
