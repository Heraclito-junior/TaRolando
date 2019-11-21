//package framework.br.com.caelum.vraptor.controller;
//
//import br.com.caelum.vraptor.*;
//import framework.br.com.caelum.vraptor.anotacoes.Transacional;
//import framework.br.com.caelum.vraptor.model.Atividade;
//import framework.br.com.caelum.vraptor.model.Atleta;
//import framework.br.com.caelum.vraptor.model.Horario;
//import framework.br.com.caelum.vraptor.negocio.AtletaNegocio;
//import framework.br.com.caelum.vraptor.negocio.EventoNegocio;
//import framework.br.com.caelum.vraptor.negocio.HorarioNegocio;
//
//import javax.inject.Inject;
//
//@Controller
//public class HorarioController extends ControladorTaRolando<Horario> {
//
//    private HorarioNegocio horarioNegocio;
//
//    @Deprecated
//    public HorarioController() { this(null, null); }
//
//    @Inject
//    public HorarioController(Result resultado, HorarioNegocio horarioNegocio) {
//        super(resultado);
//        this.horarioNegocio = horarioNegocio;
//    }
//
//    @Post
//    @Transacional
//    public void salvar(Long idAtividade, String horaInicio, String horaFim) {
//        horarioNegocio.salvar(idAtividade, horaInicio, horaFim);
//        resultado.redirectTo(AtividadeController.class).detalhar(idAtividade);
//    }
//
//    public void editarStatus(Long id) {
//
//    }
//
//    public void editarPagamento(Long id) {
//
//    }
//
//    @Get
//    public void editar(Long id) {
//        resultado.include("horario", horarioNegocio.editar(id));
//    }
//
//    @Transacional
//    public void remover(Long id, Long idAtividade) {
//        horarioNegocio.remover(id);
//        resultado.redirectTo(this).meusHorarios(idAtividade);
//    }
//
//    @Get
//    public void meusHorarios(Long id) {
//        resultado.include("horarios", horarioNegocio.meusHorarios(id));
//        resultado.redirectTo(AtividadeController.class).detalhar(id);
//    }
//
//    @Transacional
//    public void reservar(Long idHorario, Long idAtleta) {
//        Long idAtividade = horarioNegocio.reservar(idHorario, idAtleta);
//        resultado.redirectTo(AtividadeController.class).visualizar(idAtividade);
//    }
//
//    @Transacional
//    @Path("/integrarAEvento")
//    public void integrarAEvento(Long idHorario, Long idEvento) {
//        horarioNegocio.integrarAEvento(idHorario, idEvento);
//        resultado.redirectTo(EventoNegocio.class).detalhar(idEvento);
//    }
//
//    @Transacional
//    public void desintegrarEvento(Long id) {
//        horarioNegocio.desintegrarEvento(id);
//        resultado.redirectTo(AtletaController.class).minhasReservas();
//    }
//
////    @Get
////    public void minhasReservas() {
////        resultado.include("horarios", horarioNegocio.minhasReservas());
////    }
//}
