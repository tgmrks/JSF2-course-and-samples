package com.example.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;
				//validator id
@FacesValidator("com.example.validator.FutureDateValidator")
public class FutureDateValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {

		Date date = (Date) value;
		
		if (date != null && date.after(new Date())) {
			Object label = MessageFactory.getLabel(context, component);
			
			String errorDescription = label + " can't be a future date.";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					errorDescription, errorDescription);
			throw new ValidatorException(message);
		}	
	}
	
}
