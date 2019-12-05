package framework.br.com.caelum.vraptor.model;

public class RelatorioCasamento {

    private String titulo;
    private String data;
    private String horaInicio;
    private String horaFim;
    private String descricao;
    private double valorArrecadadoPresentes;
    private double valorEsperado;
    private int numPresentes;
    private int numTotalConvidados;
    private int numConvidadosConfirmados;
    private int numConvidadosNaoConfirmados;
    private int numConvidadosParticipou;
    private int numConvidadosAusentes;
    private int numPadrinhos;


    public RelatorioCasamento() {}


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
    public String getHoraFim() {
        return horaFim;
    }
    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValorEsperado() {
        return valorEsperado;
    }
    public void setValorEsperado(double valorEsperado) {
        this.valorEsperado = valorEsperado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorArrecadadoPresentes() {
        return valorArrecadadoPresentes;
    }

    public void setValorArrecadadoPresentes(double valorArrecadadoPresentes) {
        this.valorArrecadadoPresentes = valorArrecadadoPresentes;
    }

    public int getNumPresentes() {
        return numPresentes;
    }

    public void setNumPresentes(int numPresentes) {
        this.numPresentes = numPresentes;
    }

    public int getNumTotalConvidados() {
        return numTotalConvidados;
    }

    public void setNumTotalConvidados(int numTotalConvidados) {
        this.numTotalConvidados = numTotalConvidados;
    }

    public int getNumConvidadosConfirmados() {
        return numConvidadosConfirmados;
    }

    public void setNumConvidadosConfirmados(int numConvidadosConfirmados) {
        this.numConvidadosConfirmados = numConvidadosConfirmados;
    }

    public int getNumConvidadosNaoConfirmados() {
        return numConvidadosNaoConfirmados;
    }

    public void setNumConvidadosNaoConfirmados(int numConvidadosNaoConfirmados) {
        this.numConvidadosNaoConfirmados = numConvidadosNaoConfirmados;
    }

    public int getNumConvidadosParticipou() {
        return numConvidadosParticipou;
    }

    public void setNumConvidadosParticipou(int numConvidadosParticipou) {
        this.numConvidadosParticipou = numConvidadosParticipou;
    }

    public int getNumConvidadosAusentes() {
        return numConvidadosAusentes;
    }

    public void setNumConvidadosAusentes(int numConvidadosAusentes) {
        this.numConvidadosAusentes = numConvidadosAusentes;
    }

    public int getNumPadrinhos() {
        return numPadrinhos;
    }

    public void setNumPadrinhos(int numPadrinhos) {
        this.numPadrinhos = numPadrinhos;
    }
}
