package framework.br.com.caelum.vraptor.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.model.Horario;

public interface HorarioDAO extends EntidadeDAO<Horario> {
    List<Horario> meusHorarios(Long id);
    List<Horario> meusHorariosLivres(Long id);
    List<Horario> minhasReservas();
}
