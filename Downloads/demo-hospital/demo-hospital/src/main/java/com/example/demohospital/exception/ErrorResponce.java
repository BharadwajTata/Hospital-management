package com.example.demohospital.exception;

import java.time.LocalDateTime;

public class ErrorResponce {
	private String code;
	private String message;
	private LocalDateTime timeStamp;
	public ErrorResponce(String code, String message, LocalDateTime timeStamp) {
		super();
		this.code = code;
		this.message = message;
		this.timeStamp = timeStamp;
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
