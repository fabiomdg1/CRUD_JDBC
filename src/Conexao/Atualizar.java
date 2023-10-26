package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Atualizar {
    Scanner scanner = new Scanner(System.in);
    ExibirUmFilme exibirUmFilme = new ExibirUmFilme();
    Filme filme = new Filme();

    private Connection connection;
    Conexao conexao = new Conexao();

    public void atualizar() {
        connection = conexao.obterConexao();
        int id;

        try {
            String sql = "UPDATE filmes SET nome = ?, genero = ?, diretor = ?, duracao = ? WHERE idfilme = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            System.out.println("Informe o ID do filme que deseja atualizar");
            id = scanner.nextInt();

            exibirUmFilme.exibirUnicoFilme(id);

            System.out.println("Digite o nome do filme: ");
            filme.setNome(scanner.nextLine());

            scanner.nextLine(); // Consuma a nova linha pendente

            System.out.println("Digite o gênero do filme: ");
            filme.setGenero(scanner.nextLine());

            System.out.println("Digite o nome do diretor: ");
            filme.setDiretor(scanner.nextLine());

            System.out.println("Digite a duração do filme: ");
            filme.setDuracao(scanner.nextLine());

            preparedStatement.setString(1, filme.getNome());
            preparedStatement.setString(2, filme.getGenero());
            preparedStatement.setString(3, filme.getDiretor());
            preparedStatement.setString(4, filme.getDuracao());
            preparedStatement.setInt(5, id);

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("*****************************************************");
                System.out.println("Filme atualizado com sucesso");
                System.out.println("*****************************************************");
            } else {
                System.out.println("*****************************************************");
                System.out.println("Nenhum registro encontrado para atualizar");
                System.out.println("*****************************************************");
            }

            preparedStatement.close();
            conexao.fecharConexao(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("*****************************************************");
            System.out.println("Erro ao atualizar filme");
            System.out.println("*****************************************************");
        }
    }
}
