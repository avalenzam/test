package com.telefonica.eof.pojo.benefits;

import com.telefonica.eof.entity.WirelineServiceBenefits;

import lombok.Data;

@Data
public class BenefitsResponse {

    private WirelineServiceBenefits benefits;
    private String nameComp;
    private String valueAbpType;
    private String valueAbp;
    private String spsName;
    private String nameBo;
    
}
