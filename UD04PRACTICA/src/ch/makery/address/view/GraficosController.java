package ch.makery.address.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.makery.address.model.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
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
	private ObservableList<Persona> listPersons = FXCollections.observableArrayList(PersonOverviewController.getUsersData());
	
	@FXML
	private void initialize() {
        
        // Assign the month names as categories for the horizontal axis.
        xAxis.setCategories(countryNames);
	}

    public void setPersonData(List<Persona> listPersons) {
    	Map<String, Integer> frequencyMap = new HashMap<>();
        for (Persona p : listPersons) {
        	Integer count = frequencyMap.get(p.getCountry());
            if (count == null) {
                count = 0;
            }
            frequencyMap.put(p.getCountry(), count + 1);
        }

        Series<String, Integer> series = new Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
        	series.getData().add(new XYChart.Data<>(entry.getKey() , entry.getValue()));
        }
        
        barChart.getData().add(series);
    }
    
	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

}
