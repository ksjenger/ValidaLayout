package entities.model;

import java.io.BufferedReader;
import java.io.FileReader;

import entities.bean.BancoBean;
import entities.bean.Remessa;
import view.FormResp;

public class BancoDoBrasil extends Remessa  {
	
	BancoBean bancos = new BancoBean();
	private BufferedReader br;

    @Override
    public void setLinhasArquivo(int posicao, String valor) {
        this.linhasArquivo[posicao] = valor;
    }

    @Override
    public String getLinhasArquivo(int posicao) {
        return linhasArquivo[posicao];
    }

    @Override
    public void startVetor(int qtdLinhas) {
        this.linhasArquivo = new String[qtdLinhas];
    }

    @Override
    public void setGravarLinhas(String url, int qtdLinhas) {
        this.startVetor(qtdLinhas);

        try {
            br = new BufferedReader(new FileReader(url));
            for (int i = 0; i < qtdLinhas; i++) {
                setLinhasArquivo(i, br.readLine());
            }
        } catch (Exception erro) {
        }
    }

    @Override
    public String tipoSegmento(String linhasArquivo) {
        String temp = "";
        int i;
        for (i = 0; i <= 14; i++) {
            if (i == 13) {
                temp = temp + linhasArquivo.charAt(i);
            }
        }
        return temp;
    }

