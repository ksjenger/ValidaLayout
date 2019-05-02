package entities.model;
public class Banco {

    private String banco;
    private String url;
    private String tipo;
    private String arquivo;
    private int qtdLinhas;
    private int linhaSelecionada;
    
    
	public Banco(String banco, String url, String tipo, String arquivo, int qtdLinhas, int linhaSelecionada) {		
		this.banco = banco;
		this.url = url;
		this.tipo = tipo;
		this.arquivo = arquivo;
		this.qtdLinhas = qtdLinhas;
		this.linhaSelecionada = linhaSelecionada;
	}


	public Banco() {
	}


	public String getBanco() {
		return banco;
	}


	public void setBanco(String banco) {
		this.banco = banco;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getArquivo() {
		return arquivo;
	}


	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}


	public int getQtdLinhas() {
		return qtdLinhas;
	}


	public void setQtdLinhas(int qtdLinhas) {
		this.qtdLinhas = qtdLinhas;
	}


	public int getLinhaSelecionada() {
		return linhaSelecionada;
	}


	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}
 
}
