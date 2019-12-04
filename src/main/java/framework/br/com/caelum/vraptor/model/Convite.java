package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Convite extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Deprecated
    public Convite() {
    }



    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
