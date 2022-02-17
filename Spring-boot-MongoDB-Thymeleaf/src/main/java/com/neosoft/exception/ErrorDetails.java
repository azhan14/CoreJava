package com.neosoft.exception;

import java.util.Date;

public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private String detials;
	public ErrorDetails(Date timestamp, String message, String detials) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detials = detials;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetials() {
		return detials;
	}
}
