package com.telefonica.eof.pojo.upfrontFija;

import java.math.BigDecimal;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: UpfrontFijaResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre la clase
 *               Upfront y el OffersBenefitsService
 */
@Data
public class UpfrontFijaResponse {

    private BigDecimal valueAbp;
    private String productForInstFee;
    private String cidBo;
}
