package entities.bean;

import entities.model.Banco;

public abstract class Remessa extends Banco {

	protected String[] linhasArquivo;

	public abstract void setLinhasArquivo(int posicao, String valor);

	public abstract String getLinhasArquivo(int posicao);

	public abstract void startVetor(int qtdLinhas);

	public abstract void setGravarLinhas(String url, int qtdLinhas); // metodo para gravar em uma vetor a linha do
																		// arquivo

	public abstract String tipoSegmento(String linhasArquivo);

	// metodos abstratos dos segmentos do arquivo
	public abstract void ArquivoReader(String banco, int linhaSelecionada, String tipo, String linhasArquivo);

	public abstract void ArquivoReaderLote(String banco, int linhaSelecionada, String tipo, String linhaArquivo);

	public abstract void ArquivoSegmentoP(String banco, int linhaSelecionada, String tipo, String linhaArquivo);

	public abstract void ArquivoSegmentoQ(String banco, int linhaSelecionada, String tipo, String linhaArquivo);

	public abstract void ArquivoSegmentoR(String banco, int linhaSelecionada, String tipo, String linhaArquivo);

	public abstract void ArquivoTrailerdeLote(String banco, int linhaSelecionada, String tipo, String linhaArquivo);

	public abstract void ArquivoTrailerdeArquivo(String banco, int linhaSelecionada, String tipo, String linhaArquivo);

}// fim da classe
