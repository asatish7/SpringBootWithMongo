package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Movie;
import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.TVShow;

public interface TVShowRepository extends MongoRepository<TVShow, Object>{
	List<TVShow> findByShowName(String tvShowName);
	List<TVShow> findByDateOfRelease(Date dateOfRelease);
}
