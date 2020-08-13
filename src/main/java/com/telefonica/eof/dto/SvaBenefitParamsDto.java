package com.telefonica.eof.dto;

import lombok.Data;

@Data
public class SvaBenefitParamsDto {
    
    private String channelId;
    private String offerCaption; 
    private String action;
    private Boolean isPortability;
    private String orderSubType ;
    private String broadbandConnection;
    private String networkTechnology;
    private String commercialAreaId;
    private String parentId;
    private String iDcomponente;

}
