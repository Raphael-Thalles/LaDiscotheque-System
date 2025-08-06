package Telas;

import Telas.TelaListagemDisco;
import javax.swing.JOptionPane;
import model.TipoUsuario;
import model.UsuarioDTO;

/**
 *
 * @author Raphael
 */

public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    
     private UsuarioDTO usuarioLogado;
    public TelaPrincipal(UsuarioDTO logado) {
        initComponents();
        setLocationRelativeTo(null);
        this.usuarioLogado = usuarioLogado;
        configurarPermissoes();
        this.usuarioLogado = logado;
         System.out.println("Usuário logado: " + usuarioLogado.getNome());
        lblUsuario.setText("Bem-vindo(a), " + usuarioLogado.getNome());

    }

private void configurarPermissoes() {
    if (usuarioLogado == null || usuarioLogado.getTipo() == null) {
        JOptionPane.showMessageDialog(this, "Usuário não identificado.");
        return;
    }

    TipoUsuario tipo = usuarioLogado.getTipo();

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTelaDisco = new javax.swing.JButton();
        Venderbtn = new javax.swing.JButton();
        btnTelaClientes = new javax.swing.JButton();
        btnFornecedores = new javax.swing.JButton();
        BtnPedido = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTelaDisco.setBackground(new java.awt.Color(58, 71, 153));
        btnTelaDisco.setForeground(new java.awt.Color(255, 255, 255));
        btnTelaDisco.setText("Catálogo de Discos");
        btnTelaDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaDiscoActionPerformed(evt);
            }
        });

        Venderbtn.setBackground(new java.awt.Color(38, 42, 63));
        Venderbtn.setForeground(new java.awt.Color(255, 255, 255));
        Venderbtn.setText("Vender");
        Venderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VenderbtnActionPerformed(evt);
            }
        });

        btnTelaClientes.setBackground(new java.awt.Color(38, 42, 63));
        btnTelaClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnTelaClientes.setText("Lista de Clientes");
        btnTelaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelaClientesActionPerformed(evt);
            }
        });

        btnFornecedores.setBackground(new java.awt.Color(38, 42, 63));
        btnFornecedores.setForeground(new java.awt.Color(255, 255, 255));
        btnFornecedores.setText("Fornecedores");
        btnFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedoresActionPerformed(evt);
            }
        });

        BtnPedido.setBackground(new java.awt.Color(38, 42, 63));
        BtnPedido.setForeground(new java.awt.Color(255, 255, 255));
        BtnPedido.setText("Fazer Pedido de Disco");
        BtnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPedidoActionPerformed(evt);
            }
        });

        btnSair.setBackground(new java.awt.Color(63, 38, 38));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("La Discotheque");

        lblUsuario.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTelaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Venderbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTelaDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGap(218, 218, 218))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblUsuario)
                .addGap(28, 28, 28)
                .addComponent(btnTelaDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Venderbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTelaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTelaDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaDiscoActionPerformed
       new TelaListagemDisco().setVisible(true);
    }//GEN-LAST:event_btnTelaDiscoActionPerformed

    private void VenderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VenderbtnActionPerformed
        new TelaVendas().setVisible(true);
    }//GEN-LAST:event_VenderbtnActionPerformed

    private void btnTelaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelaClientesActionPerformed
        new TelaListagemCliente().setVisible(true);
    }//GEN-LAST:event_btnTelaClientesActionPerformed

    private void btnFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedoresActionPerformed
        new TelaListagemFornecedor(usuarioLogado).setVisible(true);
    }//GEN-LAST:event_btnFornecedoresActionPerformed

    private void BtnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPedidoActionPerformed
        new TelaPedidos().setVisible(true);
    }//GEN-LAST:event_BtnPedidoActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
if (resposta == JOptionPane.YES_OPTION) {
    this.dispose();
}

    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPedido;
    private javax.swing.JButton Venderbtn;
    private javax.swing.JButton btnFornecedores;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTelaClientes;
    private javax.swing.JButton btnTelaDisco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables

}