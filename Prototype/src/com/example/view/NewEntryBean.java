package com.example.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


import com.example.model.Entry;
import com.example.model.EntryType;
import com.example.model.Person;
import com.example.repository.EntryRepository;
import com.example.repository.PersonRepository;
import com.example.util.Repositories;

@ManagedBean
@ViewScoped
public class NewEntryBean implements Serializable{
	
	private Repositories repositories = new Repositories();
	private List<Person> people = new ArrayList<Person>();
	private Entry entry = new Entry();
	
	@SuppressWarnings("unchecked")
	@PostConstruct //called after the managedBean is created 
	public void init(){
		PersonRepository personRepository = this.repositories.getPeople();
		this.people = personRepository.listAll();
	}

	public void entryPaidChange(ValueChangeEvent event){
		this.entry.setPaid((Boolean) event.getNewValue());
		this.entry.setPaimentDate(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void register(){
		EntryRepository entryRepository = this.repositories.getEntries();
		entryRepository.save(this.entry);
		
		this.entry = new Entry();
		
		//add message to the queue
		String msg = "Successfully registered!";
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public EntryType[] getEntryTypes(){
		return EntryType.values();
	}
	
	public Entry getEntry() {
		return entry;
	}

	public List<Person> getPeople() {
		return people;
	}
	
}
