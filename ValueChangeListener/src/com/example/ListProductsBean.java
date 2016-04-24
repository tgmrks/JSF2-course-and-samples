package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped  
public class ListProductsBean{
	
	private Product product;
	private List<Product> products;
	private Product selectedItem;
	private String searchProduct;
	private List<Product> filterProducts;

	public ListProductsBean(){
		this.product = new Product();
		this.products = new ArrayList<Product>();
		this.filterProducts = new ArrayList<Product>();
	}
	
	public void addItem(){
		this.products.add(this.product);
		this.product = new Product();
	}
	
	public void removeItem(){
		this.products.remove(this.selectedItem);
	}
	
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
	
	public void searchProductFilter(ValueChangeEvent event){
		System.out.println("Searching...");
		
		this.filterProducts.clear();
		
		for(Product product : this.products){
			if(product.getProductName() != null && 
					product.getProductName().toLowerCase().startsWith(event.getNewValue().toString().toLowerCase())){
				this.filterProducts.add(product);
			}
		}
		
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
	
		
	public String getSearchProduct() {
		return searchProduct;
	}

	public void setSearchProduct(String searchProduct) {
		this.searchProduct = searchProduct;
	}

	public List<Product> getFilterProducts() {
		return filterProducts;
	}			
}
