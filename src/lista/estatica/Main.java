package lista.estatica;

import java.util.Scanner;

public class Main {

	// instanciando o objeto para a entrada de dados
	static Scanner sc = new Scanner(System.in);
	
	static int screen() {
		
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("+             LISTA ESTÁTICA              +\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 1 - Inserir elemento no INÍCIO          |\n");
		System.out.printf("| 2 - Inserir elemento no FIM             |\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 3 - Remover elemento do INÍCIO          |\n");
		System.out.printf("| 4 - Remover elemento do FIM             |\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 5 - Imprimir lista                      |\n");
		System.out.printf("| 6 - Imprimir lista em ordem inversa     |\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 7 - Localizar elemento na lista         |\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 8 - Ordenar por inserção                |\n");
		System.out.printf("| 9 - Ordenar por seleção                 |\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 0 - SAIR                                |\n");
		System.out.printf("+-----------------------------------------+\n");
		
		System.out.printf("Escolha uma opção: ");
		int answer = sc.nextInt();
		
		System.out.println();
		
		return answer;
		
	}

	public static void main(String[] args) {
		
		// variáveis
		final int fullSize = 5;
		Lista list = new Lista(fullSize);
		int value;
		
		int exit = -1;
		
		// executa o programa enquanto a opção 0 não é selecionada no menu
		while(exit != 0) {
			
			exit = screen();
			System.out.println("--");
			
			switch(exit) {
			
				// finaliza o programa
				case 0:
					
					System.out.println("Finalizando o programa\n");
					break;
				
				// insere um elemento no inicio da lista
				case 1:
					
					System.out.println("Inserindo elemento no inicio da lista");
					System.out.printf("Digite um valor: ");
					value = sc.nextInt();
					list.add(value);
					break;
					
				// insere um elemento no final da lista
				case 2:
					
					System.out.println("Inserindo elemento no final da lista");
					System.out.printf("Digite um valor: ");
					value = sc.nextInt();
					list.push(value);
					break;
					
				// remove um elemento no inicio da lista
				case 3:
					
					System.out.println("Removendo elemento da primeira posição");
					list.remove();
					break;
					
				// remove um elemento no final da lista
				case 4:
					
					System.out.println("Removendo elemento da última posição");
					list.pop();
					break;
					
				// imprime os elementos da lista
				case 5:
					
					System.out.println("Imprimindo os elementos da lista");
					list.print();
					break;

				// imprime os elementos em ordem inversa
				case 6:
					
					System.out.println("Imprimindo lista em ordem inversa");
					list.printReverseList();
					break;
					
				// pesquisa por um elemento na lista
				case 7:
					
					System.out.println("Pesquisar por um elemento");
					System.out.printf("Digite um valor: ");
					value = sc.nextInt();
					list.search(value);
					break;
					
				// ordena os elementos pelo método da inserção
				case 8:
					
					System.out.println("Ordenando lista pelo método da inserção");
					list.sortInsertion();
					break;
					
				// ordena os elementos pelo método da seleção
				case 9:
					
					System.out.println("Ordenando lista pelo método da seleção");
					list.sortSelection();
					break;
				
				// caso seja selecionada uma opção inválida
				default:
					
					System.out.println("Opção inválida!");
					break;
			
			}
			
			System.out.println();
			
		}
		
		sc.close();
		
	}

}
