package framework.br.com.caelum.vraptor.model;

public class Relatorio {
	
	private String titulo;
    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private String horaFim;
    private String descricao;
    private double valorArrecadado;
    private double valorEsperado;
    private int numTotalVolutarios;
    private int numParticipantesConfirmados;
    private int numParticipantesPresentes;
    
    
    public Relatorio() {}
    
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
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
	public double getValorArrecadado() {
		return valorArrecadado;
	}
	public void setValorArrecadado(double valorArrecadado) {
		this.valorArrecadado = valorArrecadado;
	}
	public double getValorEsperado() {
		return valorEsperado;
	}
	public void setValorEsperado(double valorEsperado) {
		this.valorEsperado = valorEsperado;
	}
	public int getNumTotalVolutarios() {
		return numTotalVolutarios;
	}
	public void setNumTotalVolutarios(int numTotalVolutarios) {
		this.numTotalVolutarios = numTotalVolutarios;
	}
	public int getNumParticipantesConfirmados() {
		return numParticipantesConfirmados;
	}
	public void setNumParticipantesConfirmados(int numParticipantesConfirmados) {
		this.numParticipantesConfirmados = numParticipantesConfirmados;
	}
	public int getNumParticipantesPresentes() {
		return numParticipantesPresentes;
	}
	public void setNumParticipantesPresentes(int numParticipantesPresentes) {
		this.numParticipantesPresentes = numParticipantesPresentes;
	}

}
