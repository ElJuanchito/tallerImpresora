package co.edu.uniquindio.taller_impresora.test;

import java.io.FileNotFoundException;

import co.edu.uniquindio.taller_impresora.exceptions.ExceptionImpresora;
import co.edu.uniquindio.taller_impresora.view.EscenaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class prueba extends Application {
	public static void main(String[] args) throws FileNotFoundException, ExceptionImpresora {

		/*
		 * Impresora impresora1 = new Impresora(EstadoImpresora.ENCENDIDO,
		 * "impresora", "EPSON", TipoImpresa.LASER); CentroImpresion centro =
		 * new CentroImpresion(impresora1);
		 *
		 * // "C:/Usuarios/juanp/Escritorio/ohsi.txt" centro.addDocumento("Eje",
		 * 5, "C:/Users/juanp/Desktop/ohsi.txt");
		 * System.out.println("Impresion lista: " +
		 * centro.getListaImpresion().toString());
		 * System.out.println("impresion documento: " +
		 * impresora1.getDocumentoImprimir().toString());
		 * System.out.println(centro.imprimirDocumento());
		 * System.out.println("impresion documento impresora: " +
		 * impresora1.getDocumentoImprimir().toString());
		 *
		 *
		 * centro.addDocumento("doc1", 5, "doc1.txt");
		 * centro.addDocumento("doc2", 5, "doc2.txt");
		 * centro.addDocumento("doc3", 1, "doc3.txt");
		 * centro.addDocumento("doc4", 1, "doc4.txt");
		 * centro.addDocumento("doc5", 3, "doc5.txt");
		 *
		 *
		 * System.out.println("Impresion lista: " +
		 * centro.getListaImpresion().toString());
		 * System.out.println("impresion documento: " +
		 * impresora1.getDocumentoImprimir().toString());
		 * System.out.println("Impresion lista: " +
		 * centro.getListaImpresion().toString());
		 */

		/*
		 * DataBase db = new DataBase(); try {
		 * System.out.println(db.getCentro()); } catch (ClassNotFoundException |
		 * IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new EscenaPrincipal(primaryStage);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Menu Principal");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
