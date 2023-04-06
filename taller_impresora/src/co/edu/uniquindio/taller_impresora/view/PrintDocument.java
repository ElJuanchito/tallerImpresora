package co.edu.uniquindio.taller_impresora.view;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrintDocument extends Application {
	private DataBase db;

	public PrintDocument() {
		this.db = new DataBase();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label label = new Label();
		label.setText(db.getCentro().imprimirDocumento());
		label.setStyle("-fx-font-weight: bold;" + "-fx-background-color: aqua;");
		db.escribirObjeto();

		VBox root = new VBox();
		root.getChildren().add(label);

		Scene scene = new Scene(root, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Documento");
		primaryStage.show();

	}

	public void iniciar(Stage primaryStage) throws Exception {
		this.start(primaryStage);
	}
}
