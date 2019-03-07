package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

import java.util.List;

public class SearchResults {
String message;
List<Entertainment> list;



public SearchResults(String message, List<Entertainment> list) {
	super();
	this.message = message;
	this.list = list;
}


public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<Entertainment> getList() {
	return list;
}
public void setList(List<Entertainment> list) {
	this.list = list;
}

}
