package com.telefonica.eof.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class OffersProperties implements Serializable {

    private static final long serialVersionUID = 2662412603578654105L;
    private String offerCid;
    private String nameOfProperty; 
    private String propertyValue;
    
    
}
