package com.example.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.example.model.Person;
import com.example.service.PersonManager;

@FacesConverter(forClass=Person.class)//indicating a class to the converter
public class PersonConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	
		Person returning = null;
		
		if (value != null) {
			PersonManager mng = new PersonManager();
			returning = mng.searchForCod(Integer.valueOf(value));
		}
		
		return returning;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Person) value).getCod().toString();
		}
		return null;
	}
}
