package ch.makery.address.view;


import java.util.ResourceBundle;

import ch.makery.address.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddMoviesOverviewController  {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextField descriptionText;

	@FXML
	private TextField directorText;

	@FXML
	private TableColumn<Movie, String> titleColumn;
	
	@FXML
	private TableColumn<Movie, String> genderColumn;

	@FXML
	private TableColumn<Movie, Integer> yearColumn;

	@FXML
	private TextField genderText;

	@FXML
	private TableView<Movie> movieTable;

	@FXML
	private TextField titleText;

	@FXML
	private TextField yearText;

	@FXML
	void addMovie(ActionEvent event) {

	}

	@FXML
	void eliminarMovie(ActionEvent event) {

	}

	@FXML
	void modificarMovie(ActionEvent event) {

	}

	 private ObservableList<Movie> movies = FXCollections.observableArrayList(
	    	    new Movie("Scary Movie", "Comedia", 1997),
	    	    new Movie("Scary Movie", "Comedia", 1997),
	    	    new Movie("Scary Movie", "Comedia", 1997)
	    	
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
