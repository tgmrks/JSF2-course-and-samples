package com.example.infrastructure;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

	@Override
	public Entry alikeEntry(Entry entry) {
		
		return (Entry) this.session.createCriteria(Entry.class)
				.add(Restrictions.eq("type", entry.getType()))
				.add(Restrictions.eq("person", entry.getPerson()))
				.add(Restrictions.eq("value", entry.getValue()))
				.add(Restrictions.ilike("description", entry.getDescription()))
				.add(Restrictions.eq("dueDate", entry.getDueDate()))
				.uniqueResult();
	}

}
