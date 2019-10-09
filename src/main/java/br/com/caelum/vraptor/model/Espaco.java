package br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Espaco extends Entidade {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Long numReservas;
    private boolean deletado;
//    private Endereco endereco;

    @ManyToOne
    private Parceiro proprietario;

    @OneToMany
    private List<Atividade> atividades;


    public Espaco() {
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

    public Parceiro getProprietario() {
        return proprietario;
    }

    public void setProprietario(Parceiro proprietario) {
        this.proprietario = proprietario;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    public Long getNumReservas() {
        return numReservas;
    }

    public void setNumReservas(Long numReservas) {
        this.numReservas = numReservas;
    }
}
