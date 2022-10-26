package ch.makery.address;

import java.io.IOException;

import ch.makery.address.Main;
import ch.makery.address.model.Person;
import ch.makery.address.view.MoviesOverviewController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayout();
		showMoviesOverview();
	}

	public void initRootLayout() {
		try {
			// Carga el XML con el diseño principal
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Se añade el diseño principal a la escena
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMoviesOverview() {
		try {
			// Cargamos el archivo MoviesOverview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/MoviesOverview.fxml"));
			AnchorPane moviesOverview = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(moviesOverview);
			
			// Damos al controlador acceso a la aplicaicón principal
	        MoviesOverviewController controller = loader.getController();
	        controller.setMainApp(this);
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
