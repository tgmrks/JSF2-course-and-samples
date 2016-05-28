package com.example.repository;

import java.util.List;

import com.example.model.Entry;

public interface EntryRepository {
	
	public List<Entry> listAll();
	public Entry findByCod();
	public Entry save(Entry entry);
	public void remove(Entry entry);
	public Entry alikeEntry(Entry entry);
}
