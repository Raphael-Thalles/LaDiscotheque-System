
package pi2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Raphael
 */

public class DiscoDAO {
    private Connection conn;

    public DiscoDAO() {
        ConexaoDAO conexao = new ConexaoDAO();
        this.conn = conexao.conectaBD();
    }

    public List<DiscoDTO> listarDisco() {
        List<DiscoDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM disco";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs       = stmt.executeQuery()) {

            while (rs.next()) {
                DiscoDTO disco = new DiscoDTO(
                    rs.getInt("id"),
                    rs.getString("Titulo"),
                    rs.getString("Artista"),
                    rs.getString("Genero"),
                    rs.getInt("Duracao"),
                    rs.getInt("Lancamento"),
                    rs.getBigDecimal("Preco"),
                    rs.getInt("Estoque")
                );
                lista.add(disco);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar discos: " + e.getMessage());
        }

        return lista;
    }

    public boolean cadastrarDisco(DiscoDTO disco) {
        String sql = "INSERT INTO disco (Titulo, Artista, Genero, Duracao, Lancamento, Preco, Estoque) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, disco.getTitulo());
            stmt.setString(2, disco.getArtista());
            stmt.setString(3, disco.getGenero());
            stmt.setInt(4, disco.getDuracao());
            stmt.setInt(5, disco.getLancamento());
            stmt.setBigDecimal(6, disco.getPreco());
            stmt.setInt(7, disco.getEstoque());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar disco: " + e.getMessage());
            return false;
        }
    }

    public static List<DiscoDTO> buscar(String filtro) {
        List<DiscoDTO> lista = new ArrayList<>();
        String sql = "SELECT id, Titulo, Artista, Preco, Estoque "
                   + "FROM disco WHERE Titulo LIKE ? OR Artista LIKE ?";

        try (Connection conn        = new ConexaoDAO().conectaBD();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String termo = "%" + filtro + "%";
            stmt.setString(1, termo);
            stmt.setString(2, termo);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new DiscoDTO(
                        rs.getInt("id"),
                        rs.getString("Titulo"),
                        rs.getString("Artista"),
                        null,    // Genero não vem
                        0,       // Duracao não vem
                        0,       // Lancamento não vem
                        rs.getBigDecimal("Preco"),
                        rs.getInt("Estoque")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar discos: " + e.getMessage());
        }

        return lista;
    }

    public boolean atualizarEstoque(int idDisco, int novaQuantidade) {
        String sql = "UPDATE disco SET estoque = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, novaQuantidade);
            ps.setInt(2, idDisco);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
            return false;
        }
    }
}
