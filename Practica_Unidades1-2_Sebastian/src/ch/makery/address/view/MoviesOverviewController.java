package ch.makery.address.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import ch.makery.address.model.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class MoviesOverviewController  {

	@FXML
	private ResourceBundle resources;

	@FXML
    private TreeView<String> listMovies;

	private ObservableList<Movie> movies;
	
	@FXML
	void initialize() {
		
		movies = FXCollections.observableArrayList();
		
		Movie mov1 = new Movie("Scary Movie","Comedia", 1997);
    	Movie mov2 = new Movie("Fast and Furious","Accion", 1997);
    	Movie mov3 = new Movie("Expediente Warren","Terror", 1997);
    	Movie mov4 = new Movie("Spiderman","Accion", 1997);
    	this.movies.add(mov1);
    	this.movies.add(mov2);
    	this.movies.add(mov3);
    	this.movies.add(mov4);
    	
    	// TreeView con icono y 4 ítems
    	TreeItem<String> rootItem = new TreeItem<String> ("Estrenos");
    	rootItem.setExpanded(true);
    	
    	List<String> treeListItems = new ArrayList<String>(Arrays.asList(mov1.getTitle(),mov2.getTitle(),mov3.getTitle(),mov4.getTitle()));
    	
    	// Nodos del TreeView
        for (String item : treeListItems) {
            TreeItem<String> treeItem = new TreeItem<String>(item);            
            rootItem.getChildren().add(treeItem);
        }     
        
        listMovies.setRoot(rootItem);
    	
	}
}
