package Telas;

import Telas.TelaPrincipal;
import model.UsuarioDTO;
import model.TipoUsuario;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Raphael
 */
public class TelaLogin extends javax.swing.JFrame {
    private List<UsuarioDTO> usuarios = new ArrayList<>();
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
        inicializarUsuarios();
    }
    private void inicializarUsuarios() {
        usuarios.add(new UsuarioDTO("ana","123",TipoUsuario.ATENDENTE));
        usuarios.add(new UsuarioDTO("joao","abc",TipoUsuario.FINANCEIRO));
        usuarios.add(new UsuarioDTO("lucas","admin",TipoUsuario.GERENTE));
    }

    private UsuarioDTO autenticar(String login, String senha) {
        for (UsuarioDTO u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Usuariotxt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Loginbtn = new javax.swing.JButton();
        Senhatxt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Usuariotxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Usuariotxt1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("La Discotheque");

        Loginbtn.setBackground(new java.awt.Color(81, 90, 192));
        Loginbtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Loginbtn.setForeground(new java.awt.Color(255, 255, 255));
        Loginbtn.setText("Entrar");
        Loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginbtnActionPerformed(evt);
            }
        });

        Senhatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenhatxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(Loginbtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(215, 215, 215))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(Usuariotxt1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Senhatxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(185, 185, 185))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usuariotxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Senhatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Loginbtn)
                .addGap(152, 152, 152))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Usuariotxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Usuariotxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Usuariotxt1ActionPerformed

    private void LoginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginbtnActionPerformed
        String login = Usuariotxt1.getText();
    String senha = new String(Senhatxt.getPassword());
    UsuarioDTO logado = autenticar(login, senha);

    if (logado != null) {
        new TelaPrincipal(logado).setVisible(true);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this,
            "Usuário ou senha incorretos.",
            "Erro de login",
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_LoginbtnActionPerformed

    private void SenhatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenhatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SenhatxtActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Loginbtn;
    private javax.swing.JPasswordField Senhatxt;
    private javax.swing.JTextField Usuariotxt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
