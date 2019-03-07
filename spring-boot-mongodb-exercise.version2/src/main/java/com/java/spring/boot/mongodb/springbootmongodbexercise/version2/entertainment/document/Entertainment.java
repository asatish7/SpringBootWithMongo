package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Entertainment {
	//@Id
	Object Id;
	Date dateOfRelease;
	Caste caste;
	int rating;
	double duration;
	EntertainmentType etertainmentType;
	Map<String,List<Comment>> comments = new HashMap<>();
	
	public Entertainment() {
		super();
		
	}

	public Entertainment(Object id, Date dateOfRelease, Caste caste, int rating, double duration, EntertainmentType etertainmentType) {
		super();
		Id = id;
		this.dateOfRelease = dateOfRelease;
		this.caste = caste;
		this.rating = rating;
		this.duration = duration;
		this.etertainmentType = etertainmentType;
		
		
	}

	public Object getId() {
		return Id;
	}

	public void setId(Object id) {
		Id = id;
	}

	public Date getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	public Caste getCaste() {
		return caste;
	}

	public void setCaste(Caste caste) {
		this.caste = caste;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public EntertainmentType getEtertainmentType() {
		return etertainmentType;
	}

	public void setEtertainmentType(EntertainmentType etertainmentType) {
		this.etertainmentType = etertainmentType;
	}

	
	
	public Map<String, List<Comment>> getComments() {
		return comments;
	}

	public void setComments(Map<String, List<Comment>> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((caste == null) ? 0 : caste.hashCode());
		result = prime * result + ((dateOfRelease == null) ? 0 : dateOfRelease.hashCode());
		long temp;
		temp = Double.doubleToLongBits(duration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rating;
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
		Entertainment other = (Entertainment) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (caste == null) {
			if (other.caste != null)
				return false;
		} else if (!caste.equals(other.caste))
			return false;
		if (dateOfRelease == null) {
			if (other.dateOfRelease != null)
				return false;
		} else if (!dateOfRelease.equals(other.dateOfRelease))
			return false;
		if (Double.doubleToLongBits(duration) != Double.doubleToLongBits(other.duration))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entertainment [Id=" + Id + ", dateOfRelease=" + dateOfRelease + ", caste=" + caste + ", rating="
				+ rating + ", duration=" + duration + ", etertainmentType=" + etertainmentType + "]";
	}

	
	
}
