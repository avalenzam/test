package com.telefonica.eof.pojo.aditionalSva;

import lombok.Data;
/**
 * 
 * @Author: Alexandra Valenza Medrano
 * @Datecreation: August 2020
 * @FileName: OfferDataResponse.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase para el traslado de informacion entre el metodo
 *               getOfferData y el metodo principal de la clase
 *               AditionalSva.
 */
@Data
public class OfferDataResponse {
    
    private String lob;
    private Boolean flagModemPremium;
    private Boolean flagUltraWifi;
    private String defSpsId;
    private String defSpsBo;
    
    
}
