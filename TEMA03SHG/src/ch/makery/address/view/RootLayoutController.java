package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * El controlador para el men� de la aplicaci�n
 * 
 *
 */
public class RootLayoutController {
    /**
     * Di�logo de Help -> About
     */
    @FXML
    private void handleAbout() {
    	Alert infoAbout = new Alert(AlertType.INFORMATION);
    	
    	infoAbout.setTitle("AddressApp");
    	infoAbout.setHeaderText("Acerca de...");
    	infoAbout.setContentText("Autor: IES P�o Baroja");	       
    	
    	infoAbout.show();
    }

    /**
     * Cierra la aplicaci�n
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }  
}