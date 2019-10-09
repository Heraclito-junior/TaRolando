package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Espaco;

import java.util.List;

public interface EspacoDAO extends EntidadeDAO<Espaco> {

    List<Espaco> meusEspacos(Long id);
    List<Espaco> espacosMaisReservados();
}
