package framework.br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.validator.SimpleMessage;
import framework.br.com.caelum.vraptor.anotacoes.Transacional;
import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.model.*;
import framework.br.com.caelum.vraptor.negocio.LoginNegocio;
import framework.br.com.caelum.vraptor.util.mensagemCustominizada;
import framework.br.com.caelum.vraptor.util.exception.AtletaJaExistenteException;
import framework.br.com.caelum.vraptor.util.exception.ParceiroJaExistenteException;
import framework.br.com.caelum.vraptor.util.exception.SenhaVaziaException;

import javax.inject.Inject;

@Path("/")
@Controller
public class LoginController extends Controlador {

	private AtletaLogado atletaLogado;
	private ParceiroLogado parceiroLogado;
	private LoginNegocio loginNegocio;
	private UsuarioLogado usuarioLogado;

	@Deprecated
	public LoginController() {
		this(null, null, null, null, null, null);
	}

	@Inject
	public LoginController(AtletaLogado atletaLogado, Result resultado, AtletaDAO atletaDao,
			LoginNegocio loginNegocio, ParceiroLogado parceiroLogado, UsuarioLogado usuarioLogado) {
		super(resultado);
		this.atletaLogado = atletaLogado;
		this.loginNegocio = loginNegocio;
		this.parceiroLogado = parceiroLogado;
		this.usuarioLogado = usuarioLogado;
	}

	@Post("/login")
	public void login(Atleta atleta) {
		Atleta atletaLogin = null;
		try {
			atletaLogin = this.loginNegocio.validarAtleta(atleta);
		} catch (SenhaVaziaException e) {
			// TODO Auto-generated catch block
			this.resultado.include("mensagem", new SimpleMessage("error", "login.dadoIncorreto"));
			this.resultado.of(this).form();
			return;
		}
		if (atletaLogin != null) {
			usuarioLogado.setUsuario(atletaLogin);
			this.resultado.redirectTo(InicioController.class).index();
		} else {
			this.resultado.include("mensagem", new SimpleMessage("error", "login.dadoIncorreto"));
			this.resultado.of(this).form();
		}
	}

	@Post("/loginParceiro")
	public void loginParceiro(Parceiro parceiro) {
		Parceiro parceiroLogin = null;
		try {
		parceiroLogin = this.loginNegocio.validarParceiro(parceiro);
		}catch(SenhaVaziaException e) {
			this.resultado.include("mensagem", new SimpleMessage("error", "login.dadoIncorreto"));
			this.resultado.of(this).formParceiro();
			return;

		}
		if (parceiroLogin != null) {
			usuarioLogado.setUsuario(parceiroLogin);
			this.resultado.redirectTo(InicioController.class).indexParceiro();
		} else {
			this.resultado.include("mensagem", new SimpleMessage("error", "login.dadoIncorreto"));
			this.resultado.of(this).formParceiro();
		}
	}

	@Path("/")
	public void form() {

	}

	@Path("/formParceiro")
	public void formParceiro() {
	}

	@Get("/logout")
	public void logout() {
		this.usuarioLogado.desloga();
		this.resultado.redirectTo(this).form();
	}

	@Path("/registro")
	public void registro() {
		this.resultado.include("esportes", loginNegocio.geraListaOpcoesEsportes());
	}

	@Path("/registroParceiro")
	public void registroParceiro() {
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

	@Post("/salvarParceiro")
	@Transacional
	public void salvarParceiro(Parceiro parceiro) {
		loginNegocio.setarParceiro(parceiro);
		try {
			loginNegocio.validarParceiroExistente(parceiro);
		} catch (ParceiroJaExistenteException e) {
			this.resultado.include("mensagem", new mensagemCustominizada("Login Já Existente", "error"));
			this.resultado.redirectTo(this).registroParceiro();
			return;
		}
		this.resultado.redirectTo(this).form();
	}

}
