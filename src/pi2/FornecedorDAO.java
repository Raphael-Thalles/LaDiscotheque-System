/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi2;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pixtoladelego
 */
public class FornecedorDAO {

    public ArrayList<FornecedorDTO> listarFornecedores() {
        ArrayList<FornecedorDTO> lista = new ArrayList<>();

        try {
            Connection conn = new ConexaoDAO().conectaBD();
            String sql = "SELECT * FROM fornecedores"; // ajuste o nome da tabela se for diferente
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FornecedorDTO fornecedor = new FornecedorDTO(
                    rs.getInt("id"),
                    rs.getString("nome_Fornecedor"),
                    rs.getString("contato"),
                    rs.getString("cnpj")
                );
                lista.add(fornecedor);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar fornecedores: " + e.getMessage());
        }

        return lista;
    }
    
    public void cadastrarFornecedor(FornecedorDTO fornecedor) {
    try {
        Connection conn = new ConexaoDAO().conectaBD();
        String sql = "INSERT INTO fornecedores (nome_fornecedor, contato, cnpj) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, fornecedor.getNome_Fornecedor());
        stmt.setString(2, fornecedor.getContato());
        stmt.setString(3, fornecedor.getCnpj());

        stmt.executeUpdate();
        conn.close();
    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar fornecedor: " + e.getMessage());
        e.printStackTrace();
    }
}

}