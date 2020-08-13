package com.telefonica.eof.enums;

import lombok.Getter;

public enum OfferingHeaderEnum {
	
	COUNTRY(""),
	LANG(""),
	ENTITY(""),
	SYSTEM(""),
	SUBSYSTEM(""),
	ORIGINATOR(""),
	USERID(""),
	OPERATION(""),
	DESTINATION(""),
	EXECID(""),
	TIMESTAMP(""),
	MSGTYPE("");

	@Getter
	private String value;

	private OfferingHeaderEnum(String value) {
		this.value = value;
	}

}
