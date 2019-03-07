package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

public class Comment {
	Object id;
	String userName;
	String comments;

	Comment() {

	}

	public Comment(Object id, String name, String comment) {
		this.id = id;
		this.userName = name;
		this.comments = comment;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
