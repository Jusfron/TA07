import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class TA07_04 {

	private static Hashtable<String, Double> articulosPrecio;
	private static Hashtable<String, Integer> articulosStock;
	private static Hashtable<Integer, ArrayList<Double>> ventasArticulos;
	private static Hashtable<Integer, Integer> ventasIva;
	private static Hashtable<Integer, Double> ventasPrecioBruto;
	private static Hashtable<Integer, Double> ventasCantidadPagada;

	public static void main(String[] args) {
		articulosPrecio = new Hashtable<>();
		articulosStock = new Hashtable<>();
		ventasArticulos = new Hashtable<>();
		ventasIva = new Hashtable<>();
		ventasPrecioBruto = new Hashtable<>();
		ventasCantidadPagada = new Hashtable<>();
		
		menuOpciones();
	}
	
	private static void menuOpciones () {
		String opcion = " ";
		
		while(!opcion.equals("4")) {			
			opcion = JOptionPane.showInputDialog("Opciones\n1 : Añadir producto\n2 : Mostrar artículo\n3 : Mostrar todos los artículos\n4 : Añadir venta\n"
					+ "5 : Mostrar venta\n6 : Mostrar ventas\n7 : Salir del programa");
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
				anadirVenta();
				break;
			case "5":
				mostrarVenta();
				break;
			case "6":
				mostrarVentas();
				break;
			case "7":
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
	
	private static void anadirVenta() {
		ArrayList<Double> cantidadesCarrito = new ArrayList<>();
		int iva, numVenta;
		double cantidadPagada, precioBruto=0;
		
		numVenta = ventasArticulos.size()+1;
		
		rellenarLista(cantidadesCarrito);
		ventasArticulos.put(numVenta, cantidadesCarrito);
		
		iva = Integer.parseInt(JOptionPane.showInputDialog("Introduce el IVA aplicado"));
		ventasIva.put(numVenta, iva);
		
		for(Double articulo : cantidadesCarrito) {
			precioBruto += articulo;
		}
		ventasPrecioBruto.put(numVenta, precioBruto);
		
		cantidadPagada = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad pagada"));
		ventasCantidadPagada.put(numVenta, cantidadPagada);
		
	}
	
	private static void rellenarLista(ArrayList<Double> carrito) {
		double articulo;
		articulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del articulo (-1 para salir)"));
		while(articulo >= 0) {
			carrito.add(articulo);
			articulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del articulo (-1 para salir)"));
		}
	}
	
	private static void mostrarVenta() {
		int venta, numArticulos;
		double cambio, precioIva;
		
		venta = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de venta"));
		cambio = ventasCantidadPagada.get(venta);
		precioIva = ventasPrecioBruto.get(venta) + ventasPrecioBruto.get(venta)*(double)ventasIva.get(venta)/100;
		numArticulos = ventasArticulos.get(venta).size();
		
		if(ventasArticulos.containsKey(venta)) {
			JOptionPane.showMessageDialog(null, "Venta num "+venta+"\nIVA : "+ventasIva.get(venta)+"\nPrecio total bruto : "+ventasPrecioBruto.get(venta)
			+"\nPrecio total mas IVA : "+precioIva+"\nNumero artículos comprados : "+numArticulos+"\nCantidad pagada : "+ventasCantidadPagada.get(venta)
			+"\nCambio a devolver : "+cambio);
		} else {
			JOptionPane.showMessageDialog(null, "Venta no encontrada");
		}
	}
	
	private static void mostrarVenta(int numVenta) {
		int numArticulos;
		double cambio, precioIva;
		
		cambio = ventasCantidadPagada.get(numVenta);
		precioIva = ventasPrecioBruto.get(numVenta) + ventasPrecioBruto.get(numVenta)*(double)ventasIva.get(numVenta)/100;
		numArticulos = ventasArticulos.get(numVenta).size();
		
		JOptionPane.showMessageDialog(null, "Venta num "+numVenta+"\nIVA : "+ventasIva.get(numVenta)+"\nPrecio total bruto : "+ventasPrecioBruto.get(numVenta)
		+"\nPrecio total mas IVA : "+precioIva+"\nNumero artículos comprados : "+numArticulos+"\nCantidad pagada : "+ventasCantidadPagada.get(numVenta)
		+"\nCambio a devolver : "+cambio);
	}
	
	private static void mostrarVentas() {
		for (int numVenta : ventasArticulos.keySet()) {
			mostrarVenta(numVenta);
		}
	}

}
