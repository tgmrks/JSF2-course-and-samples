package com.example.model;

import java.io.Serializable;

public class Person implements Serializable{

	private Integer cod;
	private String name;
	
	public Person(){
		
	}

	public Person(Integer cod, String name) {
		super();
		this.cod = cod;
		this.name = name;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}
}
