package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Convite;

import java.util.List;

public interface ConviteDAO extends EntidadeDAO<Convite> {

    List<Convite> meusConvites();
    List<Convite> meusConvitesEnviados();
}
