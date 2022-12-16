package ch.makery.address.view;

import java.util.ResourceBundle;

import ch.makery.address.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MoviesOverviewController  {
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextArea descriptionLabel;

    @FXML
    private Label directorLabel;
    
    @FXML
    private Label genderLabel;
    
    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;
    
    @FXML
    private TableView<Movie> moviesTable;

    @FXML
    private TableColumn<Movie, String> genderColumn;

    @FXML
    private TableColumn<Movie, String> titleColumn;

	@FXML
    private TreeView<String> listMovies;

	private ObservableList<Movie> movies = FXCollections.observableArrayList(
			new Movie("Scary Movie", "Comedia","A group of hapless teens harboring a guilty secret are stalked by an equally bumbling serial killer in this parody of 1990s horror movies.", 2000, "Keenen Ivory Wayans"),
			new Movie("Fast and Furious", "Accion", "Una misteriosa banda de delincuentes se dedica a robar camiones en marcha desde vehículos deportivos.", 2001, "Rob Cohen"),
			new Movie("Expediente Warren", "Terror", "Basada en una historia real documentada por los reputados demonólogos Ed y Lorraine Warren.", 2013, "Michael Chaves")

			);
	
	/**
     * Rellena todos los campos para mostrar información detallada de una persona
     * Si el parámero es nulo, entonces se rellenan en blanco
     * 
     * @param person o null
     */
    private void showMovieDetails(Movie mov) {
        if (mov != null) {
        	// Si el campo contiene datos, entonces se rellena la información
        	titleLabel.setText(mov.getTitle());
        	genderLabel.setText(mov.getGender());
        	descriptionLabel.setText(mov.getDescription());
        	yearLabel.setText(Integer.toString(mov.getYear()));
        	directorLabel.setText(mov.getDirector());
        } else {
            // Person is null, remove all the text.
        	titleLabel.setText("");
        	genderLabel.setText("");
        	descriptionLabel.setText("");
        	yearLabel.setText("");
        	directorLabel.setText("");
        }
    }
	
	@FXML
	void initialize() {		
		
		this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    	this.genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
    	
    	// Se rellena la tabla con objetos de la clase Person
    	moviesTable.setItems(movies); 
    	
        // Inicializa en blanco los detalles de una persona
        showMovieDetails(null);
        
        // Se añade un manejador para que cuando se seleccione una fila de la tabla
        // se muestren sus datos a la derecha
        moviesTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMovieDetails(newValue)); 
	}
}
