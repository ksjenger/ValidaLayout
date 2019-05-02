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

public class ImportarArquivos {
	
	public static void ImportarArquivos() {
		
	  int i;
      Path caminho = Paths.get(bancos.getUrl());
      try {
          Files.readAllBytes(caminho);
          byte[] texto = Files.readAllBytes(caminho);
          String leitura = new String(texto);
          LineNumberReader ln = new LineNumberReader(new InputStreamReader(new FileInputStream(bancos.getUrl())));
          String nextLine = null;
          int count = 0;
          while ((nextLine = ln.readLine()) != null) {
              count++;
              if (nextLine == "") {
                  break;
              }
          }
          String tempBanco = "";
          String tempNomeBanco = "";
          try {
              String tempLinha;
              BufferedReader br = new BufferedReader(new FileReader(bancos.getUrl()));
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
                  this.jbtnCad.setVisible(true);
              } else if (tempBanco.equals("341")) {
                  bancos.setBanco("Banco Itau");
              } else if (tempBanco.equals("104")) {
                  bancos.setBanco("Caixa Econômica Federal");
              } else if (tempBanco.equals("033")) {
                  bancos.setBanco("Grupo Santander");
              } else {
                  JOptionPane.showMessageDialog(null, "Banco ainda não homologado");
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
                      bancos.setBanco("Caixa Econômica Federal");
                      break;
                  case "033":
                      bancos.setBanco("Grupo Santander");
                      break;
                  case "237":
                      bancos.setBanco("Bradesco");
                      break;
                  default:
                      JOptionPane.showMessageDialog(null, "Banco ainda não homologado");
                      break;
              }

          }

          bancos.setArquivo(leitura);
          jTextAreaLinhaArquivo.setText(bancos.getArquivo());
          bancos.setQtdLinhas(count);
          jLabelRespBanco.setText(bancos.getBanco());

          jLabelRespTipo.setText(bancos.getTipo());
          jLabelResplinas.setText(Integer.toString(bancos.getQtdLinhas()));
      } catch (IOException e) {

      }

	}
	
      jTextAreaLinhaArquivo.setEditable(false);
}
