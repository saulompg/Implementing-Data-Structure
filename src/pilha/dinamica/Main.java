package pilha.dinamica;

import java.util.Scanner;

public class Main {
	
	// instanciando o objeto para a entrada de dados
	static Scanner sc = new Scanner(System.in);
	
	// Menu interativo
	static int menu() {
		
		System.out.printf("+-------------------------+\n");
		System.out.printf("+      PILHA DINÂMICA     +\n");
		System.out.printf("+-------------------------+\n");
		System.out.printf("| 1 - Inserir elemento    |\n");
		System.out.printf("| 2 - Remover elemento    |\n");
		System.out.printf("| 3 - Limpar pilha        |\n");
		System.out.printf("| 4 - Imprimir pilha      |\n");
		System.out.printf("| 0 - SAIR                |\n");
		System.out.printf("+-------------------------+\n");
		
		System.out.printf("Escolha uma opção: ");
		int answer = sc.nextInt();
		
		System.out.println();
		
		return answer;
		
	}

	// método principal
	public static void main(String[] args) {
		
		// Declara e Inicia as variáveis
		Pilha pilha = new Pilha();
		Object value;

		int exit = -1;		
		
		// Mantém o programam rodando em loop até que a opção 0 (SAIR) seja informada
		while(exit != 0) {
			
			exit = menu();
			
			switch(exit) {
			
				// finaliza o programa
				case 0:
					
					System.out.println("Finalizando o programa");
					break;
				
				// insere um elemento na pilha
				case 1:
					
					System.out.printf("Digite um valor: ");
					value = sc.nextInt();
					pilha.push(value);
					break;
					
				// remove um elemento da pilha
				case 2:
					
					Object element = pilha.pop();
					
					if(element != null)
						System.out.printf("Removendo --> [%s]\n", element.toString());
					else
						System.err.println("A pilha está vazia!");
					break;
					
				// limpa a pilha
				case 3:
					
					pilha.clear();
					break;
					
				// imprime os elementos da pilha
				case 4:
					
					pilha.print();
					break;
					
				// caso uma opção inválida seja digitada
				default:
					
					System.err.println("Opção inválida!");
					break;
			
			}
			
			System.out.println();
			
		}

		sc.close();
		
	}

}
