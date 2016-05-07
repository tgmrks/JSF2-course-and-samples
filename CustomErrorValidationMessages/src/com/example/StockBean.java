package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StockBean {
	private Item item = new Item();;
	private List<Item> itens = new ArrayList<Item>();
	
	public void insert(){
		this.itens.add(this.item);
		this.item = new Item();
	}
	
	public Item getItem() {
		return item;
	}
	public List<Item> getItens() {
		return itens;
	}
	
	
}
