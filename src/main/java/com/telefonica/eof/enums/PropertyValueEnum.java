package com.telefonica.eof.enums;

import lombok.Getter;

public enum PropertyValueEnum {
    
    RETENTION("Retention"),
    LOB_TYPE("LOB Type"),
    PLAN_GROUP("Plan Group");
    
    @Getter
    String value;
    
    private PropertyValueEnum(String value) {
	this.value = value;
    }

}
