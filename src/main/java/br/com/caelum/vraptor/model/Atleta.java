package br.com.caelum.vraptor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Atleta extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private boolean deletado;

    @NotNull
    private String login;
    @NotNull
    private String senha;

    @Transient
    private String novaSenha;

    @Transient
    private String confirmaSenha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoAtleta tipoAtleta;

    @ManyToOne(fetch = FetchType.EAGER)
    private Esporte esportePreferido;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Evento> eventos;

//    @ManyToOne(cascade = CascadeType.ALL    )
//    private Convite convite;

    @Deprecated
    public Atleta() {
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    public TipoAtleta getTipoAtleta() {
        return tipoAtleta;
    }

    public void setTipoAtleta(TipoAtleta tipoAtleta) {
        this.tipoAtleta = tipoAtleta;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Esporte getEsportePreferido() {
        return esportePreferido;
    }

    public void setEsportePreferido(Esporte esportePreferido) {
        this.esportePreferido = esportePreferido;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
