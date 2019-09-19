package br.com.caelum.vraptor.model;

import javax.json.JsonValue;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Mensagem extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Atleta atleta;

    private LocalDate dataEnvio;

    private String mensagem;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Chat chat;

    public Mensagem(Atleta atleta, LocalDate dataEnvio, String msg, Chat chat) {
        this.atleta = atleta;
        this.dataEnvio = dataEnvio;
        this.mensagem = msg;
        this.chat = chat;
    }

    public Mensagem(String atletaID, JsonValue dataEnvio, String mensagem) {
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
