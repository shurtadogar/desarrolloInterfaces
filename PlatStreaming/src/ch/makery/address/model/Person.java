package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase modelo para ejercicios.
 *
 */
public class Person {
	private final StringProperty name;
	private final StringProperty surname;
	private final StringProperty city;
	private final StringProperty country;
	private final StringProperty email;
	private final StringProperty password;
	private final IntegerProperty postalCode;

	/**
	 * Constructor por defecto
	 */
	public Person() {
		this(null, null);
	}

	/**
	 * Constructor con nombre y primer apellido
	 * 
	 * @param name
	 * @param surname
	 */
	public Person(String name, String surname) {
		this.name = new SimpleStringProperty(name);
		this.surname = new SimpleStringProperty(surname);
		// Dummy data para inicializar otros campos
		this.city = new SimpleStringProperty("some city");
		this.country = new SimpleStringProperty("some city");
		this.email = new SimpleStringProperty(name+"@gmail.com");
		this.password = new SimpleStringProperty("1234");
		this.postalCode = new SimpleIntegerProperty(1234);
	}

	public StringProperty getName() {
		return name;
	}

	public StringProperty getSurname() {
		return surname;
	}

	public StringProperty getCity() {
		return city;
	}

	public StringProperty getCountry() {
		return country;
	}

	public StringProperty getEmail() {
		return email;
	}

	public StringProperty getPassword() {
		return password;
	}

	public IntegerProperty getPostalCode() {
		return postalCode;
	}
}