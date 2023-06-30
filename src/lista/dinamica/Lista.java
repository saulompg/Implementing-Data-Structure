package lista.dinamica;

import java.util.ArrayList;

public class Lista {

	// ATRIBUTOS
	private ArrayList<Object> arr = new ArrayList<Object>();
	
	// CONSTRUTOR PADRÃO
	public Lista() {}
	
	// MÉTODOS
	// verifica se a lista está vazia
	public boolean isEmpty() {
		
		return arr.size() == 0;
		
	}
	
	// Adiciona elemento ao final da lista
	public void push(Object element) {
		
		arr.add(element);
		
	}
	
	// Remove o ultimo elemento da lista
	public Object pop() {
		
		Object element = null;
		
		if(!isEmpty()) {
			
			element = arr.get(arr.size() - 1);
			arr.remove(arr.size() - 1);
			
		}
		
		return element;
		
	}
	
	// Adiciona elemento ao inicio da lista
	public void add(Object element) {
		
		arr.add(0, element);
		
	}
	
	// Remove o primeiro elemento da lista
	public Object remove() {
		
		Object element = null;
		
		if(!isEmpty()) {
			
			element = arr.get(0);
			arr.remove(0);
			
		}
		
		return element;
		
	}
	
	// Exibe os elementos da lista
	public void print() {
		
		if(!isEmpty())
			
			for(int i = 0; i < arr.size(); i++)
				System.out.printf("[%d] -> [%s]\n", i, arr.get(i).toString());
		
		else
			
			System.err.println("A lista está vazia");
		
	}
	
	// Exibe os elementos da lista em ordem inversa
	public void printReverseList() {
		
		if(!isEmpty())
			
			for(int i = arr.size() - 1; i >= 0; i--)
				System.out.printf("[%d] -> [%s]\n", i, arr.get(i).toString());
		
		else
			
			System.err.println("A lista está vazia");
		
	}

	public void search(Object element) {
		
		int count = 0;
		
		if(!isEmpty()) {
			
			for(int i = 0; i < arr.size(); i++)
				
				if(arr.get(i) == element) {
					
					System.out.printf("O elemento %d está na posição %d\n", element, i);
					count++;

				}
			
			if(count == 0) System.out.printf("O elemento %d não encontra-se na lista\n", element);
			
		} else 
			
			System.err.println("A lista está vazia");
		
	}
	
	// Ordenar lista pelo método da inserção
	public void sortInsertion() {

		int i, j;
		Object k;

		for(j = 1; j < arr.size(); j++) {
			
			k = arr.get(j);
			i = j - 1;

			while(i >= 0 && Integer.parseInt( arr.get(i).toString() ) > Integer.parseInt( k.toString() )) {

				arr.set(i + 1, arr.get(i));
				i--;			
			}

			arr.set(i + 1, k);
			
		}
		
	}
	
	// Ordenar lista pelo método da seleção
	public void sortSelection() {

		int i, j, min;
		Object swap;

		for(i = 0; i < arr.size() - 1; i++) {

			min = i;

			for(j = (i+1); j < arr.size(); j++) {

				if( Integer.parseInt( arr.get(j).toString() ) < Integer.parseInt( arr.get(min).toString() ) )
					min = j;
					
			}

			swap = arr.get(i);
			arr.set(i, arr.get(min));
			arr.set(min, swap);
			
		}
		
	}
	
	
}
