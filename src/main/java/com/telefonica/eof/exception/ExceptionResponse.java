package com.telefonica.eof.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionResponse {
   

    private String httpStatusCode;
    private String message;
    
   
    
}
