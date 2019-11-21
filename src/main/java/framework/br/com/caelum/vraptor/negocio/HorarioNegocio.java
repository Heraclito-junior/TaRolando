//package framework.br.com.caelum.vraptor.negocio;
//
//import framework.br.com.caelum.vraptor.dao.AtividadeDAO;
//import framework.br.com.caelum.vraptor.dao.AtletaDAO;
//import framework.br.com.caelum.vraptor.dao.EventoDAO;
//import framework.br.com.caelum.vraptor.dao.HorarioDAO;
//import framework.br.com.caelum.vraptor.model.Atividade;
//import framework.br.com.caelum.vraptor.model.Atleta;
//import framework.br.com.caelum.vraptor.model.Evento;
//import framework.br.com.caelum.vraptor.model.Horario;
//
//import javax.inject.Inject;
//import java.time.LocalTime;
//import java.util.List;
//
//public class HorarioNegocio {
//
//    private HorarioDAO horarioDAO;
//    private AtividadeDAO atividadeDAO;
//    private AtletaDAO atletaDAO;
//
//    @Inject
//    EventoDAO eventoDAO;
//
//    @Deprecated
//    public HorarioNegocio() {this(null, null, null);}
//
//    @Inject
//    public HorarioNegocio(HorarioDAO horarioDAO, AtividadeDAO atividadeDAO, AtletaDAO atletaDAO) {
//        this.horarioDAO = horarioDAO;
//        this.atividadeDAO = atividadeDAO;
//        this.atletaDAO = atletaDAO;
//    }
//
//    public void salvar(Long id, String horaInicio, String horaFim){
//        Horario horario = new Horario();
//        Atividade atividade = atividadeDAO.buscarPorId(id);
//        horario.setAtividade(atividade);
//        horario.setHoraInicio(LocalTime.parse(horaInicio));
//        horario.setHoraFim(LocalTime.parse(horaFim));
//        horarioDAO.salvar(horario);
//    }
//
//    public Horario editar(Long id) {
//        return horarioDAO.buscarPorId(id);
//    }
//
//    public void remover(Long id) {
//        Horario horario = horarioDAO.buscarPorId(id);
//        horario.setDeletado(true);
//        horarioDAO.salvar(horario);
//    }
//
//    public List<Horario> listar() {
//        return (List<Horario>) horarioDAO.listar();
//    }
//
//    public List<Horario> meusHorarios(Long id) {
//        return horarioDAO.meusHorarios(id);
//    }
//
//    public List<Horario> meusHorariosLivres(Long id) {
//        return horarioDAO.meusHorariosLivres(id);
//    }
//
//    public Long reservar(Long idHorario, Long idAtleta) {
//        Horario horario = horarioDAO.buscarPorId(idHorario);
//        Atleta atleta = atletaDAO.buscarPorId(idAtleta);
//
//        horario.setDisponivel(false);
//        horario.setAtleta(atleta);
//        horarioDAO.salvar(horario);
//
//        return horario.getAtividade().getId();
//    }
//
//    public List<Horario> minhasReservas() {
//        return horarioDAO.minhasReservas();
//    }
//
//    public void integrarAEvento(Long idHorario, Long idEvento) {
//        Horario horario = horarioDAO.buscarPorId(idHorario);
//        Evento evento = eventoDAO.buscarPorId(idEvento);
//
//        horario.setEvento(evento);
//        evento.setHorario(horario);
//        horarioDAO.salvar(horario);
//    }
//
//    public void desintegrarEvento(Long id) {
//        Horario horario = horarioDAO.buscarPorId(id);
//
//        horario.getEvento().setHorario(null);
//        horario.setEvento(null);
//        horarioDAO.salvar(horario);
//    }
//}
