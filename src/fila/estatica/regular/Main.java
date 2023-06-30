package fila.estatica.regular;

import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	static int screen() {

		
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("+              FILA REGULAR               +\n");
		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("| 1 - Inserir elemento                    |\n");
		System.out.printf("| 2 - Inserir sempre                      |\n");
		System.out.printf("| 3 - Remover elemento                    |\n");
		System.out.printf("| 4 - Limpar fila                         |\n");
		System.out.printf("| 5 - Imprimir fila                       |\n");
		System.out.printf("| 0 - Encerrar                            |\n");
		System.out.printf("+-----------------------------------------+\n");
		
		System.out.printf("Escolha uma opção: ");
		int answer = sc.nextInt();
		
		System.out.println();
		
		return answer;
		
	}

	public static void main(String[] args) {
		
		final int size = 5;
		Fila fila = new Fila(size);
		Object element;
		
		int exit = -1;
				
		while(exit != 0) {
			
			exit = screen();
			
			switch(exit) {
			
				case 0:
					
					System.out.println("Finalizando o programa");
					break;
			
				case 1:
					
					System.out.printf("Digite um valor: ");
					element = sc.nextInt();
					fila.push(element);
					break;
					
				case 2:
					
					System.out.printf("Digite um valor: ");
					element = sc.nextInt();
					fila.add(element);
					break;
					
				case 3:
										
					element = fila.remove();
					
					if(element != null)	
						System.out.printf("Removendo --> [%s]", element.toString());
					else
						System.err.println("A fila está vazia");				
					break;
					
				case 4:
					
					fila.clear();
					break;
					
				case 5:
					
					fila.print();
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
