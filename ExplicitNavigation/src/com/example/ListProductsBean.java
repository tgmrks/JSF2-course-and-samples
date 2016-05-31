package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped  
public class ListProductsBean {
	
	private Product product;
	private List<Product> products;
	
	public ListProductsBean(){
		this.product = new Product();
		this.products = new ArrayList<Product>();
	}
	
	public void addItem(){
		this.products.add(this.product);
		this.product = new Product();
	}
	
	public String getAbout(){
		if(this.products.isEmpty())
			return "About?faces-redirect=true";
		else
			return "AboutForm?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public List<Product> getProducts() {
		return products;
	}
			
}
