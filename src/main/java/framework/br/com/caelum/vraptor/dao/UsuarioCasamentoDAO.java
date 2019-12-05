package framework.br.com.caelum.vraptor.dao;

import framework.br.com.caelum.vraptor.model.UsuarioCasamento;

public interface UsuarioCasamentoDAO {

    UsuarioCasamento buscarPorLogin(String login);
}
