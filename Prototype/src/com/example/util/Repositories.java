package com.example.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.example.infrastructure.HibernateEntryRepository;
import com.example.infrastructure.HibernatePersonRepository;
import com.example.repository.EntryRepository;
import com.example.repository.PersonRepository;

public class Repositories implements Serializable{
	
	public PersonRepository getPeople(){
		return new HibernatePersonRepository(this.getSession());		
	}
	
	public EntryRepository getEntries(){
		return new HibernateEntryRepository(this.getSession());
	}
	
	private Session getSession(){
		return (Session) FacesUtil.getRequestAttribute("session");
	}
}
