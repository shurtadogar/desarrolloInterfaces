package ch.makery.address.view;


import java.util.ResourceBundle;
import javax.print.DocFlavor.URL;
import ch.makery.address.model.Person;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PersonOverviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField firstNameText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField passwordText;
    
    @FXML
    private ChoiceBox<String> cityChoice;
   
    @FXML
    private ChoiceBox<String> countryChoice;
    
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
    private TableView<Person> personTable;

    @FXML
    private TextField postalCodeText;
    
    private ObservableList<Person> persons;
    
	@FXML
	void initialize() { 	

	}
	
	@FXML
	private void addPerson(ActionEvent event) {

		try {

			// Obtengo los datos del formulario
			String firstName = this.firstNameText.getText();
			String lastName = this.lastNameText.getText();
			String city = this.cityChoice.getValue();
			String country = this.countryChoice.getValue();
			String email = this.emailText.getText();
			String password = this.passwordText.getText();
			String postalCode = this.passwordText.getText();
			
			// Creo una Person
			Person per = new Person(firstName, lastName, city, country, email, password, postalCode);

			// Compruebo si la Person esta en el lista
			if (!this.persons.contains(per)) {
				// Lo añado a la lista
				this.persons.add(per);
				// Seteo los items
				this.personTable.setItems(persons);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("Person añadida");
				alert.showAndWait();
			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("La Person existe");
				alert.showAndWait();
			}
		} catch (NumberFormatException e) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Formato incorrecto");
			alert.showAndWait();
		}

	}

	@FXML
	private void seleccionarPerson(MouseEvent event) {

		// Obtengo la Person seleccionada
		Person per = this.personTable.getSelectionModel().getSelectedItem();

		// Sino es nula seteo los campos
		if (per != null) {
			this.firstNameText.setText(per.getFirstName());
			this.lastNameText.setText(per.getLastName());
		}

	}

	@FXML
	private void modificarPerson(ActionEvent event) {

		// Obtengo la Person seleccionada
		Person per = this.personTable.getSelectionModel().getSelectedItem();

		// Si la Person es nula, lanzo error
		if (per == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar una Person");
			alert.showAndWait();
		} else {

			try {
				// Obtengo los datos del formulario
				String firstName = this.firstNameText.getText();
				String lastName = this.lastNameText.getText();
				String city = this.cityChoice.getValue();
				String country = this.countryChoice.getValue();
				String email = this.emailText.getText();
				String password = this.passwordText.getText();
				String postalCode = this.passwordText.getText();

				// Creo una Person
				Person aux = new Person(firstName, lastName, city, country, email, password, postalCode);

				// Compruebo si la Person esta en el lista
				if (!this.persons.contains(aux)) {

					// Modifico el objeto
					per.setFirstName(aux.getFirstName());
					per.setLastName(aux.getLastName());

					// Refresco la tabla
					this.personTable.refresh();

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Info");
					alert.setContentText("Person modificada");
					alert.showAndWait();

				} else {

					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("La Person existe");
					alert.showAndWait();
				}
			} catch (NumberFormatException e) {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("Formato incorrecto");
				alert.showAndWait();
			}

		}

	}

	@FXML
	private void deletePerson(ActionEvent event) {

		// Obtengo la Person seleccionada
		Person person = this.personTable.getSelectionModel().getSelectedItem();

		// Si la Person es nula, lanzo error
		if (person == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar una Person");
			alert.showAndWait();
		} else {

			// La elimino de la lista
			this.persons.remove(person);
			// Refresco la lista
			this.personTable.refresh();

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("Person eliminada");
			alert.showAndWait();

		}

	}
}
