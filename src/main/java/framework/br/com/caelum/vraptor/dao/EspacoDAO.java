package framework.br.com.caelum.vraptor.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.model.Espaco;

public interface EspacoDAO extends EntidadeDAO<Espaco> {

    List<Espaco> meusEspacos(Long id);
    List<Espaco> espacosMaisReservados();
}
