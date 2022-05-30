
package arbolExp;

public class Pila {

	private int tamanio;
	private Nodo tope;

	// Constructor de la pila

	public Pila() {

	}

	// gets y sets

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public Nodo getTope() {
		return tope;
	}

	public void setTope(Nodo tope) {
		this.tope = tope;
	}

	/**
	 * Este metodo verifica si la pila está vacía
	 * 
	 * @return
	 */
	public boolean esVacia() {
		return (tope == null || tamanio == 0);
	}

	/**
	 * Este metodo agrega un nodo a la pila
	 * 
	 * @param n
	 */
	public void apilar(Nodo n) {

		if (esVacia()) {
			tope = n;
			tamanio = 1;
		} else {
			Nodo aux = tope;
			n.setSiguiente(aux);
			tope = n;
			tamanio++;
		}
	}

	/**
	 * Este metodo quita un nodo de la pila
	 * 
	 * @return
	 */
	public Nodo desapilar() {
		Nodo aux = tope;
		if (!esVacia()) {
			tope = tope.getSiguiente();
		} else {
			return null;

		}
		return aux;
	}

	/**
	 * Este metodo elimina la pila
	 */
	public void eliminar() {
		tope = null;
	}

}
