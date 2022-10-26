package ch.makery.address.view;

import java.awt.Label;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class PersonOverviewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> cityChoice;

    @FXML
    private ChoiceBox<String> countryChoice;

    @FXML
    private Label nameLabel;
    
    @FXML
    private Label surnameLabel;
    
    @FXML
    private Label cityLabel;
    
    @FXML
    private Label countryLabel;

    @FXML
    private Label emailLabel;
    
    @FXML
    private Label passwordLabel;

    @FXML
    private Label pcodeLabel;
    
	@FXML
	void initialize() { 	
		
		assert cityChoice != null : "fx:id=\"cityChoice\" was not injected: check your FXML file 'MainFormulario.fxml'.";
		assert countryChoice != null : "fx:id=\"countryChoice\" was not injected: check your FXML file 'MainFormulario.fxml'.";

		// ComboBox con lista de países
		countryChoice.getItems().addAll("España", "Portugal", "Inglaterra", "Francia", "Alemania");
		countryChoice.setValue("Select a value...");

		cityChoice.getItems().addAll("Madrid", "Barcelona", "Londres");
		cityChoice.setValue("Select a language");

	}
}
