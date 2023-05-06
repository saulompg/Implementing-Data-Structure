package lista.estatica;

import java.util.Scanner;

public class Main {
	
	static int screen() {

		Scanner ler = new Scanner(System.in);
		
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
		int answer = ler.nextInt();
		
		System.out.println();
		
		return answer;
		
	}

	public static void main(String[] args) {
		
		final int fullSize = 5;
		
		int value;
		
		int exit = -1;
		
		Lista list = new Lista(fullSize);
		
		Scanner ler = new Scanner(System.in);
		
		while(exit != 0) {
			
			exit = screen();
			System.out.println("--");
			
			switch(exit) {
			
				case 1:
					
					System.out.println("Inserindo elemento no inicio da lista");
					System.out.printf("Digite um valor: ");
					value = ler.nextInt();
					list.add(value);
					
					break;
					
				case 2:
					
					System.out.println("Inserindo elemento no final da lista");
					System.out.printf("Digite um valor: ");
					value = ler.nextInt();
					list.push(value);
					
					break;
					
				case 3:
					
					System.out.println("Removendo elemento da primeira posição");
					list.remove();
					
					break;
					
				case 4:
					
					System.out.println("Removendo elemento da última posição");
					list.pop();
					
					break;
					
				case 5:
					
					System.out.println("Imprimindo os elementos da lista");
					list.print();
					
					break;

				case 6:
					
					System.out.println("Imprimindo lista em ordem inversa");
					list.printReverseList();
					
					break;
					
				case 7:
					
					System.out.println("Pesquisar por um elemento");
					System.out.printf("Digite um valor: ");
					value = ler.nextInt();
					list.search(value);
					
					break;
					
				case 8:
					
					System.out.println("Ordenando lista pelo método da inserção");
					list.sortInsertion();
					
					break;
					
				case 9:
					
					System.out.println("Ordenando lista pelo método da seleção");
					list.sortSelection();
					
					break;
					
				case 0:
					
					System.out.println("Finalizando o programa\n");
					
					break;
					
				default:
					
					System.out.println("Opção inválida!");
					
					break;
			
			}
			
			System.out.println();
			
		}
		
		ler.close();
		
	}

}
