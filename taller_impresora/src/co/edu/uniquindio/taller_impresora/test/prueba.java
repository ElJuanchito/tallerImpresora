package co.edu.uniquindio.taller_impresora.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uniquindio.taller_impresora.exceptions.ExceptionImpresora;
import co.edu.uniquindio.taller_impresora.model.CentroImpresion;
import co.edu.uniquindio.taller_impresora.model.EstadoImpresora;
import co.edu.uniquindio.taller_impresora.model.Impresora;
import co.edu.uniquindio.taller_impresora.model.TipoImpresa;
import co.edu.uniquindio.taller_impresora.view.MainMenu;

public class prueba {
	public static void main(String[] args) throws FileNotFoundException, ExceptionImpresora {


		/*
		Impresora impresora1 = new Impresora(EstadoImpresora.ENCENDIDO, "impresora", "EPSON", TipoImpresa.LASER);
		CentroImpresion centro = new CentroImpresion(impresora1);

		// "C:/Usuarios/juanp/Escritorio/ohsi.txt"
		centro.addDocumento("Eje", 5, "C:/Users/juanp/Desktop/ohsi.txt");
		System.out.println("Impresion lista: " + centro.getListaImpresion().toString());
		System.out.println("impresion documento: " + impresora1.getDocumentoImprimir().toString());
		System.out.println(centro.imprimirDocumento());
		System.out.println("impresion documento impresora: " + impresora1.getDocumentoImprimir().toString());


		centro.addDocumento("doc1", 5, "doc1.txt");
		centro.addDocumento("doc2", 5, "doc2.txt");
		centro.addDocumento("doc3", 1, "doc3.txt");
		centro.addDocumento("doc4", 1, "doc4.txt");
		centro.addDocumento("doc5", 3, "doc5.txt");


		System.out.println("Impresion lista: " + centro.getListaImpresion().toString());
		System.out.println("impresion documento: " + impresora1.getDocumentoImprimir().toString());
		System.out.println("Impresion lista: " + centro.getListaImpresion().toString());
		*/
		MainMenu menu = new MainMenu();
		menu.lanzar();

	}
}
