package ch.makery.address.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class RootController {

		@FXML
	    private ResourceBundle resources;
	
	    @FXML
	    private URL location;
	
	    @FXML
	    private Button loginButton;
	    
	    private BorderPane rootLayout;

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

	    @FXML
	    void addPerson(ActionEvent event) {
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
	    void salir(ActionEvent event) {
	    	try {
				// Cargamos el archivo Controles Dinámicos
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(RootController.class.getResource("RootLayout.fxml"));
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
