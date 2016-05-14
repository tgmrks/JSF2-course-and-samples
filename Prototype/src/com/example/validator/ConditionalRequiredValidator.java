package com.example.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("com.example.validator.ConditionalRequiredValidator")
public class ConditionalRequiredValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		
	Boolean checked = (Boolean) component.getAttributes().get("checked");
	
		if (checked != null && checked && value == null) {
			
			Object label = MessageFactory.getLabel(context, component);
			
			String errorDescription = "Fill the field  " + label + ".";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					errorDescription, errorDescription);
			throw new ValidatorException(message);
		}
		
	}
	
}
