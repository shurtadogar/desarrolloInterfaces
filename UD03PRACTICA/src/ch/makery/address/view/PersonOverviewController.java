package ch.makery.address.view;

import java.io.IOException;
import java.util.ResourceBundle;

import ch.makery.address.RootLayout;
import ch.makery.address.model.Person;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
	
	// Referencia a la aplicación principal
    private RootLayout rootLayout;
    
    private ObservableList<Person> persons = FXCollections.observableArrayList(
    		new Person("Hans", "Muster", "Estados Unidos", "New York", "hans", "hans", 1111),
    		new Person("Ruth", "Mueller", "Estados Unidos", "New York", "ruth", "ruth", 1111),
    		new Person("Heinz", "Kurz", "Estados Unidos", "New York", "heinz", "heinz", 1111),
    		new Person("Cornelia", "Meier", "Estados Unidos", "New York", "cornelia", "cornelia", 1111),
    		new Person("Werner", "Meyer", "Estados Unidos", "New York", "werner", "werner", 1111),
    		new Person("Lydia", "Kunz", "Estados Unidos", "New York", "lydia", "lydia", 1111),
    		new Person("Anna", "Best", "Estados Unidos", "New York", "anna", "anna", 1111),
    		new Person("Stefan", "Meier", "Estados Unidos", "New York", "stefan", "stefan", 1111),
    		new Person("Martin", "Mueller", "Estados Unidos", "New York", "martin", "martin", 1111));
    		
    
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
    	personTable.setItems(persons);
		
		 // Inicializa en blanco los detalles de una persona
        showPersonDetails(null);

        // Se añade un manejador para que cuando se seleccione una fila de la tabla
        // se muestren sus datos a la derecha
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));       
	}
	
	/**
     * Referencia a la aplicación principal
     * 
     * @param mainApp
     */
    public void setRootLayout(RootLayout rootLayout) {
        this.rootLayout = rootLayout;
    }
    
    public RootLayout getRootLayout() {
		return rootLayout;
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
	void addPerson(ActionEvent event) {
		String firstName = this.firstNameText.getText();
		String lastName = this.lastNameText.getText();
		String country = this.countryChoice.getValue();
		String city = this.cityChoice.getValue();
		String email = this.emailText.getText();
		String password = this.passwordText.getText();
		Integer postalCode = Integer.parseInt(this.postalCodeText.getText());

		Person person = new Person(firstName, lastName, country, city, email, password, postalCode);
		if(!this.persons.contains(person)) {
			this.persons.add(person);
			this.personTable.setItems(persons);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Formato incorrecto");
			alert.showAndWait();
		}	
	}

	@FXML
	void deletePerson(ActionEvent event) {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();

		// Si no hay ningún campo seleccionado, se muestra un alert
		if (selectedIndex >= 0) {
			// Si se ha seleccionado una fila, se muestra un pop up de confirmación
			Alert confirm = new Alert(AlertType.CONFIRMATION);

			confirm.setTitle("Confirmación para eliminar");
			//errorAlert.setHeaderText("Va a eliminar la fila seleccionada");
			confirm.setContentText("¿Está seguro de eliminar la fila actual?");

			// Si el usuario acepta, entonces se lleva a cabo la acción correspondiente
			confirm.showAndWait().ifPresent(response -> {
				if (response == ButtonType.OK) {
					personTable.getItems().remove(selectedIndex);
				}
			});
		} else {
			// Se muestra un alert si no se puede eliminar la fila
			Alert errorAlert = new Alert(AlertType.ERROR);

			errorAlert.setTitle("Error al eliminar");
			errorAlert.setHeaderText("Se ha producido un error");
			errorAlert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla está vacía");

			errorAlert.showAndWait();
		}    	
	}

	@FXML
	void editPerson(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(PersonOverviewController.class.getResource("PersonEditDialog.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();
			// Se sitúa en el centro del diseño principal
			// Se crea un nuevo Stage para mostrar el di�logo
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Editar persona");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			//dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(listadoControles);
			dialogStage.setScene(scene);
			//rootLayout.setCenter(listadoControles);

			dialogStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}