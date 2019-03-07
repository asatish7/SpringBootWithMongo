package com.java.spring.boot.mongodb.springbootmongodbexercise.version2.entertainment.document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
public static void main(String[] args) {
	List<String> testList = new ArrayList<>(Arrays.asList("Abhi","bhi","Abhi"));
	testList.stream().map(s->s.equalsIgnoreCase("Abhi")).toArray(String[]::new);
}
}
