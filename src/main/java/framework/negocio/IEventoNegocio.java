package framework.negocio;

import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.Evento;
import br.com.caelum.vraptor.util.OpcaoSelect;
import br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import br.com.caelum.vraptor.util.exception.UsuarioInexistenteException;
import br.com.caelum.vraptor.util.exception.VagasInvalidasException;

import java.util.ArrayList;
import java.util.List;

public interface IEventoNegocio {

    List<OpcaoSelect> geraListaOpcoesEventos();
    void definirAdministradorESalvar(Evento evento) throws VagasInvalidasException;
    void modificarEvento(Evento evento);
    void buscarEDeletar(Long id) throws UsuarioInexistenteException;
    Object listar();
    Evento detalhar(Long id);
    Object meusEventos();
    Object meusAlertas();
    void inserirUsuario(Long id, String login) throws UsuarioInexistenteException;
    void removerUsuario(Long id, String login);
}
