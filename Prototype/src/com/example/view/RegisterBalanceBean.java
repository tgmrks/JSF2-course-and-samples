package com.example.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.example.model.Entry;
import com.example.model.EntryType;

@ManagedBean
@ViewScoped
public class RegisterBalanceBean {
	
	private Entry entry = new Entry();

	public void Register(){
		System.out.println("Type: " + this.entry.getType());
		//System.out.println("Pessoa: " + this.entry.getPerson().getName());
		System.out.println("Description: " + this.entry.getDescription());
		System.out.println("Value: " + this.entry.getValue());
		System.out.println("Due Date: " + this.entry.getDueDate());
		System.out.println("Paid: " + this.entry.isPaid());
		System.out.println("Paid Date: " + this.entry.getPaidDate());
		
		this.entry = new Entry();
		
		//add message to the queue
		String msg = "Successfully registered!";
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public EntryType[] getEntryType(){
		return EntryType.values();
	}

	public Entry getEntry() {
		return entry;
	}
	
}
