package ch.makery.address.model;

import java.util.Objects;

public class Person {
	private String firstName;
	private String lastName;
	private String country;
	private String city;
	private String email;
	private String password;
	private Integer postalCode;
	
	
	public Person(String firstName, String lastName, String country, String city, String email, String password,
			Integer postalCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.city = city;
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

	public String getCountry() {
		return country;
	}
	
	public String getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Integer getPostalCode() {
		return postalCode;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPostalCode(Integer postalCode) {
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