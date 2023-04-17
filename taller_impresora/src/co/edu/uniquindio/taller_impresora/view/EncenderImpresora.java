package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EncenderImpresora extends BorderPane {
	private DataBase db;
	private BorderPane root;

	public EncenderImpresora(BorderPane root) {
		this.root = root;
		this.db = new DataBase();
		init();
	}

	private void init() {
		HBox hbox = new HBox(20);
		VBox vbox = new VBox(20);
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-border-color: blue;");

		Label nombre = new Label();
		nombre.setStyle("-fx-font-size: 4em");
		try {
			String nombreImp = db.getCentro().getImpresoraConectada().getNombre();
			if (nombreImp != null)
				nombre.setText(nombreImp);
		} catch (ClassNotFoundException | IOException e) {
			new Alert(AlertType.ERROR, "Ocurrio un error con la impresora");
			e.printStackTrace();
		}

		Label action = new Label();
		action.getStyleClass().add("btn");
		action.setStyle("-fx-padding: 0.5em 2em;" + "-fx-font-size: 2em;");
		try {
			if (!db.getCentro().off())
				apagar(action);
			if (db.getCentro().off())
				encender(action);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		hbox.getChildren().addAll(action);
		vbox.getChildren().addAll(nombre, hbox);
		root.setCenter(vbox);
		root.setCenter(vbox);
	}

	private void apagar(Label lbl) {
		lbl.setText("Apagar");
		lbl.setOnMouseClicked(value -> {
			try {
				db.getCentro().apagarImpresora();
				db.escribirObjeto();
				lbl.setText("Encender");
				encender(lbl);
			} catch (ClassNotFoundException | IOException e) {
				new Alert(AlertType.WARNING, "Ocurrio un error con la impresora").show();
			}
		});
	}

	private void encender(Label lbl) {
		lbl.setText("Encender");
		lbl.setOnMouseClicked(value -> {
			try {
				db.getCentro().encenderImpresora();
				db.escribirObjeto();
				apagar(lbl);
			} catch (ClassNotFoundException | IOException e) {
				new Alert(AlertType.WARNING, "Ocurrio un error con la impresora").show();
			}
		});
	}
}
