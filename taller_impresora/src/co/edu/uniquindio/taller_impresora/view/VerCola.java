package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import co.edu.uniquindio.taller_impresora.model.Documento;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VerCola extends BorderPane {
	private DataBase db;
	private BorderPane root;

	public VerCola(BorderPane root) {
		this.root = root;
		this.db = new DataBase();
		init();
	}

	private void init() {

		VBox cola = new VBox(20);

		try {
			for (Documento doc : db.getCentro().getListaImpresion()) {
				Label lblCola = new Label(doc.toString());
				lblCola.setMaxWidth(Double.MAX_VALUE);
				lblCola.getStyleClass().add("lblCola");
				cola.getChildren().add(lblCola);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		VBox box = new VBox();
		box.getChildren().addAll(cola);
		root.setCenter(box);
		root.setCenter(box);
	}
}
