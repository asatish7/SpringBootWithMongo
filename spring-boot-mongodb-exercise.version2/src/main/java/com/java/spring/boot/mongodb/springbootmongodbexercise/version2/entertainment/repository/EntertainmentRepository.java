package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document.Entertainment;



public interface EntertainmentRepository extends MongoRepository<Entertainment, Object>{

}
