
public class ListaDinOrdenada {
	private No first;
	private No last;
	private int tam = 0;

	public ListaDinOrdenada() {	//construtor
		first = null;
		last = null;
	}

	public int size() {	//tamanho da lista
		return tam;
	}

	public void clear() { // limpar lista
		first = null;
		last = null;
		tam = 0;
	}

	public void add(String elem) {
		No novo = new No(elem);

		if (first == null) { // se a lista estiver vazia
			first = novo;
			last = novo;
		} else if (novo.dado.compareTo(first.dado) < 0) { // colocar no primeiro
			novo.prox = first;
			first.ant = novo;
			first = novo;
		} else if (novo.dado.compareTo(last.dado) >= 0) { // colocar por ultimo
			last.prox = novo;
			novo.ant = last;
			last = novo;
		} else { // colocar no meio
			No aux = first;

			while (novo.dado.compareTo(aux.dado) > 0) {
				aux = aux.prox;
			}
			novo.ant = aux.ant;
			novo.prox = aux;
			aux.ant.prox = novo;
			aux.ant = novo;
		}
		tam++;
	}

	public void show() {
		No aux = first;

		while (aux != null) {
			if (aux == last) {
				System.out.println(last.dado);
			} else {
				System.out.print(aux.dado + " ");
			}
			aux = aux.prox;
		}

	}

	public String getDado(int posicao) { //pegar o valor da posicao
		No aux = first;

		for (int i = 1; i <= posicao; i++) {
			aux = aux.prox;
		}

		return aux.dado;
	}

	public No getNo(int posicao) {	//pegar o No da posicao
		No aux = first;

		for (int i = 1; i <= posicao; i++) {
			aux = aux.prox;
		}

		return aux;
	}

	public int indexOf(String elem) {	//pegar a posicao de um dado
		No aux = first;
		for (int i = 0; i < tam; i++) {
			if (elem.equals(aux.dado)) {
				return i;
			}
			aux = aux.prox;
		}
		return -1;

	}

	public boolean contains(String elem) {	//ver se o valor ja existe
		No aux = first;

		for (int i = 1; i <= tam; i++) {
			if (aux.dado.equals(elem)) {
				return true;
			}
			aux = aux.prox;
		}
		return false;
	}

	public void remove(int posicao) {	//remover de uma posicao 
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
			System.out.println("Nao possui essa posicao, lista comeca no numero 0");
		}
		tam--;
	}
}
