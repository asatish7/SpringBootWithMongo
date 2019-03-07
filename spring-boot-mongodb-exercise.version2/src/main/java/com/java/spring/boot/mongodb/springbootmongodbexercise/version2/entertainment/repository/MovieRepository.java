package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Movie;

public interface MovieRepository extends MongoRepository<Movie, Object>{
	List<Movie> findByMovieName(String movieName);
	List<Movie> findByDateOfRelease(Date dateOfRelease);
}
