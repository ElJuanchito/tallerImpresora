package co.edu.uniquindio.taller_impresora.view;

import java.io.File;
import java.io.IOException;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddDocument extends BorderPane {
	private DataBase db;
	private String fPath;
	private BorderPane root;
	private Stage stage;
	private VBox box;

	public AddDocument(BorderPane root, Stage stage) {
		this.root = root;
		this.stage = stage;
		this.db = new DataBase();
		init();
	}

	private void init() {

		box = new VBox(20);

		Label addDoc = new Label();
		addDoc.setText("Datos del documento");
		addDoc.setStyle("-fx-font-size: 3em;" + "-fx-alignment: center;" + "-fx-padding: 2em 0;");
		addDoc.setMaxWidth(Double.MAX_VALUE);

		Label titulo = new Label("Titulo: ");
		titulo.getStyleClass().add("addDocLabels");
		titulo.setStyle("-fx-padding: 0 3.3em 0 1em;");

		TextField cajaTitulo = new TextField();
		cajaTitulo.setPromptText("Documento ejemplo");
		cajaTitulo.setFocusTraversable(false);
		cajaTitulo.getStyleClass().add("cajas");
		cajaTitulo.minWidth(Double.MAX_VALUE);

		HBox pTitulo = new HBox();
		pTitulo.getChildren().addAll(titulo, cajaTitulo);
		pTitulo.getStyleClass().add("panelsDoc");

		Label prioridad = new Label("Prioridad: ");
		prioridad.getStyleClass().add("addDocLabels");
		prioridad.setStyle("-fx-padding:0 1em");

		TextField cajaPrioridad = new TextField();
		cajaPrioridad.setPromptText("maxima: 5, minima: 1");
		cajaPrioridad.setFocusTraversable(false);
		cajaPrioridad.getStyleClass().add("cajas");
		cajaPrioridad.addEventFilter(KeyEvent.KEY_TYPED, event -> {
			String character = event.getCharacter();

			if (!checkNumeric(character))
				event.consume();
		});

		HBox pPrioridad = new HBox();
		pPrioridad.getChildren().addAll(prioridad, cajaPrioridad);
		pPrioridad.getStyleClass().add("panelsDoc");

		Label path = new Label("Path:");
		path.getStyleClass().add("addDocLabels");

		Button bPath = new Button("buscar path");
		bPath.getStyleClass().add("btn");
		bPath.setOnAction(event -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

			File file = fileChooser.showOpenDialog(stage);
			if (file == null) {
				new Alert(AlertType.ERROR, "Ruta no seleccionada").show();
				return;
			}
			fPath = file.getPath();
		});

		HBox pPath = new HBox(20);
		pPath.getChildren().addAll(path, bPath);
		pPath.setStyle("-fx-padding: 0 0 0 3em;");
		pPath.getStyleClass().add("panelsDoc");

		Label anadir = new Label("Añadir");
		anadir.getStyleClass().add("btn");
		anadir.setStyle("-fx-padding: 1em;");
		anadir.setOnMouseClicked(event -> {
			int priori = 1;
			if (!cajaPrioridad.getText().trim().isEmpty())
				priori = Integer.parseInt(cajaPrioridad.getText().trim());
			if (cajaTitulo.getText().trim().isEmpty()) {
				new Alert(AlertType.WARNING, "Llene el espacio del titulo").show();
				return;
			}
			try {
				db.getCentro().addDocumento(cajaTitulo.getText(), priori, fPath);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			try {
				db.escribirObjeto();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setHeaderText("El documento se añadio con exito");
			alerta.show();
		});

		HBox anadirBox = new HBox();
		anadirBox.getChildren().add(anadir);
		anadirBox.setAlignment(Pos.CENTER);

		box.getChildren().addAll(addDoc, pTitulo, pPrioridad, pPath, anadirBox);
		root.setCenter(box);
	}

	private boolean checkNumeric(String value) {
		String number = value.replaceAll("\\s+", "");
		for (int j = 0; j < number.length(); j++) {
			if (!(((int) number.charAt(j) >= 47 && (int) number.charAt(j) <= 57))) {
				return false;
			}
		}
		return true;
	}

}
