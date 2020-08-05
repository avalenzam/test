package com.telefonica.eof.pojo.aditionalSva;

import lombok.Data;

@Data
public class OfferDataResponse {
    
    private String lob;
    private Boolean flagModemPremium;
    private Boolean flagUltraWifi;
    private String defSpsId;
    private String defSpsBo;
    
    
}
