package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie {
	private final StringProperty title;
	private final StringProperty gender;
	private final StringProperty description;
	private final IntegerProperty year;
	private final StringProperty director;
	
	
	/**
	 * Constructor por defecto
	 */
	public Movie() {
		this(null, null);
	}

	/**
	 * Constructor con nombre y primer apellido
	 * 
	 * @param name
	 * @param surname
	 */
	public Movie(String title, String gender) {
		this.title = new SimpleStringProperty(title);
		this.gender = new SimpleStringProperty(gender);
		// Dummy data para inicializar otros campos
		this.description = new SimpleStringProperty("some description");
		this.year = new SimpleIntegerProperty(2000);
		this.director = new SimpleStringProperty("some director");
	}

	public StringProperty getTitle() {
		return title;
	}

	public StringProperty getGender() {
		return gender;
	}

	public StringProperty getDescription() {
		return description;
	}

	public IntegerProperty getYear() {
		return year;
	}

	public StringProperty getDirector() {
		return director;
	}
	
	public StringProperty titleProperty() {
		return title;
	}
	
	public StringProperty genderProperty() {
		return gender;
	}
	
	public StringProperty descriptionProperty() {
		return description;
	}
	
	public IntegerProperty yearCodeProperty() {
		return year;
	}
	
	public StringProperty directorProperty() {
		return director;
	}
	
	
	
}
