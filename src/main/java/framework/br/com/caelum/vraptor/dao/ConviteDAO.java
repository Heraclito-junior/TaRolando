package framework.br.com.caelum.vraptor.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.model.Convite;

public interface ConviteDAO extends EntidadeDAO<Convite> {

    List<Convite> meusConvites();
    List<Convite> meusConvitesEnviados();
}
