package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Comment;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Entertainment;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.EntertainmentType;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Movie;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.SearchFields;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.SearchResults;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.TVShow;

@Component
public class EntertainmentDAO {
	public static String MOVIE_SEARCH_MESSAGE = " : Records found for Movies: ";
	public static String TV_SHOW_SEARCH_MESSAGE = " : Records found for TV Shows: ";
	public static String ALL_SEARCH_MESSAGE = " : Records found Search Details are: ";
	public static String NOT_FOUND_MESSAGE = "No Search results found for search criteria";

	@Autowired
	MovieDAO moviesService;
	@Autowired
	TVShowDAO tvShowService;

	public SearchResults searchForEntertainmentItem(SearchFields searchFields) {
		String message = null;
		List<Entertainment> result = new ArrayList<>();
		if (searchFields == null) {
			message = "No items to search as all search fields are empty";
			return new SearchResults(message, null);
		}
		//If client nows which category to search then search for movie id, movie name
		if (searchFields.getMovieId() != null || searchFields.getMovieName() != null) {
			result.addAll(moviesService.searchMoviesByIdOrName(searchFields.getMovieId(), searchFields.getMovieName()));
			return new SearchResults(result.size()+MOVIE_SEARCH_MESSAGE, result);
		//If client nows which category to search then search for show id, show name
		} else if (searchFields.getShowId() != null || searchFields.getShowName() != null) {
			result.addAll(tvShowService.searchShowByIdOrName(searchFields.getShowId(), searchFields.getShowName()));
			return new SearchResults(result.size()+TV_SHOW_SEARCH_MESSAGE, result);
		} 
		//If client is not sure about category and wants to search by common criteria in both category
		else {
			result.addAll(moviesService.searchByOtherMovieCriterias(searchFields.getActor(), searchFields.getProducer(),
					searchFields.getDirector(), searchFields.getDateOfRelease()));
			result.addAll(tvShowService.searchByOtherTVShowCriterias(searchFields.getActor(),
					searchFields.getProducer(), searchFields.getDirector(), searchFields.getDateOfRelease()));
			if(result.size()>0)
				return new SearchResults(result.size()+ALL_SEARCH_MESSAGE, result);
			return new SearchResults(NOT_FOUND_MESSAGE, result);
		}

	}


	public List<Movie> getAllMovies() {
		return moviesService.getAllMovies();
	}

	public Movie addNewMovie(Movie movie) {
		return moviesService.addNewMovie(movie);
	}

	public Movie updateMovie(Movie movie) {
		return moviesService.updateMovieDetails(movie);
	}

	public Comment addMovieComment(Comment comment) {
		return moviesService.addCommentsForMovie(comment);
	}

	public List<TVShow> getAllTVShows() {
		return tvShowService.getAllTVShows();
	}

	public TVShow addNewTVShow(TVShow show) {
		return tvShowService.addNewTVShow(show);
	}

	public TVShow updateTVShow(TVShow tvShow) {
		return tvShowService.updateTVShowDetails(tvShow);
	}

	public Comment addTVSowComment(Comment comment) {
		return tvShowService.addCommentsForShow(comment);
	}

}
