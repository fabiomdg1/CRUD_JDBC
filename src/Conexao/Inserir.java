package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inserir {
	private Connection connection;
	Conexao conexao = new Conexao();
	
	public void adicionarFilme(Filme filme) {
    	connection = conexao.obterConexao();
    	    try {

    	        String sql = "INSERT INTO filmes (nome, genero,diretor, duracao) VALUES (?, ?, ?, ?)";
    	        //System.out.println(sql);
    	        
    	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	        
    	        preparedStatement.setString(1, filme.getNome());
    	        preparedStatement.setString(2, filme.getGenero());
    	        preparedStatement.setString(3, filme.getDiretor());
    	        preparedStatement.setString(4, filme.getDuracao());
    	        
    	        int rowsAffected = preparedStatement.executeUpdate();
    	        
    	        if (rowsAffected > 0) {
    	            System.out.println("Filme cadastrado com sucesso.");
    	        } else {
    	            System.out.println("Falha ao adicionar filme.");
    	        }
    	        	    	        
    	        preparedStatement.close();
    	        conexao.fecharConexao(connection);
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        System.out.println("Erro ao inserir filme");	    	        
    	    }
    	    
	}

}
