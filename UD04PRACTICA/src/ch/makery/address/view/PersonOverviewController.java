package ch.makery.address.view;

import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;

import ch.makery.address.model.Persona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonOverviewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TableColumn<Persona, String> FirstColumn;

	@FXML
	private TableColumn<Persona, String> LastColumn;

	@FXML
	private TableColumn<Persona, String> cityColumn;

	@FXML
	private TableColumn<Persona, String> countryColumn;

	@FXML
	private TableColumn<Persona, String> pcodeColumn;

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
	private TableView<Persona> personTable;

	@FXML
	private TextField postalCodeText;

	/* 
	 * Añadimos los ítems a la tabla como estático y así pueden acceder otras clases 
	 */
	private static ObservableList<Persona> personData = FXCollections.observableArrayList();

	private static ObservableList<String> cityData = FXCollections.observableArrayList();

	private static ObservableList<String> countryData = FXCollections.observableArrayList();

	@FXML
	void initialize() {

		String[] country = new String[]{"Spain", "Brazil", "France", "Italy", "USA"};              
		countryData.addAll(Arrays.asList(country));
		countryChoice.getItems().addAll(countryData);

		String[] citySpain = new String[] {"Madrid", "Barcelona", "Galicia", "Sevilla", "Valencia"} ;
		cityData.addAll(Arrays.asList(citySpain));
		cityChoice.getItems().addAll(cityData);

		this.FirstColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		this.LastColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		this.countryColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
		this.cityColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
		this.pcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

		if (personData.isEmpty()) {
			personData.add(new Persona("Sebastian","Hurtado","Madrid", "España", "shurtado@gmail.com", "12345", 28044));
			personData.add(new Persona("Aimane","Sakur","Madrid", "España", "aimanesakur@gmail.com", "12345", 28044));
			personData.add(new Persona("Adrian","Rodelgo","Madrid", "España", "rodel@gmail.com", "12345", 28044));
		}

		personTable.setItems(personData);

		// Inicializa en blanco los detalles de una persona
		showPersonDetails(null);

		// Se añade un manejador para que cuando se seleccione una fila de la tabla
		// se muestren sus datos a la derecha
		personTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showPersonDetails(newValue)); 

		// Event filter solo admite numeros dentro del field indicado.
		postalCodeText.addEventFilter(KeyEvent.KEY_TYPED, e -> {
			// Se impide escribir caracteres no numéricos
			if (!Character.isDigit(e.getCharacter().charAt(0))) {	
				e.consume();
			}
		});	

		// Revisa que la longitud del texto no sea mayor a la variable definida.
		postalCodeText.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number valorAnterior, Number valorActual) {
				if (valorActual.intValue() > valorAnterior.intValue()) {         
					if (postalCodeText.getText().length() >= 5) {
						postalCodeText.setText(postalCodeText.getText().substring(0, 5));
					}
				}
			}
		});		
	}



	public static ObservableList<Persona> getPersonData() {
		return personData;
	}



	public static void setPersonData(ObservableList<Persona> personData) {
		PersonOverviewController.personData = personData;
	}



	public static ObservableList<String> getCityData() {
		return cityData;
	}


	public static void setCityData(ObservableList<String> cityData) {
		PersonOverviewController.cityData = cityData;
	}


	public static ObservableList<String> getCountryData() {
		return countryData;
	}


	public static void setCountryData(ObservableList<String> countryData) {
		PersonOverviewController.countryData = countryData;
	}


	private void showPersonDetails(Persona person) {
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
		Persona pers = this.personTable.getSelectionModel().getSelectedItem();
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

			Persona pers = new Persona(firstName, lastName, country, city, email, password, postalCode);

			if(!personData.contains(pers)) {
				personData.add(pers);
				this.personTable.setItems(personData);

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
		Persona pers = this.personTable.getSelectionModel().getSelectedItem();
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

				Persona aux = new Persona(firstName, lastName, country, city, email, password, postalCode);

				if(!personData.contains(aux)) {
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
					alert.setTitle("Error al modificar la persona.");
					alert.setContentText("No se ha realizado ningún cambio.");
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
		Persona pers = this.personTable.getSelectionModel().getSelectedItem();

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

	@FXML
	void showGrafics(ActionEvent event) {
		try {
			// Cargamos el diseño del diálogo desde un XML
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PersonOverviewController.class.getResource("GraficosDialog.fxml"));
			AnchorPane dialogo = (AnchorPane) loader.load();

			// Se crea un nuevo Stage para mostrar el diálogo
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Graficos de usuaarios");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			//dialogStage.initOwner(dialogStage);			             

			Scene scene = new Scene(dialogo);
			dialogStage.setScene(scene);

			// Carga el controlador con una referencia al Stage 
			// Lo utilizaremos para cerrar la ventana
			GraficosController controller = loader.getController();
			controller.setDialogStage(dialogStage);			      

			// Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
			dialogStage.showAndWait(); 

		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
