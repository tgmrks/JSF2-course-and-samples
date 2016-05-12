package com.example.view;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ConsultBalanceBean {
	
	private List<String> entries = new ArrayList<String>();

	@PostConstruct 
	public void inicializar() {
		for (int i = 0; i < 20; i++) {
			entries.add("");
		}
	}
	
	public List<String> getEntries() {
		return entries;
	}
		
}
