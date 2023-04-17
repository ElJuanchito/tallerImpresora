package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import co.edu.uniquindio.taller_impresora.exceptions.ExceptionImpresora;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PrintDocument extends BorderPane {
	private DataBase db;
	private BorderPane root;

	public PrintDocument(BorderPane root) {
		this.root = root;
		this.db = new DataBase();
		init();

	}

	private void init() {
		Label label = new Label();
		try {
			label.setText(db.getCentro().imprimirDocumento());
		} catch (ClassNotFoundException | ExceptionImpresora | IOException e1) {
			e1.printStackTrace();
		}
		label.setStyle("-fx-font-weight: bold;" + "-fx-font-size: 1em;" + "-fx-padding: 2em 1em 0 1em");
		try {
			db.escribirObjeto();
		} catch (IOException e) {
			e.printStackTrace();
		}

		VBox box = new VBox();
		box.setAlignment(Pos.TOP_CENTER);
		box.getChildren().addAll(label);

		root.setCenter(box);

	}
}
