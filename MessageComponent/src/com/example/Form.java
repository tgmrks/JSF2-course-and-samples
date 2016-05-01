package com.example;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class Form {
	private String name;
	private String email;
	private String pass;
	
	public void verification(){
		if(this.getName() == null || this.getName().length() < 15)
			this.addMessage("form:name", FacesMessage.SEVERITY_ERROR, "Incomplet name", "Please, insert your fullname.");
		
		if(dayoff())      //null id means global message
			this.addMessage(null, FacesMessage.SEVERITY_WARN, "Dayoff", "You can't register a user today.");
		
		FacesContext fContext = FacesContext.getCurrentInstance();
		if(!fContext.getMessages().hasNext()){
			//save data here
			this.addMessage(null,  FacesMessage.SEVERITY_INFO, "User registered", "User registered successfully.");
		}
		
	}
	
	public void addMessage(String clientId, Severity severity, String summary, String detail){
		FacesContext fContext = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(severity, summary, detail);
		
		fContext.addMessage(clientId, message);		
	}
	
	public boolean dayoff(){
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
