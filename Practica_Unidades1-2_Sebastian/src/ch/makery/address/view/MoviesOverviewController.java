package ch.makery.address.view;


import java.util.ResourceBundle;
import javax.print.DocFlavor.URL;
import ch.makery.address.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MoviesOverviewController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Movie, String> genderColumn;

    @FXML
    private TableView<Movie> movieTable;

    @FXML
    private TableColumn<Movie, String> titleColumn;

    @FXML
    private TextField titleText;
    
    @FXML
    private TextField genderText;
    
    @FXML
    private TextField descriptionText;

    @FXML
    private TextField directorText;

    @FXML
    private TextField yearText;
    
    private ObservableList<Movie> movies = FXCollections.observableArrayList();
	/**
	 * Método para inicializar el controlador que se llama cuando se carga el FXML
	 */
	@FXML
	private void initialize() {   	
		
		 // Asignamos columnas y datos de la tabla
    	// Se inicializan las cuatro columnas
		titleColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<Movie, String>("gender"));
		
		// Se añaden los alumno a la tabla
		movieTable.getItems().addAll(new Movie("Scary Movie", "Comedia"),
    			new Movie("Fast and Furious", "Acción"),
    			new Movie("Expediente Warren", "Terror"));

	}

	
	@FXML
	private void addMovie(ActionEvent event) {

		try {

			// Obtengo los datos del formulario
			String title = this.titleText.getText();
			String gender = this.genderText.getText();

			// Creo una movie
			Movie mov = new Movie(title, gender);

			// Compruebo si la movie esta en el lista
			if (!this.movies.contains(mov)) {
				// Lo añado a la lista
				this.movies.add(mov);
				// Seteo los items
				this.movieTable.setItems(movies);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("movie añadida");
				alert.showAndWait();
			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("La movie existe");
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
	private void seleccionarMovie(MouseEvent event) {

		// Obtengo la movie seleccionada
		Movie mov = this.movieTable.getSelectionModel().getSelectedItem();

		// Sino es nula seteo los campos
		if (mov != null) {
			this.titleText.setText(mov.getTitle());
			this.genderText.setText(mov.getGender());
		}

	}

	@FXML
	private void modificarMovie(ActionEvent event) {

		// Obtengo la movie seleccionada
		Movie mov = this.movieTable.getSelectionModel().getSelectedItem();

		// Si la movie es nula, lanzo error
		if (mov == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar una movie");
			alert.showAndWait();
		} else {

			try {
				// Obtengo los datos del formulario
				String title = this.titleText.getText();
				String gender = this.genderText.getText();

				// Creo una movie
				Movie aux = new Movie(title, gender);

				// Compruebo si la movie esta en el lista
				if (!this.movies.contains(aux)) {

					// Modifico el objeto
					mov.setTitle(aux.getTitle());
					mov.setGender(aux.getGender());

					// Refresco la tabla
					this.movieTable.refresh();

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Info");
					alert.setContentText("movie modificada");
					alert.showAndWait();

				} else {

					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("La movie existe");
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
	private void eliminarMovie(ActionEvent event) {

		// Obtengo la movie seleccionada
		Movie mov = this.movieTable.getSelectionModel().getSelectedItem();

		// Si la movie es nula, lanzo error
		if (mov == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar una movie");
			alert.showAndWait();
		} else {

			// La elimino de la lista
			this.movies.remove(mov);
			// Refresco la lista
			this.movieTable.refresh();

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("movie eliminada");
			alert.showAndWait();

		}

	}

}
