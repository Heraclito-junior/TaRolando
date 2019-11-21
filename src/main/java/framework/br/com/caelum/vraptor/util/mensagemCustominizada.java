package framework.br.com.caelum.vraptor.util;

public class mensagemCustominizada {

    
    public mensagemCustominizada(String texto, String categoria) {
		super();
		Texto = texto;
		this.categoria = categoria;
	}
	private String Texto;
    private String categoria;
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTexto() {
		return Texto;
	}
	public void setTexto(String texto) {
		Texto = texto;
	}
}