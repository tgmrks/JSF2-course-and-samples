package com.example;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Form {

	private String content1 = "Commun";
	private String content2 = "Components";
	
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	public String getContent2() {
		return content2;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}
		
}
