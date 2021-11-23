package com.neosoft;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class GreetingTag extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw);
		
		JspWriter out = getJspContext().getOut();
		
		Date dt = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(dt);
	    String hour = "";
	    int hours = c.get(Calendar.HOUR_OF_DAY);
	    if(hours>3 && hours<=12){
	        hour = "Good Morning";
	    }else if(hours>12 && hours<=16){
	        hour = "Good Afternoon";
	    }else if(hours>16 && hours<=21){
	        hour = "Good Evening";
	    }else if(hours>21 && hours<=3){
	        hour = "Good Night";
	    }
		out.print("Hello "+sw.toString()+", "+hour);
	}
}
