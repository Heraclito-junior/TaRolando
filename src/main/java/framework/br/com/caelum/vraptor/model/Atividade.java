package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Atividade extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Long numReservas;
    private boolean deletado;

    @OneToOne
    private Esporte esporte;

    @ManyToOne
    private Espaco espaco;

    @OneToMany
    private List<Horario> horarios;


    public Atividade() {
        this.numReservas = Long.valueOf(0);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public Long getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(Long numReservas) {
        this.numReservas = numReservas;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
