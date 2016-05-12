package com.example.model;

public enum EntryType {
	
	INCOME("income"),
	EXPENDITURE("expenditure");
	
	private String description;
	
	EntryType(String description){
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
	
}
