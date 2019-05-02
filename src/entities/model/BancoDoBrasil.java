package entities.model;

import java.io.BufferedReader;
import java.io.FileReader;
import entities.bean.Remessa;

public class BancoDoBrasil extends Remessa  {

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

    /*public void ArquivoReaderBB240(String banco, int linhaSelecionada, String tipo, String linhasArquivo) {
        FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int i, ini = 1, fin = 0, cont = 0;

        n.setCabecalho(banco, "Reader de Arquivo", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String nome = "", conteudo = "";

        for (i = 0; i < this.banco.getTipoNumerico(tipo); i++) {
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
                    n.setlbnrespNome1("Código do Banco na Compensação");
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
                    n.setlbnrespNome2("Lote de Serviço");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    n.setlbnDesc2("Número seqüencial para identificar univocamente um lote de serviço");
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
                n.setlbnDesc3("Código do tipo de registro. 0 - Header de Arquivo");
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
                    n.setlbnDesc4("Texto de observações destinado para uso exclusivo da FEBRABAN");
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
                n.setlbnrespNome5("Tipo de Inscrição da Empresa");
                n.setlbnRespInicio5(a);
                n.setlbnRespFinal5(b);
                n.setlbnRespQTDL5(c);
                n.setlbnRespCont5(conteudo);
                n.setlbnDesc5("Código que identifica o tipo de inscrição:   1 - CPF  |  2 - CNPJ");
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
                    n.setlbnrespNome6("Número de Inscrição da Empresa");
                    n.setlbnRespInicio6(a);
                    n.setlbnRespFinal6(b);
                    n.setlbnRespQTDL6(c);
                    n.setlbnRespCont6(conteudo);
                    n.setlbnDesc6("Número de inscrição da Empresa ou Pessoa Física");
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
                    n.setlbnrespNome7("Número do convênio de cobrança");
                    n.setlbnRespInicio7(a);
                    n.setlbnRespFinal7(b);
                    n.setlbnRespQTDL7(c);
                    n.setlbnRespCont7(conteudo);
                    n.setlbnDesc7("Código adotado pelo Banco para identificar o Contrato com a Empresa");
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
                    n.setlbnrespNome8("Cobrança Cedente");
                    n.setlbnRespInicio8(a);
                    n.setlbnRespFinal8(b);
                    n.setlbnRespQTDL8(c);
                    n.setlbnRespCont8(conteudo);
                    if (this.banco.equals("Banco do Brasil S A")) {
                        n.setlbnDesc8("Informar 0014 para cobrança cedente");
                    }
                    //santander é diferente
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
                    n.setlbnrespNome9("Número da carteira de cobrança");
                    n.setlbnRespInicio9(a);
                    n.setlbnRespFinal9(b);
                    n.setlbnRespQTDL9(c);
                    n.setlbnRespCont9(conteudo);
                    n.setlbnDesc9("Informar o número da carteira de cobrança");
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
                    n.setlbnrespNome10("Número da variação da carteira de cobrança");
                    n.setlbnRespInicio10(a);
                    n.setlbnRespFinal10(b);
                    n.setlbnRespQTDL10(c);
                    n.setlbnRespCont10(conteudo);
                    n.setlbnDesc10("Informar o número da variação da carteira de cobrança");
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
                    n.setlbnrespNome12("Agência Mantenedora da Conta");
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
                n.setlbnrespNome13("Dígito Verificador da Agência");
                n.setlbnRespInicio13(a);
                n.setlbnRespFinal13(b);
                n.setlbnRespQTDL13(c);
                n.setlbnRespCont13(conteudo);
                n.setlbnDesc13("Em caso de digito X informar maiúsculo");

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
                    n.setlbnrespNome14("Número da Conta Corrente");
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
                n.setlbnrespNome15("Dígito Verificador da Conta");
                n.setlbnRespInicio15(a);
                n.setlbnRespFinal15(b);
                n.setlbnRespQTDL15(c);
                n.setlbnRespCont15(conteudo);
                n.setlbnDesc15("Em caso de dígito X, informar maiusculo");
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
                n.setlbnrespNome16("Dígito Verificador da Ag/Conta");
                n.setlbnRespInicio16(a);
                n.setlbnRespFinal16(b);
                n.setlbnRespQTDL16(c);
                n.setlbnRespCont16(conteudo);
                n.setlbnDesc16("Campo não tratado pelo Banco do Brasil. Informar branco ou espaço");
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
                n.setlbnrespNome20("Código Remessa / Retorno");
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
                    n.setlbnrespNome21("Data de Geração do Arquivo");
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
                    n.setlbnrespNome22("Hora de Geração do Arquivo ");
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
                    n.setlbnrespNome23("Número Seqüencial do Arquivo ");
                    n.setlbnRespInicio23(a);
                    n.setlbnRespFinal23(b);
                    n.setlbnRespQTDL23(c);
                    n.setlbnRespCont23(conteudo);
                    n.setlbnDesc23("Informar Zeros ou um número sequencial icrementado a cada arquivo");
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
                    n.setlbnrespNome24("Número da Versão do Layout do Arquivo");
                    n.setlbnRespInicio24(a);
                    n.setlbnRespFinal24(b);
                    n.setlbnRespQTDL24(c);
                    n.setlbnRespCont24(conteudo);
                    n.setlbnDesc24("Informar Zeros ou o número da versão do leiaute do arquivo");
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
                    n.setlbnrespNome25("Densidade de Gravação do Arquivo ");
                    n.setlbnRespInicio25(a);
                    n.setlbnRespFinal25(b);
                    n.setlbnRespQTDL25(c);
                    n.setlbnRespCont25(conteudo);
                    n.setlbnDesc25("Campo não criticado pelo sistema do Banco do Brasil");
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
                    n.setlbnDesc27("Campo não tratado pelo Banco do Brasil, innformar 'brancos' ou zeros");

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

    }//fim do metodo ArquivoReaderBancodoBrasil240

    //abre o form com a segunda linha do arquivo, "Reader de Lote BB240"
    public void ArquivoReaderLoteBB240(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
        FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int i, ini = 1, fin = 0, cont = 0;

        n.setCabecalho(banco, "Reader de Lote", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String conteudo = "";

        for (i = 0; i < this.getTipoNumerico(tipo); i++) {
            if (i >= 0 && i <= 2) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 2) {
                    ini = 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome1("Código do Banco na Compensação");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal1(b);
                    n.setlbnRespQTDL1(c);
                    n.setlbnRespCont1(conteudo);
                    n.setlbnDesc1("001 para Banco do Brasil S. A.");
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 3 && i <= 6) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 6) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome2("Lote de Serviço");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    n.setlbnDesc2("Número seqüencial para identificar univocamente um lote de serviço");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 7) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
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
                n.setlbnDesc3("Código do tipo de registro. 1 - Header de Lote");

                cont = 0;
                conteudo = "";

            } else if (i == 8) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome4("Tipo de Operação");
                n.setlbnRespInicio4(a);
                n.setlbnRespFinal4(b);
                n.setlbnRespQTDL4(c);
                n.setlbnRespCont4(conteudo);
                n.setlbnDesc4("R - Remessa | T - Retorno ");
                cont = 0;
                conteudo = "";
            } else if (i >= 9 && i <= 10) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 10) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome5("Tipo de Serviço");
                    n.setlbnRespInicio5(a);
                    n.setlbnRespFinal5(b);
                    n.setlbnRespQTDL5(c);
                    n.setlbnRespCont5(conteudo);

                    n.setlbnDesc5("01 - Cobrança");
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 11 && i <= 12) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 12) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome6("Uso Exclusivo FEBRABAN/CNAB");
                    n.setlbnRespInicio6(a);
                    n.setlbnRespFinal6(b);
                    n.setlbnRespQTDL6(c);
                    n.setlbnRespCont6(conteudo);
                    n.setlbnDesc6("Informar 'brancos'");
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 13 && i <= 15) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 15) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome7("Nº da Versão do Layout do Lote");
                    n.setlbnRespInicio7(a);
                    n.setlbnRespFinal7(b);
                    n.setlbnRespQTDL7(c);
                    n.setlbnRespCont7(conteudo);
                    n.setlbnDesc7("Versão homologada pela Visual - '020'");
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 16) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome8("Uso Exclusivo FEBRABAN/CNAB");
                n.setlbnDesc8("Informar 'brancos' (espaços)");
                n.setlbnRespInicio8(a);
                n.setlbnRespFinal8(b);
                n.setlbnRespQTDL8(c);
                n.setlbnRespCont8(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 17) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome9("Tipo de Inscrição da Empresa");
                n.setlbnDesc9("1 - para CPF  |  2 - para CNPJ");
                n.setlbnRespInicio9(a);
                n.setlbnRespFinal9(b);
                n.setlbnRespQTDL9(c);
                n.setlbnRespCont9(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 18 && i <= 32) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 32) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome10("Numero de Inscrição da Empresa ");
                    n.setlbnDesc10("Informar número da inscrição (CPF ou CNPJ) da Empresa");
                    n.setlbnRespInicio10(a);
                    n.setlbnRespFinal10(b);
                    n.setlbnRespQTDL10(c);
                    n.setlbnRespCont10(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 33 && i <= 41) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 41) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome11("Nùmero do convênio de cobrança ");
                    n.setlbnDesc11("Informar o número do convênio de cobrança");
                    n.setlbnRespInicio11(a);
                    n.setlbnRespFinal11(b);
                    n.setlbnRespQTDL11(c);
                    n.setlbnRespCont11(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 42 && i <= 45) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 45) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome12("Cobrança Cedente BB");
                    n.setlbnDesc12("Informar 0014 para cobrança cedente");
                    n.setlbnRespInicio12(a);
                    n.setlbnRespFinal12(b);
                    n.setlbnRespQTDL12(c);
                    n.setlbnRespCont12(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 46 && i <= 47) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 47) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome13("Número da carteira de cobrança");
                    n.setlbnDesc13("Informar o número da carteira de cobrança");
                    n.setlbnRespInicio13(a);
                    n.setlbnRespFinal13(b);
                    n.setlbnRespQTDL13(c);
                    n.setlbnRespCont13(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 48 && i <= 50) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 50) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome14("Número da variação da carteira de Cobrança BB");
                    n.setlbnDesc14("Informar o número da variação da carteira de cobrança");
                    n.setlbnRespInicio14(a);
                    n.setlbnRespFinal14(b);
                    n.setlbnRespQTDL14(c);
                    n.setlbnRespCont14(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 51 && i <= 52) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 52) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome15("Campo que identifica remessa de testes ");
                    n.setlbnDesc15("informar 'brancos' para produção ou 'TS' para testes");
                    n.setlbnRespInicio15(a);
                    n.setlbnRespFinal15(b);
                    n.setlbnRespQTDL15(c);
                    n.setlbnRespCont15(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 53 && i <= 57) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 57) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome16("Agência Mantenedora da Conta");

                    n.setlbnRespInicio16(a);
                    n.setlbnRespFinal16(b);
                    n.setlbnRespQTDL16(c);
                    n.setlbnRespCont16(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 58) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome17("Dígito Verificador da Conta");
                n.setlbnDesc17("Obs. Em caso de dígito X informar maiúsculo.");

                n.setlbnRespInicio17(a);
                n.setlbnRespFinal17(b);
                n.setlbnRespQTDL17(c);
                n.setlbnRespCont17(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 59 && i <= 70) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 70) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome18("Número da Conta Corrente ");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal18(b);
                    n.setlbnRespQTDL18(c);
                    n.setlbnRespCont18(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 71) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome19("Dígito Verificador da Conta");
                n.setlbnDesc19("Obs. Em caso de dígito X informar maiúsculo.");

                n.setlbnRespInicio19(a);
                n.setlbnRespFinal19(b);
                n.setlbnRespQTDL19(c);
                n.setlbnRespCont19(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 72) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome20("Dígito Verificador da Ag/Conta");
                n.setlbnDesc20("Campo não tratado pelo Banco do Brasil. Informar 'branco' (espaço) OU  zero.");

                n.setlbnRespInicio20(a);
                n.setlbnRespFinal20(b);
                n.setlbnRespQTDL20(c);
                n.setlbnRespCont20(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 73 && i <= 102) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 102) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome21("Nome da Empresa");
                    n.setlbnDesc21("Informar o Nome da Pessoa ou Empresa dona da conta");
                    n.setlbnRespInicio21(a);
                    n.setlbnRespFinal21(b);
                    n.setlbnRespQTDL21(c);
                    n.setlbnRespCont21(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 103 && i <= 142) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 142) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome22("Mensagem 1 ");
                    n.setlbnRespInicio22(a);
                    n.setlbnRespFinal22(b);
                    n.setlbnRespQTDL22(c);
                    n.setlbnRespCont22(conteudo);
                    n.setlbnDesc22("Para utilizar a Mensagem 1 é necessário não ter informado sacador/avalista. ");
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 143 && i <= 182) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 182) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome23("Mensagem 2");
                    n.setlbnDesc23("Campo não tratado pelo Banco do Brasil. Informar 'brancos' (espaços)");
                    n.setlbnRespInicio23(a);
                    n.setlbnRespFinal23(b);
                    n.setlbnRespQTDL23(c);
                    n.setlbnRespCont23(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 183 && i <= 190) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 190) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome24("Número Remessa/Retorno");
                    n.setlbnDesc24("Campo não tratado pelo Banco do Brasil. Informar 'branco' (espaço) OU  zero.");
                    n.setlbnRespInicio24(a);
                    n.setlbnRespFinal24(b);
                    n.setlbnRespQTDL24(c);
                    n.setlbnRespCont24(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 191 && i <= 198) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 198) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome25("Data de Gravação Remessa/Retorno");
                    n.setlbnDesc25("Informar a data de Gravação da Remessa");
                    n.setlbnRespInicio25(a);
                    n.setlbnRespFinal25(b);
                    n.setlbnRespQTDL25(c);
                    n.setlbnRespCont25(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 199 && i <= 206) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 206) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome26("Data do Crédito ");
                    n.setlbnDesc26("Informar 'brancos' (espaços)  OU Zeros");
                    n.setlbnRespInicio26(a);
                    n.setlbnRespFinal26(b);
                    n.setlbnRespQTDL26(c);
                    n.setlbnRespCont26(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 208 && i <= 239) {
                conteudo = conteudo + this.getLinhasArquivo(1).charAt(i);
                cont++;
                if (i == 239) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome27("Uso Exclusivo FEBRABAN/CNAB");
                    n.setlbnDesc27("Informar 'brancos' (espaços)");
                    n.setlbnRespInicio27(a);
                    n.setlbnRespFinal27(b);
                    n.setlbnRespQTDL27(c);
                    n.setlbnRespCont27(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            }

        }//fim do For

    }//fim do metodo ArquivoReaderBancodoBrasilLote240

    public void ArquivoSegmentoP240(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
        FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int ini = 1, fin = 0, cont = 0, i;
        n.setCabecalho(banco, "Segmento P", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String conteudo = "";

        for (i = 0; i < this.getTipoNumerico(tipo); i++) {
            if (i >= 0 && i <= 2) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 2) {
                    fin = i + 1;
                    ini = 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome1("Código do Banco na Compensação");
                    n.setlbnDesc1("001 para Banco do Brasil S.A.");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal1(b);
                    n.setlbnRespQTDL1(c);
                    n.setlbnRespCont1(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 3 && i <= 6) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 6) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome2("Lote de Serviço");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    n.setlbnDesc2("Informar o número do lote ao qual pertence o registro");
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 7) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome3("Tipo de Registro");
                n.setlbnDesc3("Código do tipo de registro. 3 - Detalhe");
                n.setlbnRespInicio3(a);
                n.setlbnRespFinal3(b);
                n.setlbnRespQTDL3(c);
                n.setlbnRespCont3(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 8 && i <= 12) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 12) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome4("Número Sequencial do Registro no Lote");
                    n.setlbnDesc4("Começar com 00001 e ir incrementando em 1 a cada nova linha de registro");
                    n.setlbnRespInicio4(a);
                    n.setlbnRespFinal4(b);
                    n.setlbnRespQTDL4(c);
                    n.setlbnRespCont4(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 13) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome5("Código Segmento do Registro Detalhe");
                n.setlbnDesc5("Código adotado pela FEBRABAN para identificar o segmento do registro");
                n.setlbnRespInicio5(a);
                n.setlbnRespFinal5(b);
                n.setlbnRespQTDL5(c);
                n.setlbnRespCont5(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 14) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome6("Uso Exclusivo FEBRABAN/CNAB");
                n.setlbnDesc6("Brancos");
                n.setlbnRespInicio6(a);
                n.setlbnRespFinal6(b);
                n.setlbnRespQTDL6(c);
                n.setlbnRespCont6(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 15 && i <= 16) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 16) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome7("Código de Movimento Remessa");
                    n.setlbnDesc7(" 01 – Entrada de títulos");
                    n.setlbnRespInicio7(a);
                    n.setlbnRespFinal7(b);
                    n.setlbnRespQTDL7(c);
                    n.setlbnRespCont7(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 17 && i <= 21) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 21) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome8("Agência Mantenedora da Conta");
                    n.setlbnDesc8("Informar a Agencia");
                    n.setlbnRespInicio8(a);
                    n.setlbnRespFinal8(b);
                    n.setlbnRespQTDL8(c);
                    n.setlbnRespCont8(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 22) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome9("Dígito Verificador da Agência");
                n.setlbnDesc9("Em caso de dígito X informar maiúsculo.");
                n.setlbnRespInicio9(a);
                n.setlbnRespFinal9(b);
                n.setlbnRespQTDL9(c);
                n.setlbnRespCont9(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 23 && i <= 34) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 34) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome10("Número da Conta Corrente");
                    n.setlbnDesc10("Informar o numero da Conta Corrente");
                    n.setlbnRespInicio10(a);
                    n.setlbnRespFinal10(b);
                    n.setlbnRespQTDL10(c);
                    n.setlbnRespCont10(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 35) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome11("Dígito Verificador da Conta");
                n.setlbnDesc11("Em caso de dígito X informar maiúsculo.");
                n.setlbnRespInicio11(a);
                n.setlbnRespFinal11(b);
                n.setlbnRespQTDL11(c);
                n.setlbnRespCont11(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 36) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome12("Dígito Verificador da Ag/Conta");
                n.setlbnDesc12("Campo não tratado pelo Banco do Brasil");
                n.setlbnRespInicio12(a);
                n.setlbnRespFinal12(b);
                n.setlbnRespQTDL12(c);
                n.setlbnRespCont12(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 37 && i <= 56) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 56) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome13("Identificação do Título no Banco");
                    n.setlbnDesc13("CCCCSSSSSSSD - Onde C = Convênio, S = Sequencial, D = Digito");
                    n.setlbnRespInicio13(a);
                    n.setlbnRespFinal13(b);
                    n.setlbnRespQTDL13(c);
                    n.setlbnRespCont13(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 57) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome14("Código da Carteira ");
                n.setlbnDesc14("7 - para carteira 17. 2 ou 3 para carteira 31. 4 - para Carteira 51. Verificar Modalidade");
                n.setlbnRespInicio14(a);
                n.setlbnRespFinal14(b);
                n.setlbnRespQTDL14(c);
                n.setlbnRespCont14(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 58) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome15("Forma de Cadastr. do Título no Banco ");
                n.setlbnDesc15("1 - Cobrança Registrada. 2 - Cobrança Sem Registro");
                n.setlbnRespInicio15(a);
                n.setlbnRespFinal15(b);
                n.setlbnRespQTDL15(c);
                n.setlbnRespCont15(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 59) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome16("Tipo de Documento ");
                n.setlbnDesc16(" 1 – Tradicional.  2 –   Escritural");
                n.setlbnRespInicio16(a);
                n.setlbnRespFinal16(b);
                n.setlbnRespQTDL16(c);
                n.setlbnRespCont16(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 60) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome17("Identificação da Emissão do Bloqueto");
                n.setlbnDesc17("2 – Cliente emite");
                n.setlbnRespInicio17(a);
                n.setlbnRespFinal17(b);
                n.setlbnRespQTDL17(c);
                n.setlbnRespCont17(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 61) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome18("Identificação da Distribuição ");
                n.setlbnDesc18("2 – Cliente distribui");
                n.setlbnRespInicio18(a);
                n.setlbnRespFinal18(b);
                n.setlbnRespQTDL18(c);
                n.setlbnRespCont18(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 62 && i <= 76) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 76) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome19("Número do Documento de Cobrança");
                    n.setlbnDesc19("Número do boleto");
                    n.setlbnRespInicio19(a);
                    n.setlbnRespFinal19(b);
                    n.setlbnRespQTDL19(c);
                    n.setlbnRespCont19(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 77 && i <= 84) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 84) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome20("Data de Vencimento do Título");
                    n.setlbnDesc20("Não deve ser menor que a data de emissão do bloqueto");
                    n.setlbnRespInicio20(a);
                    n.setlbnRespFinal20(b);
                    n.setlbnRespQTDL20(c);
                    n.setlbnRespCont20(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 85 && i <= 99) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 99) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome21("Valor Nominal do Título");
                    n.setlbnDesc21("Valor do Boleto");
                    n.setlbnRespInicio21(a);
                    n.setlbnRespFinal21(b);
                    n.setlbnRespQTDL21(c);
                    n.setlbnRespCont21(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 100 && i <= 104) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 104) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome22("Agência Encarregada da Cobrança");
                    n.setlbnDesc22("Informar Zeros");
                    n.setlbnRespInicio22(a);
                    n.setlbnRespFinal22(b);
                    n.setlbnRespQTDL22(c);
                    n.setlbnRespCont22(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 105) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome23("Dígito Verificador da Agência");
                n.setlbnDesc23("Informar 'branco' (espaço)");
                n.setlbnRespInicio23(a);
                n.setlbnRespFinal23(b);
                n.setlbnRespQTDL23(c);
                n.setlbnRespCont23(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 106 && i <= 107) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 107) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome24("Espécie do Título");
                    n.setlbnDesc24("02 – Duplicata Mercantil, 04 - Duplicata de Servico,  06 – Duplicata Rural");
                    n.setlbnRespInicio24(a);
                    n.setlbnRespFinal24(b);
                    n.setlbnRespQTDL24(c);
                    n.setlbnRespCont24(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 108) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome25("Identific. de Título Aceito/Não Aceito ");
                n.setlbnDesc25("Informar 'A' – para sim, ou 'N' – para não");
                n.setlbnRespInicio25(a);
                n.setlbnRespFinal25(b);
                n.setlbnRespQTDL25(c);
                n.setlbnRespCont25(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 109 && i <= 116) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 116) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome26("Data da Emissão do Título");
                    n.setlbnDesc26("DDMMAAAA - D- DIA. M - MES. A - ANO");
                    n.setlbnRespInicio26(a);
                    n.setlbnRespFinal26(b);
                    n.setlbnRespQTDL26(c);
                    n.setlbnRespCont26(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 117) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome27("Código do Juros de Mora ");
                n.setlbnDesc27("1 - Valor por Dia. 2 - Taxa Mensal. 3 - Isento ");
                n.setlbnRespInicio27(a);
                n.setlbnRespFinal27(b);
                n.setlbnRespQTDL27(c);
                n.setlbnRespCont27(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 118 && i <= 125) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 125) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome28("Data do Juros de Mora");
                    n.setlbnDesc28("DDMMAAAA - D- DIA. M - MES. A - ANO");
                    n.setlbnRespInicio28(a);
                    n.setlbnRespFinal28(b);
                    n.setlbnRespQTDL28(c);
                    n.setlbnRespCont28(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 126 && i <= 140) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 140) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome29("Juros de Mora por Dia/Taxa ");
                    n.setlbnDesc29("Valor ou porcentagem sobre o valor do título a ser cobrada de juros de mora.");
                    n.setlbnRespInicio29(a);
                    n.setlbnRespFinal29(b);
                    n.setlbnRespQTDL29(c);
                    n.setlbnRespCont29(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 141) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome30("Código do Desconto 1 ");
                n.setlbnDesc30("1 - Valor por Dia. 2 - Taxa Mensal. 3 - Isento ");
                n.setlbnRespInicio30(a);
                n.setlbnRespFinal30(b);
                n.setlbnRespQTDL30(c);
                n.setlbnRespCont30(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 142 && i <= 149) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 149) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome31("do Desconto 1");
                    n.setlbnDesc31("DDMMAAAA - D- DIA. M - MES. A - ANO");
                    n.setlbnRespInicio31(a);
                    n.setlbnRespFinal31(b);
                    n.setlbnRespQTDL31(c);
                    n.setlbnRespCont31(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 150 && i <= 164) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 164) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome32("Desconto 1 Valor/Percentual a ser concedido");
                    n.setlbnDesc32("Zeros, quando não houver desconto a ser concedido");
                    n.setlbnRespInicio32(a);
                    n.setlbnRespFinal32(b);
                    n.setlbnRespQTDL32(c);
                    n.setlbnRespCont32(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 165 && i <= 179) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 179) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome33("Valor do IOF a ser Recolhido");
                    n.setlbnDesc33("Zeros, quando não houver IOF a ser cobrando.");
                    n.setlbnRespInicio33(a);
                    n.setlbnRespFinal33(b);
                    n.setlbnRespQTDL33(c);
                    n.setlbnRespCont33(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 180 && i <= 194) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 194) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome34("Valor do Abatimento ");
                    n.setlbnDesc34("O valor do abatimento");
                    n.setlbnRespInicio34(a);
                    n.setlbnRespFinal34(b);
                    n.setlbnRespQTDL34(c);
                    n.setlbnRespCont34(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 195 && i <= 219) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 219) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome35("Identificação do Título na Empresa");
                    n.setlbnDesc35("Campo destinado para uso da Empresa Beneficiário para identificação do Título");
                    n.setlbnRespInicio35(a);
                    n.setlbnRespFinal35(b);
                    n.setlbnRespQTDL35(c);
                    n.setlbnRespCont35(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 220) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome36("Código para Protesto ");
                n.setlbnDesc36("1 – Protestar dias corridos, 2 – Protestar dias úteis, 3 – Não Protestar");
                n.setlbnRespInicio36(a);
                n.setlbnRespFinal36(b);
                n.setlbnRespQTDL36(c);
                n.setlbnRespCont36(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 221 && i <= 222) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 222) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome37("Número de Dias para Protesto");
                    n.setlbnDesc37("Número de dias decorrentes após a data de vencimento para protesto");
                    n.setlbnRespInicio37(a);
                    n.setlbnRespFinal37(b);
                    n.setlbnRespQTDL37(c);
                    n.setlbnRespCont37(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 223) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome38("Código para Baixa/Devolução ");
                n.setlbnDesc38("Campo não tratado pelo sistema. Informar 'zeros'");
                n.setlbnRespInicio38(a);
                n.setlbnRespFinal38(b);
                n.setlbnRespQTDL38(c);
                n.setlbnRespCont38(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 224 && i <= 226) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 226) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome39("Número de Dias para Baixa/Devolução");
                    n.setlbnDesc39("Campo não tratado pelo sistema. Informar 'zeros'");
                    n.setlbnRespInicio39(a);
                    n.setlbnRespFinal39(b);
                    n.setlbnRespQTDL39(c);
                    n.setlbnRespCont39(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 227 && i <= 228) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 228) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome40("Código da Moeda");
                    n.setlbnDesc40("09 -  Real ");
                    n.setlbnRespInicio40(a);
                    n.setlbnRespFinal40(b);
                    n.setlbnRespQTDL40(c);
                    n.setlbnRespCont40(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 229 && i <= 238) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 238) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome41("Nº do Contrato da Operação de Créd.");
                    n.setlbnDesc41("Campo não tratado pelo sistema. Pode ser informado 'zeros'");
                    n.setlbnRespInicio41(a);
                    n.setlbnRespFinal41(b);
                    n.setlbnRespQTDL41(c);
                    n.setlbnRespCont41(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 239) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome42("Uso Exclusivo FEBRABAN/CNAB");
                n.setlbnDesc42("Informar 'brancos' (espaços)");
                n.setlbnRespInicio42(a);
                n.setlbnRespFinal42(b);
                n.setlbnRespQTDL42(c);
                n.setlbnRespCont42(conteudo);
                cont = 0;
                conteudo = "";
            }

        }//fim do for

    }//fim metodo ArquivoSegmentoP240

    public void ArquivoSegmentoQ240(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
        FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int coluna = 240;
        int ini = 1, fin = 0, cont = 0, i, linhas;
        String linha;

        n.setCabecalho(banco, "Segmento Q", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String nome = "", conteudo = "";

        for (i = 0; i < this.getTipoNumerico(tipo); i++) {
            if (i >= 0 && i <= 2) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 2) {
                    fin = i + 1;
                    ini = 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome1("Código do Banco na Compensação");
                    n.setlbnDesc1("001 - Banco do Brasil S.A. ");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal1(b);
                    n.setlbnRespQTDL1(c);
                    n.setlbnRespCont1(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 3 && i <= 6) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 6) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome2("Lote de Serviço");
                    n.setlbnDesc2("Número seqüencial para identificar univocamente um lote de serviço");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 7) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome3("Tipo de Registro");
                n.setlbnDesc3("Código do tipo de registro. 3 - Detalhe");
                n.setlbnRespInicio3(a);
                n.setlbnRespFinal3(b);
                n.setlbnRespQTDL3(c);
                n.setlbnRespCont3(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 8 && i <= 12) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 12) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome4("Número Sequencial do Registro no Lote");
                    n.setlbnDesc4("Começar com 00002 e ir incrementando em 1 a cada nova linha de registro");
                    n.setlbnRespInicio4(a);
                    n.setlbnRespFinal4(b);
                    n.setlbnRespQTDL4(c);
                    n.setlbnRespCont4(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 13) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome5("Código Segmento do Registro Detalhe");
                n.setlbnDesc5("Código adotado pela FEBRABAN para identificar o segmento do registro");
                n.setlbnRespInicio5(a);
                n.setlbnRespFinal5(b);
                n.setlbnRespQTDL5(c);
                n.setlbnRespCont5(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 14) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome6("Uso Exclusivo FEBRABAN/CNAB");
                n.setlbnDesc6("Preencher com Brancos ");
                n.setlbnRespInicio6(a);
                n.setlbnRespFinal6(b);
                n.setlbnRespQTDL6(c);
                n.setlbnRespCont6(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 15 && i <= 16) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 16) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome7("Código de Movimento Remessa");
                    n.setlbnDesc7("'01' - Entrada de Títulos");
                    n.setlbnRespInicio7(a);
                    n.setlbnRespFinal7(b);
                    n.setlbnRespQTDL7(c);
                    n.setlbnRespCont7(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 17) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome8("Tipo de Inscrição");
                n.setlbnDesc8("1 – para CPF.  2 – para CNPJ");
                n.setlbnRespInicio8(a);
                n.setlbnRespFinal8(b);
                n.setlbnRespQTDL8(c);
                n.setlbnRespCont8(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 18 && i <= 32) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 32) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome9("Número de Inscrição");
                    n.setlbnDesc9("Número de inscrição (CPF ou CNPJ) da Empresa");
                    n.setlbnRespInicio9(a);
                    n.setlbnRespFinal9(b);
                    n.setlbnRespQTDL9(c);
                    n.setlbnRespCont9(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 33 && i <= 72) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 72) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome10("Nome");
                    n.setlbnDesc10("Nome da Empresa");
                    n.setlbnRespInicio10(a);
                    n.setlbnRespFinal10(b);
                    n.setlbnRespQTDL10(c);
                    n.setlbnRespCont10(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 73 && i <= 112) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 112) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome11("Endereço");
                    n.setlbnDesc11("Endereço da Empresa");
                    n.setlbnRespInicio11(a);
                    n.setlbnRespFinal11(b);
                    n.setlbnRespQTDL11(c);
                    n.setlbnRespCont11(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 113 && i <= 127) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 127) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome12("Bairro");
                    n.setlbnDesc12("Bairro da Empresa");
                    n.setlbnRespInicio12(a);
                    n.setlbnRespFinal12(b);
                    n.setlbnRespQTDL12(c);
                    n.setlbnRespCont12(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 128 && i <= 132) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 132) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome13("CEP");
                    n.setlbnDesc13("CEP com 5 digitos");
                    n.setlbnRespInicio13(a);
                    n.setlbnRespFinal13(b);
                    n.setlbnRespQTDL13(c);
                    n.setlbnRespCont13(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 133 && i <= 135) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 135) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome14("Sufixo do CEP");
                    n.setlbnDesc14("Digitos do CEP");
                    n.setlbnRespInicio14(a);
                    n.setlbnRespFinal14(b);
                    n.setlbnRespQTDL14(c);
                    n.setlbnRespCont14(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 136 && i <= 150) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 150) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome15("Cidade");
                    n.setlbnDesc15("Cidade da Empresa");
                    n.setlbnRespInicio15(a);
                    n.setlbnRespFinal15(b);
                    n.setlbnRespQTDL15(c);
                    n.setlbnRespCont15(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 151 && i <= 152) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 152) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome16("Unidade da Federação");
                    n.setlbnDesc16("UF da Empresa");
                    n.setlbnRespInicio16(a);
                    n.setlbnRespFinal16(b);
                    n.setlbnRespQTDL16(c);
                    n.setlbnRespCont16(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 153) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome17("Tipo de Inscrição");
                n.setlbnDesc17("'0'  -  Isento / Não Informado. '1' - CPF.  '2' - CGC / CNPJ");
                n.setlbnRespInicio17(a);
                n.setlbnRespFinal17(b);
                n.setlbnRespQTDL17(c);
                n.setlbnRespCont17(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 154 && i <= 168) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 168) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome18("Número de Inscrição");
                    n.setlbnDesc18("Número de inscrição da Empresa ou Pessoa Física");
                    n.setlbnRespInicio18(a);
                    n.setlbnRespFinal18(b);
                    n.setlbnRespQTDL18(c);
                    n.setlbnRespCont18(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 169 && i <= 208) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 208) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome19("Nome do Sacador / Avalista");
                    n.setlbnDesc19("Nome que identifica a pessoa, física ou jurídica, a qual se quer fazer referência.");
                    n.setlbnRespInicio19(a);
                    n.setlbnRespFinal19(b);
                    n.setlbnRespQTDL19(c);
                    n.setlbnRespCont19(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 209 && i <= 211) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 211) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome20("Cod Bco Corres. na Compensação");
                    n.setlbnDesc20("Campo não tratado. Preencher com 'zeros'");
                    n.setlbnRespInicio20(a);
                    n.setlbnRespFinal20(b);
                    n.setlbnRespQTDL20(c);
                    n.setlbnRespCont20(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 212 && i <= 231) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 231) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome21("Nosso Número no Banco Correspondente");
                    n.setlbnDesc21("Campo não tratado. Preencher com 'brancos'");
                    n.setlbnRespInicio21(a);
                    n.setlbnRespFinal21(b);
                    n.setlbnRespQTDL21(c);
                    n.setlbnRespCont21(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i >= 232 && i <= 239) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 239) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome22("Uso Exclusivo Febraban/CNAB");
                    n.setlbnDesc22("Informar 'brancos' (espaços)");
                    n.setlbnRespInicio22(a);
                    n.setlbnRespFinal22(b);
                    n.setlbnRespQTDL22(c);
                    n.setlbnRespCont22(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            }

        }//fim do for

    }//fim metodo ArquivoSegmentoQ240

    public void ArquivoSegmentoR240(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
        FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int coluna = 240;
        int ini = 1, fin = 0, cont = 0, i, linhas;
        String linha;

        n.setCabecalho(banco, "Segmento R", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String nome = "", conteudo = "";

        for (i = 0; i < this.getTipoNumerico(tipo); i++) {
            if (i >= 0 && i <= 2) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 2) {
                    fin = i + 1;
                    ini = 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome1("Código do Banco na Compensação");
                    n.setlbnDesc1("001 - Banco do Brasil S.A. ");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal1(b);
                    n.setlbnRespQTDL1(c);
                    n.setlbnRespCont1(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 3 && i <= 6) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 6) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome2("Lote de Serviço");
                    n.setlbnDesc2("Número seqüencial para identificar univocamente um lote de serviço");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 7) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome3("Tipo de Registro");
                n.setlbnDesc3("Código do tipo de registro. 3 - Detalhe");
                n.setlbnRespInicio3(a);
                n.setlbnRespFinal3(b);
                n.setlbnRespQTDL3(c);
                n.setlbnRespCont3(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 8 && i <= 12) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 12) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome4("Número Sequencial do Registro no Lote");
                    n.setlbnDesc4("Incrementar em 1 a cada nova linha do registro detalhe");
                    n.setlbnRespInicio4(a);
                    n.setlbnRespFinal4(b);
                    n.setlbnRespQTDL4(c);
                    n.setlbnRespCont4(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 13) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome5("Código Segmento do Registro Detalhe");
                n.setlbnDesc5("Incrementar em 1 a cada nova linha do registro detalhe");
                n.setlbnRespInicio5(a);
                n.setlbnRespFinal5(b);
                n.setlbnRespQTDL5(c);
                n.setlbnRespCont5(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i == 14) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome6("Reservado (uso Banco)");
                n.setlbnDesc6("Campo não tratado. Informar Zeros ou 'brancos'");
                n.setlbnRespInicio6(a);
                n.setlbnRespFinal6(b);
                n.setlbnRespQTDL6(c);
                n.setlbnRespCont6(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 15 && i <= 16) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 16) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome7("Código de Movimento Remessa");
                    n.setlbnDesc7(" 01 – Entrada de títulos");
                    n.setlbnRespInicio7(a);
                    n.setlbnRespFinal7(b);
                    n.setlbnRespQTDL7(c);
                    n.setlbnRespCont7(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i == 17) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome8("Código do Desconto 2");
                n.setlbnDesc8("0 - Isento | 1 - Valor Fixo | 2 - Percentual ");
                n.setlbnRespInicio8(a);
                n.setlbnRespFinal8(b);
                n.setlbnRespQTDL8(c);
                n.setlbnRespCont8(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 18 && i <= 25) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 25) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome9("Data do Desconto 2");
                    n.setlbnDesc9("DDMMAAAA - D- DIA. M - MES. A - ANO");
                    n.setlbnRespInicio9(a);
                    n.setlbnRespFinal9(b);
                    n.setlbnRespQTDL9(c);
                    n.setlbnRespCont9(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 26 && i <= 40) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 40) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome10("Valor/Percentual a ser Concedido");
                    n.setlbnDesc10("Expresso em moeda corrente, utilizar duas casas decimais");
                    n.setlbnRespInicio10(a);
                    n.setlbnRespFinal10(b);
                    n.setlbnRespQTDL10(c);
                    n.setlbnRespCont10(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 41 && i <= 64) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 64) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome11("Reservado (uso Banco)");
                    n.setlbnDesc11("Brancos");
                    n.setlbnRespInicio11(a);
                    n.setlbnRespFinal11(b);
                    n.setlbnRespQTDL11(c);
                    n.setlbnRespCont11(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 65 && i <= 65) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 65) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome12("Código da multa");
                    n.setlbnDesc12("1 - Valor fixo | 2 - Percentual");
                    n.setlbnRespInicio12(a);
                    n.setlbnRespFinal12(b);
                    n.setlbnRespQTDL12(c);
                    n.setlbnRespCont12(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 66 && i <= 73) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 73) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome13("Data da multa");
                    n.setlbnDesc13("DDMMAAAA - D- DIA. M - MES. A - ANO");
                    n.setlbnRespInicio13(a);
                    n.setlbnRespFinal13(b);
                    n.setlbnRespQTDL13(c);
                    n.setlbnRespCont13(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 74 && i <= 88) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 88) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome14("Valor / Percentual a ser aplicado");
                    n.setlbnDesc14("Decimais sem separador");
                    n.setlbnRespInicio14(a);
                    n.setlbnRespFinal14(b);
                    n.setlbnRespQTDL14(c);
                    n.setlbnRespCont14(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 89 && i <= 98) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 98) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome15("Reservado (uso Banco)");
                    n.setlbnDesc15("Data a partir da qual a multa deverá ser cobrada");
                    n.setlbnRespInicio15(a);
                    n.setlbnRespFinal15(b);
                    n.setlbnRespQTDL15(c);
                    n.setlbnRespCont15(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 99 && i <= 138) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 138) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome16("Mensagem 3");
                    n.setlbnDesc16("Mensagem livres a serem impressas no campo de instruções no boleto");
                    n.setlbnRespInicio16(a);
                    n.setlbnRespFinal16(b);
                    n.setlbnRespQTDL16(c);
                    n.setlbnRespCont16(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 139 && i <= 178) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 178) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome17("Mensagem 4");
                    n.setlbnDesc17("Mensagem livres a serem impressas no campo de instruções no boleto");
                    n.setlbnRespInicio17(a);
                    n.setlbnRespFinal17(b);
                    n.setlbnRespQTDL17(c);
                    n.setlbnRespCont17(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 179 && i <= 198) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 198) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome18("Uso Exclusivo FEBRABAN/CNAB  ");
                    n.setlbnDesc18("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio18(a);
                    n.setlbnRespFinal18(b);
                    n.setlbnRespQTDL18(c);
                    n.setlbnRespCont18(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 199 && i <= 206) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 206) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome19("Cód. Ocorrencia do Sacado ");
                    n.setlbnDesc19("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio19(a);
                    n.setlbnRespFinal19(b);
                    n.setlbnRespQTDL19(c);
                    n.setlbnRespCont19(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 207 && i <= 209) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 209) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome20("Cód. do Banco na Conta do Débito ");
                    n.setlbnDesc20("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio20(a);
                    n.setlbnRespFinal20(b);
                    n.setlbnRespQTDL20(c);
                    n.setlbnRespCont20(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 210 && i <= 214) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 214) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome21("Código da Agência do Débito ");
                    n.setlbnDesc21("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio21(a);
                    n.setlbnRespFinal21(b);
                    n.setlbnRespQTDL21(c);
                    n.setlbnRespCont21(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 215 && i <= 215) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 215) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome22("Verificador da Agência");
                    n.setlbnDesc22("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio22(a);
                    n.setlbnRespFinal22(b);
                    n.setlbnRespQTDL22(c);
                    n.setlbnRespCont22(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 216 && i <= 227) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 227) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome23("Conta Corrente para Débito");
                    n.setlbnDesc23("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio23(a);
                    n.setlbnRespFinal23(b);
                    n.setlbnRespQTDL23(c);
                    n.setlbnRespCont23(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 228 && i <= 228) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 228) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome24("Conta Corrente para Débito ");
                    n.setlbnDesc24("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio24(a);
                    n.setlbnRespFinal24(b);
                    n.setlbnRespQTDL24(c);
                    n.setlbnRespCont24(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 229 && i <= 229) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 229) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome25("Dígito Verificador da Conta ");
                    n.setlbnDesc25("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio25(a);
                    n.setlbnRespFinal25(b);
                    n.setlbnRespQTDL25(c);
                    n.setlbnRespCont25(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 230 && i <= 230) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 229) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome26("Aviso para Débito Automático  ");
                    n.setlbnDesc26("Campo não tratado. Informar 'brancos'. ");
                    n.setlbnRespInicio26(a);
                    n.setlbnRespFinal26(b);
                    n.setlbnRespQTDL26(c);
                    n.setlbnRespCont26(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 231 && i <= 239) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 239) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome27("Aviso para Débito Automático  ");
                    n.setlbnDesc27("Uso Exclusivo FEBRABAN/CNAB ");
                    n.setlbnRespInicio27(a);
                    n.setlbnRespFinal27(b);
                    n.setlbnRespQTDL27(c);
                    n.setlbnRespCont27(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            }

        }//fim do for

    }//fim metodo ArquivoSegmentoR240

    public void ArquivoTrailerdeLote240(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
        FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int coluna = 240;
        int ini = 1, fin = 0, cont = 0, i, linhas;
        String linha;

        n.setCabecalho(banco, "Trailer de Lote", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String nome = "", conteudo = "";

        for (i = 0; i < this.getTipoNumerico(tipo); i++) {
            if (i >= 0 && i <= 2) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 2) {
                    fin = i + 1;
                    ini = 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome1("Código do Banco na Compensação");
                    n.setlbnDesc1("001 - Banco do Brasil S. A.");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal1(b);
                    n.setlbnRespQTDL1(c);
                    n.setlbnRespCont1(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 3 && i <= 6) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 6) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome2("Lote de Serviço");
                    n.setlbnDesc2("Número seqüencial para identificar univocamente um lote de serviço");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 7) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome3("Tipo de Registro");
                n.setlbnDesc3("Código do tipo de registro. 5 - Trailer de Lote ");
                n.setlbnRespInicio3(a);
                n.setlbnRespFinal3(b);
                n.setlbnRespQTDL3(c);
                n.setlbnRespCont3(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 8 && i <= 16) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 16) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome4("Uso Exclusivo FEBRABAN/CNAB");
                    n.setlbnDesc6("Campo não tratado. Informar Zeros ou 'brancos'");
                    n.setlbnRespInicio4(a);
                    n.setlbnRespFinal4(b);
                    n.setlbnRespQTDL4(c);
                    n.setlbnRespCont4(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 17 && i <= 22) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 22) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome5("Quantidade de Registros do Lote");
                    n.setlbnDesc5("Total de linhas do lote (inclui Header de lote, Registros e  Trailer de lote)");
                    n.setlbnRespInicio5(a);
                    n.setlbnRespFinal5(b);
                    n.setlbnRespQTDL5(c);
                    n.setlbnRespCont5(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 23 && i <= 239) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 239) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome6("Uso Exclusivo FEBRABAN/CNAB");
                    n.setlbnDesc6("Campo não tratado. Informar Zeros ou 'brancos'");
                    n.setlbnRespInicio6(a);
                    n.setlbnRespFinal6(b);
                    n.setlbnRespQTDL6(c);
                    n.setlbnRespCont6(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            }
        }//fim do for

    }//fim metodo ArquivoTrailerdeLote240    

    public void ArquivoTrailerdeArquivo240(String banco, int linhaSelecionada, String tipo, String linhaArquivo) {
        FormResp n = new FormResp();
        n.setVisible(true);
        n.setLocationRelativeTo(null);
        int coluna = 240;
        int ini = 1, fin = 0, cont = 0, i, linhas;
        String linha;

        n.setCabecalho(banco, "Trailer de Arquivo", linhaSelecionada);
        n.setlbnLinhaSelecionada(Integer.toString(linhaSelecionada));

        String nome = "", conteudo = "";

        for (i = 0; i < this.getTipoNumerico(tipo); i++) {
            if (i >= 0 && i <= 2) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 2) {
                    fin = i + 1;
                    ini = 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome1("Código do Banco na Compensação");
                    n.setlbnDesc1("001 - Banco do Brasil S. A.");
                    n.setlbnRespInicio1(a);
                    n.setlbnRespFinal1(b);
                    n.setlbnRespQTDL1(c);
                    n.setlbnRespCont1(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 3 && i <= 6) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 6) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome2("Lote de Serviço");
                    n.setlbnDesc2("Número seqüencial para identificar univocamente um lote de serviço");
                    n.setlbnRespInicio2(a);
                    n.setlbnRespFinal2(b);
                    n.setlbnRespQTDL2(c);
                    n.setlbnRespCont2(conteudo);
                    cont = 0;
                    conteudo = "";
                }

            } else if (i == 7) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                fin = i + 1;
                ini = fin - cont + 1;
                String a, b, c;
                a = Integer.toString(ini);
                b = Integer.toString(fin);
                c = Integer.toString(cont);
                n.setlbnrespNome3("Tipo de Registro");
                n.setlbnDesc3("Código do tipo de registro. 9 - Trailer de Arquivo");
                n.setlbnRespInicio3(a);
                n.setlbnRespFinal3(b);
                n.setlbnRespQTDL3(c);
                n.setlbnRespCont3(conteudo);
                cont = 0;
                conteudo = "";
            } else if (i >= 8 && i <= 16) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 16) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome4("Uso Exclusivo FEBRABAN/CNAB");
                    n.setlbnDesc4("Campo não tratado. Informar Zeros ou 'brancos'");
                    n.setlbnRespInicio4(a);
                    n.setlbnRespFinal4(b);
                    n.setlbnRespQTDL4(c);
                    n.setlbnRespCont4(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 17 && i <= 22) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 22) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome5("Quantidade de Lotes do Arquivo");
                    n.setlbnDesc5("Total de linhas do lote (inclui Header de lote, Registros e  Trailer de lote)");
                    n.setlbnRespInicio5(a);
                    n.setlbnRespFinal5(b);
                    n.setlbnRespQTDL5(c);
                    n.setlbnRespCont5(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 23 && i <= 28) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 28) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome6("Quantidade de Registros do Arquivo");
                    n.setlbnDesc6("Campo não tratado. Informar Zeros ou 'brancos'");
                    n.setlbnRespInicio6(a);
                    n.setlbnRespFinal6(b);
                    n.setlbnRespQTDL6(c);
                    n.setlbnRespCont6(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 29 && i <= 34) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 34) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome7("Qtde de Contas p/ Conc. (Lotes)");
                    n.setlbnRespInicio7(a);
                    n.setlbnRespFinal7(b);
                    n.setlbnRespQTDL7(c);
                    n.setlbnRespCont7(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            } else if (i >= 35 && i <= 239) {
                conteudo = conteudo + linhaArquivo.charAt(i);
                cont++;
                if (i == 239) {
                    fin = i + 1;
                    ini = fin - cont + 1;
                    String a, b, c;
                    a = Integer.toString(ini);
                    b = Integer.toString(fin);
                    c = Integer.toString(cont);
                    n.setlbnrespNome8("Uso Exclusivo FEBRABAN/CNAB");
                    n.setlbnDesc8("Campo não tratado. Informar Zeros ou 'brancos'");
                    n.setlbnRespInicio8(a);
                    n.setlbnRespFinal8(b);
                    n.setlbnRespQTDL8(c);
                    n.setlbnRespCont8(conteudo);
                    cont = 0;
                    conteudo = "";
                }
            }

        }//fim do for

    }//fim metodo ArquivoSegmentoR240
    */

}
