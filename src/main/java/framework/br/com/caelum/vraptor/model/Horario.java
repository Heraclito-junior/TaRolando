package framework.br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class Horario extends Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime horaInicio;
    private LocalTime horaFim;
    private boolean disponivel;
    private boolean realizado;
    private StatusPagamento pagamento;
    private double valorPago;
    private boolean deletado;

    @ManyToOne
    private Atividade atividade;

    @ManyToOne
    private Atleta atleta;

    @OneToOne(cascade = CascadeType.ALL)
    private EventoAjudando evento;

    public Horario() {
        this.disponivel = true;
        this.realizado = false;
        this.pagamento = StatusPagamento.NAO_PAGO;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public StatusPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(StatusPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(EventoAjudando evento) {
        this.evento = evento;
    }
}
