package Telas;

import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import pi2.ClienteDAO;
import pi2.ClienteDTO;
import pi2.DiscoDAO;
import pi2.DiscoDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import pi2.VendaDAO;
import pi2.VendaDTO;
/**
 *
 * @author Raphael
 */
public class TelaVendas extends javax.swing.JFrame {

    public TelaVendas() {
        initComponents();

        // Substitui o modelo String antigo por um genérico vazio
        listadisco.setModel(new DiscoTableModel(new ArrayList<>()));
        listacliente.setModel(new ClienteTableModel(new ArrayList<>()));

        // Registra listeners
        btnFinalizarVenda.addActionListener(e -> finalizarVenda());
        pesquisardiscobtn.addActionListener(e -> buscarDiscos());
        pesquisarclientebtn.addActionListener(e -> buscarClientes());

        setLocationRelativeTo(null);
    }

    // ─────────────────────────────────────────────────────────────────
    // Métodos de ação

    private void finalizarVenda() {
        DiscoDTO disco     = getDiscoSelecionado();
        ClienteDTO cliente = getClienteSelecionado();
        if (disco == null || cliente == null) return;

        int quantidade = 1;
        BigDecimal valorTotal = disco.getPreco().multiply(new BigDecimal(quantidade));
        VendaDTO venda = new VendaDTO(0, disco, cliente, LocalDate.now(), quantidade, valorTotal);

        boolean okVenda   = new VendaDAO().salvarVenda(venda);
        boolean okEstoque = false;
        if (okVenda) {
            int novaQtd = disco.getEstoque() - quantidade;
            okEstoque = new DiscoDAO().atualizarEstoque(disco.getid(), novaQtd);
            disco.setEstoque(novaQtd);
            ((DiscoTableModel) listadisco.getModel())
                .fireTableRowsUpdated(listadisco.getSelectedRow(), listadisco.getSelectedRow());
        }

        if (okVenda && okEstoque) {
            JOptionPane.showMessageDialog(this, "Venda registrada e estoque atualizado!");
        } else if (okVenda) {
            JOptionPane.showMessageDialog(this, "Venda registrada, mas erro no estoque.");
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao registrar venda.");
        }
    }

    private void buscarDiscos() {
        String filtro = txtdisco.getText().trim();
        List<DiscoDTO> resultados = DiscoDAO.buscar(filtro);
        listadisco.setModel(new DiscoTableModel(resultados));
    }

    private void buscarClientes() {
        String filtro = txtBuscaCliente.getText().trim();
        List<ClienteDTO> resultados = new ClienteDAO().buscar(filtro);
        listacliente.setModel(new ClienteTableModel(resultados));
    }

    // ─────────────────────────────────────────────────────────────────
    // Métodos auxiliares

    private DiscoDTO getDiscoSelecionado() {
        int linhaSelecionada = listadisco.getSelectedRow();
        if (linhaSelecionada >= 0) {
            return ((DiscoTableModel) listadisco.getModel()).getDiscoAt(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um disco para realizar a venda.");
            return null;
        }
    }

    private ClienteDTO getClienteSelecionado() {
        int linhaSelecionada = listacliente.getSelectedRow();
        if (linhaSelecionada >= 0) {
            return ((ClienteTableModel) listacliente.getModel()).getClienteAt(linhaSelecionada);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um cliente para realizar a venda.");
            return null;
        }
    }

    // ─────────────────────────────────────────────────────────────────
    // TableModels

    public class ClienteTableModel extends AbstractTableModel {
        private final List<ClienteDTO> clientes;
        private final String[] colunas = {"ID", "Nome", "Email", "Telefone"};

        public ClienteTableModel(List<ClienteDTO> clientes) {
            this.clientes = clientes;
        }

        @Override
        public int getRowCount() {
            return clientes.size();
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public String getColumnName(int column) {
            return colunas[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            ClienteDTO c = clientes.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> c.getId();
                case 1 -> c.getNome();
                case 2 -> c.getEmail();
                case 3 -> c.getTelefone();
                default -> null;
            };
        }

        public ClienteDTO getClienteAt(int linha) {
            return clientes.get(linha);
        }
    }

    public class DiscoTableModel extends AbstractTableModel {
        private final List<DiscoDTO> discos;
        private final String[] colunas = {"ID", "Título", "Artista", "Preço", "Estoque"};

        public DiscoTableModel(List<DiscoDTO> discos) {
            this.discos = discos;
        }

        @Override
        public int getRowCount() {
            return discos.size();
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public String getColumnName(int column) {
            return colunas[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            DiscoDTO d = discos.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> d.getid();
                case 1 -> d.getTitulo();
                case 2 -> d.getArtista();
                case 3 -> d.getPreco();
                case 4 -> d.getEstoque();
                default -> null;
            };
        }

        public DiscoDTO getDiscoAt(int linha) {
            return discos.get(linha);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnFinalizarVenda = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnVoltar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadisco = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listacliente = new javax.swing.JTable();
        txtBuscaCliente = new javax.swing.JTextField();
        pesquisarclientebtn = new javax.swing.JToggleButton();
        pesquisardiscobtn = new javax.swing.JToggleButton();
        txtdisco = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Venda de Disco");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Pesquisar Cliente");

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cliente Não Cadastrado");

        btnFinalizarVenda.setBackground(new java.awt.Color(234, 200, 62));
        btnFinalizarVenda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFinalizarVenda.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarVenda.setText("Finalizar Venda");
        btnFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarVendaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Selecionar Disco");

        jButton2.setBackground(new java.awt.Color(38, 42, 63));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Ver Lista de Vendas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(35, 42, 111));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        listadisco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(listadisco);

        listacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(listacliente);

        txtBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaClienteActionPerformed(evt);
            }
        });

