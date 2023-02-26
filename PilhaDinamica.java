
public class PilhaDinamica {	//First in last out
	private No topo;
	private int tam = 0;
	
	public PilhaDinamica (){
		topo = null;
	}
	
	public int size() {
		return tam;
	}
	
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void push(int inserir) {
		No novo = new No(inserir); 
		if (topo == null) {
			topo = novo;
		} else {
			novo.prox = topo;	//o proximo do novo,no caso o que esta embaixo dele, vai receber o valor que estava no topo
			topo = novo;	//o novo agora e o topo
		}
		tam++;
	}
	
	public void display() {
		No aux = topo;
		if(topo == null) {
			System.out.println("Pilha vazia");
		} else {
			while(aux != null) {
				System.out.println(aux.dado + " ");
				aux = aux.prox;
				System.out.println();
			}
		}
	}
	
	public void pop() {
			if(topo == null) {
				System.out.println("Pilha vazia");
			} else {
				topo = topo.prox;
			}
		tam--;
	}
	
	
	public void clear() {
		try {
			if(topo == null) {
				System.out.println("Pilha ja esta vazia!");
			} else {
				topo = null;
			}
		} catch(Exception e) {
			System.out.println("Erro ao limpar a lista");
		}
	}
	
	public int peek() {	//retorna o valor no topo
		try {
			if(topo == null) {
				System.out.println("Pilha vazia");
			} else {
				return topo.dado;
			}
		} catch (Exception e) {
			System.out.println("Erro na pilha");
		}
		return topo.dado;
	}
	
	public int priori(char a) {
		int prioridade;
		if(a == '+' || a == '-') {
			prioridade = 1;
		} else if(a == '*' || a == '/') {
			prioridade = 2;
		} else if(a == '^') {
			prioridade = 3;
		} else {
			prioridade = 0;
		}
		return prioridade;
	}
}
