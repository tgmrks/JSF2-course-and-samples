package com.example.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.example.model.Entry;
import com.example.repository.EntryRepository;
import com.example.util.Repositories;


@FacesConverter(forClass=Entry.class)
public class EntryConverter implements Converter {

	private Repositories repositories = new Repositories();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Entry returning = null;
		EntryRepository entryRepository = this.repositories.getEntries();
		
		if (value != null && !value.equals("")) {
			returning = entryRepository.findByCod(new Integer(value));
			
			if (returning == null) {
				String description = "Entry doesn't exist.";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						description, description);
				throw new ConverterException(message);
			}
		}
		
		return returning;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Integer cod = ((Entry) value).getCod();
			return cod == null ? "" : cod.toString();
		}
		return null;
	}
	
	
}
