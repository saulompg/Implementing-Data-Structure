package pilha.estatica;

// CLASSE PILHA - ESTÁTICA
public class Pilha {
	
	// ATRIBUTOS - declara as variáveis de controle da pilha
	private int size;
	private int lastElement;
	private Object[] arr;

	// CONSTRUTOR PADRÃO - define um tamanho padrão de 5 para a Pilha
	public Pilha() {
		this(5);
	}
	
	// CONSTRUTOR - recebe o tamanho da Pilha | inicializa as variáveis de controle da pilha
	public Pilha(int size) {
		
		this.size = size;
		lastElement = -1;
		arr = new Object[size];
		
	}
	
	// MÉTODOS
	// Verifica se a pilha está vazia
	public boolean isEmpty() {
		
		return lastElement == -1;
		
	}
	
	// Verifica se a pilha está cheia
	public boolean isFull() {
		
		return lastElement == size - 1;
		
	}
	
	// Adiciona elemento ao final da Pilha
	public void push(Object element) {
		
		if(!isFull()) {
		
			lastElement++;
			arr[lastElement] = element;
		
		} else
			
			System.err.printf("Não foi possível adicionar o elemento %s \n", element.toString());
		
	}
	
	// Remove elemento do final da Pilha | retorna o valor removido - se não houver, retorna null
	public Object pop() {
		
		Object element = null;

		if(!isEmpty()) {
		
			element = arr[lastElement];
			lastElement--;

		}
			
		return element;
			
	}
	
	// Limpa todos os elementos da Pilha
	public void clear() {
		
		if(!isEmpty())
			
			for(int i = lastElement; i >= 0; i--)
				System.out.printf("O elemento [%s] foi removido da pilha\n", this.pop().toString());
			
		else
			
			System.err.printf("A pilha está vazia!\n");
		
	}
	
	// Exibir a Pilha
	public void print() {
		
		if(!isEmpty())
			
			for(int i = lastElement; i >= 0; i--)
				System.out.printf("[%d] -> [%s]\n", i, arr[i].toString());
			
		else
			
			System.err.printf("A pilha está vazia!\n");
		
	}
	
}
