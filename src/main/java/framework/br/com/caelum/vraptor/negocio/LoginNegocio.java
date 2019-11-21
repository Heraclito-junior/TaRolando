package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.dao.EsporteDAO;
import framework.br.com.caelum.vraptor.dao.ParceiroDAO;
import framework.br.com.caelum.vraptor.model.*;
import framework.br.com.caelum.vraptor.util.Criptografia;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;
import framework.br.com.caelum.vraptor.util.exception.AtletaJaExistenteException;
import framework.br.com.caelum.vraptor.util.exception.ParceiroJaExistenteException;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LoginNegocio {

	@Inject
	private AtletaDAO atletaDao;

	@Inject
	private ParceiroDAO parceiroDAO;

	@Inject
	private EsporteDAO esporteDAO;

	

	public LoginNegocio() {
	}

	public Atleta validarAtleta(Atleta atleta) {
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

    public Parceiro validarParceiro(Parceiro parceiro) {
        if (parceiro != null) {
            Optional<Parceiro> parceiroBanco = this.parceiroDAO.buscarPorLogin(parceiro.getLogin());
            if (parceiroBanco.isPresent()) {
                if (compararSenha(parceiro.getSenha(), parceiroBanco.get().getSenha())) {
                    return parceiroBanco.get();
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
			atleta.setTipoUsuario(TipoUsuario.ATLETA);
			atleta.setDataCadastro(LocalDateTime.now());
			atleta.setDeletado(false);
			atletaDao.salvar(atleta);
		}
		return;
	}

	public void validarParceiroExistente(Parceiro parceiro) throws ParceiroJaExistenteException {
		if (parceiro != null) {
			Optional<Parceiro> parceiroBanco = this.parceiroDAO.buscarPorLogin(parceiro.getLogin());
			if (parceiroBanco.isPresent()) {
				throw new ParceiroJaExistenteException();

			} else {
				parceiro.setTipoUsuario(TipoUsuario.PARCEIRO);
				parceiro.setDataCadastro(LocalDateTime.now());
				parceiro.setPermissao(false);
				parceiro.setDeletado(false);
				parceiroDAO.salvar(parceiro);
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
		atleta.setTipoUsuario(TipoUsuario.ATLETA);
		atleta.setSenha(criptografarSenha(atleta.getSenha()));

	}

	public void setarParceiro(Parceiro parceiro) {
		parceiro.setTipoUsuario(TipoUsuario.PARCEIRO);
		parceiro.setSenha(criptografarSenha(parceiro.getSenha()));
	}

	private String criptografarSenha(String senha) {
		return Criptografia.criptografar(senha);
	}
}
