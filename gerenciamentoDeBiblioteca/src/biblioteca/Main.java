package biblioteca;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		int opcao = -1;

		System.out.println("========================================");
		System.out.println(" 📚 S I S T E M A   B I B L I O T E C A");
		System.out.println("========================================");

		do {
			System.out.println("\n========================================");
			System.out.println("       M E N U   P R I N C I P A L      ");
			System.out.println("========================================");
			System.out.println("1 - 📖 Cadastrar Livro");
			System.out.println("2 - 📰 Cadastrar Revista");
			System.out.println("3 - 📋 Listar Acervo");
			System.out.println("4 - 🔍 Buscar Material por Título");
			System.out.println("5 - 🗑️ Deletar Material");
			System.out.println("6 - 🏷️ Buscar Livros por Gênero");
			System.out.println("0 - ❌ Sair");
			System.out.println("----------------------------------------");
			System.out.print("▶ Escolha uma opção: ");

			String entrada = sc.nextLine().trim();

			if (entrada.isBlank()) {
				continue;
			}

			try {
				opcao = Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.out.println("\n❌ Erro: Digite apenas o número da opção desejada.");
				opcao = -1;
				continue;
			}

			switch (opcao) {
				case 1:
					biblioteca.cadastrarLivro(sc);
					break;
					
				case 2:
					biblioteca.cadastrarRevista(sc);
					break;
					
				case 3:
				    biblioteca.listarAcervo();
				    break;
				    
				case 4:				   
				    biblioteca.buscarTodosPorTitulo(sc);
				    break;
				    
				case 5:
				    biblioteca.deletarMaterial(sc);
				    break;
					
				case 6:
					biblioteca.listarLivrosPorGenero(sc);
					break;
					
				case 0:
					System.out.println("\n========================================");
					System.out.println("👋 Encerrando o sistema. Até logo!");
					System.out.println("========================================");
					break;
					
				default:
					System.out.println("\n⚠️ Opção inválida! Escolha um número entre 0 e 6.");
			}

		} while (opcao != 0);

		sc.close();
	}
}