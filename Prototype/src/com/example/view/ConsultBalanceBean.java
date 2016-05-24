package com.example.view;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.example.model.Entry;
import com.example.util.HibernateUtil;

@ManagedBean
public class ConsultBalanceBean {
	
	private List<Entry> entries = new ArrayList<Entry>();

	@SuppressWarnings("unchecked")
	@PostConstruct 
	public void initialize() {
		Session session = HibernateUtil.getSession();
		
		this.entries = session.createCriteria(Entry.class)
				.addOrder(Order.desc("dueDate"))
				.list();
	}
	
	public List<Entry> getEntries() {
		return entries;
	}
		
}
