package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
		
	//Dados de acesso ao banco
    private static final String URL = "jdbc:mysql://localhost:3306/catalogo";
    private static final String username = "root";
    private static final String password = "root";
    
    public Connection obterConexao() {
        try {
            return DriverManager.getConnection(URL, username, password);            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void fecharConexao(Connection conexao) {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
        	e.getMessage();
        	e.printStackTrace();
        }
    }
}
