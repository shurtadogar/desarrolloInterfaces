package ch.makery.address.view;


import java.util.ResourceBundle;

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

public class MoviesOverviewController  {

	@FXML
	private ResourceBundle resources;

	@FXML
	private TextField descriptionText;

	@FXML
	private TextField directorText;

	@FXML
	private TableColumn<Movie, String> genderColumn;

	@FXML
	private TextField genderText;

	@FXML
	private TableView<Movie> movieTable;

	@FXML
	private TableColumn<Movie, String> titleColumn;

	@FXML
	private TextField titleText;

	@FXML
	private TextField yearText;

	private ObservableList<Movie> movies;

	/**
	 * Método para inicializar el controlador que se llama cuando se carga el FXML
	 */
	@FXML
	private void initialize() {   	

		movies = FXCollections.observableArrayList();
		// Asignamos columnas y datos de la tabla
		// Se inicializan las cuatro columnas
		this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
    	this.genderColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    	
    	Movie pers1 = new Movie("Scary Movie","Comedia");
    	Movie pers2 = new Movie("Fast and Furious","Accion");
    	Movie pers3 = new Movie("Expediente Warren","Terror");
    	Movie pers4 = new Movie("Spiderman","Accion");
    	this.movies.add(pers1);
    	this.movies.add(pers2);
    	this.movies.add(pers3);
    	this.movies.add(pers4);

	}

	@FXML
	void addMovie(ActionEvent event) {
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
	void eliminarMovie(ActionEvent event) {
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

	@FXML
	void modificarMovie(ActionEvent event) {
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
}
