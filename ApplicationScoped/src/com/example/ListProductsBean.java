package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 * With the 'ApplicationScoped' annotation, the obj instance will be alive/available while the application is running.<br/> 
 * Different 'sessions' will access the same information.
 *  
 * User sessions, for instance, will use the annotation 'SessionScoped'. This way, each session will access its own information.<br/>
 * A session lasts as its activated (in use). 
 * 
 * The 'ViewScoped' will keep the obj as soon as the view/screen is alive. 
 * 
 * The default scope is the 'RequestScoped'. Which will require a new instance obj for each new request.
 * 
 * Furthermore, there is the 'NoneScoped' that will keep objects for demand. It'll distroy object for each obj access. 
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
