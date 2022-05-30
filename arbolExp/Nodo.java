
package arbolExp;

public class Nodo {

	private char valor;
	private int etqArb;
	private Nodo der;
	private Nodo izq;
	private Nodo siguiente;

	// Constructores del nodo

	public Nodo(Nodo n) {

	}

	public Nodo(int etiqueta) {
		this.etqArb = etiqueta;
	}

	// gets y sets

	public char getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}

	public Nodo getDer() {
		return der;
	}

	public void setDer(Nodo der) {
		this.der = der;
	}

	public Nodo getIzq() {
		return izq;
	}

	public void setIzq(Nodo izq) {
		this.izq = izq;
	}

	public int getEtqArb() {
		return etqArb;
	}

	public void setEtqArb(int etqArb) {
		this.etqArb = etqArb;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	/**
	 * Este metodo inserta un nodo en el arbol de expresiones
	 * 
	 * @param nuevo
	 */
	public void insertar(Nodo nuevo) {
		if (this.izq == null) {
			this.izq = nuevo;
		} else {
			this.der = nuevo;
		}
	}

	/**
	 * Este metodo verifica si el caracter es un operador
	 * 
	 * @param c
	 * @return
	 */
	public boolean esOperador(char c) {

		if (c == '*' || c == '/' || c == '+' || c == '-') {
			return true;
		} else {
			return false;
		}
	}

}
