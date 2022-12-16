package ch.makery.address.view;

import java.util.List;

import ch.makery.address.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class GraficosController {
	private Stage dialogStage;

	@FXML
	private BarChart<String, Integer> barChart;

	@FXML
	private PieChart pieChart;

	@FXML
	private CategoryAxis xAxis;
	
	private ObservableList<String> countryNames = FXCollections.observableArrayList(PersonOverviewController.getCountryData());
	
	@FXML
	private void initialize() {
		// Se asignan los nombres de meses en el eje horizontal
		xAxis.setCategories(countryNames);
		
	}

	public void setPersonData(List<Persona> persons) {
		
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
