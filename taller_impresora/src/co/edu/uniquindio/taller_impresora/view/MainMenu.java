package co.edu.uniquindio.taller_impresora.view;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application {

	private DataBase db;

	public MainMenu() {
		this.db = new DataBase();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label addDoc = new Label("Anadir documento");
		addDoc.getStyleClass().add("labels");
		addDoc.setMaxWidth(Double.MAX_VALUE);
		addDoc.setOnMouseClicked(value -> {
			AddDocument anadir = new AddDocument();
			try {
				anadir.iniciar(primaryStage);
			} catch (Exception e) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Error al mostrar las ventana");
				e.printStackTrace();
			}
		});

		Label printDoc = new Label("Imprimir documento");
		printDoc.getStyleClass().add("labels");
		printDoc.setMaxWidth(Double.MAX_VALUE);
		printDoc.setOnMouseClicked(value -> {
			PrintDocument imprimir = new PrintDocument();
			try {
				if (db.getCentro().imprimirDocumento() == null) {
					Alert alerta = new Alert(AlertType.WARNING);
					alerta.setHeaderText("No existe ningun documento en cola");
					alerta.show();
				} else imprimir.iniciar(primaryStage);
			} catch (Exception e) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Error al mostrar las ventana");
				e.printStackTrace();
			}

		});

		Label verCola = new Label("Ver cola");
		verCola.getStyleClass().add("labels");
		verCola.setMaxWidth(Double.MAX_VALUE);
		verCola.setOnMouseClicked(value -> {
			VerCola ver = new VerCola();
			try {
				ver.iniciar(primaryStage);
			} catch (Exception e) {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setHeaderText("Error al mostrar las ventana");
				e.printStackTrace();
			}
		});

		VBox pnDer = new VBox();
		pnDer.getChildren().addAll(addDoc, printDoc, verCola);

		BorderPane root = new BorderPane();
		root.setRight(pnDer);

		Scene scene = new Scene(root, 500, 600);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Menu");
		primaryStage.show();

	}

	public void lanzar() {
		launch();
	}

	public void iniciar(Stage primaryStage) throws Exception {
		start(primaryStage);
	}
}
