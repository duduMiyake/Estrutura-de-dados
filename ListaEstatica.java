
public class ListaEstatica	 {
	private String lista[];
	private int tamLista;
	
	public ListaEstatica(int n) {
		lista = new String[n];
		tamLista = 0;
	}
	
	public ListaEstatica() {
		lista = new String[20];
		tamLista = 0;
	}
	
	public int size() {
		return tamLista;
	}
	
	public boolean vazio() {
		return tamLista == 0;
	}
	
	public void removeall() {
		tamLista = 0;
	}
	
	public boolean cheio() {
		return tamLista == lista.length;
	}
	
	public void show() {
		if(tamLista == 0) {
			System.out.println("Lista vazia");
		} else {
			for(int i = 0; i < tamLista; i++) {
				if(i == tamLista - 1) {
					System.out.println(lista[i] + "");
				} else {
					System.out.print(lista[i] + ", ");
				}
			}
		}
	}
	
	
	
	public void remove(int index) {
		tamLista--;
		for(int i = index; i < tamLista; i++) {
			lista[i] = lista[i + 1];
		}
	}
	
	public void add(String item) {
		try {
			lista[tamLista] = item;
			tamLista++;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("lista cheia");
		}
	}
	
	public void addInicio(String item) {
		try {
			for(int i = tamLista; i >= 1; i--) {
				lista[i] = lista[i - 1];
			}
			tamLista++;
			lista[0] = item;
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Lista cheia");
		}
	}
	
	public void addPosicao(String item, int posicao) {
		try {
			if(posicao == 0) {
				addInicio(item);
			} else {
				for(int i = tamLista; i >= posicao; i--) {
					lista[i] = lista[i - 1];
				}
				lista[posicao] = item;
				tamLista++;
			}
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Lista cheia");
		}
	}
	
	public String posicao(int i) {
		return lista[i];
	}
	
	public int indexOf(String s) {
		for(int i = 0; i < tamLista; i++) {
			if(s.equals(posicao(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(String s) {
		for(int i = 0; i < tamLista; i++) {
			if(s.equals(posicao(i))) {
				return true;
			} 
		}
		return false;
	}
		
}
