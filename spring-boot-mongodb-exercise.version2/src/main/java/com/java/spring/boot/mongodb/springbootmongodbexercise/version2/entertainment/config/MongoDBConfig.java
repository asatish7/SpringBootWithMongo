package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Caste;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.EntertainmentType;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Movie;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.TVShow;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository.EntertainmentRepository;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository.MovieRepository;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository.TVShowRepository;

@EnableMongoRepositories(basePackageClasses = EntertainmentRepository.class)
@Configuration
public class MongoDBConfig {

	/*
	 * @Bean CommandLineRunner commandLineRunner(EntertainmentRepository
	 * entertainment) { return strings -> { entertainment.save(new
	 * Entertainment((Object)1, "Peter")); entertainment.save(new
	 * Entertainment((Object)2, "Sam")); }; }
	 */

	@Bean
	CommandLineRunner commandLineRunner(MovieRepository movieRepository, TVShowRepository tvShowRepository) {
		return strings -> {
			Movie movie = createMovieObject();
			movieRepository.save(movie);
			TVShow tvShow = createTvShowObject();
			tvShowRepository.save(tvShow);
		};
	}

	private Movie createMovieObject() {

		Caste movieCaste = new Caste(Arrays.asList("Jonny Depp"), Arrays.asList("Geoffry Rush"),
				Arrays.asList("keth Richards"));
		Movie movie = new Movie(1, new Date(), movieCaste, 4, 2.5, 1, "Parites of Carrbiean", "Fantasy Adventure",
				Arrays.asList("Theater1, Theater2"), EntertainmentType.MOVIES);
		return movie;
	}

	private TVShow createTvShowObject() {
		Caste tvCaste = new Caste(Arrays.asList("Bendict Cumberbench"), Arrays.asList("Green Field"),
				Arrays.asList("Phillips Mathew"));
		TVShow tvShow = new TVShow(2, new Date(), tvCaste, 4, 2.5, 1, "Sherlock Holmess", "Crime, Mystory",
				Arrays.asList("Sony, BBC"), EntertainmentType.TV_SHOWS);
		return tvShow;
	}
}
