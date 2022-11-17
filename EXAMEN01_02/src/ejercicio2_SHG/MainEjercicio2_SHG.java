package ejercicio2_SHG;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainEjercicio2_SHG extends Application {
	private AnchorPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainEjercicio2_SHG.class.getResource("Ejercicio2_SHG.fxml"));
			rootLayout = (AnchorPane) loader.load();
			
			// Mostramos la escena del TabPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);
						
			primaryStage.setScene(scene);
			primaryStage.setTitle("Ejercicio 2 Examen Sebastian Hurtado");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