	@Override
	public void ArquivoReader(String banco, int linhaSelecionada, String tipo, String linhasArquivo) {
		FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int i, ini = 1, fin = 0, cont = 0;

        n.setCabecalho(banco, "Reader de Arquivo", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String nome = "", conteudo = "";

        for (i = 0; i < bancos.getTipoNumerico(tipo); i++) {
            if (i >= 0 && i <= 2) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                fin = 3;
                cont++;
                if (i == 2) {
                    ini = 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome1("C�digo do Banco na Compensa��o");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal1(b);
                    n.setlbnRespQTDL1(c);
                    n.setlbnRespCont1(conteudo);
                    n.setlbnDesc1("001 para Banco do Brasil S. A.");

                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 3 && i <= 6) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 6) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome2("Lote de Servi�o");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    n.setlbnDesc2("N�mero seq�encial para identificar univocamente um lote de servi�o");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 7) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome3("Tipo de Registro");
                n.setlbnRespInicio3(a);
                n.setlbnRespFinal3(b);
                n.setlbnRespQTDL3(c);
                n.setlbnRespCont3(conteudo);
                n.setlbnDesc3("C�digo do tipo de registro. 0 - Header de Arquivo");
                cont = 0;
                conteudo = "";

            } else if (i >= 8 && i <= 16) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 16) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome4("Uso Exclusivo FEBRABAN / CNAB");
                    n.setlbnRespInicio4(a);
                    n.setlbnRespFinal4(b);
                    n.setlbnRespQTDL4(c);
                    n.setlbnRespCont4(conteudo);
                    n.setlbnDesc4("Texto de observa��es destinado para uso exclusivo da FEBRABAN");
                    cont = 0;
                    conteudo = "";

                }
            } else if (i == 17) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome5("Tipo de Inscri��o da Empresa");
                n.setlbnRespInicio5(a);
                n.setlbnRespFinal5(b);
                n.setlbnRespQTDL5(c);
                n.setlbnRespCont5(conteudo);
                n.setlbnDesc5("C�digo que identifica o tipo de inscri��o:   1 - CPF  |  2 - CNPJ");
                cont = 0;
                conteudo = "";

            } else if (i >= 18 && i <= 31) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 31) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome6("N�mero de Inscri��o da Empresa");
                    n.setlbnRespInicio6(a);
                    n.setlbnRespFinal6(b);
                    n.setlbnRespQTDL6(c);
                    n.setlbnRespCont6(conteudo);
                    n.setlbnDesc6("N�mero de inscri��o da Empresa ou Pessoa F�sica");
                    cont = 0;
                    conteudo = "";

                }

            } else if (i >= 32 && i <= 40) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 40) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome7("N�mero do conv�nio de cobran�a");
                    n.setlbnRespInicio7(a);
                    n.setlbnRespFinal7(b);
                    n.setlbnRespQTDL7(c);
                    n.setlbnRespCont7(conteudo);
                    n.setlbnDesc7("C�digo adotado pelo Banco para identificar o Contrato com a Empresa");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 41 && i <= 44) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 44) {
                    if (cont == 1) {
                        fin = i;
                    }

                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome8("Cobran�a Cedente");
                    n.setlbnRespInicio8(a);
                    n.setlbnRespFinal8(b);
                    n.setlbnRespQTDL8(c);
                    n.setlbnRespCont8(conteudo);
                    cont = 0;
                    conteudo = "";

                }

            } else if (i >= 45 && i <= 46) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 46) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome9("N�mero da carteira de cobran�a");
                    n.setlbnRespInicio9(a);
                    n.setlbnRespFinal9(b);
                    n.setlbnRespQTDL9(c);
                    n.setlbnRespCont9(conteudo);
                    n.setlbnDesc9("Informar o n�mero da carteira de cobran�a");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 47 && i <= 49) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 49) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome10("N�mero da varia��o da carteira de cobran�a");
                    n.setlbnRespInicio10(a);
                    n.setlbnRespFinal10(b);
                    n.setlbnRespQTDL10(c);
                    n.setlbnRespCont10(conteudo);
                    n.setlbnDesc10("Informar o n�mero da varia��o da carteira de cobran�a");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 50 && i <= 51) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 51) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome11("Campo reservado BB");
                    n.setlbnRespInicio11(a);
                    n.setlbnRespFinal11(b);
                    n.setlbnRespQTDL11(c);
                    n.setlbnRespCont11(conteudo);
                    n.setlbnDesc11("Informar brancos");
                    cont = 0;
                    conteudo = "";

                }

            } else if (i >= 52 && i <= 56) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 56) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome12("Ag�ncia Mantenedora da Conta");
                    n.setlbnRespInicio12(a);
                    n.setlbnRespFinal12(b);
                    n.setlbnRespQTDL12(c);

                    n.setlbnDesc12("Agencia mantedora da Conta");
                    n.setlbnRespCont12(conteudo);
                    cont = 0;
                    conteudo = "";

                }

            } else if (i == 57) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (cont == 1) {
                    fin = i;
                }
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome13("D�gito Verificador da Ag�ncia");
                n.setlbnRespInicio13(a);
                n.setlbnRespFinal13(b);
                n.setlbnRespQTDL13(c);
                n.setlbnRespCont13(conteudo);
                n.setlbnDesc13("Em caso de digito X informar mai�sculo");

                cont = 0;
                conteudo = "";

            } else if (i >= 58 && i <= 69) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 69) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome14("N�mero da Conta Corrente");
                    n.setlbnRespInicio14(a);
                    n.setlbnRespFinal14(b);
                    n.setlbnRespQTDL14(c);
                    n.setlbnRespCont14(conteudo);
                    n.setlbnDesc14("");

                    cont = 0;
                    conteudo = "";

                }

            } else if (i == 70) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (cont == 1) {
                    fin = i;
                }
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome15("D�gito Verificador da Conta");
                n.setlbnRespInicio15(a);
                n.setlbnRespFinal15(b);
                n.setlbnRespQTDL15(c);
                n.setlbnRespCont15(conteudo);
                n.setlbnDesc15("Em caso de d�gito X, informar maiusculo");
                cont = 0;
                conteudo = "";

            } else if (i == 71) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (cont == 1) {
                    fin = i;
                }
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome16("D�gito Verificador da Ag/Conta");
                n.setlbnRespInicio16(a);
                n.setlbnRespFinal16(b);
                n.setlbnRespQTDL16(c);
                n.setlbnRespCont16(conteudo);
                n.setlbnDesc16("Campo n�o tratado pelo Banco do Brasil. Informar branco ou espa�o");
                cont = 0;
                conteudo = "";

            } else if (i >= 72 && i <= 101) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 101) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome17("Nome da Empresa");
                    n.setlbnRespInicio17(a);
                    n.setlbnRespFinal17(b);
                    n.setlbnRespQTDL17(c);
                    n.setlbnRespCont17(conteudo);

                    cont = 0;
                    conteudo = "";

                }

            } else if (i >= 102 && i <= 131) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 131) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome18("Nome do Banco");
                    n.setlbnRespInicio18(a);
                    n.setlbnRespFinal18(b);
                    n.setlbnRespQTDL18(c);
                    n.setlbnRespCont18(conteudo);
                    n.setlbnDesc18("Banco do Brasil S.A.");
                    cont = 0;
                    conteudo = "";
                    n.setlbnDesc11("Informar brancos");
                }

            } else if (i >= 132 && i <= 141) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                if (i == 141) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome19("Uso Exclusivo FEBRABAN / CNABB");
                    n.setlbnRespInicio19(a);
                    n.setlbnRespFinal19(b);
                    n.setlbnRespQTDL19(c);
                    n.setlbnRespCont19(conteudo);

                    cont = 0;
                    conteudo = "";

                }

            } else if (i == 142) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (cont == 1) {
                    fin = i;
                }
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome20("C�digo Remessa / Retorno");
                n.setlbnRespInicio20(a);
                n.setlbnRespFinal20(b);
                n.setlbnRespQTDL20(c);
                n.setlbnRespCont20(conteudo);

                cont = 0;
                conteudo = "";

            } else if (i >= 143 && i <= 150) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 150) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome21("Data de Gera��o do Arquivo");
                    n.setlbnRespInicio21(a);
                    n.setlbnRespFinal21(b);
                    n.setlbnRespQTDL21(c);
                    n.setlbnRespCont21(conteudo);
                    n.setlbnDesc21("DDMMAAAA");
                    cont = 0;
                    conteudo = "";

                }
            } else if (i >= 151 && i <= 156) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 156) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome22("Hora de Gera��o do Arquivo ");
                    n.setlbnRespInicio22(a);
                    n.setlbnRespFinal22(b);
                    n.setlbnRespQTDL22(c);
                    n.setlbnRespCont22(conteudo);
                    n.setlbnDesc22("Zero ou HHMMSS");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 157 && i <= 162) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 162) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome23("N�mero Seq�encial do Arquivo ");
                    n.setlbnRespInicio23(a);
                    n.setlbnRespFinal23(b);
                    n.setlbnRespQTDL23(c);
                    n.setlbnRespCont23(conteudo);
                    n.setlbnDesc23("Informar Zeros ou um n�mero sequencial icrementado a cada arquivo");
                    cont = 0;
                    conteudo = "";

                }
            } else if (i >= 163 && i <= 165) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 165) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome24("N�mero da Vers�o do Layout do Arquivo");
                    n.setlbnRespInicio24(a);
                    n.setlbnRespFinal24(b);
                    n.setlbnRespQTDL24(c);
                    n.setlbnRespCont24(conteudo);
                    n.setlbnDesc24("Informar Zeros ou o n�mero da vers�o do leiaute do arquivo");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 166 && i <= 170) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 170) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome25("Densidade de Grava��o do Arquivo ");
                    n.setlbnRespInicio25(a);
                    n.setlbnRespFinal25(b);
                    n.setlbnRespQTDL25(c);
                    n.setlbnRespCont25(conteudo);
                    n.setlbnDesc25("Campo n�o criticado pelo sistema do Banco do Brasil");
                    cont = 0;
                    conteudo = "";

                }
            } else if (i >= 171 && i <= 190) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 190) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome26("Para Uso Reservado do Banco");
                    n.setlbnRespInicio26(a);
                    n.setlbnRespFinal26(b);
                    n.setlbnRespQTDL26(c);
                    n.setlbnRespCont26(conteudo);
                    n.setlbnDesc26("");
                    cont = 0;
                    conteudo = "";

                }
            } else if (i >= 191 && i <= 210) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 210) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome27("Para Uso Reservado da Empresa");
                    n.setlbnRespInicio27(a);
                    n.setlbnRespFinal27(b);
                    n.setlbnRespQTDL27(c);
                    n.setlbnRespCont27(conteudo);
                    n.setlbnDesc27("Campo n�o tratado pelo Banco do Brasil, innformar 'brancos' ou zeros");

                    cont = 0;
                    conteudo = "";

                }

            } else if (i >= 211 && i <= 239) {
                conteudo = conteudo + linhasArquivo.charAt(i);
                cont++;
                if (i == 239) {
                    if (cont == 1) {
                        fin = i;
                    }
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome28("Uso Exclusivo FEBRABAN / CNAB");
                    n.setlbnRespInicio28(a);
                    n.setlbnRespFinal28(b);
                    n.setlbnRespQTDL28(c);
                    n.setlbnRespCont28(conteudo);
                    cont = 0;
                    conteudo = "";
                    n.setlbnDesc28("Informar 'brancos'");

                }
            }
        }

		
	}

	@Override
	public void ArquivoReaderLote(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ArquivoSegmentoP(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ArquivoSegmentoQ(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ArquivoSegmentoR(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ArquivoTrailerdeLote(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ArquivoTrailerdeArquivo(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
		// TODO Auto-generated method stub
		
	}

}
