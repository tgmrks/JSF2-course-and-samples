package com.example.repository;

import java.util.List;

import com.example.model.Person;

public interface PersonRepository {
	
	public List<Person> listAll();
	public Person findByCod(Integer cod); 
}
