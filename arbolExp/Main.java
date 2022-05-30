
package arbolExp;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		Arbol ar = null;
		int opcion = 0;

		//Menu de la aplicacion
		do {
			try {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(
						"Escoja una opción \n1-Crear un arbol\n2-Cantidad de nodos creados\n3-PreOrden\n4-InOrden\n5-PosOrden\n6-Salir"));

				switch (opcion) {
				case 1:
					ar = new Arbol();
					String expresion = JOptionPane.showInputDialog("Introduzca la expresion:");
					ar.crearArbol(expresion);
					JOptionPane.showMessageDialog(null, "Arbol creado", null, JOptionPane.INFORMATION_MESSAGE);
					break;
				case 2:
					if (ar != null) {
						System.out.println("La cantidad de nodos creados es de " + ar.getCantidadNodos());
						;
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe crear primero un arbol para mostrar la cantidad de nodos", "null",
								JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 3:
					if (ar != null) {
						ar.preorden(ar.getRaiz());
						System.out.println();
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe crear primero un arbol para mostrar la expresion en Preorden", "null",
								JOptionPane.WARNING_MESSAGE);
					}

					break;
				case 4:
					if (ar != null) {
						ar.inorden(ar.getRaiz());
						System.out.println();
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe crear primero un arbol para mostrar la expresion en Inorden", "null",
								JOptionPane.WARNING_MESSAGE);
					}

					break;
				case 5:
					if (ar != null) {
						ar.postorden(ar.getRaiz());
						System.out.println();
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe crear primero un arbol para mostrar la expresion en Posorden", "null",
								JOptionPane.WARNING_MESSAGE);
					}

					break;
				case 6:
					break;

				default:
					JOptionPane.showMessageDialog(null, "No existe la opcion " + opcion + " ingrese un opcion válida",
							"null", JOptionPane.ERROR_MESSAGE);
				}

			} catch (NumberFormatException e) {
				if ("Null".equals(e.getMessage())) {
					break;
				}
			}
		} while (opcion != 6);

	}

}
