package ch.makery.address.view;

import java.io.IOException;
import java.util.ResourceBundle;

import ch.makery.address.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextField emailText;

	@FXML
	private Button loginButton;

	@FXML
	private PasswordField passText;

	@FXML
	private Button registreButton;

	private Stage dialogStage;

	private ObservableList<Persona> usuarios = FXCollections.observableArrayList(PersonOverviewController.getUsersData());

	@FXML
	void initialize() {
		loginButton.setDisable(true);
		// Cuando cambia el valor, se habilita o deshabilita en función del número de caracteres
		emailText.textProperty().addListener((observable, oldValue, newValue) -> {
			loginButton.setDisable(newValue.length() == 0);    		
		});   	

	}

	@FXML
	void loginUser(ActionEvent event) {
		String email = this.emailText.getText();
		String pass = this.passText.getText();
		Persona aux = new Persona (email, pass);
		boolean loginOk = false;

		for (Persona per:this.usuarios) {
			if (per.compareTo(aux) == 0) {
				loginOk = false;
			}
			else {
				loginOk = true;
				break;
			}
		}

		if (loginOk) {	
			try {
				// Cargamos el diseño del diálogo desde un XML
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(LoginController.class.getResource("UserOverview.fxml"));
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
				UserController controller = loader.getController();
				controller.setDialogStage(dialogStage);			      

				// Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
				dialogStage.showAndWait(); 

			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al iniciar sesion");
			alert.setContentText("La contraseña o el correo introducido son incorrectos.");
			alert.showAndWait();
		}
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	@FXML
	void registreUser(ActionEvent event) {

	}

	// Para acceder al diálogo desde el controlador
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;		
	}   
}
