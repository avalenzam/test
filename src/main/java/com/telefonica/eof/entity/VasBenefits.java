package com.telefonica.eof.entity;

import lombok.Data;

@Data
public class VasBenefits {
    private String benefitComponentCid;
    private String benefitThemePackSpsCid;
    private String benefitBillingOfferCid;
    private String speed;
    private String duration;

}
