package com.example;

public class Client {
	private int cod;
	private String name;
	private String city;
	
	public Client(int cod, String name, String city){
		this.cod = cod;
		this.name = name;
		this.city = city;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
