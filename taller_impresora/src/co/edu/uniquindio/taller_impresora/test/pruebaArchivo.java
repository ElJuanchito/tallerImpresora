package co.edu.uniquindio.taller_impresora.test;

import javax.swing.JFileChooser;

public class pruebaArchivo {
	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser();

		// Abre el diálogo para seleccionar un archivo
		int result = fileChooser.showOpenDialog(null);

		// Si el usuario ha seleccionado un archivo
		if (result == JFileChooser.APPROVE_OPTION) {
			// Obtiene la ruta del archivo seleccionado
			String filePath = fileChooser.getSelectedFile().getPath();

			// Hacer algo con el archivo seleccionado, por ejemplo imprimir su
			// ruta
			System.out.println("Archivo seleccionado: " + filePath);
		}

	}
}
