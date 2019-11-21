package framework.br.com.caelum.vraptor.negocio;

import framework.br.com.caelum.vraptor.dao.AtletaDAO;
import framework.br.com.caelum.vraptor.dao.EsporteDAO;
import framework.br.com.caelum.vraptor.model.Atleta;
import framework.br.com.caelum.vraptor.model.Esporte;
import framework.br.com.caelum.vraptor.util.Criptografia;
import framework.br.com.caelum.vraptor.util.OpcaoSelect;
import framework.br.com.caelum.vraptor.util.exception.AtletaInexistenteException;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class AtletaNegocio {

    private AtletaDAO dao;
    private EsporteDAO esporteDAO;

    public AtletaNegocio() {this(null, null);}

    @Inject
    public AtletaNegocio(AtletaDAO atletaDAO, EsporteDAO esporteDAO) {
        this.dao = atletaDAO;
        this.esporteDAO = esporteDAO;
    }

    public List<OpcaoSelect> geraListaOpcoesEsportes() {
        List<Esporte> todos = this.esporteDAO.listar().stream().collect(Collectors.toList());
        return todos.stream().map(
                esportes -> new OpcaoSelect(esportes.getNome(), esportes.getId()))
                .collect(Collectors.toList());
    }

	public void salvar(Atleta atleta) throws AtletaInexistenteException {
        atleta.setSenha(criptografarSenha(atleta.getSenha()));
        
        if (atleta.getId() == null) {
            this.dao.salvar(atleta);
            throw new AtletaInexistenteException("Atleta não existe");
        } else {
            this.dao.salvar(atleta);
        }
        
	}
	
	
	
	
	private String criptografarSenha(String senha) {
        return Criptografia.criptografar(senha);
    }

	public Atleta perfil(Long id) {
		// TODO Auto-generated method stub
		return this.dao.buscarPorId(id);
		
	}
	
}
