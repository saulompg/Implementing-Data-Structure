package lista.dinamica;

import java.util.Scanner;

public class Main {
	
	// instanciando o objeto para a entrada de dados
	static Scanner sc = new Scanner(System.in);
	
	// menu interativo
	static int screen (){

		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("+             LISTA DINÂMICA              +\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 1 - Inserir elemento no INÍCIO          |\n");
		System.out.printf("| 2 - Inserir elemento no FIM             |\n");
		System.out.printf("| 3 - Remover elemento do INÍCIO          |\n");
		System.out.printf("| 4 - Remover elemento do FIM             |\n");
		System.out.printf("| 5 - Imprimir lista                      |\n");
		System.out.printf("| 6 - Imprimir lista em ordem inversa     |\n");
		System.out.printf("| 7 - Localizar elemento na lista         |\n");
		System.out.printf("| 8 - Ordenar por inserção                |\n");
		System.out.printf("| 9 - Ordenar por seleção                 |\n");
		System.out.printf("| 0 - SAIR                                |\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("Escolha uma opção: ");
		
		int answer = sc.nextInt();
		return answer;
		
	}

	// método principal
	public static void main(String[] args) {
		
		Lista list = new Lista();
		Object element;
		
		int exit = -1;
		
		while(exit != 0) {
			
			exit = screen();
			System.out.println("--");
			
			switch(exit) {
			
				case 1:
					
					System.out.println("Inserir elemento no inicio da lista");
					System.out.printf("Digite um valor: ");
					element = sc.nextInt();
					list.add(element);
					break;
					
				case 2:
					
					System.out.println("Inserir elemento no final da lista");
					System.out.printf("Digite um valor: ");
					element = sc.nextInt();
					list.push(element);
					break;

				case 3:
					
					element = list.remove();
					
					if(element != null)
						System.out.printf("O elemento %s foi removido da Lista", element.toString());
					else
						System.err.println("A lista está vazia!");		
					break;

				case 4:
					
					element = list.pop();
					
					if(element != null)
						System.out.printf("O elemento %s foi removido da Lista", element.toString());		
					else			
						System.err.println("A lista está vazia!");					
					break;
					
				case 5:
					
					list.print();
					break;
					
				case 6:
				
					list.printReverseList();				
					break;
					
				case 7:
					
					System.out.println("Pesquisar por um elemento");
					System.out.printf("Digite um valor: ");
					element = sc.nextInt();
					list.search(element);				
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
		
		sc.close();
		
	}

}
