package com.telefonica.eof.pojo.sva;

import java.util.List;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: SvaResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre la clase
 *               Sva y el OffersBenefitsService
 */
@Data
public class SvaResponse {

    private List<BillingOfferResponse> billingOffer;
    private String idComponent;
}
