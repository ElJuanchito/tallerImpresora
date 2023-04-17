package co.edu.uniquindio.taller_impresora.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class PantallaCarga extends BorderPane {
	private BorderPane root;
	private int i = 0;
	private double j = 0;
	private Label lbl;

	public PantallaCarga(BorderPane root) {
		this.root = root;
		init();
	}

	private void init() {
		VBox box = new VBox(10);
		box.setAlignment(Pos.CENTER);
		this.setCenter(box);
		ProgressBar barra = new ProgressBar();
		barra.setPrefSize(300, 50);

		lbl = new Label();
		lbl.setStyle("-fx-font-size: 2em;");
		box.getChildren().addAll(lbl, barra);

		Timeline tiempo = new Timeline(new KeyFrame(Duration.seconds(0.05), event -> {
			root.setCenter(this);
			i += 1;
			j += 0.01;
			barra.setProgress(j);
			lbl.setText(i + "%");
		}));
		tiempo.setCycleCount(100);
		tiempo.play();
		tiempo.setOnFinished(e -> {
			new PrintDocument(root);
		});
	}
}
