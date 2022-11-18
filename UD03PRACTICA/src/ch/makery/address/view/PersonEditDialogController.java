package ch.makery.address.view;

import java.util.ResourceBundle;

import ch.makery.address.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextField firstNameText;

	@FXML
	private TextField lastNameText;

	@FXML
	private ChoiceBox<String> cityChoice;

	@FXML
	private ChoiceBox<String> countryChoice;

	@FXML
	private TextField emailText;

	@FXML
	private TextField postalCodeText;
	
	@FXML
	void cancelChange(ActionEvent event) {
		dialogStage.close();
	}

	@FXML
	void okChange(ActionEvent event) {
		person.setFirstName(this.firstNameText.getText());
		person.setLastName(this.lastNameText.getText());
		person.setCountry(this.countryChoice.getValue());
		person.setCity(this.cityChoice.getValue());
		person.setEmail(this.emailText.getText());
		person.setPostalCode(Integer.parseInt(this.postalCodeText.getText()));

		okClicked = true;
		dialogStage.close();
	}

	// Campos auxiliares para intercambiar datos con la clase Main
	private Stage dialogStage;
	private Person person;
	private boolean okClicked = false;


	@FXML
	private void initialize() {
		cityChoice.getItems().addAll("Madrid", "Barcelona", "Sevilla", "Valencia", "Galicia", 
				"Alicante", "Leon", "Cadiz", "Malaga"); 

		countryChoice.getItems().addAll("España", "Estados Unidos", "Reino Unido", "Francia", "Alemania", 
				"Portugal", "Italia"); 

	}


	public void setPerson(Person person) {
		this.person = person;
		
		firstNameText.setText(person.getFirstName());
		lastNameText.setText(person.getLastName());
		cityChoice.setValue(person.getCity());
		countryChoice.setValue(person.getCity());
		emailText.setText(person.getEmail());
		postalCodeText.setText(Integer.toString(person.getPostalCode()));	
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
}
