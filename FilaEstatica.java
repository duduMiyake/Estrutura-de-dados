
public class FilaEstatica {
	private Object fila[];
	private int size;
	
	public FilaEstatica() {
		fila = new Object[10];
		size = 0;
	}
	
	public FilaEstatica(int n) {
		fila = new Object[n];
	}
	
	public boolean isEmpty() {
		return fila.length == 0;
	}
	
	public void Enqueue(Object o) {
		try {
			fila[size] = o;
			size++;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Fila cheia");
		}
	}
	
	public void Dequeue() {
		if(isEmpty()) {
			System.out.println("Fila vazia");
		} else {
			for(int i = 0; i < size - 1; i++) {
				fila[i] = fila[i + 1];
			}
			size--;
		}
	}
	
	public Object peek() {
		return fila[size - 1];
	}
	
	public void display() {
		for(int i = 0; i < size; i++) {
			System.out.print(fila[i] + " ");
		}
	}
	
	public void clear() {
		size = 0;
	}
}
