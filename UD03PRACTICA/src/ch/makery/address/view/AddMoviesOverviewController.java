package ch.makery.address.view;


import java.util.ResourceBundle;

import ch.makery.address.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddMoviesOverviewController  {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TableView<Movie> movieTable;

	@FXML
	private TableColumn<Movie, String> titleColumn;

	@FXML
	private TableColumn<Movie, String> genderColumn;

	@FXML
	private TableColumn<Movie, Integer> yearColumn;

	@FXML
	private TextField genderText;

	@FXML
	private TextField titleText;

	@FXML
	private TextField yearText;

	@FXML
	private TextField descriptionText;

	@FXML
	private TextField directorText;

	@FXML
	void addMovie(ActionEvent event) {
		String title = this.titleText.getText();
		String gender = this.genderText.getText();
		String description = this.descriptionText.getText();
		Integer year =  Integer.parseInt(this.yearText.getText());
		String director = this.directorText.getText();

		Movie mov = new Movie(title, gender, description, year, director);

		if(!this.movies.contains(mov)) {
			this.movies.add(mov);
			this.movieTable.setItems(movies);
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
	void eliminarMovie(ActionEvent event) {
		int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();
    	
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
    				movieTable.getItems().remove(selectedIndex);
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
	void modificarMovie(ActionEvent event) {

	}

	private ObservableList<Movie> movies = FXCollections.observableArrayList(
			new Movie("Scary Movie", "Comedia", 2000),
			new Movie("Fast and Furious", "Accion", 2001),
			new Movie("Expediente Warren", "Terror", 2013)

			);

	/**
	 * Método para inicializar el controlador que se llama cuando se carga el FXML
	 */
	@FXML
	private void initialize() {   	

		this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		this.genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
		this.yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

		// Se rellena la tabla con objetos de la clase Person
		movieTable.setItems(movies); 

	}

}
