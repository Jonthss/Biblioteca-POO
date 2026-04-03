package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
	
	private List<Material> acervo = new ArrayList<>();
	
	
	// METODOS DE CADASTRAR
	
	public void cadastrarLivro(Scanner sc) {
		System.out.println("\n========================================");
		System.out.println("   C A D A S T R O   D E   L I V R O   ");
		System.out.println("========================================");
		
		String tituloDoLivroAdd;
	    do {
	    	System.out.print("\n▶ Favor informar Titulo do Livro: ");
	        tituloDoLivroAdd = sc.nextLine().trim();
	        if (tituloDoLivroAdd.isBlank()) {
	            System.out.println("❌ O título não pode ser vazio!");
	        }
	    } while (tituloDoLivroAdd.isBlank());
		
	    String autorDoLivroAdd;
	    do {
	    	System.out.print("\n▶ Favor informar Autor do Livro: ");
			autorDoLivroAdd = sc.nextLine().trim();
			if (autorDoLivroAdd.isBlank()) {
	            System.out.println("❌ O autor não pode ser vazio!");
	        }
	    } while (autorDoLivroAdd.isBlank());
	    
	    System.out.println("\n----------------------------------------");
	    System.out.println("📚 Categorias Disponíveis:");
	    System.out.println("----------------------------------------");
	    
		Genero[] generos = Genero.values();
		for (int i = 0; i < generos.length; i++) {
			System.out.println((i + 1) + " - " + generos[i]);
		}
		
		int opcao = -1;
		boolean entradaValida = false;

		do {
		    System.out.print("\n▶ Digite o número do Gênero: ");
		    String entrada = sc.nextLine().trim();

		    if (entrada.isBlank()) {
		        System.out.println("⚠️ Erro: Você não digitou nada. Tente novamente.");
		        continue;
		    }

		    try {
		        opcao = Integer.parseInt(entrada);
		        
		        if (opcao < 1 || opcao > generos.length) {
		            System.out.println("⚠️ Opção inválida! Favor digite um número de 1 a " + generos.length + ".");
		        } else {
		            entradaValida = true;
		        }
		    } catch (NumberFormatException e) {
		        System.out.println("❌ Erro: Por favor, digite apenas NÚMEROS, não letras.");
		    }
		} while (!entradaValida);
		
		Genero generoEscolhido = generos[opcao - 1];
				
		Livro novoLivro = new Livro(tituloDoLivroAdd, autorDoLivroAdd, generoEscolhido);
		acervo.add(novoLivro);
		
		System.out.println("\n========================================");
		System.out.println("✅ SUCESSO: Livro '" + tituloDoLivroAdd + "' adicionado!");
		System.out.println("========================================\n");
	}
	
	public void cadastrarRevista(Scanner sc) {
		System.out.println("\n========================================");
		System.out.println("  C A D A S T R O   D E   R E V I S T A ");
		System.out.println("========================================");
		
		String tituloDaRevistaAdd;
		do {
			System.out.print("\n▶ Favor informar Titulo da Revista: ");
			tituloDaRevistaAdd = sc.nextLine().trim();
			if (tituloDaRevistaAdd.isBlank()) {
				System.out.println("❌ O título não pode ser vazio!");
			}
		} while (tituloDaRevistaAdd.isBlank());
		
		String autorDaRevistaAdd;
		do {
			System.out.print("\n▶ Favor informar Autor da Revista: ");
			autorDaRevistaAdd = sc.nextLine().trim();
			if (autorDaRevistaAdd.isBlank()) {
				System.out.println("❌ O autor não pode ser vazio!");
			}
		} while (autorDaRevistaAdd.isBlank());
		
		int numeroDaRevistaAdd = -1;
		boolean entradaValida = false;
		
		do {
			System.out.print("\n▶ Favor digite o número da Edição: ");
			String entrada = sc.nextLine().trim();
			
			if (entrada.isBlank()) {
		        System.out.println("⚠️ Erro: Você não digitou nada. Tente novamente.");
		        continue;
		    }
			
			try {
				numeroDaRevistaAdd = Integer.parseInt(entrada);
				if (numeroDaRevistaAdd <= 0) {
					System.out.println("⚠️ O número da edição deve ser maior que zero!");
				} else {
					entradaValida = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("❌ Erro: Por favor, digite apenas NÚMEROS, não letras.");
			}
		} while (!entradaValida);
		
		Revista novaRevista = new Revista(tituloDaRevistaAdd, autorDaRevistaAdd, numeroDaRevistaAdd);
		acervo.add(novaRevista);
		
		System.out.println("\n========================================");
		System.out.println("✅ SUCESSO: Revista '" + tituloDaRevistaAdd + "' adicionada!");
		System.out.println("========================================\n");
	}
	
	// METODOS DELETAR E BUSCAR
	
	public void deletarMaterial(Scanner sc) {
		System.out.println("\n========================================");
		System.out.println(" E X C L U S Ã O   D E   M A T E R I A L ");
		System.out.println("========================================");
		
		Material materialParaDeletar = buscarMaterialPorTitulo(sc);
		
		if (materialParaDeletar != null) {
			System.out.print("\n▶ Deseja realmente deletar '" + materialParaDeletar.getTitulo() + "'? (Sim/Não): ");
			String confirmacaoDelet = sc.nextLine().trim();
			
			if(confirmacaoDelet.equalsIgnoreCase("sim")) {
				acervo.remove(materialParaDeletar);
				System.out.println("\n========================================");
				System.out.println("🗑️ SUCESSO: Título deletado com sucesso!");
				System.out.println("========================================\n");
			} else {
				System.out.println("\n⚠️ Operação cancelada. O Título não foi deletado.");
			}
		} else {
			System.out.println("\n❌ Operação cancelada. O Título não foi encontrado.");
		}
	}
	
	
	public Material buscarMaterialPorTitulo(Scanner sc) { 
	    if (acervo.isEmpty()) {
	        System.out.println("\n📭 O acervo está vazio no momento.");
	        return null; 
	    } 
	    
	    System.out.print("\n▶ Favor informar o Título exato que deseja deletar: ");
	    String tituloProcurado = sc.nextLine().trim();

	    for (Material m : acervo) {
	        if (m.getTitulo().equalsIgnoreCase(tituloProcurado)) {
	            return m; 
	        }
	    }
	    
	    return null; 
	}
	
	public void buscarTodosPorTitulo(Scanner sc) {
	    if (acervo.isEmpty()) {
	        System.out.println("\n📭 O acervo está vazio no momento.");
	        return; 
	    }
	    
	    System.out.println("\n========================================");
	    System.out.println("      B U S C A R   M A T E R I A L     ");
	    System.out.println("========================================");
	    System.out.print("▶ Favor informar o Título que deseja buscar: ");
	    String tituloProcurado = sc.nextLine().trim();

	    System.out.println("\n========================================");
	    System.out.println("     🔍 R E S U L T A D O S   ");
	    System.out.println("========================================");

	    boolean encontrouAlgum = false;

	    
	    for (Material m : acervo) {
	        if (m.getTitulo().equalsIgnoreCase(tituloProcurado)) {
	            System.out.println(m); 
	            encontrouAlgum = true;
	        }
	    }
	    
	    if (!encontrouAlgum) {
	        System.out.println("❌ Nenhum título encontrado com o nome: " + tituloProcurado);
	    }
	    
	    System.out.println("========================================\n");
	}
	
	public void listarLivrosPorGenero(Scanner sc) { 
	    if (acervo.isEmpty()) {
	        System.out.println("\n📭 O acervo está vazio no momento.");
	        return;
	    } 
	        
	    System.out.println("\n----------------------------------------");
	    System.out.println("📚 Categorias Disponíveis:");
	    System.out.println("----------------------------------------");
	    
	    Genero[] generos = Genero.values();
	    for (int i = 0; i < generos.length; i++) {
	        System.out.println((i + 1) + " - " + generos[i]);
	    }
	    
	    int opcao = -1;
	    boolean entradaValida = false;

	    do {
	        System.out.print("\n▶ Digite o número do Gênero: ");
	        String entrada = sc.nextLine().trim();

	        if (entrada.isBlank()) {
	            System.out.println("⚠️ Erro: Você não digitou nada. Tente novamente.");
	            continue;
	        }

	        try {
	            opcao = Integer.parseInt(entrada);
	            
	            if (opcao < 1 || opcao > generos.length) {
	                System.out.println("⚠️ Opção inválida! Favor digite um número de 1 a " + generos.length + ".");
	            } else {
	                entradaValida = true;
	            }
	        } catch (NumberFormatException e) {
	            System.out.println("❌ Erro: Por favor, digite apenas NÚMEROS, não letras.");
	        }
	    } while (!entradaValida);
	    
	    Genero generoEscolhido = generos[opcao - 1];

	    // ==========================================
	    // A MÁGICA DA BUSCA ACONTECE AQUI
	    // ==========================================
	    
	    System.out.println("\n========================================");
	    System.out.println("  🔍 RESULTADOS PARA A BUSCA: " + generoEscolhido.toString().toUpperCase());
	    System.out.println("========================================");
	    
	    boolean encontrouAlgum = false;

	    for (Material m : acervo) {
	        
	        if (m instanceof Livro) {
	            
	            Livro livroAtual = (Livro) m; 
	            
	            if (livroAtual.getGenero() == generoEscolhido) {
	                System.out.println(livroAtual); 
	                encontrouAlgum = true;
	            }
	        }
	    }
	    
	    if (!encontrouAlgum) {
	        System.out.println("❌ Nenhum livro encontrado para esta categoria.");
	    }
	    
	    System.out.println("========================================\n");
	}
	
	// METODOS LISTAR
	
	public void listarAcervo() {
		if (acervo.isEmpty()) {
			System.out.println("\n📭 No momento nosso acervo está vazio.");
		} else {
			System.out.println("\n========================================");
			System.out.println("       L I S T A   D O   A C E R V O     ");
			System.out.println("========================================");
			for (Material m : acervo) {
				System.out.println(m); 
			}
			System.out.println("========================================\n");
		}
	}
}