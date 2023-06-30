package pilha.estatica;

import java.util.Scanner;

public class Main {

	// instanciando o objeto para a entrada de dados
	static Scanner sc = new Scanner(System.in);
	
	// Menu interativo
	static int menu() {
		
		System.out.printf("+-------------------------+\n");
		System.out.printf("+      PILHA ESTÁTICA     +\n");
		System.out.printf("+-------------------------+\n");
		System.out.printf("| 1 - Inserir elemento    |\n");
		System.out.printf("| 2 - Remover elemento    |\n");
		System.out.printf("| 3 - Limpar pilha        |\n");
		System.out.printf("| 4 - Imprimir pilha      |\n");
		System.out.printf("| 0 - SAIR                |\n");
		System.out.printf("+-------------------------+\n");
		
		System.out.printf("Escolha uma opção: ");
		int answer = sc.nextInt();
		
		return answer;
		
	}

	// Método principal
	public static void main(String[] args) {
		
		// Declara e inicializa as variáveis
		int maxSize = 5;
		Pilha pilha = new Pilha(maxSize);
		Object value;
		int exit = -1;		
		
		// Mantém o programam rodando em loop até que a opção 0 (SAIR) seja informada
		while(exit != 0) {
			
			exit = menu();
			System.out.println();

			switch(exit) {
			
				// caso a opção 0 seja digitada, o laço é finalizado
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
						System.out.printf("O elemento [%s] foi removido da pilha\n", element.toString());
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
					
				// caso seja informada uma opção inválida
				default:
					
					System.err.println("Opção inválida!");
					break;
			
			}
			
			System.out.println();
			
		}

		sc.close();
		
	}

}
