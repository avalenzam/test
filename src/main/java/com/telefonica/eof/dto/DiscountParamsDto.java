package com.telefonica.eof.dto;

import lombok.Data;

@Data
public class DiscountParamsDto {

    private String channelId;
    //TODO id oferta amdocs
    private String catalogItemID; 
    private String action;
    private Boolean isPortability;
    private String currentOffering;
    private String broadbandConnection;
    private String networkTechnology;
    private String commercialAreaId;
    //TODO viene de amdocs
    private String downloadSpeed;
}
