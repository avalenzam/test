package com.telefonica.eof.enums;

import lombok.Getter;

public enum OfferingHeaderEnum {
	
	COUNTRY("PE"),
	LANG("es"),
	ENTITY("TEF"),
	SYSTEM("FE"),
	SUBSYSTEM("FE"),
	ORIGINATOR("PE:TEF:FE:FE"),
	USERID(""),
	OPERATION(""),
	DESTINATION(""),
	EXECID("550e8400-e29b-41d4-a716-446655440005"),
	TIMESTAMP("2018-04-03T09:30:47.233+01:00"),
	MSGTYPE("");

	@Getter
	private String value;

	private OfferingHeaderEnum(String value) {
		this.value = value;
	}

}
