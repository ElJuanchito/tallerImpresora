package co.edu.uniquindio.taller_impresora.view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Barra extends ToolBar {
	private Stage stage;

	public Barra(Stage stage) {
		this.stage = stage;
		stage.initStyle(StageStyle.UNDECORATED);
		init();
	}

	private void init() {
		Label max = new Label("●");
		max.setStyle("-fx-text-fill: #3FD820;");
		max.setId("max");
		max.getStyleClass().add("tools");
		max.setOnMouseClicked(value -> {
			if (stage.isMaximized()) {
				stage.setMaximized(false);
			} else {
				stage.setMaximized(true);
			}
		});

		Label cerrar = new Label("●");
		cerrar.setId("exit");
		cerrar.setStyle("-fx-text-fill: red");
		cerrar.getStyleClass().add("tools");
		cerrar.setOnMouseClicked(value -> Platform.exit());

		Label min = new Label("●");
		min.setId("min");
		min.setStyle("-fx-text-fill: yellow;");
		min.getStyleClass().add("tools");
		min.setOnMouseClicked(value -> stage.setIconified(true));

		this.getItems().addAll(cerrar, min, max);
		this.setStyle("-fx-padding: 0;" + "-fx-background-color: #6C3483;");
	}

}
