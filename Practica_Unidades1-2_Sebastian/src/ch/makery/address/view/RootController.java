package ch.makery.address.view;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RootController {

	@FXML
	private ResourceBundle resources;

	private BorderPane rootLayout;

	@FXML
	void addMovie(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("MoviesOverview.fxml"));
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
			AnchorPane listadoControles = (AnchorPane) loader.load();
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
			loader.setLocation(RootController.class.getResource("PersonOverview.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			// Se sitúa en el centro del diseño principal
			System.out.println( listadoControles.toString());

			this.rootLayout.setCenter(listadoControles);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void salir(ActionEvent event) {
		rootLayout.setCenter(null);
	}


	@FXML
	void initialize() {

	}

	public void setRootLayout(BorderPane rootLayout2) {
		this.rootLayout = rootLayout2;
	}
}
