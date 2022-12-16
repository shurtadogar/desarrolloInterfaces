package ch.makery.address.view;

import java.io.IOException;
import java.util.ResourceBundle;

import ch.makery.address.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RootController {

	@FXML
	private ResourceBundle resources;

	private BorderPane rootLayout;

	private Main mainApp;

	private Stage dialogStage;

	@FXML
	private Button loginButton;

	@FXML
	void initialize() {
		// Aquí debes mostrar el diálogo que se indica en el enunciado
		loginButton.setOnAction((event) -> {
			try {
				// Cargamos el diseño del diálogo desde un XML
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(RootController.class.getResource("LoginDialog.fxml"));
				AnchorPane dialogo = (AnchorPane) loader.load();

				// Se crea un nuevo Stage para mostrar el diálogo
				Stage dialogStage = new Stage();
				dialogStage.setTitle("Login de usuarios");
				dialogStage.initModality(Modality.WINDOW_MODAL);
				//dialogStage.initOwner(dialogStage);			             

				Scene scene = new Scene(dialogo);
				dialogStage.setScene(scene);

				// Carga el controlador con una referencia al Stage 
				// Lo utilizaremos para cerrar la ventana
				LoginController controller = loader.getController();
				controller.setDialogStage(dialogStage);			      

				// Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
				dialogStage.showAndWait(); 

			} catch (IOException e) {
				e.printStackTrace();

			}
		});
	}

	public void setMainApp(Main mainApp) {
		this.mainApp = mainApp; 
	}

	public Main getMainApp() {
		return mainApp;
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
	private void verPersonas(ActionEvent event) {
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
	private void aboutUs(ActionEvent event) {
		try {
			// Cargamos el diseño del diálogo desde un XML
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(RootController.class.getResource("AboutDialog.fxml"));
			AnchorPane dialogo = (AnchorPane) loader.load();

			// Se crea un nuevo Stage para mostrar el diálogo
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ayuda PioFlix");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			//dialogStage.initOwner(dialogStage);			             

			Scene scene = new Scene(dialogo);
			dialogStage.setScene(scene);

			// Carga el controlador con una referencia al Stage 
			// Lo utilizaremos para cerrar la ventana
			AboutController controller = loader.getController();
			controller.setDialogStage(dialogStage);			      

			// Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
			dialogStage.showAndWait(); 

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@FXML
	private void exitApp() {
		Alert alertInfo = new Alert(AlertType.CONFIRMATION);
    	
    	alertInfo.setTitle("Cerrando ventana");
    	alertInfo.setHeaderText("Va a cerrar la ventana actual");
    	alertInfo.setContentText("¿Está seguro?");
    	
    	// Mostramos un alert de tipo confirm antes de cerrar
    	alertInfo.showAndWait().ifPresent(response -> {
    		if (response == ButtonType.OK) {
    			System.exit(0);
    		}
    	});     
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
