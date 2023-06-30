package arvore.binaria;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	// declara a raíz da árvore binária 
	Node root;
	
	// função para inserir um valor no nó da árvore
	public void insert(int value) {
		root = insertRecursive(root, value);
	}
	
	// função para inserir um nó na árvore
	private Node insertRecursive(Node current, int value) {
		
		if(current == null) {
			return new Node(value);
		}
		
		if(value < current.getValue())
			current.setLeft(insertRecursive(current.getLeft(), value));
		else if(value > current.getValue())
			current.setRight(insertRecursive(current.getRight(), value));
		else
			System.out.printf("A árvore não permite elementos repetidos \n");
		
		return current;
		
	}
	
	// função para remover um elemento da árvore
	public void remove(int value) {
		
		// verifica se o nó da árvore é nulo
		if(root == null) {
			System.out.printf("A árvore está vazia! \n");
			return;
		}
		
		// verifica se a árvore possui o elemento
		if(!contains(value)) {
			System.out.printf("O elemento não está inserido na árvore \n");
			return;
		}
		
		root = removeRecursive(root, value);
		
	}
	
	// função que percorre a árvore de forma recursiva
	public Node removeRecursive(Node current, int value) {
			
		// se o valor é igual ao nó
		if(value == current.getValue()) {
			
			System.out.printf("O elemento %d foi removido \n", current.getValue());
			
			// caso 1
			if(current.getLeft() == null && current.getRight() == null)
				return null;
			
			// caso 2
			else if(current.getLeft() == null)
				return current.getRight();
			
			// caso 3
			else if(current.getRight() == null)
				return current.getLeft();
			
			else {

				// cria uma variável auxiliar para armazenar o elemento da esquerda
				Node son = current.getLeft();
				
				// case 4:
				if(son.getLeft() == null && son.getRight() == null) {
					current.setValue(son.getValue());
					current.setLeft(null);
					return current;
				}
				
				// cria uma variável auxiliar para armazenar o elemento pai
				Node parent = current;
				
				// percorre para o elemento mais à direita
				while(son.getRight() != null) {
					parent = son;
					son = son.getRight();
				}
				
				// case 4.1:
				if(son.getLeft() != null) {
					current.setValue(son.getValue());
					parent.setRight(son.getLeft());	
				
				// case 4.2:
				} else {
					current.setValue(son.getValue());
					parent.setRight(null);
					
				}
				
				return current;
				
			}

		}
			
		// se o valor é menor que o nó - passa o nó esquerdo como parâmetro
		if(value < current.getValue())
			current.setLeft(removeRecursive(current.getLeft(), value));
		
		// se o valor é maior que o nó - passa o nó direito como parâmetro
		if(value > current.getValue())
			current.setRight(removeRecursive(current.getRight(), value));
		
		// retorna o elemento atual como raíz
		return current;
		
	}
	
	// IN ORDER - função para imprimir os elementos da árvore
	public void printInOrder() {
		
		if(root == null) {
			System.out.printf("A árvore está vazia! \n");
			return;
		}
		
		printRecursiveInOrder(root);

	}
	
	// IN ORDER - função que percorre a árvore de forma recursiva
	private void printRecursiveInOrder(Node current) {
		
		if(current != null) {
			printRecursiveInOrder(current.getLeft());
			System.out.printf("%d ", current.getValue());
			printRecursiveInOrder(current.getRight());
		}
		
	}
	
	// PRÉ ORDER - função para imprimir os elementos da árvore
	public void printPreOrder() {
		
		if(root == null) {
			System.out.printf("A árvore está vazia! \n");
			return;
		}
		
		printRecursivePreOrder(root);

	}
	
	// PRÉ ORDER - função que percorre a árvore de forma recursiva
	private void printRecursivePreOrder(Node root) {
		
		if(root != null) {
			System.out.printf("%d ", root.getValue());
			printRecursivePreOrder(root.getLeft());
			printRecursivePreOrder(root.getRight());
		}
		
	}
	
	// PÓS ORDER - função para imprimir os elementos da árvore
	public void printPosOrder() {
		
		if(root == null) {
			System.out.printf("A árvore está vazia! \n");
			return;
		}
		
		printRecursivePosOrder(root);

	} 
	
	// PÓS ORDER - função que percorre a árvore de forma recursiva
	private void printRecursivePosOrder(Node root) {
		
		if(root != null) {
			printRecursivePreOrder(root.getLeft());
			printRecursivePreOrder(root.getRight());
			System.out.printf("%d ", root.getValue());
		}
		
	}
	
	// IN NIVEL - função para imprimir os elementos da árvore
	public void printLevel() {
		
		if(root == null) {
			System.out.printf("A árvore está vazia! \n");
			return;
		}
		
		getLevel(root);

	}
	
	private void getLevel(Node current) {
		
		boolean proceed = true;
		int level = 0;
		
		while(proceed == true) {
			
			proceed = printLevel(current, level);
			level++;
			System.out.println();
			
		}
		
	}
	
	private boolean printLevel(Node current, int level) {
		
		if(current == null)
			return false;
		
		if(level == 0) {
			System.out.printf("%d ", current.getValue());
			return true;
		}
		
		boolean left = printLevel(current.getLeft(), level-1);
		boolean right = printLevel(current.getRight(), level-1);
		return left || right;
		
	}
	
	// IN LEVEL
	public void printInLevel() {
		
		if(root == null) {
			System.out.printf("A árvore está vazia \n");
			return;
		}
		
		inLevel(root);		
		
	}
	
	private void inLevel(Node current) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(current);
		
		while(!queue.isEmpty()) {
			
			Node element = queue.poll();
			System.out.printf("%d ", element.getValue());
			
			if(element.getLeft() != null)
				queue.add(element.getLeft());
				
			if(element.getRight() != null)
				queue.add(element.getRight());
			
		}
		
	}
	
	// função que procura um elemento na árvore
	public boolean contains(int value) {
		return containsRecursive(root, value);
	}
	
	// função que percorre a árvore de forma recursiva
	private boolean containsRecursive(Node current, int value) {
		
		if(current == null)
			return false;
		
		if (value == current.getValue())
			return true;
		
		return value < current.getValue() ? containsRecursive(current.getLeft(), value) : containsRecursive(current.getRight(), value);
		
	}
	
	// função que retorna o pai do elemento
	public int findParent(int value) {
		
		if(!contains(value)) {
			System.out.printf("O valor não está inserido na árvore \n");
			return -1;			
		}
		
		Node parent = findParentRecursive(root, value);
		
		if(parent == null) {
			System.out.printf("O elemento é a raiz da árvore \n");
			return -1;
		}
		
		return parent.getValue();
		
	}
	
	// função que percorre a árvore e retorna o pai do elemento passado
	private Node findParentRecursive(Node current, int value) {
		
		if(current == null)
			return null;
		
		if(current.getLeft() != null && current.getLeft().getValue() == value)
			return current;
		
		if(current.getRight() != null && current.getRight().getValue() == value)
			return current;
		
		Node left = findParentRecursive(current.getLeft(), value);
		
		if(left != null)
			return left;
		
		return findParentRecursive(current.getRight(), value);
		
	}
	
	public void print() {
		
		printRecursive(root);
		
	}
	
	private void printRecursive(Node current) {
		
		if(current != null) {			
			System.out.printf("id: %s \n", current);
			System.out.printf("valor: %d \n", current.getValue());
			System.out.printf("esquerda_id: %s \n", current.getLeft());
			System.out.printf("direita_id: %s \n", current.getRight());
			System.out.println("--");
			printRecursive(current.getLeft());
			printRecursive(current.getRight());
		}
		
	}
	
}
