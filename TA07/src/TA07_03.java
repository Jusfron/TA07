import java.util.Hashtable;

import javax.swing.JOptionPane;

public class TA07_03 {
	
	private static Hashtable<String, Double> articulosPrecio;
	private static Hashtable<String, Integer> articulosStock;

	public static void main(String[] args) {
		articulosPrecio = new Hashtable<>();
		articulosStock = new Hashtable<>();
		
		menuOpciones();
	}
	
	private static void menuOpciones () {
		String opcion = " ";
		
		while(!opcion.equals("4")) {			
			opcion = JOptionPane.showInputDialog("Opciones\n1 : Añadir producto\n2 : Mostrar artículo\n3 : Mostrar todos los artículos\n4 : Salir del programa");
			switch (opcion) {
			case "1":
				anadirArticulo();
				break;
			case "2":
				mostrarArticulo();
				break;
			case "3":
				mostrarArticulos();
				break;
			case "4":
				JOptionPane.showMessageDialog(null, "Fin del programa");
				break;
			case " ":
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no reconocida");
				break;
			}
		}
	}
	
	private static void anadirArticulo () {
		String articulo;
		double precio;
		int cantidad;
		
		articulo = JOptionPane.showInputDialog("Introduce el nombre del artículo");
		precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del artículo"));
		cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad en stock"));
		articulosPrecio.put(articulo, precio);
		articulosStock.put(articulo, cantidad);
	}
	
	private static void mostrarArticulo() {
		String articulo;
		
		articulo = JOptionPane.showInputDialog("Introduce el nombre del artículo");
		if(articulosPrecio.containsKey(articulo)) {
			JOptionPane.showMessageDialog(null, "Artículo: "+articulo+"\nPrecio: "+articulosPrecio.get(articulo)+"\nCantidad: "+articulosStock.get(articulo));
		} else {
			JOptionPane.showMessageDialog(null, "Artículo no encontrado");
		}
	}
	
	private static void mostrarArticulos() {
		int i = 1;
		for (String art : articulosPrecio.keySet()) {
			JOptionPane.showMessageDialog(null, "Mostrando artículo "+i+" de "+articulosPrecio.size()+"\nArtículo: "+art+"\nPrecio: "+articulosPrecio.get(art)+"\nCantidad: "+articulosStock.get(art));
			i++;
		}
	}

}
