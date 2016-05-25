package com.example.view;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.example.model.Entry;
import com.example.util.FacesUtil;
import com.example.util.HibernateUtil;

@ManagedBean
public class ConsultBalanceBean {
	
	private Entry selectedEntry;
	private List<Entry> entries = new ArrayList<Entry>();

	@SuppressWarnings("unchecked")
	@PostConstruct 
	public void initialize() {
		Session session = (Session) FacesUtil.getRequestAttribute("session");
		
		this.entries = session.createCriteria(Entry.class)
				.addOrder(Order.desc("dueDate"))
				.list();
			}
	
	public void remove(){
		if(this.selectedEntry.isPaid()){
			FacesUtil.addMsg(FacesMessage.SEVERITY_ERROR, "Can't be removed");
		}
		else{
			Session session = (Session) FacesUtil.getRequestAttribute("session");
			session.delete(this.selectedEntry);
			
			this.initialize();
			
			FacesUtil.addMsg(FacesMessage.SEVERITY_INFO, "Removed Successfully!");	
		}
		
	}
	
	public List<Entry> getEntries() {
		return entries;
	}

	public Entry getSelectedEntry() {
		return selectedEntry;
	}

	public void setSelectedEntry(Entry selectedEntry) {
		this.selectedEntry = selectedEntry;
	}
	
	
		
}
