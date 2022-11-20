package ch.makery.address.view;

import java.io.IOException;
import java.util.ResourceBundle;

import ch.makery.address.RootLayout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RootController {

	@FXML
	private ResourceBundle resources;

	private BorderPane rootLayout;

	private RootLayout mainApp;

	private Stage dialogStage;

	@FXML
	void initialize() {

	}

	public void setMainApp(RootLayout mainApp) {
		this.mainApp = mainApp; 
	}

	public RootLayout getMainApp() {
		return mainApp;
	}

	@FXML
	private void addMovie(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("AddMoviesOverview.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void verCartelera(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("MoviesOverview.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void addPerson(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("PersonOverview.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void loginPerson(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("LoginOverview.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void about(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PersonOverviewController.class.getResource("AboutOverview.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("About Pioflix");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(listadoControles);
			dialogStage.setScene(scene);

			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	private void exit() {
		System.exit(0);
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;		
	}

	public Stage getDialogStage() {
		return dialogStage;
	}
}
