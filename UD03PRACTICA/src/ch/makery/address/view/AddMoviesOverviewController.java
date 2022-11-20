package ch.makery.address.view;


import java.util.ResourceBundle;

import ch.makery.address.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

	private ObservableList<Movie> movies = FXCollections.observableArrayList(
			new Movie("Scary Movie", "Comedia", 2000),
			new Movie("Fast and Furious", "Accion", 2001),
			new Movie("Expediente Warren", "Terror", 2013)

			);

	@FXML
	private void initialize() {   	

		this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		this.genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
		this.yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

		// Se rellena la tabla con objetos de la clase Person
		movieTable.setItems(movies); 

		// Inicializa en blanco los detalles de una persona
		showMovieDetails(null);

		// Se añade un manejador para que cuando se seleccione una fila de la tabla
		// se muestren sus datos a la derecha
		movieTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> showMovieDetails(newValue)); 

	}

	private void showMovieDetails(Movie mov) {
		if (mov != null) {
			// Si el campo contiene datos, entonces se rellena la información
			titleText.setText(mov.getTitle());
			genderText.setText(mov.getGender());
			descriptionText.setText(mov.getDescription());
			directorText.setText(mov.getDirector());
			yearText.setText(Integer.toString(mov.getYear()));

		} else {
			titleText.setText("");
			genderText.setText("");
			descriptionText.setText("");
			directorText.setText("");
			yearText.setText("");
		}
	}

	@FXML
	private void addMovie(ActionEvent event) {
		try {
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
		} catch (NumberFormatException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al añadir");
			alert.setContentText("Formato de año incorrecto");
			alert.showAndWait();
		}
	}



	@FXML
	private void modificarMovie(ActionEvent event) {
		Movie mov = this.movieTable.getSelectionModel().getSelectedItem();
		if (mov == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al modificar");
			alert.setContentText("No se puede modificar porque no ha seleccionado una fila o la tabla está vacía");
			alert.showAndWait();
		}
		else {
			try {
				String title = this.titleText.getText();
				String gender = this.genderText.getText();
				String description = this.descriptionText.getText();
				Integer year =  Integer.parseInt(this.yearText.getText());
				String director = this.directorText.getText();

				Movie aux = new Movie(title, gender, description, year, director);

				if(!this.movies.contains(aux)) {
					mov.setTitle(title);
					mov.setGender(gender);
					mov.setDescription(description);
					mov.setYear(year);
					mov.setDirector(director);

					this.movieTable.refresh();

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Persona modificada");
					alert.setContentText("Se ha modificado una pelicula en la tabla");
					alert.showAndWait();
				} else {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error al añadir");
					alert.setContentText("La pelicula ya existe en la tabla");
					alert.showAndWait();
				}		
			} catch (NumberFormatException e) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error al añadir");
				alert.setContentText("Formato de año incorrecto");
				alert.showAndWait();
			}	
		}
	}

	@FXML
	private void eliminarMovie(ActionEvent event) {
		int selectedIndex = movieTable.getSelectionModel().getSelectedIndex();

		// Si no hay ningún campo seleccionado, se muestra un alert
		if (selectedIndex >= 0) {
			// Si se ha seleccionado una fila, se muestra un pop up de confirmación
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Confirmación para eliminar");
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

}
