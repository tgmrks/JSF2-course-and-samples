package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 * With the 'ApplicationScoped'annotation the data instance will be alive/available while the application is running.<br/> 
 * Without it a new instance is required in every new request.
 * 
 * Different 'sessions' will access the same information.</br>
 * User session, for instance, will use the annotation 'SessionScoped'. This way, each session will access its own information. 
 */
@ManagedBean
@ApplicationScoped  
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

	public Product getProduct() {
		return product;
	}

	public List<Product> getProducts() {
		return products;
	}
			
}
