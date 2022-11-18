package ch.makery.address.view;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RootController {

	@FXML
	private ResourceBundle resources;

	private BorderPane rootLayout;
	

	@FXML
	void initialize() {

	}

	@FXML
	void addMovie(ActionEvent event) {
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
	void verCartelera(ActionEvent event) {
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
	void addPerson(ActionEvent event) {
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
	void loginPerson(ActionEvent event) {
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
    private void about() {
    	Alert infoAbout = new Alert(AlertType.INFORMATION);
    	
    	infoAbout.setTitle("127.0.0.1");
    	infoAbout.setHeaderText("Acerca de...");
    	infoAbout.setContentText("Autor: Sebastian Hurtado Garcia");	       
    	
    	infoAbout.show();
    }

	@FXML
	private void exit(ActionEvent event) {
		System.exit(0);
	}

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
	
}