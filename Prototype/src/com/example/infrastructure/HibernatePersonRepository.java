package com.example.infrastructure;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.example.model.Person;
import com.example.repository.PersonRepository;

public class HibernatePersonRepository implements PersonRepository {

	private Session session;//dependency injection concept
	
	public HibernatePersonRepository (Session session){
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listAll() {
		return session.createCriteria(Person.class)
				.addOrder(Order.asc("name"))
					.list();		
	}

	@Override
	public Person findByCod(Integer cod) {
		return (Person) session.load(Person.class, Integer.valueOf(cod));
	}

}
