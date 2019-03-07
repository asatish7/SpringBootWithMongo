package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Movie extends Entertainment {
	@Id
	Object movieId;
	String movieName;
	String movieDescription;
	List<String> theatre;

	public Movie() {
		super();
	}
	
	public Movie(Object id, Date dateOfRelease, Caste caste, int rating, double duration, Object movieId,
			String movieName, String movieDescription, List<String> theatre, EntertainmentType type) {
		super(id, dateOfRelease, caste, rating, duration,EntertainmentType.MOVIES);
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.theatre = theatre;
	}

	public Object getMovieId() {
		return movieId;
	}

	public void setMovieId(Object movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public List<String> getTheatre() {
		return theatre;
	}

	public void setTheatre(List<String> theatre) {
		this.theatre = theatre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((movieDescription == null) ? 0 : movieDescription.hashCode());
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
		result = prime * result + ((theatre == null) ? 0 : theatre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (movieDescription == null) {
			if (other.movieDescription != null)
				return false;
		} else if (!movieDescription.equals(other.movieDescription))
			return false;
		if (movieId == null) {
			if (other.movieId != null)
				return false;
		} else if (!movieId.equals(other.movieId))
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (theatre == null) {
			if (other.theatre != null)
				return false;
		} else if (!theatre.equals(other.theatre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ ", theatre=" + theatre + ", Id=" + Id + ", dateOfRelease=" + dateOfRelease + ", caste=" + caste
				+ ", rating=" + rating + ", duration=" + duration + ", etertainmentType=" + etertainmentType + "]";
	}

}
