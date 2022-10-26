package ch.makery.address.view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.print.DocFlavor.URL;

import ch.makery.address.Main;
import ch.makery.address.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MoviesOverviewController  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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

		this.titleColumn.setCellValueFactory(new PropertyValueFactory("title"));
		this.genderColumn.setCellValueFactory(new PropertyValueFactory("gender"));

	}

	@FXML
	private void addMovie(ActionEvent event) {

		try {

			// Obtengo los datos del formulario
			String title = this.txtNombre.getText();
			String gender = this.txtApellidos.getText();

			// Creo una persona
			Movie mov = new Movie(title, gender);

			// Compruebo si la persona esta en el lista
			if (!this.movies.contains(p)) {
				// Lo añado a la lista
				this.movies.add(p);
				// Seteo los items
				this.movieTable.setItems(movies);

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Info");
				alert.setContentText("Persona añadida");
				alert.showAndWait();
			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setHeaderText(null);
				alert.setTitle("Error");
				alert.setContentText("La persona existe");
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
	private void seleccionar(MouseEvent event) {

		// Obtengo la persona seleccionada
		Movie mov = this.movieTable.getSelectionModel().getSelectedItem();

		// Sino es nula seteo los campos
		if (p != null) {
			this.txtNombre.setText(p.getNombre());
			this.txtApellidos.setText(p.getApellidos());
			this.txtEdad.setText(p.getEdad() + "");
		}

	}

	@FXML
	private void modificar(ActionEvent event) {

		// Obtengo la persona seleccionada
		Movie mov = this.movieTable.getSelectionModel().getSelectedItem();

		// Si la persona es nula, lanzo error
		if (mov == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar una persona");
			alert.showAndWait();
		} else {

			try {
				// Obtengo los datos del formulario
				String title = this.txtNombre.getText();
				String gender = this.txtApellidos.getText();

				// Creo una persona
				Movie aux = new Movie(nombre, apellidos, edad);

				// Compruebo si la persona esta en el lista
				if (!this.movies.contains(aux)) {

					// Modifico el objeto
					mov.setNombre(aux.getNombre());
					mov.setApellidos(aux.getApellidos());

					// Refresco la tabla
					this.movieTable.refresh();

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setHeaderText(null);
					alert.setTitle("Info");
					alert.setContentText("Persona modificada");
					alert.showAndWait();

				} else {

					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setHeaderText(null);
					alert.setTitle("Error");
					alert.setContentText("La persona existe");
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
	private void eliminar(ActionEvent event) {

		// Obtengo la persona seleccionada
		Movie mov = this.movieTable.getSelectionModel().getSelectedItem();

		// Si la persona es nula, lanzo error
		if (mov == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error");
			alert.setContentText("Debes seleccionar una persona");
			alert.showAndWait();
		} else {

			// La elimino de la lista
			this.movies.remove(mov);
			// Refresco la lista
			this.movieTable.refresh();

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setTitle("Info");
			alert.setContentText("Persona eliminada");
			alert.showAndWait();

		}

	}

}
