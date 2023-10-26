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
            String sql = "SELECT * FROM catalogo.filmes;";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("*****************************************************");
            System.out.println("******************Lista de Filmes********************");
            System.out.println("*****************************************************");
            
            if(resultSet.next()){
            	do  {
                	int idfilme = resultSet.getInt("idfilme");            
                    String nome = resultSet.getString("nome");
                    String genero = resultSet.getString("genero");
                    String diretor = resultSet.getString("diretor");
                    String duracao = resultSet.getString("duracao");
                    System.out.println("ID: " + idfilme + "\nTítulo: " + nome + "\nGênero: " + genero + "\nDiretor: " + diretor + "\nDuração: " + duracao);
                    System.out.println("*****************************************************");
                }
                while (resultSet.next());
            } else {
            	System.out.println("*****************************************************");
                System.out.println("Não há filmes cadastrados!");
                System.out.println("*****************************************************");
            	
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("*****************************************************");
            System.out.println("Erro ao exibir filmes");
            System.out.println("*****************************************************");

        } 
            conexao.fecharConexao(connection);
        
    }
}
