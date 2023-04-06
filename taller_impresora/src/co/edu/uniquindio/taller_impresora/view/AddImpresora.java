package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;
import java.util.Optional;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import co.edu.uniquindio.taller_impresora.model.EstadoImpresora;
import co.edu.uniquindio.taller_impresora.model.Impresora;
import co.edu.uniquindio.taller_impresora.model.TipoImpresa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddImpresora extends Application {
	private DataBase db;

	public AddImpresora() {
		this.db = new DataBase();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label addDoc = new Label();
		addDoc.setText("Llena los datos de la Impresora");
		// EstadoImpresora estado, String nombre, String marca, TipoImpresa tipo

		Label nombre = new Label("Nombre:");

		TextField cajaNombre = new TextField();
		cajaNombre.setPromptText("Impresora#1");

		Label estado = new Label("Estado de la impresora: ");

		ComboBox<EstadoImpresora> cajaEstado = new ComboBox<>();
		cajaEstado.setPromptText("Seleccionar");
		cajaEstado.getItems().add(EstadoImpresora.ENCENDIDO);
		cajaEstado.getItems().add(EstadoImpresora.APAGADO);

		Label marca = new Label("Marca:");

		TextField cajaMarca = new TextField();
		cajaMarca.setPromptText("EPSON");

		Label tipo = new Label("Tipo de la impresora: ");

		ComboBox<TipoImpresa> cajaTipo = new ComboBox<>();
		cajaTipo.setPromptText("Seleccionar");
		cajaTipo.getItems().add(TipoImpresa.CARTUCHO);
		cajaTipo.getItems().add(TipoImpresa.LASER);

		Button agregar = new Button("Agregar");
		agregar.setOnAction(event -> {
			try {
				db.getCentro().getListaImpresoras().add(new Impresora(cajaEstado.getValue(), cajaNombre.getText().trim(),
						cajaMarca.getText().trim(), cajaTipo.getValue()));
			} catch (ClassNotFoundException | IOException e1) {
				// TOD O Auto-generated catch block
				e1.printStackTrace();
			}
			Alert alerta = new Alert(AlertType.CONFIRMATION, "Desea establecerla como impresora conectada ?");
			alerta.setHeaderText("La Impresora se agrego con exito.");
			alerta.getButtonTypes().set(0, new ButtonType("Si"));
			Optional<ButtonType> result = alerta.showAndWait();

			if (result.get() == new ButtonType("Si")) {
				try {
					db.getCentro()
							.setImpresoraConectada(db.getCentro().getListaImpresoras().stream()
									.filter(impresora -> impresora.getNombre().equals(cajaNombre.getText().trim()))
									.findFirst().get());
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				alerta.close();
			} try {
				db.escribirObjeto();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		VBox root = new VBox();
		root.getChildren().addAll(nombre, cajaNombre, estado, cajaEstado, marca, cajaMarca, tipo, cajaTipo, agregar);

		Scene scene = new Scene(root, 500, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Cola de Impresion");
		primaryStage.show();
	}

	public void iniciar(Stage primaryStage) throws Exception {
		this.start(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
