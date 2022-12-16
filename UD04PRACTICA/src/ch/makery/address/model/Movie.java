package ch.makery.address.model;

import java.util.Objects;

public class Movie {
	private String  title;
	private String  gender;
	private String  description;
	private Integer year;
	private String director;
	
	public Movie(String title, String gender, String description, Integer year, String director) {
		super();
		this.title = title;
		this.gender = gender;
		this.description = description;
		this.year = year;
		this.director = director;
	}
	
	public Movie(String title, String gender, Integer year) {
		super();
		this.title = title;
		this.gender = gender;
		this.description = "some description";
		this.year = year;
		this.director = "some director";
	}

	public String getTitle() {
		return title;
	}

	public String getGender() {
		return gender;
	}

	public String getDescription() {
		return description;
	}

	public Integer getYear() {
		return year;
	}

	public String getDirector() {
		return director;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", gender=" + gender + ", description=" + description + ", year=" + year
				+ ", director=" + director + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(title, gender, description, year, director);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(title, other.title) && Objects.equals(gender, other.gender)
				&& description == other.description && year == other.year
				&& director == other.director;
	}
}
