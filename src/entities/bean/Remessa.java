package entities.bean;

import entities.model.Banco;

public abstract class Remessa extends Banco {

	protected String[] linhasArquivo;

	// atributos de Remessa
	public abstract void setLinhasArquivo(int posicao, String valor);

	public abstract String getLinhasArquivo(int posicao);

	public abstract void startVetor(int qtdLinhas);

	public abstract void setGravarLinhas(String url, int qtdLinhas); // metodo para gravar em uma vetor a linha do
																		// arquivo

	public abstract String tipoSegmento(String linhasArquivo);

	// Metodos de Remessa

}// fim da classe
