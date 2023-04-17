package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SelectImpresora extends BorderPane {

	private DataBase db;
	private BorderPane root;
	private VBox box;

	public SelectImpresora(BorderPane root) {
		this.root = root;
		this.db = new DataBase();
		init();
	}

	private void init() {
		box = new VBox();
		Label main = new Label("Seleccione una impresora");
		main.setStyle("-fx-font-size: 3em;" + "-fx-alignment: center;" + "-fx-padding: 2em 0;");
		main.setMaxWidth(Double.MAX_VALUE);

		box.getChildren().add(main);

		try {
			db.getCentro().getListaImpresoras().forEach(impresora -> {

				Label lbl = new Label(impresora.getDatos());
				lbl.setAlignment(Pos.CENTER);
				lbl.getStyleClass().add("lblCola");
				lbl.setMaxWidth(Double.MAX_VALUE);
				lbl.setId("selectImp");
				lbl.setOnMouseClicked(value -> {
					try {
						db.getCentro().setImpresoraConectada(impresora);
						db.escribirObjeto();
						new Alert(AlertType.CONFIRMATION, "Impresora " + impresora.getNombre() + " seleccionada.")
								.show();
						System.out.println(impresora);
					} catch (ClassNotFoundException | IOException e) {
						e.printStackTrace();
					}
				});
				box.getChildren().add(lbl);
			});
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		root.setCenter(box);

	}
}
