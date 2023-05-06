package fila.dinamica;

import java.util.Scanner;

public class Main {

	static int screen() {

		Scanner ler = new Scanner(System.in);
		
		System.out.printf("+---------------------------+\n");
		System.out.printf("+       FILA DINÂMICA       +\n");
		System.out.printf("+---------------------------+\n");
		System.out.printf("| 1 - Inserir elemento      |\n");
		System.out.printf("| 2 - Remover elemento      |\n");
		System.out.printf("| 3 - Limpar fila           |\n");
		System.out.printf("| 4 - Imprimir fila         |\n");
		System.out.printf("| 0 - SAIR                  |\n");
		System.out.printf("+---------------------------+\n");
		
		System.out.printf("Escolha uma opção: ");
		int answer = ler.nextInt();
		
		System.out.println();
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		
		Object element;
		
		int exit = -1;
		
		Fila fila = new Fila();
		Scanner ler = new Scanner(System.in);
		
		while(exit != 0) {
			
			exit = screen();
			
			switch(exit) {
			
				case 0:
				
					System.out.println("Finalizando o programa\n");
					
					break;
				
				case 1:
					
					System.out.printf("Digite um valor: ");
					element = ler.nextInt();
					fila.push(element);
					
					break;
					
				case 2:
					
					element = fila.remove();
					
					if(element != null)
						
						System.out.printf("Removendo --> [%s]\n", element.toString());
					
					else
						
						System.err.println("A fila está vazia!");
					
					break;
					
				case 3:
					
					fila.clear();
					
					break;
					
					
				case 4:
					
					fila.print();
					
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
