package pilha.dinamica;

// IMPORTAÇÕES
import java.util.ArrayList;

// CLASSE PILHA - DINÂMICA
public class Pilha {
	
	// ATRIBUTOS
	ArrayList<Object> arr = new ArrayList<Object>();
	
	// MÉTODOS
	// Verifica se a Pilha está vazia
	public boolean isEmpty() {
		
		return arr.size() == 0;
		
	}
	
	// Adiciona elemento no topo da Pilha
	public void push(Object element) {
		
		arr.add(element);
		
	}
	
	// Remove elemento do topo da Pilha
	public Object pop() {
		
		Object element = null;
		
		if(!isEmpty()) {
			
			element = arr.get(arr.size() - 1);
			arr.remove(arr.size() - 1);
			
		}
		
		return element;
		
	}
	
	// Limpa todos os elementos da Pilha
	public void clear() {
		
		if(!isEmpty())
			
			for(int i = arr.size() - 1; i >= 0; i--)
				System.out.printf("Removendo --> [%s]\n", this.pop().toString());
			
		else
			
			System.err.println("A pilha está vazia!");
		
	}
		
	// Exibir a Pilha
	public void print() {
		
		if(!isEmpty())
			
			for(int i = arr.size() - 1; i >= 0; i--)
				System.out.printf("[%d] --> [%s]\n", i, arr.get(i).toString());
			
		else
			
			System.err.println("A pilha está vazia!");
		
	}

}
