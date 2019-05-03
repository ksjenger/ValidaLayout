package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import entities.model.Banco;
import view.Principal;

public class ImportarArquivos {

	private static BufferedReader br;
	private static LineNumberReader ln;

	public static Banco ImportarArquivos(String url) {

		Banco bancos = new Banco();

		int i, cont = 0;
		Path caminho = Paths.get(url);
		
		try {
			Files.readAllBytes(caminho);
			byte[] texto = Files.readAllBytes(caminho);
			String leitura = new String(texto);
			ln = new LineNumberReader(new InputStreamReader(new FileInputStream(url)));
			String nextLine = null;
			while ((nextLine = ln.readLine()) != null) {
				cont ++;
				if (nextLine == "") {
					break;
				}
			}

			String tempBanco = "";
			
			try {
				String tempLinha;
				br = new BufferedReader(new FileReader(url));
				tempLinha = br.readLine();
				if (tempLinha.length() == 240) {
					bancos.setTipo("CNAB 240");
				} else if (tempLinha.length() == 400) {
					bancos.setTipo("CNAB 400");
				}

			} catch (Exception e) {

			}
			if (bancos.getTipo().equals("CNAB 240")) {
				for (i = 0; i <= 2; i++) {
					tempBanco = tempBanco + leitura.charAt(i);
				}
				if (tempBanco.equals("001")) {
					bancos.setBanco("Banco do Brasil S A");
				} else if (tempBanco.equals("341")) {
					bancos.setBanco("Banco Itau");
				} else if (tempBanco.equals("104")) {
					bancos.setBanco("Caixa Economica Federal");
				} else if (tempBanco.equals("033")) {
					bancos.setBanco("Grupo Santander");
				} else {
					JOptionPane.showMessageDialog(null, "Banco ainda nao homologado");
				}
			} else {
				for (i = 0; i <= 78; i++) {
					if (i > 75) {
						tempBanco = tempBanco + leitura.charAt(i);
					}
				}
				switch (tempBanco) {
				case "001":
					bancos.setBanco("Banco do Brasil S A");
					break;
				case "341":
					bancos.setBanco("Banco Itau");
					break;
				case "104":
					bancos.setBanco("Caixa Economica Federal");
					break;
				case "033":
					bancos.setBanco("Grupo Santander");
					break;
				case "237":
					bancos.setBanco("Bradesco");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Banco ainda nao homologado");
					break;
				}

			}
			bancos.setQtdLinhas(cont);
			bancos.setArquivo(leitura);

		} catch (IOException e) {

		}
		
		return bancos;
	}

}
