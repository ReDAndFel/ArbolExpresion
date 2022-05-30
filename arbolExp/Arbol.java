
package arbolExp;

public class Arbol {

	private Nodo actual;
	private Nodo raiz;
	private int etiqueta = 1;
	private int cantidadNodos;

	private Pila p = new Pila();

	/**
	 * Constructor del arbol
	 */

	public Arbol() {

	}

	// Gets y sets
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	public Nodo getActual() {
		return actual;
	}

	public void setActual(Nodo actual) {
		this.actual = actual;
	}

	public Pila getP() {
		return p;
	}

	public void setP(Pila p) {
		this.p = p;
	}

	public int getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(int etiqueta) {
		this.etiqueta = etiqueta;
	}

	public int getCantidadNodos() {
		return cantidadNodos;
	}

	public void setCantidadNodos(int cantidadNodos) {
		this.cantidadNodos = cantidadNodos;
	}

	/**
	 * Este metodo crea el arbol de expresiones recorriendo cada caracter de la
	 * expresion
	 * 
	 * @param expresion
	 */
	public void crearArbol(String expresion) {
		if (!expresion.isEmpty()) {
			// El replace es para eliminar los espacios y los ) de la expresion
			String expresionAux = expresion.replace(" ", "").replace(")", "");
			for (int i = 0; i <= expresionAux.length() - 1; i++) {
				insertar(expresionAux.charAt(i));
			}
		}
	}

	/**
	 * Este metodo crea los nodos del arbol de expresiones
	 * 
	 * @param valor
	 */
	public void insertar(char valor) {
		if (valor == '(') { // En caso de ser /
			Nodo nuevo = new Nodo(this.etiqueta);
			if (raiz == null) {
				this.raiz = nuevo;
				this.actual = nuevo;
			} else {
				this.actual.insertar(nuevo);
				this.actual = nuevo;
			}
			p.apilar(nuevo);
			this.etiqueta++;
			this.cantidadNodos++;
		} else if (!esOperador(valor)) { // En caso de ser operador
			Nodo nuevo = new Nodo(this.etiqueta);
			nuevo.setValor(valor);
			this.actual.insertar(nuevo);
			this.actual = nuevo;
			this.etiqueta++;
			this.cantidadNodos++;

		} else { // En caso de ser operando
			this.actual = p.desapilar();
			this.actual.setValor(valor);
		}
	}

	/**
	 * Este metodo recorre e imprime el arbol de expresiones en pre orden
	 * 
	 * @param n
	 */
	public void preorden(Nodo n) {
		if (n == null)
			return;

		System.out.print(n.getValor());
		preorden(n.getIzq());
		preorden(n.getDer());

	}

	/**
	 * Este metodo recorre e imprime el arbol de expresiones en pos orden
	 * 
	 * @param n
	 */
	public void postorden(Nodo n) {
		if (n == null)
			return;
		postorden(n.getIzq());
		postorden(n.getDer());
		System.out.print(n.getValor());

	}

	/**
	 * Este metodo recorre e imprime el arbol de expresiones en inorden
	 * 
	 * @param nodo
	 */

	public void inorden(Nodo nodo) {
		if (nodo != null) {
			inorden(nodo.getIzq());
			System.out.print(nodo.getValor());
			inorden(nodo.getDer());
		}
	}

	public boolean esOperador(char c) {

		if (c == '*' || c == '/' || c == '+' || c == '-') {
			return true;
		} else {
			return false;
		}
	}

}
