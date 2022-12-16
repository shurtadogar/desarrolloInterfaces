package ch.makery.address.view;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField cityText;

    @FXML
    private TextField countryText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField postalCodeText;
    
    private Stage dialogStage;

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
    @FXML
    void initialize() {

    }
}
