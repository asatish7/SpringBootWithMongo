package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

import java.util.ArrayList;
import java.util.List;

public class Caste {
	List<String> actors;
	List<String> producers;
	List<String> directors;


	public Caste() {
		this.actors = new ArrayList<>();
		this.producers = new ArrayList<>();
		this.directors = new ArrayList<>();
	}

	public Caste(List<String> actors, List<String> producers, List<String> directors) {
		this.actors = actors;
		this.producers = producers;
		this.directors = directors;
	}
	
	

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public List<String> getProducers() {
		return producers;
	}

	public void setProducers(List<String> producers) {
		this.producers = producers;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((actors == null) ? 0 : actors.hashCode());
		result = prime * result + ((directors == null) ? 0 : directors.hashCode());
		result = prime * result + ((producers == null) ? 0 : producers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caste other = (Caste) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (directors == null) {
			if (other.directors != null)
				return false;
		} else if (!directors.equals(other.directors))
			return false;
		if (producers == null) {
			if (other.producers != null)
				return false;
		} else if (!producers.equals(other.producers))
			return false;
		return true;
	}

	
}
