package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

import java.util.Date;

public class SearchFields {
	Object movieId;
	Object showId;
	String movieName;
	String showName;
	String actor;
	String producer;
	String director;
	Date dateOfRelease;
	EntertainmentType type;

	public SearchFields() {

	}

	public SearchFields(Object movieId, Object showId, String movieName, String showName, String actor, String producer,
			String director, Date dateOfRelease, EntertainmentType type) {
		super();
		this.movieId = movieId;
		this.showId = showId;
		this.movieName = movieName;
		this.showName = showName;
		this.actor = actor;
		this.producer = producer;
		this.director = director;
		this.dateOfRelease = dateOfRelease;
		this.type = type;
	}

	public Object getMovieId() {
		return movieId;
	}

	public void setMovieId(Object movieId) {
		this.movieId = movieId;
	}

	public Object getShowId() {
		return showId;
	}

	public void setShowId(Object showId) {
		this.showId = showId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Date getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	public EntertainmentType getType() {
		return type;
	}

	public void setType(EntertainmentType type) {
		this.type = type;
	}

}
