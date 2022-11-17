package ch.makery.address.view;

import java.util.ResourceBundle;

import ch.makery.address.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private ChoiceBox<String> cityChoice;

	@FXML
	private ChoiceBox<String> countryChoice;

	@FXML
	private TextField emailText;

	@FXML
	private TextField lastNameText;

	@FXML
	private TextField nameText;

	@FXML
	private TextField postalCodeText;

	/**
	 * Manejador del botón "CANCELAR" 
	 */

	@FXML
	void cancelChange(ActionEvent event) {
		dialogStage.close();
	}
	

	/**
	 * Manejador del botón "ENVIAR" 
	 */

	@FXML
	void okChange(ActionEvent event) {
		if (isInputValid()) {
			person.setFirstName(nameText.getText());
			person.setLastName(lastNameText.getText());
			person.setCity(cityChoice.getValue());
			person.setCountry(countryChoice.getValue());
			person.setEmail(emailText.getText());
			person.setPostalCode(Integer.parseInt(postalCodeText.getText()));
			
			okClicked = true;
			dialogStage.close();
		}
	}

	// Este componente será un diálogo. Campos auxiliares para su gestión
	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;

	/**
	 * Método para inicializar el controlador que se llama cuando se carga el FXML
	 */
	@FXML
	private void initialize() {

	}

	/**
	 * Rellena los datos de la persona que va a ser añadida o modificada en el diálogo
	 * 
	 * @param person
	 */
	public void setPerson(Person person) {
		this.person = person;

		nameText.setText(person.getFirstName());
		lastNameText.setText(person.getLastName());
		cityChoice.setValue(person.getCity());
		countryChoice.setValue(person.getCountry());
		emailText.setText(person.getCity());
		postalCodeText.setText(Integer.toString(person.getPostalCode()));
		
	}

	/**
	 * Devuelve true si el usuario hace click en el botón "OK"
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}


	/**
	 * Valida los campos de texto del usuario
	 * 
	 * @return true si los campos son válidos
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (nameText.getText() == null || nameText.getText().length() == 0) {
			errorMessage += "El campo first name está vacío\n"; 
		}
		if (lastNameText.getText() == null || lastNameText.getText().length() == 0) {
			errorMessage += "El campo last name está vacío\n"; 
		}
		
		if (emailText.getText() == null || emailText.getText().length() == 0) {
			errorMessage += "El campo last email está vacío\n"; 
		}
		if (postalCodeText.getText() == null || postalCodeText.getText().length() == 0) {
			errorMessage += "El campo postal code está vacío\n"; 
		} else {
			// Se intenta convertir el código postal en entero y si da un error se muestra un mensaje
			try {
				Integer.parseInt(postalCodeText.getText());
			} catch (NumberFormatException e) {
				errorMessage += "Postal code no válido. Debe ser un número entero\n"; 
			}
		}

		if (cityChoice.getValue() == null || cityChoice.getValue().length() == 0) {
			errorMessage += "El campo city está vacío\n"; 
		}

		if (countryChoice.getValue() == null || countryChoice.getValue().length() == 0) {
			errorMessage += "El campo country está vacío\n"; 
		}
		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Se muestra un alert si no se puede eliminar la fila
			Alert errorAlert = new Alert(AlertType.ERROR);

			errorAlert.setTitle("Hay campos incorrectos");
			errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
			errorAlert.setContentText(errorMessage);

			errorAlert.showAndWait();
			return false;
		}
	}

	/**
	 * Método set de la propiedad dialogStage
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
}
