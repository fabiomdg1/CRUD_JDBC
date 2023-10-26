package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Deletar {
	Scanner scanner = new Scanner(System.in);
	private Connection connection;
	Conexao conexao = new Conexao();
	
	public void deletarFilme(){
		
		connection = conexao.obterConexao();
		
		try{
			String sql = "DELETE FROM filmes WHERE idfilme = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			System.out.println("Digite o Id do filme que deseja excluir: ");
			int id = scanner.nextInt();

			preparedStatement.setInt(1, id);
			
			int linhasAfetadas = preparedStatement.executeUpdate();
			
			if(linhasAfetadas > 0){
	            System.out.println("*****************************************************");
				System.out.println("Filme deletado com sucesso!");
	            System.out.println("*****************************************************");

			} else {
	            System.out.println("*****************************************************");
				System.out.println("Filme não encontrado para exclusão!");
	            System.out.println("*****************************************************");

			}
			
			preparedStatement.close();
			conexao.fecharConexao(connection);
			
		}catch(SQLException e){
			e.printStackTrace();
            System.out.println("*****************************************************");
			System.out.println("Erro ao excluir filme");
            System.out.println("*****************************************************");

		}
	}
}
