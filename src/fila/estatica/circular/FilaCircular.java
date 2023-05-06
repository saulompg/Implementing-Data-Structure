package fila.estatica.circular;

public class FilaCircular {

	// ATRIBUTOS - declara as variáveis de controle da Fila
	private int size;
	private int lastElement;
	private int firstElement;
	private int totalElements;
	private Object[] arr;
	
	// CONSTRUTOR PADRÃO - define um tamanho padrão de 5 para a Fila
	public FilaCircular() {
		this(5);
	}
			
	// CONSTRUTOR - recebe o tamanho da Fila | inicializa as variáveis de controle da Fila
	public FilaCircular(int size) {
		
		this.size = size;
		lastElement = -1;
		firstElement = -1;
		totalElements = 0;
		arr = new Object[size];
				
	}
	
	// MÉTODOS
	// Verifica se a fila está vazia
	private boolean isEmpty() {
	
		return totalElements == 0;
		
	}
	
	// Verifica se a fila está cheia
	private boolean isFull() {
		
		return totalElements == this.size;
		
	}
		
	// Adiciona elemento ao fim da fila
	public void push(Object element) {
		
		if(!isFull()) {
			
			if(isEmpty()) {
				
				lastElement = 0;
				firstElement = 0;
				
			} else {
				
				lastElement++;
				
				if(lastElement == this.size)
					lastElement = 0;
				
			}
			
			totalElements++;
			arr[lastElement] = element;
			
		} else
			
			System.err.println("A fila está cheia!");
		
	}

	// Adiciona elemento sempre
	public void add(Object element) {
		
		if(isFull()) {
				
			System.out.printf("Removendo -> [%s]\n", this.remove().toString());
			this.push(element);
			
		} else
			
			this.push(element);
		
	}

	// Remove elemento do inicio da fila
	public Object remove() {
		
		Object element = null;
		
		if(!isEmpty()) {
			
			element = arr[firstElement];
			
			firstElement++;
			totalElements--;
			
			if(firstElement == arr.length)
				
				firstElement = 0;
			
		}
		
		return element;
		
	}

	// Remove todos os elementos
	public void clear() {
		
		if(!isEmpty()) {
			
			int aux = totalElements;
			for(int i = 0; i < aux; i++)
				System.out.printf("Removendo -> [%s]\n", this.remove().toString());
			
		} else
			
			System.err.println("A fila está vazia!");
		
	}

	// Exibe os elementos da fila
	public void print() {
		
		if(!isEmpty()) {
			
			if(firstElement > lastElement) {
				
				for(int i = firstElement; i < arr.length; i++)
					System.out.printf("[%d] -> [%s]\n", i, arr[i].toString());
				
				for(int i = 0; i <= lastElement; i++)
					System.out.printf("[%d] -> [%s]\n", i, arr[i].toString());
				
			} else
				
				for(int i = firstElement; i <= lastElement; i++)
					System.out.printf("[%d] -> [%s]\n", i, arr[i].toString());
				
		} else
			
			System.err.println("A fila está vazia!");
		
	}

}
