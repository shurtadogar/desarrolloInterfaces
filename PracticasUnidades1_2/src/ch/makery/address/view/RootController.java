package ch.makery.address.view;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class RootController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
	@FXML
	private Button loginButton;

	private BorderPane rootLayout;

	public void handleButtonAction(ActionEvent e) {

	}

	@FXML
	void addPerson(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("PersonOverview.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			System.out.println(listadoControles.toString());

			this.rootLayout.setCenter(listadoControles);

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
			BorderPane listadoControles = (BorderPane) loader.load();
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void addMovie(ActionEvent event) {
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

	
	void rePrincipal(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("RootLayouts.fxml"));
			BorderPane listadoControles = (BorderPane) loader.load();
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
	void initialize() {

	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}
}
