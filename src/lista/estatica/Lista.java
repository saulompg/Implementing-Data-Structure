package lista.estatica;

public class Lista {

	// ATRIBUTOS - declara as variáveis de controle da Lista
	private int size;
	private int lastElement;
	private Object[] arr;
	
	// CONSTRUTOR PADRÃO - define um tamanho padrão de 5 para a Lista
	public Lista() {
		this(5);
	}
	
	// CONSTRUTOR - recebe o tamanho da Lista | inicializa as variáveis de controle da Lista
	public Lista(int size) {
		
		this.size = size;
		lastElement = -1;
		arr = new Object[size];
		
	}
	
	// MÉTODOS
	// Verifica se a lista está vazia
	private boolean isEmpty() {
		
		return lastElement == -1;
		
	}
	
	// Verifica se a lista está cheia
	private boolean isFull() {
		
		return lastElement == size - 1;
		
	}
	
	// Adiciona elemento ao final da lista
	public Object push(Object element) {
		
		if(isFull()) return null;
		
		lastElement++;
		arr[lastElement] = element;
		
		return element;
		
	}
	
	// Remove o último elemento da lista
	public Object pop() {
		
		Object element = null;
		
		if(!isEmpty()) {
			
			element = arr[lastElement];
			lastElement--;
			
		}

		return element;			
		
	}
	
	// Adiciona elemento ao inicio da lista
	public Object add(Object element) {
		
		if(isFull()) return null;
			
		lastElement++;
		for(int i = lastElement; i > 0; i--)
			arr[i] = arr[i-1];
		
		arr[0] = element;
			
		return element;
		
	}
	
	// Remove o primeiro elemento da lista
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
	
	// Exibe os elementos da lista
	public void print() {
		
		if(!isEmpty())
			
			for(int i = 0; i <= lastElement; i++)
				System.out.printf("Índice: %d - Elemento %d\n", i, arr[i]);
		
		else 
			
			System.out.println("A lista está vazia");
		
	}
	
	// Exibe os elementos da lista em ordem inversa
	public void printReverseList() {
		
		if(!isEmpty())
			
			for(int i = lastElement; i >= 0; i--)
				System.out.printf("Índice: %d - Elemento: %d\n", i, arr[i]);
		
		else
			
			System.out.println("A lista está vazia");
		
	}
	
	// Procurar elemento na lista
	public void search(Object element) {
		
		int count = 0;
		
		if(!isEmpty()) {
			
			for(int i = 0; i <= lastElement; i++)
				
				if(arr[i] == element) {
					
					System.out.printf("O elemento %d está na posição %d\n", element, i);
					count++;
					
				}
	
			if(count == 0) System.out.printf("O elemento %d não encontra-se na lista\n", element);
			
		} else 
			
			System.out.println("A lista está vazia");
		
	}
	
	// Ordenar lista pelo método da inserção
	public void sortInsertion() {

		int i, j;
		Object k;

		for(j = 1; j <= this.lastElement; j++) {
			
			k = arr[j];
			i = j-1;

			while(i >= 0 && Integer.parseInt( arr[i].toString() ) > Integer.parseInt( k.toString() )) {

				arr[i+1] = arr[i];
				i--;			
			}

			arr[i+1] = k;
			
		}
		
	}
	
	// Ordenar lista pelo método da seleção
	public void sortSelection() {

		int i, j, min;
		Object swap;

		for(i = 0; i < this.lastElement; i++) {

			min = i;

			for(j = (i+1); j <= this.lastElement; j++) {

				if( Integer.parseInt( arr[j].toString() ) < Integer.parseInt( arr[min].toString() ) )
					min = j;
					
			}

			swap = arr[i];
			arr[i] = arr[min];
			arr[min] = swap;
			
		}
		
	}
	
}
