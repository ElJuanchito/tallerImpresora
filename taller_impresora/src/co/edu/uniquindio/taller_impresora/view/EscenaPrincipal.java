package co.edu.uniquindio.taller_impresora.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class EscenaPrincipal extends Scene {
	public EscenaPrincipal(Stage stage) {
		super(new MainMenu(stage), 800, 550);

		this.getStylesheets().add("/resources/style.css");
		this.getStylesheets().add("https://fonts.googleapis.com/css2?family=Nunito:wght@700&display=swap");

	}
}
