package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.EnderecoDAO;

import javax.inject.Inject;

@Path("/endereco")
@Controller
public class EnderecoController extends Controlador{

    private EnderecoDAO dao;

    public EnderecoController() { this(null, null); }

    @Inject
    public EnderecoController(Result resultado, EnderecoDAO dao) {
        super(resultado);
        this.dao = dao;
    }

    public void salvar() {

    }
}
