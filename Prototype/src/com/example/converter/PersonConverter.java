package com.example.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.example.model.Person;
import com.example.util.HibernateUtil;

@FacesConverter(forClass=Person.class)//indicating a class to the converter
public class PersonConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
	
		Person returning = null;
		System.out.println("---> 3" + "value: " + value);
		
		if (value != null) {
			System.out.println("---> 1");
			
			Session session = HibernateUtil.getSession();
			
			returning = (Person) session.load(Person.class, Integer.valueOf(value));
			System.out.println("Selected Person: " + returning.getCod() + " - " + returning.getName());
			
			session.close(); 
		}
		
		return returning;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			System.out.println("---> 2");
			return ((Person) value).getCod().toString();
		}
		return null;
	}
}
