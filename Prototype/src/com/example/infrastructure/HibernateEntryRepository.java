package com.example.infrastructure;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.example.model.Entry;
import com.example.repository.EntryRepository;
import com.example.util.FacesUtil;

public class HibernateEntryRepository implements EntryRepository {
	Session session;
		
	public HibernateEntryRepository(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entry> listAll() {
		return session.createCriteria(Entry.class)
				.addOrder(Order.desc("dueDate"))
				.list();
	}

	@Override
	public Entry findByCod() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry save(Entry entry) {
		return (Entry) session.merge(entry);
	}

	@Override
	public void remove(Entry entry) {
		session.delete(entry);
	}

}
