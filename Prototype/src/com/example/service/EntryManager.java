package com.example.service;

import com.example.model.Entry;
import com.example.repository.EntryRepository;

public class EntryManager {
	
	private EntryRepository entryRepository;
	
	public EntryManager(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}
	
	public void save(Entry entry) throws BusinessRuleException{
		if(entryExists(entry)){
			throw new BusinessRuleException("This entry already exists!");
		}
		this.entryRepository.save(entry);
		
	}
	
	private boolean entryExists(Entry entry){
		Entry similarEntry = this.entryRepository.alikeEntry(entry);		
		return similarEntry != null && !similarEntry.equals(entry);	
	}

	public void remove(Entry entry) throws BusinessRuleException {
		if(entry.isPaid()){
			throw new BusinessRuleException("Can't be removed. It's a paid entry");
		}
		
		this.entryRepository.remove(entry);
	}
}
