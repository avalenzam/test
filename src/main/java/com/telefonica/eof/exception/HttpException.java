package com.telefonica.eof.exception;

import com.telefonica.eof.enums.HttpsErrorMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpException extends Exception {

    private static final long serialVersionUID = 1L;

    private String exceptionId;
    private String responseHttp;
    private String message;

    public HttpException(String exceptionId, String responseHttp, String message) {
	super();
	this.exceptionId = exceptionId;
	this.responseHttp = responseHttp;
	this.message = message;
    }

    public HttpException() {
	super();
    }

    public static HttpException HttpExceptionResponse(String e) {

	HttpException httpException = new HttpException();
	String sSubCadena = e.substring(0, 7);

	for (HttpsErrorMessage http : HttpsErrorMessage.values()) {
	    if (http.getExceptionId().equalsIgnoreCase(sSubCadena)) {
		
		httpException.setExceptionId(http.getExceptionId());
		httpException.setMessage(http.getMessage());
	    }
		
	}
	
	 return httpException;

    }   

}
