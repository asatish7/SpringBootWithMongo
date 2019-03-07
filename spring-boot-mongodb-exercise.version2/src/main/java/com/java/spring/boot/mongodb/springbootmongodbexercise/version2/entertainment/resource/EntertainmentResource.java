package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.dao.EntertainmentDAO;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Comment;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.EntertainmentType;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Movie;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.SearchFields;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.SearchResults;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.TVShow;

@RestController
@RequestMapping(path = "/entertainment")
public class EntertainmentResource {
	@Autowired
	EntertainmentDAO entertainmentService;

	@GetMapping(path = "/all-movies")
	public List<Movie> listAllMovies() {
		return entertainmentService.getAllMovies();
	}

	@PostMapping(path = "/add-movie")
	public ResponseEntity<Object> addMovie(@RequestBody Movie movie) {
		Movie savedMovie = entertainmentService.addNewMovie(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMovie.getMovieId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/update-movie")
	public ResponseEntity<Object> updateMovie(@RequestBody Movie movie) {
		Movie savedMovie = entertainmentService.updateMovie(movie);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMovie.getMovieId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/add-movie-comment")
	private ResponseEntity<Object> addMovieComment(@RequestBody Comment comment) {
		Comment com = entertainmentService.addMovieComment(comment);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(com.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

//Search for both TVShows and Movies
	@PostMapping(path = "/search")
	private SearchResults searchEntertainmentItem(@RequestBody SearchFields searchFields) {
		return entertainmentService.searchForEntertainmentItem(searchFields);

	}

	@GetMapping(path = "/all-tv-shows")
	public List<TVShow> listAllTVShows() {
		return entertainmentService.getAllTVShows();
	}

	@PostMapping(path = "/add-tv-show")
	public ResponseEntity<Object> addTVShow(@RequestBody TVShow show) {
		TVShow savedMovie = entertainmentService.addNewTVShow(show);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedMovie.getShowId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/update-tv-show")
	public ResponseEntity<Object> updateTVShow(@RequestBody TVShow tvShow) {
		TVShow savedShow = entertainmentService.updateTVShow(tvShow);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedShow.getShowId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(path = "/add-tv-show-comment")
	private ResponseEntity<Object> addTVShowComment(@RequestBody Comment comment) {
		Comment com = entertainmentService.addTVSowComment(comment);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(com.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	// Dummy Objects for easier Json Object creations
	@GetMapping(path = "/comment")
	private Comment testComment() {
		Comment com = new Comment(2, "Abhishek", "Bad Movie");
		return com;

	}

	@GetMapping(path = "/search")
	private SearchFields testSearchFields() {
		SearchFields search = new SearchFields();
		search.setMovieId(1);
		search.setMovieName("Parites of Carrbiean");
		search.setType(EntertainmentType.MOVIES);
		return search;
	}

}
