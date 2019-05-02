package entities.bean;

import entities.model.Banco;

public class BancoBean extends Banco {

	public int numeroLinha(int posicao, String tipo) {
		int tempNumLinha = 1, i;
		for (i = posicao; i >= 0; i--) {
			if (this.getTipoNumerico(tipo) == 240) {
				if (posicao >= 242) {
					tempNumLinha++;
					posicao = posicao - 242;
				} else {
					i = 0;
				}
			} else if (this.getTipoNumerico(tipo) == 400) {
				if (posicao >= 400) {
					posicao = posicao - 402;
					tempNumLinha++;
				} else {
					i = 0;
				}

			}
		}
		return tempNumLinha;
	}

	public int getTipoNumerico(String tipo) {
		int n = 0;
		if (tipo.equals("CNAB 240")) {
			n = 240;
		}
		if (tipo.equals("CNAB 400")) {
			n = 400;
		}
		return n;
	}
}
