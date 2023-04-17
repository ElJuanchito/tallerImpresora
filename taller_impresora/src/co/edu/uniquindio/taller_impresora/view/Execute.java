package co.edu.uniquindio.taller_impresora.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Execute extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new EscenaPrincipal(primaryStage);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Menu Principal");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lanzar(){
		launch();
	}

}
