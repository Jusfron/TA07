import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class TA07_01 {

	public static void main(String[] args) {
		String nombre;
		double notaMedia;
		Hashtable<String, Double> alumnos = new Hashtable<>();
		
		nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno (-1 para salir)");
		while(!nombre.equals("-1")) {
			notaMedia = calcularNotaMedia();
			alumnos.put(nombre, notaMedia);
			nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno (-1 para salir)");
		}
		
		mostrarAlumnos(alumnos);
	}
	
	private static double calcularNotaMedia() {
		double nota = 0, sumaNotas=0;
		ArrayList<Double> notas = new ArrayList<>();
		
		nota = Double.parseDouble(JOptionPane.showInputDialog("Introduce las notas del alumno (-1 para salir)"));
		while(nota >= 0) {
			notas.add(nota);
			nota = Double.parseDouble(JOptionPane.showInputDialog("Introduce las notas del alumno (-1 para salir)"));
		}
		
		for(double not : notas) {
			sumaNotas = sumaNotas+not;
		}
		
		return sumaNotas/notas.size();
	}
	
	private static void mostrarAlumnos(Hashtable<String, Double> alumnos) {
		for (String alumno : alumnos.keySet()) {
			JOptionPane.showMessageDialog(null, "Nombre: "+alumno+" nota media: "+Double.toString(alumnos.get(alumno)));
		}
	}

}
