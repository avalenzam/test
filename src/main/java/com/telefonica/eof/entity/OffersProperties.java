package com.telefonica.eof.entity;

import lombok.Data;

@Data
public class OffersProperties {
    //TODO BORRAR CONSTRUCTORES
    
    public OffersProperties(String nameOfProperty, String propertyValue) {
	super();
	this.nameOfProperty = nameOfProperty;
	this.propertyValue = propertyValue;
    }
   

    public OffersProperties(String nameOfProperty) {
	super();
	this.nameOfProperty = nameOfProperty;
    }


    private String nameOfProperty;
   
    private String propertyValue;
    
    
}
