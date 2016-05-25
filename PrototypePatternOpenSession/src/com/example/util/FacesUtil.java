package com.example.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class FacesUtil {

	public static void addMsg(Severity type, String msg){
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(type,
						msg, msg));
	}
	
	public static Object getRequestAttribute(String requestName){//fecth request obj defined in 'doFilter'
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(requestName);
	}
	
}
