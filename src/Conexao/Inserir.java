package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Inserir {
	Scanner scanner = new Scanner(System.in);
	private Connection connection;
	Conexao conexao = new Conexao();
	
	public void adicionarFilme(Filme filme) {
    	connection = conexao.obterConexao();
    	    try {
    	    	
    	    	System.out.println("Digite o nome do filme: ");
				filme.setNome(scanner.nextLine());
				
				System.out.println("Digite o gênero do filme: ");
				filme.setGenero(scanner.nextLine());
				
				System.out.println("Digite o nome do diretor: ");
				filme.setDiretor(scanner.nextLine());
			
				System.out.println("Digite a duração do filme: ");
				filme.setDuracao(scanner.nextLine());

    	        String sql = "INSERT INTO filmes (nome, genero,diretor, duracao) VALUES (?, ?, ?, ?)";
    	        //System.out.println(sql);
    	        
    	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	        
    	        preparedStatement.setString(1, filme.getNome());
    	        preparedStatement.setString(2, filme.getGenero());
    	        preparedStatement.setString(3, filme.getDiretor());
    	        preparedStatement.setString(4, filme.getDuracao());
    	        
    	        int linhasAfetadas = preparedStatement.executeUpdate();
    	        
    	        if (linhasAfetadas > 0) {
    	        	System.out.println("*****************************************************");
    	            System.out.println("Filme cadastrado com sucesso!");
    	            System.out.println("*****************************************************");
    	        } else {
    	        	System.out.println("*****************************************************");
    	            System.out.println("Falha ao adicionar filme!");
    	            System.out.println("*****************************************************");
    	        }
    	        	    	        
    	        preparedStatement.close();
    	        conexao.fecharConexao(connection);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        System.out.println("Erro ao inserir filme");	    	        
    	    }
    	    
	}

}
