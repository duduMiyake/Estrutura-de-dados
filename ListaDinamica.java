
public class ListaDinamica {
	private No first;
	private No last;
	private int tam = 0;
		
	public ListaDinamica () {	//construtor
		first = null;
		last = null;
	}
	
	public int size() {	//tamanho da lista
		return tam;
	}
	
	public void clear() {	//limpar a lista
		first = null;
		last = null;
		tam = 0;
	}
	
	public void remove(int posicao) {	//remover elemento da posicao indicada
		try {
			if (posicao == 0) {
				No proximo = first.prox;
				first.prox = null;
				first = proximo;
			} else {
				No ant = getNo(posicao - 1);
				No excl = ant.prox;
				ant.prox = excl.prox;
				excl = null;
			}
		}catch (NullPointerException e) {
			System.out.println("Nao possui essa posicao, comeca no zero");
		}
		tam--;
	}
	
	public void add(String elemento) {	//adicionar elemento
		No novo = new No(elemento);
		
		if(first == null) {
			first = novo;
			last = novo;
		} else {
			last.prox = novo;
			last = novo;
		}
		tam++;
	}
	
	public void add(int posicao, String elem) {	//adicionar um elemento em uma posicao da lista
		No novo = new No(elem);
		
		if (posicao == 0) { 	//colocar na primeira posicao
			first.ant = novo;
			novo.prox = first;
			first = novo;
		} else if (posicao == tam + 1) {	//colocar na ultima posicao
			add(elem);
		} else {	//colocar no meio da lista
			No aux = first;
			
			for(int i = 1; i < posicao - 1; i++) {
				aux = aux.prox;
			}
			
			novo.prox = aux.prox;
			aux.prox = novo;
		}
		tam++;
	}
	
	public String getDado(int posicao) {	//retorna um dado de uma posicao da lista
		No aux = first;
		
		for(int i = 1; i <= posicao; i++) {
			aux = aux.prox;
		}
		
		return aux.dado;
	}
	
	public No getNo(int posicao) {	//retorna o No de uma posicao da lista
		No aux = first;
		
		for(int i = 1; i <= posicao; i++) {
			aux = aux.prox;
		}
		
		return aux;
	}
	
	public int indexOf(String elem) {	//retorna a posicao de um elemento da lista
		No aux = first;
		for(int i = 0; i < tam; i++) {
			if(elem.equals(aux.dado)) {
				return i;
			} 	
			aux = aux.prox;
		}
		return -1;
		
	}
	
	public boolean contains(String elem) {	//ver se o elemento ja existe na lista
		No aux = first;
		
		for(int i = 1; i <= tam; i++) {
			if(aux.dado.equals(elem)) {
				return true;
			}
			aux = aux.prox;
		}
		return false;
	}
	
	public void show() {	//ver 
		No aux = first;
		
		while (aux != null) {
			System.out.print(aux.dado + " ");
			aux = aux.prox;
		}
	}
}
