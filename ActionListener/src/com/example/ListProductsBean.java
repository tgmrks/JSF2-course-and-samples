package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped  
public class ListProductsBean {
	
	private Product product;
	private List<Product> products;
	private Product selectedItem;
	
	public ListProductsBean(){
		this.product = new Product();
		this.products = new ArrayList<Product>();
	}
	
	public void addItem(){
		this.products.add(this.product);
		this.product = new Product();
	}
	
	public void removeItem(){
		this.products.remove(this.selectedItem);
	}
	
	//A 'ActionEvent' parameter is always required for using ActionListener
	public void checkItem(ActionEvent event){
		System.out.println("Cheking Item!");
		if("".equals(this.product.getManufacturer()))
			this.product.setManufacturer("not informed");
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
	
	public Product getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Product selectedItem) {
		this.selectedItem = selectedItem;
	}
			
}
