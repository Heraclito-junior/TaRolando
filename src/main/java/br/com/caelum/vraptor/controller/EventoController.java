package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.dao.ConviteDAO;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.Convite;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.negocio.AtletaNegocio;
import br.com.caelum.vraptor.negocio.EventoNegocio;
import br.com.caelum.vraptor.validator.Validator;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.util.Optional;

@Path("/evento")
@Controller
public class EventoController extends ControladorTaRolando<Evento>{

    private EventoDAO dao;
    private EventoNegocio negocio;
    private Validator validator;

    @Inject
    private ServletContext context;

    @Inject
    private AtletaDAO atletaDAO;
    @Inject
    private AtletaNegocio atletaNegocio;
    @Inject
    private AtletaLogado atletaLogado;

    @Inject
    private Convite convite;
    @Inject
    private ConviteDAO conviteDAO;


    @Deprecated
    public EventoController() { this(null, null, null, null); }

    @Inject
    public EventoController(Result resultado, EventoDAO dao, EventoNegocio negocio, Validator validator) {
        super(resultado);
        this.dao = dao;
        this.negocio = negocio;
        this.validator = validator;
    }

    public void form() {
//        this.resultado.include("atletaLogado", this.atletaLogado);
        resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
    }

    @Transacional
    @Post
    public void salvar(Evento evento) {
        this.validator.onErrorRedirectTo(this).form();

        evento.setOrganizador(this.atletaLogado.getAtleta());
        this.dao.salvar(evento);
        this.resultado.redirectTo(this).lista();
    }


    @Transacional
    public void remover(Long id) {
        Evento evento = this.dao.buscarPorId(id);
        evento.setDeletado(true);
        this.dao.salvar(evento);
        this.resultado.redirectTo(this).lista();
    }

    public void lista() {
        this.resultado.include("eventos", this.dao.listar());
    }

    public void meusEventos() {
        this.resultado.include("eventos", this.dao.meusEventos());
    }


    public void detalhar(Long id) {
        Evento evento = this.dao.buscarPorId(id);
        this.resultado.include("numParticipantes", evento.getParticipantes().size());
        this.resultado.include("evento", evento);
        this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
    }

    @Transacional
    public void convidarAtleta(Long id, String login) {
        Evento evento = this.dao.buscarPorId(id);
        Optional<Atleta> atleta = this.atletaDAO.buscarPorLogin(login);
        if (!evento.getParticipantes().contains(atleta)) {
            evento.getParticipantes().add(atleta.get());
        }
        this.dao.salvar(evento);
        this.resultado.redirectTo(this).detalhar(id);

//        Atleta atleta = this.atletaDAO.buscarPorLogin(login).get();
//        convite.setEvento(evento);
//        convite.setAtleta(atleta);
//        conviteDAO.salvar(convite);

    }





}
