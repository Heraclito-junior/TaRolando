package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.anotacoes.Transacional;
import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.model.AtletaLogado;
import br.com.caelum.vraptor.model.TipoAtleta;
import br.com.caelum.vraptor.negocio.LoginNegocio;
import br.com.caelum.vraptor.util.Criptografia;
import br.com.caelum.vraptor.util.mensagemCustominizada;
import br.com.caelum.vraptor.util.exception.AtletaJaExistenteException;
import br.com.caelum.vraptor.validator.SimpleMessage;

import javax.inject.Inject;

@Path("/")
@Controller
public class LoginController extends Controlador {

	private AtletaLogado atletaLogado;
	private LoginNegocio loginNegocio;

	@Deprecated
	public LoginController() {
		this(null, null, null, null);
	}

	@Inject
	public LoginController(AtletaLogado atletaLogado, Result resultado, AtletaDAO atletaDao,
			LoginNegocio loginNegocio) {
		super(resultado);
		this.atletaLogado = atletaLogado;
		this.loginNegocio = loginNegocio;
	}

	@Post("/login")
	public void login(Atleta atleta) {
		Atleta atletaLogin = this.loginNegocio.validarUsuario(atleta);
		if (atletaLogin != null) {
			atletaLogado.setAtleta(atletaLogin);
			this.resultado.redirectTo(InicioController.class).index();
		} else {
			this.resultado.include("mensagem", new SimpleMessage("error", "login.dadoIncorreto"));
			this.resultado.of(this).form();
		}
	}

	@Path("/")
	public void form() {

	}

	@Get("/logout")
	public void logout() {
		this.atletaLogado.desloga();
		this.resultado.redirectTo(this).form();
	}

	@Path("/registro")
	public void registro() {
		this.resultado.include("esportes", loginNegocio.geraListaOpcoesEsportes());
	}

	@Post("/salvar")
	@Transacional
	public void salvar(Atleta atleta) {
		loginNegocio.setar(atleta);
		try {
			loginNegocio.validarUsuarioExistente(atleta);
		} catch (AtletaJaExistenteException e) {
			this.resultado.include("mensagem", new mensagemCustominizada("Login Já Existente", "error"));
			this.resultado.redirectTo(this).registro();
			return;
		}
		this.resultado.redirectTo(this).form();
	}

	

}
