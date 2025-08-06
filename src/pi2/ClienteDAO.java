
package pi2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Raphael
 */

public class ClienteDAO {
    
    // Método para cadastrar cliente
    public void cadastrarCliente(ClienteDTO cliente) {
        try {
            Connection conn = new ConexaoDAO().conectaBD();
            String sql = "INSERT INTO cliente (Nome, Email, Telefone) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // Método para listar todos os clientes
    public ArrayList<ClienteDTO> listarClientes() {
        ArrayList<ClienteDTO> lista = new ArrayList<>();
        try {
            Connection conn = new ConexaoDAO().conectaBD();
            String sql = "SELECT * FROM cliente";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO(
                    rs.getInt("Id"),
                    rs.getString("Nome"),
                    rs.getString("Email"),
                    rs.getString("Telefone")
                );
                lista.add(cliente);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    // Método para atualizar dados do cliente
    public void atualizarCliente(ClienteDTO cliente) {
        try {
            Connection conn = new ConexaoDAO().conectaBD();
            String sql = "UPDATE cliente SET Nome = ?, Email = ?, Telefone = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getTelefone());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }
    
    public List<ClienteDTO> buscar(String filtro) {
    List<ClienteDTO> lista = new ArrayList<>();

    String sql = "SELECT id, nome, email, telefone FROM cliente WHERE nome LIKE ? OR email LIKE ?";

    try (Connection conn = ConexaoDAO.conectaBD();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        String termoBusca = "%" + filtro + "%";
        stmt.setString(1, termoBusca);
        stmt.setString(2, termoBusca);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            ClienteDTO c = new ClienteDTO(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("telefone")
            );
            lista.add(c);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao buscar clientes: " + e.getMessage());
    }

    return lista;
}

}
