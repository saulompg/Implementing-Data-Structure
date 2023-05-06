package fila.estatica.regular;

public class Fila {
	
	// ATRIBUTOS - declara as variáveis de controle da fila
	private int size;
	private int lastElement;
	private Object[] arr;
	
	// CONSTRUTOR PADRÃO - define um tamanho padrão de 5 para a Fila
		public Fila() {
			this(5);
		}
		
	// CONSTRUTOR - recebe o tamanho da Fila | inicializa as variáveis de controle da Fila
	public Fila(int size) {
		
		this.size = size;
		lastElement = -1;
		arr = new Object[size];
		
	}
	
	// MÉTODOS
	// Verifica se a fila está vazia
	private boolean isEmpty() {
	
		return lastElement == -1;
		
	}
	
	// Verifica se a fila está cheia
	private boolean isFull() {
		
		return lastElement == this.size - 1;
		
	}
	
	// Adicionar elemento ao fim da fila
	public void push(Object element) {
		
		if(!isFull()) {
			
			lastElement++;
			arr[lastElement] = element;
			
		} else
			
			System.err.println("A fila está cheia!");
		
	}
	
	// Adiciona elemento sempre
	public void add(Object element) {
		
		if(isFull()) {
			
			System.out.printf("Removendo --> [%s]\n", this.remove().toString());
			this.push(element);
			
		} else
			
			this.push(element);
		
	}
	
	// Remover elemento do inicio da fila
	public Object remove() {
		
		Object element = null;
		
		if(!isEmpty()) {
			
			element = arr[0];
			
			for(int i = 0; i < lastElement; i++)
				arr[i] = arr[i+1];
			
			lastElement--;
			
		}
		
		return element;
		
	}
	
	// Remover todos os elementos da fila
	public void clear() {
		
		if(!isEmpty()) {
			
			int aux = lastElement;
			for(int i = 0; i <= aux; i++)
				System.out.printf("Removendo --> [%s]\n", this.remove().toString());
			
		} else
			
			System.err.println("A fila está vazia!");
				
	}

	// Exibir elementos da fila
	public void print() {
		
		if(!isEmpty())
			
			for(int i = 0; i <= lastElement; i++)
				System.out.printf("[%d] --> [%s]\n", i, arr[i].toString());
		
		else
			
			System.err.println("A fila está vazia!");
		
	}

}
