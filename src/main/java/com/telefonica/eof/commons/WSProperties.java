package com.telefonica.eof.commons;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
@ConfigurationProperties(prefix = "ws")
public class WSProperties {
	
	private String urlPenaltyService;
	private String urlOfferingsService;
	private String urlBenefitsService;
	private Integer connectiontimeout;
	private Integer readtimeout;

}
