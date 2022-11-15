package ch.makery.address.view;

import java.util.ResourceBundle;

import ch.makery.address.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @FXML
    void addPerson(ActionEvent event) {
    	String firstName = this.firstNameText.getText();
    	String lastName = this.lastNameText.getText();
    	String city = this.cityChoice.getValue();
    	String country = this.countryChoice.getValue();
    	String email = this.emailText.getText();
    	String password = this.passwordText.getText();
    	String postalCode = this.postalCodeText.getText();
    
    	Person person = new Person(firstName, lastName, city, country, email, password, postalCode);
    	
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

    }

    @FXML
    void modificarPerson(ActionEvent event) {

    }
    
    private ObservableList<Person> persons;
    
    @FXML
    void initialize() {
    	persons = FXCollections.observableArrayList();
    	this.FirstColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    	this.LastColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    	this.countryColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
    	this.cityColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
    	this.pcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
    	
    	Person pers1 = new Person("Sebastian","Hurtado","Madrid","España","shurtado@gmail.com","password","28044");
    	Person pers2 = new Person("Andres","Guzman","Madrid","España","klkmanin@gmail.com","password","28044");
    	Person pers3 = new Person("Aimane","Shakur","Madrid","España","cnh23@gmail.com","password","28044");
    	Person pers4 = new Person("Adrian","Rodelgo","Madrid","España","rodel@gmail.com","password","28044");
    	this.persons.add(pers1);
    	this.persons.add(pers2);
    	this.persons.add(pers3);
    	this.persons.add(pers4);
    }
}
