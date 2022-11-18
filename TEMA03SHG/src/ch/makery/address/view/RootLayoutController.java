package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * El controlador para el menú de la aplicación
 * 
 *
 */
public class RootLayoutController {
    /**
     * Diálogo de Help -> About
     */
    @FXML
    private void handleAbout() {
    	Alert infoAbout = new Alert(AlertType.INFORMATION);
    	
    	infoAbout.setTitle("AddressApp");
    	infoAbout.setHeaderText("Acerca de...");
    	infoAbout.setContentText("Autor: IES Pío Baroja");	       
    	
    	infoAbout.show();
    }

    /**
     * Cierra la aplicación
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }  
}