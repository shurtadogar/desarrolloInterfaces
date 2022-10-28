package ch.makery.address;

import ch.makery.address.RootLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class RootLayout extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootLayout.class.getResource("view/RootLayout.fxml"));
			BorderPane rootLayout = (BorderPane) loader.load();

			// Mostramos la escena del TabPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejercicio prueba examen");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
