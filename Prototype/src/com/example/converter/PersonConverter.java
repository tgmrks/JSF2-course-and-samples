package com.example.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.example.model.Person;
import com.example.util.FacesUtil;
import com.example.util.HibernateUtil;

@FacesConverter(forClass=Person.class)//indicating a class to the converter
public class PersonConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	
		Person returning = null;
		
		if (value != null) {
			Session session = (Session) FacesUtil.getRequestAttribute("session");
			
			returning = (Person) session.load(Person.class, Integer.valueOf(value));			
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
