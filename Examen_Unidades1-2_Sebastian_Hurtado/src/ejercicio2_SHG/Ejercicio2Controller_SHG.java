package ejercicio2_SHG;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Ejercicio2Controller_SHG {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TreeView<String> almacenamientoTree;

    @FXML
    private TableColumn<Producto, String> descripColumn;

    @FXML
    private TreeView<String> hardwareView;

    @FXML
    private TableColumn<Producto, String> idColumn;

    @FXML
    private ComboBox<String> productComboBox;

    @FXML
    private TableView<Producto> tablaProductos;
    
    
    private ObservableList<String> productosList = FXCollections.observableArrayList();
      
    @FXML
    void initialize() {
    	
    	// Ítem raíz del TreeView que se expande por defecto
    	TreeItem<String> rootItem = new TreeItem<String>("Hardware");
    	rootItem.setExpanded(true);   
    	
    	rootItem.getChildren().add(new TreeItem<String>("Monitor"));
    	rootItem.getChildren().add(new TreeItem<String>("Tarjeta grafica"));
    	rootItem.getChildren().add(new TreeItem<String>("Fuente de alimentación"));
    	rootItem.getChildren().add(new TreeItem<String>("Refrigeración Liquida"));
    	
    	// Ítem raíz del TreeView que se expande por defecto
    	TreeItem<String> rootItem2 = new TreeItem<String>("Almacenamiento");
    	rootItem.setExpanded(true);   
    	
    	rootItem2.getChildren().add(new TreeItem<String>("Disco Duro SSD"));
    	rootItem2.getChildren().add(new TreeItem<String>("Memoria RAM"));
    	
    	// Se asigna el ítem raíz al TreeView
    	hardwareView.setRoot(rootItem);
    	almacenamientoTree.setRoot(rootItem2);
        
        productosList.addAll("Monitor", "Tarjeta grafica", "Disco duro SSD", "Refrigeración Liquida", "Fuente de alimentación", "Memoria RAM");
        
        // Lista indeterminada donde cada item se obtiene de un ComboBox
        productComboBox.setItems(productosList); 

        // Asignamos columnas y datos de la tabla
    	// Se inicializan las cuatro columnas
        idColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("id"));
        descripColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));
        
     // Se añaden los alumno a la tabla
    	tablaProductos.getItems().addAll(new Producto(1, "Monitor"),
    			new Producto(2, "Tarjeta grafica"),
    			new Producto(3, "Disco duro SSD"));
    }
}
