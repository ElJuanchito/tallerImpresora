package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;

import javax.swing.JFileChooser;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddDocument extends Application {
	private DataBase db;
	private String fPath;

	public AddDocument() {
		this.db =  new DataBase();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label addDoc = new Label();
		addDoc.setText("Llena los datos del documento");

		Label titulo = new Label("Titulo:");

		TextField cajaTitulo = new TextField();
		cajaTitulo.setPromptText("Documento ejemplo");

		HBox pTitulo = new HBox();
		pTitulo.getChildren().addAll(titulo, cajaTitulo);

		Label prioridad = new Label("Prioridad:");

		TextField cajaPrioridad = new TextField();
		cajaPrioridad.setPromptText("Prioridad maxima: 5, minima: 1");

		HBox pPrioridad = new HBox();
		pPrioridad.getChildren().addAll(prioridad, cajaPrioridad);

		Label path = new Label("Path:");

		Button bPath = new Button("buscar path");
		bPath.setOnAction(event -> {
			JFileChooser fileChooser = new JFileChooser();

			int result = fileChooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				String filePath = fileChooser.getSelectedFile().getPath();
				fPath = filePath;
			}
		});

		HBox pPath = new HBox();
		pPath.getChildren().addAll(path, bPath);

		Button anadir = new Button("Añadir");
		anadir.setOnAction(event -> {
			int priori = Integer.parseInt(cajaPrioridad.getText().trim());
			try {
				db.getCentro().addDocumento(cajaTitulo.getText(), priori, fPath);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				db.escribirObjeto();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setHeaderText("El documento se añadio con exito");
			alerta.show();
		});

		Button cerrar = new Button("Cerrar");
		cerrar.setOnAction(event -> {
			MainMenu menu = new MainMenu();
			try {
				menu.iniciar(primaryStage);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		VBox root = new VBox();
		root.getChildren().addAll(pTitulo, pPrioridad, pPath, anadir, cerrar);

		Scene scene = new Scene(root, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anadir Documento");
		primaryStage.show();
	}

	public void iniciar(Stage primaryStage) throws Exception {
		this.start(primaryStage);
	}

}
