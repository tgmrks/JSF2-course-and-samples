package com.example.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.example.model.Entry;
import com.example.model.EntryType;
import com.example.model.Person;
import com.example.util.FacesUtil;
import com.example.util.HibernateUtil;

@ManagedBean
@ViewScoped
public class NewEntryBean implements Serializable{
	
	private List<Person> people = new ArrayList<Person>();
	private Entry entry = new Entry();
	
	@SuppressWarnings("unchecked")
	@PostConstruct //called after the managedBean is created 
	public void init(){
		Session session = (Session) FacesUtil.getRequestAttribute("session"); 
		
		this.people = session.createCriteria(Person.class)
				.addOrder(Order.asc("name"))
					.list();
	}

	public void entryPaidChange(ValueChangeEvent event){
		this.entry.setPaid((Boolean) event.getNewValue());
		this.entry.setPaimentDate(null);
		FacesContext.getCurrentInstance().renderResponse();
	}
	
	public void register(){
		Session session = (Session) FacesUtil.getRequestAttribute("session");
		session.merge(this.entry);
		
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
