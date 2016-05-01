package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClientBean {
	
	private List<Client> clients  = new ArrayList<Client>();
	
	public void consult(){
		this.getClients().add(new Client(1, "John Doe", "New York"));
		this.getClients().add(new Client(2, "Pedro", "Sao Paulo"));
		this.getClients().add(new Client(3, "Peter", "London"));
		this.getClients().add(new Client(4, "Kobayashi", "Tokyo"));
		this.getClients().add(new Client(5, "Juan", "Madri"));
		this.getClients().add(new Client(6, "Ivan", "Moscow"));
	}

	public List<Client> getClients() {
		return clients;
	};
	

}
