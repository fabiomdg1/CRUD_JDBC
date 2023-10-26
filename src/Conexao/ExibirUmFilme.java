package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExibirUmFilme {
	Scanner scanner = new Scanner(System.in);
	private Connection connection;
	Conexao conexao = new Conexao();
	
	public void exibirUnicoFilme(int id){
		
		connection = conexao.obterConexao();
		try{
			
			String sql = "SELECT * FROM filmes WHERE idfilme = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next() ){
				int idfilme = resultSet.getInt("idfilme");            
	            String nome = resultSet.getString("nome");
	            String genero = resultSet.getString("genero");
	            String diretor = resultSet.getString("diretor");
	            String duracao = resultSet.getString("duracao");
	            System.out.println("ID: " + idfilme + "\nTítulo: " + nome + "\nGênero: " + genero + "\nDiretor: " + diretor + "\nDuração: " + duracao);
	            System.out.println("*****************************************************");
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erro ao exibir um filme!");
		}
		conexao.fecharConexao(connection);	
	}
	
	public void exibirUnicoFilme(){
		
		connection = conexao.obterConexao();
		try{
			
			String sql = "SELECT * FROM filmes WHERE idfilme = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println("Digite o Id do filme que deseja exibir: ");
			int id = scanner.nextInt();

			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next() ){
				int idfilme = resultSet.getInt("idfilme");            
	            String nome = resultSet.getString("nome");
	            String genero = resultSet.getString("genero");
	            String diretor = resultSet.getString("diretor");
	            String duracao = resultSet.getString("duracao");
	            System.out.println("ID: " + idfilme + "\nTítulo: " + nome + "\nGênero: " + genero + "\nDiretor: " + diretor + "\nDuração: " + duracao);
	            System.out.println("*****************************************************");
			}
		}catch(SQLException e){
			e.printStackTrace();
            System.out.println("*****************************************************");
			System.out.println("Erro ao exibir um filme!");
            System.out.println("*****************************************************");
		}
			
		conexao.fecharConexao(connection);	

	}


}
