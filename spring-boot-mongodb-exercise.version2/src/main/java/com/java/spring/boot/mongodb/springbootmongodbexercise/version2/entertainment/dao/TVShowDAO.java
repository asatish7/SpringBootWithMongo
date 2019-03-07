package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Comment;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Entertainment;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.TVShow;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.exceptions.InvalidEntertainmentResource;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository.TVShowRepository;

@Component
public class TVShowDAO {
	@Autowired
	private TVShowRepository tvShowRepository;

	public List<TVShow> getAllTVShows() {
		return tvShowRepository.findAll();
	}

	public TVShow addNewTVShow(TVShow show) {

		if (show.getId() == null) {
			int entertainmentId = tvShowRepository.findAll().stream().map(s -> (Integer) s.getId()).reduce(Integer::max)
					.get() + 1;
			show.setId(entertainmentId);
		}
		if (show.getShowId() == null) {
			int showId = tvShowRepository.findAll().stream().map(s -> (Integer) s.getShowId()).reduce(Integer::max)
					.get() + 1;
			show.setShowId(showId);
		}
		tvShowRepository.save(show);
		return show;
	}

	public TVShow updateTVShowDetails(TVShow updateShow) {
		if (updateShow == null || updateShow.getShowId() == null) {
			throw new InvalidEntertainmentResource("updateShow id should not be null");
		}
		if (searchByShowId(updateShow.getShowId()) != null) {
			return addNewTVShow(updateShow);
		} else {
			throw new InvalidEntertainmentResource(
					"Update failed, No records found for showId" + updateShow.getShowId());
		}
	}
	
	public Comment addCommentsForShow(Comment comment) {
		Object showId = comment.getId();
		TVShow tvShow = searchByShowId(showId);
		if (tvShow != null) {
			List<Comment> commentList = tvShow.getComments().getOrDefault(comment.getUserName(), new ArrayList<>());
			commentList.add(comment);
			tvShow.getComments().put(comment.getUserName(), commentList);
			updateTVShowDetails(tvShow);
		} else {
			throw new RuntimeException("Comments was not added, No TVShow exists for give show Id " + comment.getId());
		}
		return comment;
	}

	public List<TVShow> searchShowByIdOrName(Object tvShowId, String tvShowName) {
		List<TVShow> resultList = new ArrayList<>();
		// check with show id
		if (tvShowId != null) {
			resultList.add(searchByShowId(tvShowId));
			return resultList;
		}
		// search by show name
		else {
			resultList = tvShowRepository.findByShowName(tvShowName);
			return resultList;
		}

	}

	private TVShow searchByShowId(Object showId) {
		TVShow tvShow = null;
		Optional<TVShow> showResult = Optional.ofNullable(tvShow);
		showResult = tvShowRepository.findById(showId);
		if (showResult.isPresent()) {
			return showResult.get();
		}
		return null;
	}

	public List<Entertainment> searchByOtherTVShowCriterias(String actor, String producer, String director,
			Date dateOfRelease) {

		List<TVShow> tvShows = tvShowRepository.findAll();

		if (!StringUtils.isEmpty(actor))
			return searchShowsByActor(actor, tvShows);
		if (!StringUtils.isEmpty(director))
			return searchShowsByDirector(director, tvShows);
		if (!StringUtils.isEmpty(producer))
			return searchShowsByProducer(producer, tvShows);
		if (dateOfRelease != null)
			return searchShowsByReleaseDate(dateOfRelease, tvShows);

		return new ArrayList<>();
	}

	public List<Entertainment> searchShowsByActor(String actor, List<TVShow> repoShowsList) {
		return Arrays.asList(
				repoShowsList.stream().filter(m -> m.getCaste().getActors().contains(actor)).toArray(TVShow[]::new));
	}

	public List<Entertainment> searchShowsByProducer(String producer, List<TVShow> repoShowsList) {
		return Arrays.asList(repoShowsList.stream().filter(m -> m.getCaste().getProducers().contains(producer))
				.toArray(TVShow[]::new));
	}

	public List<Entertainment> searchShowsByDirector(String director, List<TVShow> repoShowsList) {
		return Arrays.asList(repoShowsList.stream().filter(m -> m.getCaste().getDirectors().contains(director))
				.toArray(TVShow[]::new));

	}

	public List<Entertainment> searchShowsByReleaseDate(Date date, List<TVShow> repoShowsList) {
		return Arrays
				.asList(repoShowsList.stream().filter(m -> m.getDateOfRelease().equals(date)).toArray(TVShow[]::new));

	}

}
