package ch.makery.address.view;

import java.util.ResourceBundle;

import ch.makery.address.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PersonOverviewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TableColumn<Person, String> FirstColumn;

	@FXML
	private TableColumn<Person, String> LastColumn;

	@FXML
	private TableColumn<Person, String> cityColumn;

	@FXML
	private TableColumn<Person, String> countryColumn;

	@FXML
	private TableColumn<Person, String> pcodeColumn;

	@FXML
	private ChoiceBox<String> cityChoice;

	@FXML
	private ChoiceBox<String> countryChoice;

	@FXML
	private TextField emailText;

	@FXML
	private TextField firstNameText;

	@FXML
	private TextField lastNameText;

	@FXML
	private PasswordField passwordText;

	@FXML
	private TableView<Person> personTable;

	@FXML
	private TextField postalCodeText;


	private ObservableList<Person> personas = FXCollections.observableArrayList(
			new Person("Sebastian","Hurtado","Madrid", "España", "shurtado@gmail.com", "password", 28044),
			new Person("Andres","Guzman","Madrid", "España", "aguzman@gmail.com", "password", 28044),
			new Person("Aimane","Sakur","Madrid", "España", "aimanesakur@gmail.com", "password", 28044),
			new Person("Adrian","Rodelgo","Madrid", "España", "rodel@gmail.com", "password", 28044));

	@FXML
	void initialize() {
		cityChoice.getItems().addAll("Madrid", "Barcelona", "Sevilla", "Valencia", "Galicia", 
				"Alicante", "Leon", "Cadiz", "Malaga"); 

		countryChoice.getItems().addAll("España", "Estados Unidos", "Reino Unido", "Francia", "Alemania", 
				"Portugal", "Italia"); 

		this.FirstColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		this.LastColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		this.countryColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
		this.cityColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
		this.pcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

		// Se rellena la tabla con objetos de la clase Person
		personTable.setItems(personas);

		// Inicializa en blanco los detalles de una persona
		showPersonDetails(null);

		// Se añade un manejador para que cuando se seleccione una fila de la tabla
		// se muestren sus datos a la derecha
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(newValue)); 
	}

	private void showPersonDetails(Person person) {
		if (person != null) {
			// Si el campo contiene datos, entonces se rellena la información
			firstNameText.setText(person.getFirstName());
			lastNameText.setText(person.getLastName());
			cityChoice.setValue(person.getCity());
			countryChoice.setValue(person.getCity());
			emailText.setText(person.getEmail());
			passwordText.setText(person.getPassword());
			postalCodeText.setText(Integer.toString(person.getPostalCode()));
		} else {
			// Person is null, remove all the text.
			firstNameText.setText("");
			lastNameText.setText("");
			cityChoice.setValue("");
			countryChoice.setValue("");
			emailText.setText("");
			passwordText.setText("");
			postalCodeText.setText("");
		}
	}

	@FXML
	private void selectPerson(MouseEvent event) { 
		Person pers = this.personTable.getSelectionModel().getSelectedItem();
		if (pers != null) {
			this.firstNameText.setText(pers.getFirstName());
			this.lastNameText.setText(pers.getLastName());
			this.countryChoice.setValue(pers.getCountry());
			this.cityChoice.setValue(pers.getCity());
			this.passwordText.setText(pers.getPassword());
			this.postalCodeText.setText(pers.getPostalCode().toString());
		}
	}

	@FXML
	private void addPerson(ActionEvent event) {
		try {
			String firstName = this.firstNameText.getText();
			String lastName = this.lastNameText.getText();
			String country = this.countryChoice.getValue();
			String city = this.cityChoice.getValue();
			String email = this.emailText.getText();
			String password = this.passwordText.getText();
			Integer postalCode = Integer.parseInt(this.postalCodeText.getText());

			Person pers = new Person(firstName, lastName, country, city, email, password, postalCode);
			if(!this.personas.contains(pers)) {
				this.personas.add(pers);
				this.personTable.setItems(personas);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Persona añadida");
				alert.setContentText("Se ha añadido una nueva persona a la tabla");
				alert.showAndWait();
			}
			else {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error al añadir");
				alert.setContentText("La persona ya existe");
				alert.showAndWait();
			}	
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al añadir");
			alert.setContentText("Formato de codigo postal incorrecto");
			alert.showAndWait();
		}

	}

	@FXML
	private void editPerson(ActionEvent event) {
		Person pers = this.personTable.getSelectionModel().getSelectedItem();
		if (pers == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al modificar");
			alert.setContentText("No se puede modificar porque no ha seleccionado una fila o la tabla está vacía");
			alert.showAndWait();
		}
		else {
			try {
				String firstName = this.firstNameText.getText();
				String lastName = this.lastNameText.getText();
				String country = this.countryChoice.getValue();
				String city = this.cityChoice.getValue();
				String email = this.emailText.getText();
				String password = this.passwordText.getText();
				Integer postalCode = Integer.parseInt(this.postalCodeText.getText());

				Person aux = new Person(firstName, lastName, country, city, email, password, postalCode);

				if(!this.personas.contains(aux)) {
					pers.setFirstName(firstName);
					pers.setLastName(lastName);
					pers.setCountry(country);
					pers.setCity(city);
					pers.setEmail(email);
					pers.setPassword(password);
					pers.setPostalCode(postalCode);		

					this.personTable.refresh();

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Persona modificada");
					alert.setContentText("Se ha modificado una persona en la tabla");
					alert.showAndWait();
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error al añadir");
					alert.setContentText("La persona ya existe en la tabla");
					alert.showAndWait();
				}		
			} catch (NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error al añadir");
				alert.setContentText("Formato de codigo postal incorrecto");
				alert.showAndWait();
			}	
		}
	}

	@FXML
	private void deletePerson(ActionEvent event) {
		Person pers = this.personTable.getSelectionModel().getSelectedItem();

		if (pers != null) {

			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Confirmación para eliminar");
			confirm.setContentText("¿Está seguro de eliminar la fila actual?");
			confirm.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					personTable.getItems().remove(pers);

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Persona eliminada");
					alert.setContentText("Se ha eliminado una nueva persona a la tabla");
					alert.showAndWait();
				}
			});
		} else {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("Error al eliminar");
			errorAlert.setHeaderText("Se ha producido un error");
			errorAlert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla está vacía");

			errorAlert.showAndWait();
		}    	
	}

}
