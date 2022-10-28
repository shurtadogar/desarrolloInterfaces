package ch.makery.address.model;

import java.util.Objects;

public class Person {
	private String firstName;
	private String lastName;
	private String city;
	private String country;
	private String email;
	private String password;
	private String postalCode;
	
	
	public Person(String firstName, String lastName, String city, String country, String email, String password,
			String postalCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.country = country;
		this.email = email;
		this.password = password;
		this.postalCode = postalCode;
	}
	
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPostalCode() {
		return postalCode;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", country=" + country + ", email="
				+ email + ", password=" + password + ", postalCode=" + postalCode + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, city, country, email, password, postalCode);
	}
	
}