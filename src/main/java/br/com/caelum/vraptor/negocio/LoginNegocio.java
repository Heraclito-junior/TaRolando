package br.com.caelum.vraptor.negocio;

import br.com.caelum.vraptor.dao.EsporteDAO;
import br.com.caelum.vraptor.dao.AtletaDAO;
import br.com.caelum.vraptor.model.Esporte;
import br.com.caelum.vraptor.model.TipoAtleta;
import br.com.caelum.vraptor.model.Atleta;
import br.com.caelum.vraptor.util.Criptografia;
import br.com.caelum.vraptor.util.OpcaoSelect;
import br.com.caelum.vraptor.util.exception.AtletaJaExistenteException;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LoginNegocio {

	@Inject
	private AtletaDAO atletaDao;

	@Inject
	private EsporteDAO esporteDAO;

	

	public LoginNegocio() {
	}

	public Atleta validarUsuario(Atleta atleta) {
		if (atleta != null) {
			Optional<Atleta> atletaBanco = this.atletaDao.buscarPorLogin(atleta.getLogin());
			if (atletaBanco.isPresent()) {
				if (compararSenha(atleta.getSenha(), atletaBanco.get().getSenha())) {
					return atletaBanco.get();
				}
			}
		}
		return null;
	}

	public void validarUsuarioExistente(Atleta atleta) throws AtletaJaExistenteException {
		if (atleta != null) {
			Optional<Atleta> atletaBanco = this.atletaDao.buscarPorLogin(atleta.getLogin());
			if (atletaBanco.isPresent()) {
				throw new AtletaJaExistenteException();

			}
		}
		return;
	}

	private boolean compararSenha(String senha, String senhaBanco) {
		if (Criptografia.criptografar(senha).equals(senhaBanco)) {
			return true;
		}
		return false;
	}

	public List<OpcaoSelect> geraListaOpcoesEsportes() {
		List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
		return todos.stream().map(esportes -> new OpcaoSelect(esportes.getNome(), esportes.getId()))
				.collect(Collectors.toList());
	}

	public void setar(Atleta atleta) {
		atleta.setTipoAtleta(TipoAtleta.ATLETA);
		atleta.setSenha(criptografarSenha(atleta.getSenha()));

	}

	private String criptografarSenha(String senha) {
		return Criptografia.criptografar(senha);
	}

}
