package com.example;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

/**
 * Backing Bean is a Managed Bean used to manipulate component properties.</br>
 * The extensive use of Backing Beans is not recommended. Instead, use tag attributes.
 */
@ManagedBean 
public class HelloWorldBean {
	
	private HtmlInputText field;
	private HtmlCommandButton button;
	
	public void change(){
		if(this.field.isDisabled()){
			this.field.setDisabled(false);
			this.button.setStyle("");
		}
		else{
			this.field.setDisabled(true);
			this.button.setStyle("background-color: red; color: white");
		}
			
	}
	
	public HtmlInputText getField() {
		return field;
	}
	public void setField(HtmlInputText field) {
		this.field = field;
	}
	public HtmlCommandButton getButton() {
		return button;
	}
	public void setButton(HtmlCommandButton button) {
		this.button = button;
	}
	
}
