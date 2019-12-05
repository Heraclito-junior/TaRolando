package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;

@Entity
public class ConviteCasamento extends Convite {

    private String email;

    private String nomeConvidado;

    private String grupo;

    private boolean compareceu;

    @OneToOne
    private Presente presente;

    @ManyToOne
    private EventoCasamento eventoCasamento;

    public ConviteCasamento() {
        super();
    }

    public ConviteCasamento(EventoCasamento evento,UsuarioCasamento convidado,double valor,String participacao) {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeConvidado() {
        return nomeConvidado;
    }

    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public boolean isCompareceu() {
        return compareceu;
    }

    public void setCompareceu(boolean compareceu) {
        this.compareceu = compareceu;
    }

    public Presente getPresente() {
        return presente;
    }

    public void setPresente(Presente presente) {
        this.presente = presente;
    }

    public EventoCasamento getEventoCasamento() {
        return eventoCasamento;
    }

    public void setEventoCasamento(EventoCasamento eventoCasamento) {
        this.eventoCasamento = eventoCasamento;
    }
}
