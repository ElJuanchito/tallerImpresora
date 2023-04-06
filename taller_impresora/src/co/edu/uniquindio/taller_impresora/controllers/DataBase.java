package co.edu.uniquindio.taller_impresora.controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uniquindio.taller_impresora.model.CentroImpresion;

public class DataBase {

	private CentroImpresion centro = new CentroImpresion();

	public DataBase() {
		try{
			leerObjeto();
		} catch (Exception e) {
			try {
				escribirObjeto();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public CentroImpresion getCentro() throws ClassNotFoundException, IOException {
		leerObjeto();
		return centro;
	}

	public void setCentro(CentroImpresion centro) throws IOException {
		escribirObjeto();
		this.centro = centro;
	}

	public void leerObjeto() throws IOException, ClassNotFoundException {
			FileInputStream fileIn = new FileInputStream("src/co/edu/uniquindio/taller_impresora/controllers/myData.dat");
			ObjectInputStream obIn = new ObjectInputStream(fileIn);
			centro = (CentroImpresion) obIn.readObject();
			obIn.close();
			fileIn.close();
	}

	public void escribirObjeto() throws IOException {

			FileOutputStream fileOut = new FileOutputStream("src/co/edu/uniquindio/taller_impresora/controllers/myData.dat");
			ObjectOutputStream obOut = new ObjectOutputStream(fileOut);
			obOut.writeObject(centro);
			obOut.close();
			fileOut.close();

	}

}
