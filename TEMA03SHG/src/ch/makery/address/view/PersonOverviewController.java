package ch.makery.address.view;

import ch.makery.address.Main;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

	// TODO Versión con map
	/*@FXML
    private TableView<Map<String,Object>> personTable;
    @FXML
    private TableColumn<Map<String,Object>, String> firstNameColumn;
    @FXML
    private TableColumn<Map<String,Object>, String> lastNameColumn;*/
	
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Referencia a la aplicación principal
    private Main mainApp;
    
    /**
     * Método para inicializar el controlador que se llama cuando se carga el FXML
     */
    @FXML
    private void initialize() {
    	// Se inicializan las columnas firstName y lastName
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	
      	// TODO Versión con map 
    	// Se crea un objecto que herede de ObservableValue
    	/*firstNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("firstName").toString()));
    	lastNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get("lastName").toString()));*/
        
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
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        personTable.setItems(this.mainApp.getPersonData());
               
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
    
    /**
     * Rellena todos los campos para mostrar información detallada de una persona
     * Si el parámero es nulo, entonces se rellenan en blanco
     * 
     * @param person o null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
        	// Si el campo contiene datos, entonces se rellena la información
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }
    
    /**
     * Se llama cuando el usuario hace click en el botón "Delete"
     */
    @FXML
    private void handleDeletePerson(ActionEvent event) {
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
    
    /**
     * Se llama cuando el usuario hace click en el botón nuevo 
     * Se añade una nueva persona a la tabla
     */
    @FXML
    private void handleNewPerson(ActionEvent event) {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }       
    }

    /**
     * Se llama cuando el usuario hace click en el botón editar
     * Se modifica la persona seleccionada
     */
    @FXML
    private void handleEditPerson(ActionEvent event) {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
        	// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Error al editar persona");
    		errorAlert.setHeaderText("No se ha seleccionado ninguna fila");
    		errorAlert.setContentText("Por favor, selecciona una persona en la tabla");
    		
    		errorAlert.showAndWait();
        }
    }
}