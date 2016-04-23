package com.example;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

@ManagedBean
public class ButtonListener implements ActionListener{

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		System.out.println("Button Clicked: " + event.getComponent().getId());		
	}

}
