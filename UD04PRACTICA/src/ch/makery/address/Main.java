package ch.makery.address;

import ch.makery.address.view.RootController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			RootController rootController = loader.getController();
			rootController.setRootLayout(rootLayout);

			// Mostramos la escena del TabPane de la variable rootLayot
			Scene scene = new Scene(rootLayout);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Pioflix");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}


	public static void main(String[] args) {
		launch(args);
	}
}
