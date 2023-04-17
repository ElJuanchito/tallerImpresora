package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;
import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import co.edu.uniquindio.taller_impresora.exceptions.ExceptionImpresora;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends BorderPane {

	private DataBase db;
	private Stage stage;

	public MainMenu(Stage stage) {
		this.stage = stage;
		this.db = new DataBase();
		init();
	}

	public void init() {

		Label addDoc = new Label("Añadir documento");
		addDoc.getStyleClass().add("opciones");
		addDoc.setMaxWidth(Double.MAX_VALUE);
		addDoc.setOnMouseClicked(value -> new AddDocument(this, stage));

		Label printDoc = new Label("Imprimir documento");
		printDoc.getStyleClass().add("opciones");
		printDoc.setMaxWidth(Double.MAX_VALUE);
		printDoc.setOnMouseClicked(value -> {
			try {
				if (db.getCentro().getImpresoraConectada() == null) {
					new Alert(AlertType.ERROR, "No hay impresora conectada").show();
					return;
				}
				if (db.getCentro().getListaImpresion().isEmpty()) {
					new Alert(AlertType.ERROR, "No existe ningun documento en la cola").show();
					return;
				}
				if (db.getCentro().off()) {
					new Alert(AlertType.ERROR, "La impresora no esta encendida").show();
					return;
				}
				if (db.getCentro().imprimirDocumento() == null) {
					new Alert(AlertType.ERROR, "Error con el documento").show();
					return;
				} else
					// new PrintDocument(this);
					new PantallaCarga(this);

			} catch (ClassNotFoundException | IOException | ExceptionImpresora e) {
				e.printStackTrace();
			}

		});

		Label verCola = new Label("Ver cola");
		verCola.getStyleClass().add("opciones");
		verCola.setMaxWidth(Double.MAX_VALUE);
		verCola.setOnMouseClicked(value -> {

			new VerCola(this);
		});

		Label addImpresora = new Label("Añadir impresora");
		addImpresora.getStyleClass().add("opciones");
		addImpresora.setMaxWidth(Double.MAX_VALUE);
		addImpresora.setOnMouseClicked(value -> {
			new AddImpresora(this);
		});

		Label setIm = new Label("Elegir impresora");
		setIm.getStyleClass().add("opciones");
		setIm.setMaxWidth(Double.MAX_VALUE);
		setIm.setOnMouseClicked(value -> {
			new SelectImpresora(this);
		});

		Label coomingsoon1 = new Label("Encender Impresora");
		coomingsoon1.getStyleClass().add("opciones");
		coomingsoon1.setMaxWidth(Double.MAX_VALUE);
		coomingsoon1.setOnMouseClicked(value -> {
			new EncenderImpresora(this);
		});

		Label coomingsoon2 = new Label("Comming Soon");
		coomingsoon2.getStyleClass().add("opciones");
		coomingsoon2.setMaxWidth(Double.MAX_VALUE);
		coomingsoon2.setOnMouseClicked(value -> new Alert(AlertType.INFORMATION, "Pronto nueva funcionalidad").show());

		VBox pnDer = new VBox();
		pnDer.getChildren().addAll(addDoc, printDoc, verCola, addImpresora, setIm, coomingsoon1, coomingsoon2);
		this.setRight(pnDer);
		this.setTop(new Barra(stage));
		this.setStyle("-fx-font-family: 'Nunito', sans-serif;");

	}
}
