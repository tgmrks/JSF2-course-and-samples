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
import com.example.service.PersonManager;

@ManagedBean
@ViewScoped
public class NewEntryBean implements Serializable{
	
	private List<Person> people = new ArrayList<Person>();
	private Entry entry = new Entry();
	
	@PostConstruct //called after the managedBean is created 
	public void init(){
		PersonManager mng = new PersonManager();
		this.people = mng.listAll();
	}

	public void entryPaidChange(ValueChangeEvent event){
		this.entry.setPaid((Boolean) event.getNewValue());
		this.entry.setPaimentDate(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void Register(){
		System.out.println("Type: " + this.entry.getType());
		//System.out.println("Pessoa: " + this.entry.getPerson().getName());
		System.out.println("Description: " + this.entry.getDescription());
		System.out.println("Value: " + this.entry.getValue());
		System.out.println("Due Date: " + this.entry.getDueDate());
		System.out.println("Paid: " + this.entry.isPaid());
		System.out.println("Paid Date: " + this.entry.getPaimentDate());
		
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
