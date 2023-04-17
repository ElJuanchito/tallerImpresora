package co.edu.uniquindio.taller_impresora.view;

import java.io.IOException;

import co.edu.uniquindio.taller_impresora.controllers.DataBase;
import co.edu.uniquindio.taller_impresora.model.EstadoImpresora;
import co.edu.uniquindio.taller_impresora.model.Impresora;
import co.edu.uniquindio.taller_impresora.model.TipoImpresa;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddImpresora extends BorderPane {
	private DataBase db;
	private Impresora impresoraConectada;
	private BorderPane root;

	public AddImpresora(BorderPane root) {
		this.root = root;
		this.db = new DataBase();
		init();
	}

	private void init() {
		Label addDoc = new Label();
		addDoc.setText("Datos de la Impresora");
		addDoc.setStyle("-fx-font-size: 3em;" + "-fx-alignment: center;" + "-fx-padding: 2em 0;");
		addDoc.setMaxWidth(Double.MAX_VALUE);

		Label nombre = new Label("Nombre:");
		nombre.getStyleClass().add("labels");

		TextField cajaNombre = new TextField();
		cajaNombre.setPromptText("Impresora#1");
		cajaNombre.getStyleClass().add("cajas");

		HBox pNombre = new HBox(20);
		pNombre.getChildren().addAll(nombre, cajaNombre);
		pNombre.getStyleClass().add("cajasImpresora");

		Label estado = new Label("Estado de la impresora: ");
		estado.getStyleClass().add("labels");

		ComboBox<EstadoImpresora> cajaEstado = new ComboBox<>();
		cajaEstado.setPromptText("Seleccionar");
		cajaEstado.getStyleClass().add("btn");
		cajaEstado.getItems().add(EstadoImpresora.ENCENDIDO);
		cajaEstado.getItems().add(EstadoImpresora.APAGADO);

		HBox pEstado = new HBox(20);
		pEstado.getChildren().addAll(estado, cajaEstado);
		pEstado.getStyleClass().add("cajasImpresora");

		Label marca = new Label("Marca:");
		marca.getStyleClass().add("labels");

		TextField cajaMarca = new TextField();
		cajaMarca.setPromptText("EPSON");
		cajaMarca.getStyleClass().add("cajas");

		HBox pMarca = new HBox(20);
		pMarca.getChildren().addAll(marca, cajaMarca);
		pMarca.getStyleClass().add("cajasImpresora");

		Label tipo = new Label("Tipo de la impresora: ");
		tipo.getStyleClass().add("labels");

		ComboBox<TipoImpresa> cajaTipo = new ComboBox<>();
		cajaTipo.setPromptText("Seleccionar");
		cajaTipo.getStyleClass().add("btn");
		cajaTipo.setStyle("-fx-prompt-text-fill: white;");
		cajaTipo.getItems().add(TipoImpresa.CARTUCHO);
		cajaTipo.getItems().add(TipoImpresa.LASER);

		HBox pTipo = new HBox(20);
		pTipo.getChildren().addAll(tipo, cajaTipo);
		pTipo.getStyleClass().add("cajasImpresora");

		Button setImpresora = new Button("Establecer Impresora");
		setImpresora.setVisible(false);
		setImpresora.setOnAction(value -> {
			try {
				db.getCentro().setImpresoraConectada(impresoraConectada);
				db.escribirObjeto();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		});

		Button agregar = new Button("Agregar");
		agregar.getStyleClass().add("btn");
		agregar.setStyle("-fx-padding: 1em;" + "-fx-font-family: 'Nunito', sans-serif;");
		agregar.setOnAction(event -> {
			try {
				System.out.println(db.getCentro());
				Impresora impresora = new Impresora(cajaEstado.getValue(), cajaNombre.getText().trim(),
						cajaMarca.getText().trim(), cajaTipo.getValue());
				db.getCentro().getListaImpresoras().add(impresora);
				db.escribirObjeto();
				impresoraConectada = impresora;
				System.out.println(db.getCentro());
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setHeaderText("La Impresora se agrego con exito.");
			alerta.show();

			try {
				db.escribirObjeto();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		HBox cajaBoton = new HBox(agregar);
		cajaBoton.setAlignment(Pos.CENTER);

		VBox box = new VBox(20);
		box.getChildren().addAll(addDoc, pNombre, pMarca, pEstado, pTipo, setImpresora, cajaBoton);
		root.setCenter(box);
	}

}
