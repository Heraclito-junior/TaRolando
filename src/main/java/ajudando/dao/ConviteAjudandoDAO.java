package ajudando.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.dao.EntidadeDAO;
import framework.br.com.caelum.vraptor.model.Convite;
import framework.br.com.caelum.vraptor.model.ConviteCasamento;

public interface ConviteAjudandoDAO extends EntidadeDAO<ConviteCasamento> {

    List<ConviteCasamento> meusConvites();
    List<ConviteCasamento> meusConvitesEnviados();
}
