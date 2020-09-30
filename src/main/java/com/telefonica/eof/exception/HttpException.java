package com.telefonica.eof.exception;

import org.springframework.http.HttpStatus;

import com.telefonica.eof.enums.HttpsErrorMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HttpException extends Exception {

    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;
    private String httpStatusCode;
    private String message;

      public HttpException(HttpStatus httpStatus, String httpStatusCode, String message) {
	super();
	this.httpStatus = httpStatus;
	this.httpStatusCode = httpStatusCode;
	this.message = message;
    }

    public HttpException() {
	super();
    }

    public HttpException(HttpException e) {
	this.httpStatus = e.getHttpStatus();
	this.httpStatusCode = e.getHttpStatusCode();
	this.message = e.getMessage();
    }

    public static HttpException HttpExceptionResponse(Exception e) {

	HttpException httpException = null;
	String soapMessage = e.getMessage().substring(0, 7);

	for (HttpsErrorMessage http : HttpsErrorMessage.values()) {
	    
	    if (http.getExceptionId().equalsIgnoreCase(soapMessage)) {
		
		httpException = new HttpException();
		httpException.setHttpStatusCode(http.getHttpStatusCode());
		httpException.setHttpStatus(http.getHttpStatus());

		if (http.getExceptionId().equalsIgnoreCase(HttpsErrorMessage.ERROR_500.getExceptionId())) {
		    httpException.setMessage(e.getMessage());
		} else {
		    httpException.setMessage(http.getMessage());
		}

	    }

	}

	if (httpException == null) {
	    httpException = new HttpException();
	    httpException.setHttpStatusCode("500");
	    httpException.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
	    httpException.setMessage(e.getMessage());
	}

	return httpException;

    }

  

}
