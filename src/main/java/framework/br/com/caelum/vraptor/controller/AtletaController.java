package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.TipoAtleta;
import framework.br.com.caelum.vraptor.negocio.AtletaNegocio;
import framework.br.com.caelum.vraptor.util.Criptografia;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;

@Controller
public class AtletaController extends ControladorTaRolando<Atleta> {
	@Inject
	private AtletaNegocio negocio;

	@Deprecated
	public AtletaController() {
		this(null, null);
	}

	@Inject
	public AtletaController(Result resultado, AtletaNegocio negocio) {
		super(resultado);
		this.negocio = negocio;
	}

	public void form() {
		resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
	}

	@Post
	@Transacional
	public void salvar(Atleta atleta) {

		try {
			negocio.salvar(atleta);
			atleta.setSenha(criptografarSenha(atleta.getSenha()));

			this.resultado.redirectTo(InicioController.class).index();

		} catch (AtletaInexistenteException e) {
			this.resultado.redirectTo(LoginController.class).form();

		}

	}

	public void atualizarSenha() {
	}

	public void remover(Long id) {

	}

	public void perfil(Long id) {
		
		Atleta atleta = negocio.perfil(id);
		this.resultado.include("atleta", atleta);
		this.resultado.include("tipoAtleta", OpcaoSelect.toListaOpcoes(TipoAtleta.values()));
		this.resultado.include("esportes", this.negocio.geraListaOpcoesEsportes());
	}

	private String criptografarSenha(String senha) {
		return Criptografia.criptografar(senha);
	}

}
