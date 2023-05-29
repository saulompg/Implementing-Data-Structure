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
			
			// caso 1
			if(current.getLeft() == null && current.getRight() == null)
				return null;
			
			// caso 2
			else if(current.getLeft() == null)
				return current.getRight();
			
			// caso 3
			else if(current.getRight() == null)
				return current.getLeft();
				
			// caso 4
			else {

				current.setValue(current.getRight().getValue());
				current.setRight(null);
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
	private void printRecursiveInOrder(Node root) {
		
		if(root != null) {
			
			printRecursiveInOrder(root.getLeft());
			System.out.printf("%d ", root.getValue());
			printRecursiveInOrder(root.getRight());
			
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
			printRecursivePosOrder(root.getLeft());
			printRecursivePosOrder(root.getRight());
			
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
	public void printInNivel() {
		
		if(root == null) {
			System.out.printf("A árvore está vazia! \n");
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			System.out.printf("%d ", node.getValue());
			
			if(node.getLeft() != null)
				queue.add(node.getLeft());
			
			if(node.getRight() != null)
				queue.add(node.getRight());
			
		}
		

	}
	
	// função que procura um elemento na árvore
	public boolean contains(int value) {
		
		return containsRecursive(root, value);
		
	}
	
	// função que percorre a árvore de forma recursiva
	private boolean containsRecursive(Node current, int value) {
		
		if(current == null) {
			return false;
		}
		
		if (value == current.getValue()) {
			return true;
		}
		
		return value < current.getValue() ? containsRecursive(current.getLeft(), value) : containsRecursive(current.getRight(), value);
		
	}
	
	// função que retorna o pai do elemento
	public int findParent(int value) {
		
		Node parent = findParentRecursive(root, value);
		if(parent == null)
			return -1;
		return parent.getValue();
		
	}
	
	// função que percorre a árvore e retorna o pai do elemento passado
	private Node findParentRecursive(Node current, int value) {
		
		if(current == null) {
			return null;
		}
		
		if((current.getLeft() != null && current.getLeft().getValue() == value) || (current.getRight() != null && current.getRight().getValue() == value)) {
			return current;
		}
		
		Node left = findParentRecursive(current.getLeft(), value);
		
		if(left != null)
			return left;
		return findParentRecursive(current.getRight(), value);
		
		
	}
	
}
