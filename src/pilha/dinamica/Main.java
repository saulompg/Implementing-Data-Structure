package pilha.dinamica;

import java.util.Scanner;

public class Main {
	
	// Menu interativo
	static int menu() {
		
		Scanner ler = new Scanner(System.in);
		
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
		int answer = ler.nextInt();
		
		System.out.println();
		
		return answer;
		
	}

	public static void main(String[] args) {
		
		// Declara e Inicia as variáveis
		int exit = -1;		
		Object value;
		
		Pilha pilha = new Pilha();
		Scanner ler = new Scanner(System.in);
		
		// Mantém o programam rodando em loop até que a opção 0 (SAIR) seja informada
		while(exit != 0) {
			
			exit = menu();
			
			switch(exit) {
			
				case 0:
				
					System.out.println("Finalizando o programa");
					
					break;
				
				case 1:
					
					System.out.printf("Digite um valor: ");
					value = ler.nextInt();
					pilha.push(value);
					
					break;
					
				case 2:
					
					Object element = pilha.pop();
					
					if(element != null)
						
						System.out.printf("Removendo --> [%s]\n", element.toString());
					
					else
						
						System.err.println("A pilha está vazia!");
					
					
					break;
					
				case 3:
					
					pilha.clear();
					
					break;
					
					
				case 4:
					
					pilha.print();
					
					break;
					
				default:
					
					System.err.println("Opção inválida!");
					
					break;
			
			}
			
			System.out.println();
			
		}

		ler.close();
		
	}

}
