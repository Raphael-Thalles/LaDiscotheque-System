/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Raphael
 */
public class ConexaoDAO {
    public static Connection conectaBD() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ladisco";
            String user = "root";
            String password = "Derpixon_96";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso! 🟢");

        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = conectaBD();

        if (conn != null) {
            System.out.println("✅ Conexão estabelecida com sucesso!");
        } else {
            System.out.println("❌ Falha ao conectar ao banco.");
        }
    }
}