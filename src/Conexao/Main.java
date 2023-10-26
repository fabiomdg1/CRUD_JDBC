package Conexao;

import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int escolha = 0;
		Inserir inserir = new Inserir();
		Exibir exibir = new Exibir();
		ExibirUmFilme exibirUmFilme = new ExibirUmFilme();
		Deletar deletar = new Deletar();
		Atualizar atualizar = new Atualizar();
		Filme filme = new Filme();
		
		
		while(true){
			System.out.println("Digite a opção desejadas: ");
			System.out.println("1 - Inseri filme");
			System.out.println("2 - Deletar filme");
			System.out.println("3 - Atualizar filme");
			System.out.println("4 - Exibir todos os filmes");
			System.out.println("5 - Exibir um filme");
			
			escolha = scanner.nextInt();
			
			switch(escolha){
			case 1:			
				inserir.adicionarFilme(filme);
				break;
				
			case 2:
				deletar.deletarFilme();
				break;
				
			case 3:
				atualizar.atualizar();
				break;
				
			case 4:
				exibir.exibirTodosFilmes();
				break;
				
			case 5:
				exibirUmFilme.exibirUnicoFilme();
				break;
			}
		}
	}
}
