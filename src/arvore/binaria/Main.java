package arvore.binaria;

import java.util.Scanner;

public class Main {

	// instanciando o objeto para a entrada de dados
	static Scanner sc = new Scanner(System.in);

	// MÉTODO PRINCIPAL
	public static void main(String[] args) {
		
		// DECLARAÇÃO DE VARIÁVEIS
		BinaryTree tree = new BinaryTree();
		int value;
		int exit = -1;
		
		// EXIBIÇÃO 
		while(exit != 0) {
			
			exit = menu();
			
			switch(exit) {
			
			// caso a opção 0 seja digitada, o laço é finalizado
			case 0:
				System.out.println("Finalizando o programa");
				break;
			
			// insere um elemento na árvore
			case 1:
				System.out.printf("> INSERIR ELEMENTO \n");
				System.out.printf("insira o elemento: ");
				value = sc.nextInt();
				tree.insert(value);
				break;
			
			// remove um elemento da árvore
			case 2:
				System.out.printf("> REMOVER ELEMENTO \n");
				System.out.printf("informe o elemento que será removido: ");
				value = sc.nextInt();
				tree.remove(value);
				break;
			
			// imprime os elementos da árvore
			case 3:
				System.out.printf("> IMPRIMIR ELEMENTOS - IN ORDER \n");
				tree.printInOrder();
				break;
				
			case 4:
				System.out.printf("> IMPRIMIR ELEMENTOS - PRE ORDER \n");
				tree.printPreOrder();
				break;
				
			case 5:
				System.out.printf("> IMPRIMIR ELEMENTOS - POS ORDER\n");
				tree.printPosOrder();
				break;
				
			case 6:
				System.out.printf("> IMPRIMIR ELEMENTOS - IN NIVEL\n");
				tree.printLevel();
				break;
				
			// verifica se determinado elemento está inserido na árvore
			case 7:
				System.out.printf("> LOCALIZAR VALOR \n");
				System.out.printf("insira o elemento: ");
				value = sc.nextInt();
				if(tree.contains(value))
					System.out.printf("Elemento encontrado \n");
				else
					System.out.printf("Elemento não encontrado \n");
				break;
			
			// identifica o pai de determinado elemento 
			case 8:
				System.out.printf("> LOCALIZAR PAI \n");
				System.out.printf("insira o elemento: ");
				value = sc.nextInt();
				int temp = tree.findParent(value);
				if(temp != -1)
					System.out.printf("O pai do elemento %d é: %d \n", value, temp);
				break;
			
			case 9:
				tree.printInLevel();
				break;
				
			// caso seja digitada uma opção inválida no menu
			default:
				System.err.printf("> OPÇÃO INVÁLIDA!");
				break;
				
			}

			System.out.printf("\n");
			
		}
		
		sc.close();

	} 
	
	// MÉTODO PARA EXIBIR O MENU
	public static int menu() {
		
		System.out.printf("+------------------------+ \n");
		System.out.printf("|     ÁRVORE BINÁRIA     | \n");
		System.out.printf("+------------------------+ \n");
		System.out.printf("| 1 - Inserir elemento   | \n");
		System.out.printf("| 2 - Remover elemento   | \n");
		System.out.printf("| 3 - Exibir in-order    | \n");
		System.out.printf("| 4 - Exibir pre-order   | \n");
		System.out.printf("| 5 - Exibir pos-order   | \n");
		System.out.printf("| 6 - Exibir in-nivel    | \n");
		System.out.printf("| 7 - Localizar valor    | \n");
		System.out.printf("| 8 - Localizar pai      | \n");
		System.out.printf("| 0 - SAIR               | \n");
		System.out.printf("+------------------------+ \n");
		
		System.out.printf("Escolha uma opção: ");
		int answer = sc.nextInt();
		
		return answer;
		
	}

}
