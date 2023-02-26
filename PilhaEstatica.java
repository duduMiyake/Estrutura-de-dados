
public class PilhaEstatica {
	private Object pilha[];
	private int size;
	
	public PilhaEstatica() {
		pilha = new Object[10];
		size = 0;
	}
	
	public PilhaEstatica(int n) {
		pilha = new Object[n];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void push(Object o) {
		try {
			pilha[size] = o;
			size++;
		} catch(ArrayIndexOutOfBoundsException exception) {
			System.out.println("Pilha cheia");
		}
	}
	
	public void pop() {
		try {
			for(int i = 0; i < size; i++) {
				pilha[i] = pilha[i + 1];
			}
		} catch(Exception e) {
			System.out.println("Erro ao selecionar a pilha cheia");
		}
	}
	
	public void display() {
		for(int i = 0; i < size; i++) {
			System.out.println(pilha[i] + " ");
		}
	}
	
	public void clear() {
		size = 0;
	}
	
	public Object peek() {
		return pilha[size - 1];
	}
}
