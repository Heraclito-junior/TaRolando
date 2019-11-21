package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.model.Evento;
import framework.br.com.caelum.vraptor.negocio.AlertaNegocio;

import javax.inject.Inject;

@Path("/alerta")
@Controller
public class AlertaController extends ControladorTaRolando<Evento> {

	@Inject
	private AlertaNegocio negocio;




	@Deprecated
	public AlertaController() {
		this(null);
	}
	

	@Inject
	public AlertaController(Result resultado) {
		super(resultado);

	}


	public void lista() {
		this.resultado.include("AlertaTabela", negocio.meusAlertas());
	}


}
