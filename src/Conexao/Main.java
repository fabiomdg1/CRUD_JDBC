package Conexao;

import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Inserir inserir = new Inserir();
		Exibir exibir = new Exibir();
		Filme filme = new Filme();
		
//		System.out.println("Digite o nome do filme: ");
//		filme.setNome(scanner.nextLine());
//		System.out.println("Digite o gênero do filme: ");
//		filme.setGenero(scanner.nextLine());
//		System.out.println("Digite o nome do diretor: ");
//		filme.setDiretor(scanner.nextLine());
//		System.out.println("Digite a duração do filme: ");
//		filme.setDuracao(scanner.nextLine());
		
		//inserir.adicionarFilme(filme);
		
		exibir.exibirTodosFilmes();
		
		
	}
}
