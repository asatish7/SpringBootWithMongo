package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TVShow extends Entertainment {
	
	@Id
	Object showId;
	String showName;
	String showDescription;
	List<String> channels;

	public TVShow() {
	}

	public TVShow(Object id, Date dateOfRelease, Caste caste, int rating, double duration, Object showId,
			String showName, String showDescription, List<String> channels, EntertainmentType type) {
		super(id, dateOfRelease, caste, rating, duration, EntertainmentType.TV_SHOWS);
		this.showId = showId;
		this.showName = showName;
		this.showDescription = showDescription;
		this.channels = channels;
	}

	public Object getShowId() {
		return showId;
	}

	public void setShowId(Object showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getShowDescription() {
		return showDescription;
	}

	public void setShowDescription(String showDescription) {
		this.showDescription = showDescription;
	}

	public List<String> getChannels() {
		return channels;
	}

	public void setChannels(List<String> channels) {
		this.channels = channels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((channels == null) ? 0 : channels.hashCode());
		result = prime * result + ((showDescription == null) ? 0 : showDescription.hashCode());
		result = prime * result + ((showId == null) ? 0 : showId.hashCode());
		result = prime * result + ((showName == null) ? 0 : showName.hashCode());
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
		TVShow other = (TVShow) obj;
		if (channels == null) {
			if (other.channels != null)
				return false;
		} else if (!channels.equals(other.channels))
			return false;
		if (showDescription == null) {
			if (other.showDescription != null)
				return false;
		} else if (!showDescription.equals(other.showDescription))
			return false;
		if (showId == null) {
			if (other.showId != null)
				return false;
		} else if (!showId.equals(other.showId))
			return false;
		if (showName == null) {
			if (other.showName != null)
				return false;
		} else if (!showName.equals(other.showName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TVShow [showId=" + showId + ", showName=" + showName + ", showDescription=" + showDescription
				+ ", channels=" + channels + ", Id=" + Id + ", dateOfRelease=" + dateOfRelease + ", caste=" + caste
				+ ", rating=" + rating + ", duration=" + duration + ", etertainmentType=" + etertainmentType + "]";
	}

}
