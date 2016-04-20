package com.example;

import javax.faces.bean.ManagedBean;

@ManagedBean //older versions didn't have this annotation. Instead, the file 'faces-config.xml' was used to configure ManagedBeans.
public class HelloWorldBean {
	
	String name;
	String modifiedName;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getModifiedName() {
		return modifiedName;
	}

	public void setModifiedName(String modifiedName) {
		this.modifiedName = modifiedName;
	}

	public void toUpperCase(){
		this.setModifiedName(this.getName().toUpperCase());
	}

}
