package com.mediscreennote.model;

import org.springframework.http.HttpStatus;

public class Response {

	private HttpStatus status;
	private Object data;
	private String errorCode;
	private String errorDescription;
	public HttpStatus getStatus() {
		return status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
