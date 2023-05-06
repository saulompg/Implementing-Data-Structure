package fila.dinamica;

import java.util.ArrayList;

public class Fila {

	// ATRIBUTOS
	private ArrayList<Object> arr = new ArrayList<Object>();
	
	// CONSTRUCTOR
	public Fila() {}

	// MÉTODOS
	
	// Verifica se a fila está vazia
	private boolean isEmpty() {
		
		return arr.size() == 0;
		
	}	

	// Adiciona um elemento na fila
	public void push(Object element) {
		
		arr.add(element);
		
	}

	// Remove um elemento da fila
	public Object remove() {
		
		Object element = null;
		
		if(!isEmpty()) {
			
			element = arr.get(0);
			arr.remove(0);
		
		}
		
		return element;
		
	}

	// Remove todos os elementos da fila
	public void clear() {
		
		if(!isEmpty()) {
			
			int n = arr.size();
			for(int i = 0; i < n; i++)
				System.out.printf( "Removendo --> [%s]\n", this.remove().toString() );

		} else
			
			System.err.println("A fila está vazia!");
		
	}

	// Exibe todos os elementos da fila
	public void print() {
		
		if(!isEmpty())
			
			for(int i = 0; i < arr.size(); i++)
				System.out.printf( "[%d] --> [%s]\n", i, arr.get(i).toString() );
		
		else
			
			System.err.println("A fila está vazia!");
		
	}
	
}
