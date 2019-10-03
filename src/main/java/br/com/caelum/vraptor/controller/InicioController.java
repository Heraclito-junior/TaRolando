package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.EventoDAO;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.negocio.EspacoNegocio;
import br.com.caelum.vraptor.view.Results;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@Path("/inicio")
@Controller
public class InicioController extends Controlador {

    @Inject
    EventoDAO eventoDAO;

    private EspacoNegocio espacoNegocio;

    public InicioController() { this(null, null); }

    @Inject
    public InicioController(Result resultado, EspacoNegocio espacoNegocio) {
        super(resultado);
        this.espacoNegocio = espacoNegocio;
    }

    @Path("/")
    public void index(){
    }

    @Path("/indexParceiro")
    public void indexParceiro(){
        resultado.include("espacos", espacoNegocio.meusEspacos());
    }

    @Get
    public void listaEventos() {
        Collection<Evento> eventos = this.eventoDAO.listar();
        JsonArray listaEventos = new JsonArray();

        if (eventos != null) {
            for (Evento evento : eventos) {
                JsonObject jsonObject = new JsonObject();

                jsonObject.addProperty("id", evento.getId());
                jsonObject.addProperty("titulo", evento.getTitulo());
                jsonObject.addProperty("dataInicio", evento.getDataInicio());
                jsonObject.addProperty("horaInicio", evento.getHoraInicio());
                jsonObject.addProperty("horaFim", evento.getHoraFim());
                jsonObject.addProperty("latitude", evento.getLatitude());
                jsonObject.addProperty("longitude", evento.getLongitude());
                jsonObject.addProperty("numVagasMax", evento.getNumVagasMax());
                jsonObject.addProperty("numVagasMin", evento.getNumVagasMin());
                jsonObject.addProperty("dataFim", evento.getDataFim());
                jsonObject.addProperty("descricao", evento.getDescricao());
                jsonObject.addProperty("tipoEsporte", evento.getTipoEsporte().getIcone());
                listaEventos.add(jsonObject);
            }
            this.resultado.use(Results.json()).withoutRoot().from(listaEventos).recursive().serialize();
        } else {
            resultado.use(Results.json()).withoutRoot().from(listaEventos).recursive().serialize();
        }
    }

}
