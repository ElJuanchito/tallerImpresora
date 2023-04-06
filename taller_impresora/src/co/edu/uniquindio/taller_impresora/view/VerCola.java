package co.edu.uniquindio.taller_impresora.view;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VerCola extends Application {
	private DataBase db;

	public VerCola() {
		this.db =  new DataBase();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label cola = new Label();
		cola.setText(db.getCentro().getListaImpresion().toString());

		VBox root = new VBox();
		root.getChildren().add(cola);

		Scene scene = new Scene(root, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cola de Impresion");
		primaryStage.show();
	}

	public void iniciar(Stage primaryStage) throws Exception {
		this.start(primaryStage);
	}
}
