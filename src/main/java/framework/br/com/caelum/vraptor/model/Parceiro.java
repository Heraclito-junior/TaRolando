package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class Parceiro extends Usuario{

    private boolean permissao;
//    private TipoAtleta tipoAtleta;

//    @OneToOne
//    private Endereco endereco;
//    private List<Espaco> espacos;

    public Parceiro() {
    }


//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }

    public boolean getPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }


//    public TipoAtleta getTipoAtleta() {
//        return tipoAtleta;
//    }
//
//    public void setTipoAtleta(TipoAtleta tipoAtleta) {
//        this.tipoAtleta = tipoAtleta;
//    }
}
