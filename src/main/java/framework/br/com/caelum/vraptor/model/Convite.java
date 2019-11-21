package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Convite extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected boolean aceito;
    protected boolean deletado;

    @ManyToOne
    protected Atleta convidado;

    

    @Deprecated
    public Convite() {
    }

    public Convite( Atleta convidado){
        this.convidado = convidado;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito) {
        this.aceito = aceito;
    }

    public Atleta getConvidado() {
        return convidado;
    }

    public void setConvidado(Atleta convidado) {
        this.convidado = convidado;
    }


    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }
}
