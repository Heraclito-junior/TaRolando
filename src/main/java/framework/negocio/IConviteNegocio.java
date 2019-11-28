package framework.negocio;

import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaEvento;
import br.com.caelum.vraptor.model.Convite;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import java.util.List;

public interface IConviteNegocio {

    void convidar(Long id, String login) throws AtletaInexistenteException;
    void aceitar(Long id);
    void rejeitar(Long id);
    void remover(Long id);
    List<Convite> meusConvites();
    List<Convite> meusConvitesEnviados();
}
