
public class FilaDinamica { // First in first out
	private No first;
	private No last;
	private int size = 0;

	public FilaDinamica() {
		first = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (first == null && last == null) {
			return true;
		} else {
			return false;
		}
	}

	public void Enqueue(int elem) { // adicionar um elemento no fim da lista
		No novo = new No(elem);
		if (first == null) {
			first = novo;
			last = novo;
		} else {
			last.prox = novo;
			last = novo;
		}
		size++;
	}

	public void Dequeue() { // remover um elemento do inicio da lista
		if (first == null) {
			System.out.println("Fila vazia");
		} else {
			first = first.prox;
		}
		size--;
	}

	public int peek() { // retorna o valor do primeiro elemento da lista
		return first.dado;
	}

	public void display() {
		No aux = first;
		if (first == null) {
			System.out.println("Fila vazia");
		} else {
			while (aux != null) {
				if (aux.prox == null) {
					System.out.println(aux.dado);
					aux = aux.prox;
				} else {
					System.out.print(aux.dado + " ");
					aux = aux.prox;
				}
			}
		}
	}

	public void clear() {
		if (first == null) {
			System.out.println("Fila vazia");
		} else {
			first = null;
		}
		size = 0;
	}

}
