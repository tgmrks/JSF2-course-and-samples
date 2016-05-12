package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.Person;

public class PersonManager {

	private static Map<Integer, Person> person = new HashMap<Integer, Person>();
	
	static{
		person.put(1, new Person(1, "John Doe"));
		person.put(2, new Person(2, "Jane Doe"));
		person.put(3, new Person(3, "Erika Mustermann"));
	}
	
	public List<Person> listAll(){
		List<Person> all = new ArrayList<Person>();
		all.addAll(PersonManager.person.values());			
		return all;
	}
	
	public Person searchCod(Integer cod){
		return person.get(cod);
	}
}
