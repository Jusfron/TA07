import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class TA07_02 {

	public static void main(String[] args) {
		ArrayList<Double> cantidadesCarrito = new ArrayList<>();
		int iva, numArticulos;
		double cantidadPagada, cambio, precioBruto=0, precioIva;
		
		rellenarLista(cantidadesCarrito);
		iva = Integer.parseInt(JOptionPane.showInputDialog("Introduce el IVA aplicado"));
		cantidadPagada = Double.parseDouble(JOptionPane.showInputDialog("Introduce la cantidad pagada"));
		for(Double articulo : cantidadesCarrito) {
			precioBruto += articulo;
		}
		precioIva = precioBruto + precioBruto * ((double)iva/100);
		numArticulos = cantidadesCarrito.size();
		cambio = cantidadPagada - precioIva;
		
		mostrarVentas(iva, precioBruto, precioIva, numArticulos, cantidadPagada, cambio);
	}
	
	private static void rellenarLista(ArrayList<Double> carrito) {
		double articulo;
		articulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del articulo (-1 para salir)"));
		while(articulo >= 0) {
			carrito.add(articulo);
			articulo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del articulo (-1 para salir)"));
		}
	}
	
	private static void mostrarVentas(int iva, double precioBruto, double precioIva, int numArticulos, double cantidadPagada, double cambio) {
		JOptionPane.showMessageDialog(null, "IVA aplicado: "+iva+"\nPrecio total bruto: " +precioBruto+"\nPrecio mas IVA: "+precioIva+
				"\nNumero articulos: "+numArticulos+"\nCantidad pagada: "+cantidadPagada+"\nCambio a devolver: "+ cambio);
	}

}
