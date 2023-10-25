package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Exibir {

    private Connection connection;
    Conexao conexao = new Conexao();

    public void exibirTodosFilmes() {
        connection = conexao.obterConexao();

        try {
            String sql = "SELECT * FROM filmes";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {

                int idfilme = resultSet.getInt("idfilme");            
                String nome = resultSet.getString("nome");
                String genero = resultSet.getString("genero");
                String diretor = resultSet.getString("diretor");
                String duracao = resultSet.getString("duracao");
                

                // Agora você pode fazer o que quiser com os dados, como exibi-los
                System.out.println("ID: " + idfilme + "| Título: " + nome + " | Gênero: " + genero + " | Diretor: " + diretor + " | Duração: " + duracao);
                // Adicione mais colunas conforme necessário
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao exibir filmes");
        } 
            conexao.fecharConexao(connection);
        
    }
}
