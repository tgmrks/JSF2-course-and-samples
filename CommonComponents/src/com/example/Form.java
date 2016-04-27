package com.example;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Form {

	private String content1 = "Commun";
	private String content2 = "Components";
	private String choice1;
	private String choice2[];
	
	public void chooseOne(){
		System.out.println("Choice: " + this.getChoice1());
	}
	
	public void chooseMany(){
		System.out.println("-------------");
		System.out.println("selected ones: " + this.getChoice1());
		for(String item : this.getChoice2()){
			System.out.println(item);
		}
	}
	
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
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String[] getChoice2() {
		return choice2;
	}

	public void setChoice2(String[] choice2) {
		this.choice2 = choice2;
	}
	
			
}
