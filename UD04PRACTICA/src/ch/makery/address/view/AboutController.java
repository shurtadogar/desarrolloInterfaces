package ch.makery.address.view;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class AboutController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private Button about;

	@FXML
	private TextArea descriptionText;

	@FXML
	private Button newMovies;

	@FXML
	private Button users;

	@FXML
	private Button okButton;

	private Stage dialogStage;

	@FXML
	void initialize() {
		this.descriptionText.setText("");
		// Aquí debes mostrar el diálogo que se indica en el enunciado
		okButton.setOnAction((event) -> {
			Alert alertInfo = new Alert(AlertType.CONFIRMATION);

			alertInfo.setTitle("Cerrando ventana");
			alertInfo.setHeaderText("Va a cerrar la ventana actual");
			alertInfo.setContentText("¿Está seguro?");

			// Mostramos un alert de tipo confirm antes de cerrar
			alertInfo.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					dialogStage.close();

					// Aquí también es válido cerrar directamente la aplicación
					// System.exit(0);
				}
			});     
		});
	}

	@FXML
	void aboutInformation(ActionEvent event) {
		String texto = "Pioflix es un servicio de streaming que funciona mediante suscripción y permite a sus usuarios ver series y películas a través de cualquier dispositivo conectado a internet.";
		this.descriptionText.setText(texto);
	}

	@FXML
	void moviesInformation(ActionEvent event) {
		String texto = "El contenido de Pioflix varía según la región, y puede cambiar con el tiempo. Su oferta incluye una gran variedad de galardonados títulos originales de Pioflix, series, películas, documentales y mucho más. ";
		this.descriptionText.setText(texto);
	}

	@FXML
	void usersInformation(ActionEvent event) {
		String texto = "Únete a los millones de suscriptores de todo el mundo que disfrutan de acceso ilimitado a series, películas, documentales y otros contenidos premiados sin un solo anuncio.";
		this.descriptionText.setText(texto);
	}

	// Para acceder al diálogo desde el controlador
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;		
	}   

}
