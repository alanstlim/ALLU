
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alan S'
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Conexao conecta = new Conexao();
    
    public Login() {
        initComponents();
        conecta.conectar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        login = new javax.swing.JTextField();
        entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Senha :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 60, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 40, 60, 25);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lag.png"))); // NOI18N
        jLabel4.setText("jLabel3");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(380, 10, 180, 140);
        getContentPane().add(senha);
        senha.setBounds(40, 120, 200, 30);
        getContentPane().add(login);
        login.setBounds(40, 60, 200, 30);

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        getContentPane().add(entrar);
        entrar.setBounds(70, 170, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 560, 240);

        setSize(new java.awt.Dimension(576, 278));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
       String funcao; 
        try {
            conecta.executaSQL("SELECT * FROM usuarios where login = '" + login.getText() + "' and senha ='" + senha.getText() + "'");
            conecta.rs.first();
            funcao = (conecta.rs.getString("funcao"));

            if (conecta.rs.getRow() > 0) {
                switch (funcao) {
                    case "responsavel":    
                    JOptionPane.showMessageDialog(null, "Seja Bem-vindo!");
                    new InicioAdm().setVisible(true);
                    this.setVisible(false);
                    
                        break;
                    case "adm":
                     JOptionPane.showMessageDialog(null, "Seja Bem-vindo!");
                     new InicioAdm().setVisible(true);
                     this.setVisible(false);
                        break;
                      
                    case "aluno":
                    JOptionPane.showMessageDialog (null, "Seja Bem-Vindo");
                    new InicioAdm().setVisible(true);
                    this.setVisible(false);
                    break;
                        
                    default:
                        System.out.println("Função Invalida!");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha Invalido!!");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Login ou Senha Invalido!!");
        }
    }//GEN-LAST:event_entrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}