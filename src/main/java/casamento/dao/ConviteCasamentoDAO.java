package casamento.dao;

import framework.br.com.caelum.vraptor.dao.EntidadeDAO;
import framework.br.com.caelum.vraptor.model.ConviteCasamento;

import java.util.List;

public interface ConviteCasamentoDAO extends EntidadeDAO<ConviteCasamento> {

    List<ConviteCasamento> meusConvites();
    List<ConviteCasamento> meusConvitesEnviados();
    List<ConviteCasamento> convitesPorEvento(Long idEvento);
}
