package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.model.Evento;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;
import framework.br.com.caelum.vraptor.util.exception.VagasInvalidasException;

import java.util.List;

public interface  EventoNegocio<T>{


	public void definirAdministradorESalvar(T evento) throws VagasInvalidasException;
	
	public void modificarEvento(T evento);

	public void buscarEDeletar(Long id) throws AtletaInexistenteException;

	public Object listar();

	public Evento detalhar(Long id);

	public Object meusEventos();
	

}
