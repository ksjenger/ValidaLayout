package view;


public class FormSobre extends javax.swing.JFrame {

    public FormSobre() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblDesc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setInheritsPopupMenu(true);
        jPanel1.setMaximumSize(new java.awt.Dimension(480, 370));
        jPanel1.setName("Sobre"); 
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        lblDesc.setFont(new java.awt.Font("Tahoma", 0, 16));
        lblDesc.setText("Esta aplicação foi desenvolvida utilizando linguagem JAVA. ");
        jPanel2.add(lblDesc);
        lblDesc.setBounds(10, 20, 430, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        jLabel1.setText("Seu objetivo é auxiliar a compreensão e facil analise dos");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 40, 420, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        jLabel3.setText("arquivos de remessa dos bancos. Qualquer dúvida sobre as ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 70, 430, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        jLabel2.setText("no layout disponibilizados pelos bancos.");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 120, 420, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        jLabel4.setText("informaÃ§Ãµes descritas, devem ser esclarecidas diretamente");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 90, 440, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 460, 170);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        jLabel5.setText("Autor: Kauan Jenger");
        jPanel3.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        jPanel3.add(jLabel6);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 310, 460, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 370);
        jPanel1.getAccessibleContext().setAccessibleName("Sobre");
        jPanel1.getAccessibleContext().setAccessibleDescription("Sobre");

        setSize(new java.awt.Dimension(501, 415));
        setLocationRelativeTo(null);
    }

   
    public static void main(String args[]) {
     
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSobre().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDesc;

}
