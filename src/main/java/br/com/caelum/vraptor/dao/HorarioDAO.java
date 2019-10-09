package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Horario;

import java.util.List;

public interface HorarioDAO extends EntidadeDAO<Horario> {
    List<Horario> meusHorarios(Long id);
    List<Horario> meusHorariosLivres(Long id);
    List<Horario> minhasReservas();
}
