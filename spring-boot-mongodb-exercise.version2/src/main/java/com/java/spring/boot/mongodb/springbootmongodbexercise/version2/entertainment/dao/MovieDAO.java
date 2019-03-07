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
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Movie;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.exceptions.InvalidEntertainmentResource;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository.MovieRepository;

@Component
public class MovieDAO {
	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public Movie addNewMovie(Movie movie) {

		if (movie.getId() == null) {
			int entertainmentId = movieRepository.findAll().stream().map(s -> (Integer) s.getId()).reduce(Integer::max)
					.get() + 1;
			movie.setId(entertainmentId);
		}
		if (movie.getMovieId() == null) {
			int movieId = movieRepository.findAll().stream().map(s -> (Integer) s.getMovieId()).reduce(Integer::max)
					.get() + 1;
			movie.setMovieId(movieId);
		}
		movieRepository.save(movie);
		return movie;
	}

	
	public Movie updateMovieDetails(Movie updateMovie) {
		if (updateMovie == null || updateMovie.getMovieId() == null) {
			throw new InvalidEntertainmentResource("updateMovie id should not be null");
		}
		if (searchByMovieId(updateMovie.getMovieId()) != null) {
			return addNewMovie(updateMovie);
		} else {
			throw new InvalidEntertainmentResource(
					"Update failed, No records found for movieId" + updateMovie.getMovieId());
		}
	}

	public Comment addCommentsForMovie(Comment comment) {
		Object movieId = comment.getId();
		Movie movie = searchByMovieId(movieId);
		if (movie != null) {
			List<Comment> commentList = movie.getComments().getOrDefault(comment.getUserName(), new ArrayList<>());
			commentList.add(comment);
			movie.getComments().put(comment.getUserName(), commentList);
			updateMovieDetails(movie);
		} else {
			throw new RuntimeException("Comments was not added, No Movie exists for give movie Id " + comment.getId());
		}
		return comment;
	}

	public List<Movie> searchMoviesByIdOrName(Object movieId, String movieName) {

		List<Movie> resultList = new ArrayList<>();
		// check with movie id
		if (movieId != null) {
			resultList.add(searchByMovieId(movieId));
			return resultList;
		}
		// search by movie name
		else {
			resultList = movieRepository.findByMovieName(movieName);
			return resultList;
		}
	}

	private Movie searchByMovieId(Object movieId) {
		Movie movie = null;
		Optional<Movie> movieResult = Optional.ofNullable(movie);
		movieResult = movieRepository.findById(movieId);
		if (movieResult.isPresent()) {
			return movieResult.get();
		}
		return null;
	}

	public List<Entertainment> searchByOtherMovieCriterias(String actor, String producer, String director,
			Date dateOfRelease) {
		
		List<Movie> movies = movieRepository.findAll();
		if(movies!=null && movies.size()>0) {
		if (!StringUtils.isEmpty(actor))
			return searchMoviesByActor(actor, movies);
		if (!StringUtils.isEmpty(director))
			return searchMoviesByDirector(director, movies);
		if (!StringUtils.isEmpty(producer))
			return searchMoviesByProducer(producer, movies);
		if (dateOfRelease != null)
			return searchMoviesByReleaseDate(dateOfRelease, movies);
		}
		return new ArrayList<>();
	}

	public List<Entertainment> searchMoviesByActor(String actor, List<Movie> repoMovieList) {
		return Arrays.asList(
				repoMovieList.stream().filter(m -> m.getCaste().getActors().contains(actor)).toArray(Movie[]::new));
	}

	public List<Entertainment> searchMoviesByProducer(String producer, List<Movie> repoMovieList) {
		return Arrays.asList(repoMovieList.stream().filter(m -> m.getCaste().getProducers().contains(producer))
				.toArray(Movie[]::new));
	}

	public List<Entertainment> searchMoviesByDirector(String director, List<Movie> repoMovieList) {
		return Arrays.asList(repoMovieList.stream().filter(m -> m.getCaste().getDirectors().contains(director))
				.toArray(Movie[]::new));

	}

	public List<Entertainment> searchMoviesByReleaseDate(Date date, List<Movie> repoMovieList) {
		return Arrays
				.asList(repoMovieList.stream().filter(m -> m.getDateOfRelease().equals(date)).toArray(Movie[]::new));
		

	}

}