        pesquisarclientebtn.setText("Pesquisar");
        pesquisarclientebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarclientebtnActionPerformed(evt);
            }
        });

        pesquisardiscobtn.setText("Pesquisar");
        pesquisardiscobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisardiscobtnActionPerformed(evt);
            }
        });

        txtdisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiscoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addGap(8, 8, 8)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscaCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisarclientebtn))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(147, 147, 147))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdisco, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pesquisardiscobtn)))))
                        .addGap(59, 59, 59))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnFinalizarVenda)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscaCliente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(pesquisarclientebtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisardiscobtn)
                    .addComponent(txtdisco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnFinalizarVenda)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarVendaActionPerformed
    btnFinalizarVenda.addActionListener(e -> {
    // Pega os dados da interface (você adapta conforme seus componentes)
    DiscoDTO discoSelecionado = getDiscoSelecionado();       // método que pega o disco da tabela
    ClienteDTO clienteSelecionado = getClienteSelecionado(); // idem pro cliente
    LocalDate dataVenda = LocalDate.now();
    int quantidade = 1;
    BigDecimal valorTotal = discoSelecionado.getPreco();

    // Monta o DTO
    VendaDTO venda = new VendaDTO();
    venda.setDisco(discoSelecionado);
    venda.setCliente(clienteSelecionado);
    venda.setDataVenda(dataVenda);
    venda.setQuantidade(quantidade);
    venda.setValorTotal(valorTotal);

    // Salva no banco
    VendaDAO dao = new VendaDAO();
    boolean sucesso = dao.salvarVenda(venda);

    if (sucesso) {
        JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
        
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao registrar venda.");
    }
});

    }//GEN-LAST:event_btnFinalizarVendaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new TelaListagemVendas().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtdiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiscoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiscoActionPerformed

    private void pesquisardiscobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisardiscobtnActionPerformed
        pesquisardiscobtn.addActionListener(e -> {
    String filtro = txtdisco.getText().trim();
    List<DiscoDTO> resultados = DiscoDAO.buscar(filtro);
    DiscoTableModel modelo = new DiscoTableModel(resultados);
    listadisco.setModel(modelo);
});

    }//GEN-LAST:event_pesquisardiscobtnActionPerformed

    private void pesquisarclientebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarclientebtnActionPerformed
       pesquisarclientebtn.addActionListener(e -> {
    String filtro = txtBuscaCliente.getText().trim();
    ClienteDAO dao = new ClienteDAO();
    List<ClienteDTO> resultados = dao.buscar(filtro);
    ClienteTableModel modelo = new ClienteTableModel(resultados);
    listacliente.setModel(modelo);
});

    }//GEN-LAST:event_pesquisarclientebtnActionPerformed

    private void txtBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaClienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnFinalizarVenda;
    private javax.swing.JToggleButton btnVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listacliente;
    private javax.swing.JTable listadisco;
    private javax.swing.JToggleButton pesquisarclientebtn;
    private javax.swing.JToggleButton pesquisardiscobtn;
    private javax.swing.JTextField txtBuscaCliente;
    private javax.swing.JTextField txtdisco;
    // End of variables declaration//GEN-END:variables
}
