package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import framework.br.com.caelum.vraptor.anotacoes.Seguranca;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.model.Esporte;
import framework.br.com.caelum.vraptor.model.TipoAtleta;
import framework.br.com.caelum.vraptor.negocio.EsporteNegocio;

import javax.inject.Inject;

@Seguranca(tipoUsuario = TipoAtleta.ADMINISTRADOR)
@Path("/esporte")
@Controller
public class EsporteController extends Controlador {

	private EsporteNegocio negocio;

	@Deprecated
	public EsporteController() {
		this(null, null);
	}

	@Inject
	public EsporteController(Result resultado, EsporteNegocio negocio) {
		super(resultado);
		this.negocio = negocio;
	}

	public void form() {
	}

	@Transacional
	public void salvar(Esporte esporte) {
		negocio.salvar(esporte);
		this.resultado.redirectTo(EsporteController.class).lista();
	}

	@Transacional
	public void remover(Long id) {
		negocio.remover(id);
		this.resultado.redirectTo(this).lista();
	}

	public void lista() {
		this.resultado.include("esportes", negocio.listar());
	}
}
