package com.telefonica.eof.pojo.benefits;

import com.telefonica.eof.entity.WirelineServiceBenefits;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: BenefitsResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre la clase
 *               Benefit y el OffersBenefitsService
 */
@Data
public class BenefitsResponse {

    private WirelineServiceBenefits benefits;
    private String nameComp;
    private String valueAbpType;
    private String valueAbp;
    private String spsName;
    private String nameBo;
    
}
