package framework.br.com.caelum.vraptor.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class EventoCasamento extends Evento {


    @OneToMany
    private List<Presente> presentes;

    private int maxConvidados;

    private double custoPorPessoa;

    public EventoCasamento() {
        super();
    }



    public List<Presente> getPresentes() {
        return presentes;
    }

    public void setPresentes(List<Presente> presentes) {
        this.presentes = presentes;
    }

    public int getMaxConvidados() {
        return maxConvidados;
    }

    public void setMaxConvidados(int maxConvidados) {
        this.maxConvidados = maxConvidados;
    }

    public double getCustoPorPessoa() {
        return custoPorPessoa;
    }

    public void setCustoPorPessoa(double custoPorPessoa) {
        this.custoPorPessoa = custoPorPessoa;
    }
}
