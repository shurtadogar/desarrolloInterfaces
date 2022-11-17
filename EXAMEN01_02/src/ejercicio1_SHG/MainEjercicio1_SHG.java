package ejercicio1_SHG;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainEjercicio1_SHG extends Application {
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainEjercicio1_SHG.class.getResource("Ejercicio1_SHG.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Mostramos la escena del TabPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
						
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejercicio 1 Examen Sebastian Hurtado");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
