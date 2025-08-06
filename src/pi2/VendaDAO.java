package pi2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class VendaDAO {

    /**
     * Ralhael
     */
    public boolean salvarVenda(VendaDTO venda) {
        String sql = "INSERT INTO venda "
                   + "(id_disco, id_cliente, data_venda, quantidade, valor_total) "
                   + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoDAO.conectaBD();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, venda.getDisco().getid());
            stmt.setInt(2, venda.getCliente().getId());
            stmt.setDate(3, Date.valueOf(venda.getDataVenda()));
            stmt.setInt(4, venda.getQuantidade());
            stmt.setBigDecimal(5, venda.getValorTotal());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar venda: " + e.getMessage());
            return false;
        }
    }

  
    public List<VendaDTO> listarVendas() {
    List<VendaDTO> lista = new ArrayList<>();
    String sql = 
        "SELECT " +
        "  v.id             AS venda_id, " +
        "  v.data_venda     AS data_venda, " +
        "  v.quantidade     AS quantidade, " +
        "  v.valor_total    AS valor_total, " +
        "  c.nome           AS cliente_nome, " +
        "  d.id             AS disco_id, " +
        "  d.titulo         AS disco_titulo " +
        "FROM venda v " +
        "JOIN cliente c ON v.id_cliente = c.id " +
        "JOIN disco   d ON v.id_disco   = d.id " +
        "ORDER BY v.data_venda DESC";

    try (Connection conn = ConexaoDAO.conectaBD();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            // Cria e popula o ClienteDTO
            ClienteDTO cliente = new ClienteDTO();
            cliente.setId   (rs.getInt   ("id_cliente"));
            cliente.setNome (rs.getString("cliente_nome"));

            // Cria e popula o DiscoDTO via construtor vazio + setters
            DiscoDTO disco = new DiscoDTO();
            disco.setid        (rs.getInt       ("disco_id"));
            disco.setTitulo    (rs.getString    ("disco_titulo"));
            disco.setArtista   (rs.getString    ("disco_artista"));
            disco.setGenero    (rs.getString    ("disco_genero"));
            disco.setDuracao   (rs.getInt       ("disco_duracao"));
            disco.setLancamento(rs.getInt       ("disco_lancamento"));
            disco.setPreco     (rs.getBigDecimal("disco_preco"));
            disco.setEstoque   (rs.getInt       ("disco_estoque"));

            // Cria e popula o VendaDTO
            VendaDTO venda = new VendaDTO();
            venda.setId        (rs.getInt       ("venda_id"));
            venda.setCliente   (cliente);
            venda.setDisco     (disco);
            venda.setDataVenda (rs.getDate("data_venda").toLocalDate());
            venda.setQuantidade(rs.getInt       ("quantidade"));
            venda.setValorTotal(rs.getBigDecimal("valor_total"));

            lista.add(venda);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao listar vendas: " + e.getMessage());
    }

    return lista;
}

}
