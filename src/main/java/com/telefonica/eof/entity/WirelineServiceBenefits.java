package com.telefonica.eof.entity;

import lombok.Data;

@Data
public class WirelineServiceBenefits {
    
    private String benefitComponentCid;
    private String benefitThemePackSpsCid;
    private String benefitBillingOfferCid;
    private String speed;
    private String duration;
    private String nightInd;
    private String lob;

}
