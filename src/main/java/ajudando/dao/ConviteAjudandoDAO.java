package ajudando.dao;

import java.util.List;

import framework.br.com.caelum.vraptor.dao.EntidadeDAO;
import framework.br.com.caelum.vraptor.model.Convite;
import framework.br.com.caelum.vraptor.model.ConviteAjudando;

public interface ConviteAjudandoDAO extends EntidadeDAO<ConviteAjudando> {

    List<ConviteAjudando> meusConvites();
    List<ConviteAjudando> meusConvitesEnviados();
    List<ConviteAjudando> convitesPorEvento(Long idEvento);
}
