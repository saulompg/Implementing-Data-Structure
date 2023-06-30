package fila.estatica.circular;

import java.util.Scanner;

public class Main {
	
	// instanciando o objeto para a entrada de dados
	static Scanner sc = new Scanner(System.in);
	
	static int screen() {

		System.out.printf("+-----------------------------------------+\n");
		System.out.printf("+              FILA CIRCULAR              +\n");
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
		
		final int fullSize = 5;
		FilaCircular fila = new FilaCircular(fullSize);
		Object value;

		int exit = -1;
		
		while(exit != 0) {
			
			exit = screen();
			
			switch(exit) {
			
				case 0:
					
					System.out.println("Finalizando o programa\n");					
					break;
				
				case 1:
					
					System.out.printf("Digite um valor: ");
					value = sc.nextInt();
					fila.push(value);				
					break;
					
				case 2:
					
					System.out.printf("Digite um valor: ");
					value = sc.nextInt();
					fila.add(value);			
					break;
					
				case 3:
					
					Object element = fila.remove();
					
					if(element != null)					
						System.out.printf("Removendo -> [%s]", element.toString());					
					else						
						System.out.println("A fila está vazia");					
					break;
					
				case 4:
					
					fila.clear();					
					break;
				
				case 5:
					
					fila.print();					
					break;
					
				default:
					
					System.err.println("Opção inválida!");					
					break;
			
			}
			
			System.out.println();
			
		}
		
		sc.close();
		
	}

}
