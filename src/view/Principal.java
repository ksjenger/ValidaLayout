package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Principal extends javax.swing.JFrame {


    public Principal() {
        initComponents();
    }

    private void initComponents() {

        buttonGroupCNAB = new javax.swing.ButtonGroup();
        jPanelCabecalho = new javax.swing.JPanel();
        jLabel_Cabecalho = new javax.swing.JLabel();
        jbtnCad = new javax.swing.JButton();
        jPanelImportar = new javax.swing.JPanel();
        jButtonProcurar = new javax.swing.JButton();
        jButtonAnalisar2 = new javax.swing.JButton();
        jTextFieldCaminhoArquivo = new javax.swing.JTextField();
        jLabelAnalise = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLinhaArquivo = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabelQtd1 = new javax.swing.JLabel();
        jLabelBanco1 = new javax.swing.JLabel();
        jLabelTipo = new javax.swing.JLabel();
        jLabelRespBanco = new javax.swing.JLabel();
        jLabelRespTipo = new javax.swing.JLabel();
        jLabelResplinas = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jRadioButtonMenuBancosHomologados = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuSobre = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanelCabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelCabecalho.setLayout(null);

        jLabel_Cabecalho.setFont(new java.awt.Font("Tahoma", 1, 36)); 
        jLabel_Cabecalho.setText("Validador de Arquivo Remessa");
        jPanelCabecalho.add(jLabel_Cabecalho);
        jLabel_Cabecalho.setBounds(370, 10, 570, 80);

        jbtnCad.setText("Visual");
        jbtnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCadActionPerformed(evt);
            }
        });
        jPanelCabecalho.add(jbtnCad);
        jbtnCad.setBounds(1110, 30, 140, 23);

        getContentPane().add(jPanelCabecalho);
        jPanelCabecalho.setBounds(0, 30, 1310, 90);

        jPanelImportar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButtonProcurar.setText("Procurar");
        jButtonProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProcurarActionPerformed(evt);
            }
        });

        jButtonAnalisar2.setText("Analisar");
        jButtonAnalisar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalisar2ActionPerformed(evt);
            }
        });

        jTextFieldCaminhoArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCaminhoArquivoActionPerformed(evt);
            }
        });

        jLabelAnalise.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabelAnalise.setText("Caminho do Arquivo:");

        jTextAreaLinhaArquivo.setColumns(20);
        jTextAreaLinhaArquivo.setRows(5);
        jTextAreaLinhaArquivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextAreaLinhaArquivoMouseClicked(evt);
            }
        });
        jTextAreaLinhaArquivo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jTextAreaLinhaArquivoCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTextAreaLinhaArquivo);

        jLabelQtd1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabelQtd1.setText("Quantidade Linhas: ");

        jLabelBanco1.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabelBanco1.setText("Banco:");

        jLabelTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        jLabelTipo.setText("Tipo:");

        jLabelRespBanco.setForeground(new java.awt.Color(204, 0, 0));

        jLabelRespTipo.setForeground(new java.awt.Color(204, 0, 0));

        jLabelResplinas.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelBanco1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRespBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(jLabelTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRespTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127)
                .addComponent(jLabelQtd1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelResplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelResplinas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelQtd1)
                    .addComponent(jLabelTipo)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelBanco1)
                        .addComponent(jLabelRespBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelRespTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelImportarLayout = new javax.swing.GroupLayout(jPanelImportar);
        jPanelImportar.setLayout(jPanelImportarLayout);
        jPanelImportarLayout.setHorizontalGroup(
            jPanelImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImportarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelImportarLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabelAnalise, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAnalisar2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelImportarLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanelImportarLayout.setVerticalGroup(
            jPanelImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelImportarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelImportarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProcurar)
                    .addComponent(jButtonAnalisar2)
                    .addComponent(jTextFieldCaminhoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAnalise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelImportar);
        jPanelImportar.setBounds(0, 140, 1310, 390);

        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });

        jMenu.setText("Opções");

        jRadioButtonMenuBancosHomologados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        jRadioButtonMenuBancosHomologados.setText("Bancos e Layouts Revisados");
        jRadioButtonMenuBancosHomologados.setToolTipText("");
        jRadioButtonMenuBancosHomologados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuBancosHomologadosActionPerformed(evt);
            }
        });
        jMenu.add(jRadioButtonMenuBancosHomologados);

        jRadioButtonMenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jRadioButtonMenuSobre.setText("Sobre");
        jRadioButtonMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuSobreActionPerformed(evt);
            }
        });
        jMenu.add(jRadioButtonMenuSobre);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1326, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProcurarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JFileChooser buscaAquivo = new JFileChooser();
            buscaAquivo.setCurrentDirectory(new File("/Users/ksjenger/Desktop/"));
            buscaAquivo.setDialogTitle("Selecione o arquivo de Remessa");
            buscaAquivo.showOpenDialog(this);
            String arquivo = "" + buscaAquivo.getSelectedFile().getPath();

            jTextFieldCaminhoArquivo.setText(arquivo);
            bancos.setUrl(arquivo);
            

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Tente novamente!");
        }
    }

    private void jButtonAnalisar2ActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void jTextFieldCaminhoArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCaminhoArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCaminhoArquivoActionPerformed

    private void jTextAreaLinhaArquivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaLinhaArquivoMouseClicked
        jTextAreaLinhaArquivo.setEditable(false);
        int i, j, l = 0, temp, temp1;
        
        bancos.setLinhaSelecionada(bancos.numeroLinha(jTextAreaLinhaArquivo.getCaretPosition()));
        
          //CNAB 240
        if (bancos.getTipo().equals("CNAB 240")) {
            //Banco do Brasil
            if (bancos.getBanco().equals("Banco do Brasil S A")) {
                arquivoBancoBB.setGravarLinhas(bancos.getUrl(), bancos.getQtdLinhas());
                if (bancos.getLinhaSelecionada() == 1) {
                    arquivoBancoBB.ArquivoReaderBB240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() == 2) {
                    arquivoBancoBB.ArquivoReaderLoteBB240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() > 2) {
                    if (arquivoBancoBB.tipoSegmento(arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("P")) {
                        arquivoBancoBB.ArquivoSegmentoP240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoBB.tipoSegmento(arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("Q")) {
                        arquivoBancoBB.ArquivoSegmentoQ240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoBB.tipoSegmento(arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("R")) {
                        arquivoBancoBB.ArquivoSegmentoR240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas() - 1) {
                        arquivoBancoBB.ArquivoTrailerdeLote240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas()) {
                        arquivoBancoBB.ArquivoTrailerdeArquivo240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBB.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "Tente novamente com outra linha.");
                    }
                }
                //Banco Itau
                
            }else if (bancos.getBanco().equals("Banco Itau")) {
                arquivoBancoIt.setGravarLinhas(bancos.getUrl(), bancos.getQtdLinhas());
                if (bancos.getLinhaSelecionada() == 1) {
                    arquivoBancoIt.ArquivoReader240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() == 2) {
                    arquivoBancoIt.ArquivoReaderLote240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() > 2) {
                    if (arquivoBancoIt.tipoSegmento(arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("P")) {
                        arquivoBancoIt.ArquivoSegmentoP240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoIt.tipoSegmento(arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("Q")) {
                        arquivoBancoIt.ArquivoSegmentoQ240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoIt.tipoSegmento(arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("R")) {
                        JOptionPane.showMessageDialog(null, "Segmento R não homologado");
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas() - 1) {
                        arquivoBancoIt.ArquivoTrailerdeLote240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas()) {
                        arquivoBancoIt.ArquivoTrailerdeArquivo240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "Tente novamente com outra linha.");
                    }
                }

                // Banco Santander
            } else if (bancos.getBanco().equals("Grupo Santander")) {
                arquivoBancoSt.setGravarLinhas(bancos.getUrl(), bancos.getQtdLinhas());
                if (bancos.getLinhaSelecionada() == 1) {
                    arquivoBancoSt.ArquivoReaderSantander240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() == 2) {
                    arquivoBancoSt.ArquivoReaderLote240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() > 2) {
                    if (arquivoBancoSt.tipoSegmento(arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("P")) {
                        arquivoBancoSt.ArquivoSegmentoP240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoSt.tipoSegmento(arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("Q")) {
                        arquivoBancoSt.ArquivoSegmentoQ240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoSt.tipoSegmento(arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("R")) {
                        arquivoBancoSt.ArquivoSegmentoR240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas() - 1) {
                        arquivoBancoSt.ArquivoTrailerdeLote240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas()) {
                        arquivoBancoSt.ArquivoTrailerdeArquivo240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoSt.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "Tente novamente com outra linha.");
                    }
                }

            }
        //Caixa    
            
            else if (bancos.getBanco().equals("Caixa Econômica Federal")) {
                arquivoBancoCx.setGravarLinhas(bancos.getUrl(), bancos.getQtdLinhas());
                if (bancos.getLinhaSelecionada() == 1) {
                    arquivoBancoCx.ArquivoReader(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() == 2) {
                    arquivoBancoCx.ArquivoReaderLote240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() > 2) {
                    if (arquivoBancoCx.tipoSegmento(arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("P")) {
                        arquivoBancoCx.ArquivoSegmentoP240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoCx.tipoSegmento(arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("Q")) {
                        arquivoBancoCx.ArquivoSegmentoQ240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (arquivoBancoCx.tipoSegmento(arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1)).equals("R")) {
                        arquivoBancoCx.ArquivoSegmentoR240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas() - 1) {
                        arquivoBancoCx.ArquivoTrailerdeLote240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas()) {
                        arquivoBancoCx.ArquivoTrailerdeArquivo240(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoCx.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "Tente novamente com outra linha.");
                    }
                }

            }
            
        } else {
            //CNAB 400
            if (bancos.getBanco().equals("Banco Itau")) {
                arquivoBancoIt2.setGravarLinhas(bancos.getUrl(), bancos.getQtdLinhas());
                if (bancos.getLinhaSelecionada() == 1) {
                    arquivoBancoIt2.ArquivoReader400(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt2.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() > 1) {
                    if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas()) {
                        arquivoBancoIt2.Trailer(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt2.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else {
                        arquivoBancoIt2.Detalhe(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoIt2.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    }
                }

            }
            if(bancos.getBanco().equals("Bradesco")){
                arquivoBancoBra400.setGravarLinhas(bancos.getUrl(), bancos.getQtdLinhas());
                if (bancos.getLinhaSelecionada() == 1) {
                    arquivoBancoBra400.ArquivoReader400(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBra400.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                } else if (bancos.getLinhaSelecionada() >= 2) {
                    if (bancos.getLinhaSelecionada() == bancos.getQtdLinhas()) {
                        arquivoBancoBra400.Trailer(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBra400.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    } else {
                        arquivoBancoBra400.Detalhe(bancos.getBanco(), bancos.getLinhaSelecionada(), bancos.getTipo(), arquivoBancoBra400.getLinhasArquivo(bancos.getLinhaSelecionada() - 1));
                    }
                }
                
            }

        }

    }

    private void jTextAreaLinhaArquivoCaretPositionChanged(java.awt.event.InputMethodEvent evt) {
        
    }

    private void jRadioButtonMenuBancosHomologadosActionPerformed(java.awt.event.ActionEvent evt) {
    
    }

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {
        
    }

    private void jRadioButtonMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {
        FormSobre sobre = new FormSobre ();
        sobre.setVisible(true);
        sobre.setTitle("Sobre");
    }

    private void jbtnCadActionPerformed(java.awt.event.ActionEvent evt) {
        CadastroVisualClasse visual = new CadastroVisualClasse();
        visual.MontarFormCdVisual(bancos.getBanco(), bancos.getTipo(), visual.getGravarLinha(bancos.getUrl()));
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal x = new Principal();
                x.setVisible(true);
                x.setTitle("Validador de Arquivo Remessa");
                x.jbtnCad.setVisible(false);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCNAB;
    private javax.swing.JButton jButtonAnalisar2;
    private javax.swing.JButton jButtonProcurar;
    private javax.swing.JLabel jLabelAnalise;
    private javax.swing.JLabel jLabelBanco1;
    private javax.swing.JLabel jLabelQtd1;
    private javax.swing.JLabel jLabelRespBanco;
    private javax.swing.JLabel jLabelRespTipo;
    private javax.swing.JLabel jLabelResplinas;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JLabel jLabel_Cabecalho;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCabecalho;
    private javax.swing.JPanel jPanelImportar;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuBancosHomologados;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuSobre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaLinhaArquivo;
    private javax.swing.JTextField jTextFieldCaminhoArquivo;
    private javax.swing.JButton jbtnCad;
    // End of variables declaration//GEN-END:variables
}