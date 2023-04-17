package co.edu.uniquindio.taller_impresora.controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uniquindio.taller_impresora.model.CentroImpresion;

public class DataBase {

	private CentroImpresion centro = new CentroImpresion();

	/**
	 * Constructor de la clase <b>DataBase</b>
	 */
	public DataBase() {
		try{
			leerObjeto();
		} catch (Exception e) {
			try {
				escribirObjeto();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 *	Obtiene el <b>centro de Impresion</b>
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public CentroImpresion getCentro() throws ClassNotFoundException, IOException {
		leerObjeto();
		return centro;
	}

	/**
	 * Establece el <b>centro de Impresion</b>
	 * @param centro
	 * @throws IOException
	 */
	public void setCentro(CentroImpresion centro) throws IOException {
		escribirObjeto();
		this.centro = centro;
	}

	/**
	 *	Transforma el flujo de bytes en un objeto manipulable.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void leerObjeto() throws IOException, ClassNotFoundException {
			FileInputStream fileIn = new FileInputStream("src/co/edu/uniquindio/taller_impresora/controllers/myData.dat");
			ObjectInputStream obIn = new ObjectInputStream(fileIn);
			centro = (CentroImpresion) obIn.readObject();
			obIn.close();
			fileIn.close();
	}

	/**
	 * Guarda el objecto en forma de flujo de bytes
	 * <br>
	 * <br> guarda el flujo de datos en la carpeta controllers con el nombre de <b>myData.dat</b>
	 * @throws IOException
	 */
	public void escribirObjeto() throws IOException {

			FileOutputStream fileOut = new FileOutputStream("src/co/edu/uniquindio/taller_impresora/controllers/myData.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fileOut);
			obOut.writeObject(centro);
			obOut.close();
			fileOut.close();

	}

}
